package com.wanted.spring.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanted.spring.domain.QEmploymentNotice;
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
}
