package com.wanted.spring.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanted.spring.domain.QEmploymentNotice;
import com.wanted.spring.dto.employment_notice.EmploymentNoticeNoDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmploymentNoticeRepositoryCustomImpl implements EmploymentNoticeRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    // companyid로 해당하는 company의 모든 채용공고 id 받아오기
    public List<Long> getAllIdByCompanyId(Long id){
        QEmploymentNotice qEmploymentNotice = QEmploymentNotice.employmentNotice;

        JPAQuery<Long> query = jpaQueryFactory.select(qEmploymentNotice.id)
                .from(qEmploymentNotice)
                .where(qEmploymentNotice.company.id.eq(id))
                ;

        return query.fetch();
    }

    // 검색어를 이용해서 해당 검색어가 포함되는 속성을 갖는 채용공고 찾아오기 (자세한 내용 미 포함)
    public List<EmploymentNoticeNoDetailResponseDto> searchNoticeByWordNoDetail(String word){
        QEmploymentNotice qEmploymentNotice = QEmploymentNotice.employmentNotice;

        JPAQuery<EmploymentNoticeNoDetailResponseDto> query = jpaQueryFactory.select(Projections.constructor(
                EmploymentNoticeNoDetailResponseDto.class,
                qEmploymentNotice.id.as("id"),
                qEmploymentNotice.company.name.as("companyName"),
                qEmploymentNotice.position,
                qEmploymentNotice.compensation,
                qEmploymentNotice.tools,
                qEmploymentNotice.region
        ))
                .from(qEmploymentNotice)
                .where(
                        qEmploymentNotice.company.name.likeIgnoreCase("%" + word + "%")
                                .or(qEmploymentNotice.position.likeIgnoreCase("%" + word + "%"))
                                .or(qEmploymentNotice.description.likeIgnoreCase("%" + word + "%"))
                                .or(qEmploymentNotice.compensation.likeIgnoreCase("%" + word + "%"))
                                .or(qEmploymentNotice.tools.likeIgnoreCase("%" + word + "%"))
                                .or(qEmploymentNotice.region.likeIgnoreCase("%" + word + "%"))
                )
                .orderBy(qEmploymentNotice.id.asc())
                ;
        return query.fetch();
    }
}
