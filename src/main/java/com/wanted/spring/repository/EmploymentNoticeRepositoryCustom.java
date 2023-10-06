package com.wanted.spring.repository;

import com.wanted.spring.dto.employment_notice.EmploymentNoticeNoDetailResponseDto;

import java.util.List;

public interface EmploymentNoticeRepositoryCustom {
    // companyid로 해당하는 company의 모든 채용공고 id 받아오기
    List<Long> getAllIdByCompanyId(Long id);

    // 검색어를 이용해서 해당 검색어가 포함되는 속성을 갖는 채용공고 찾아오기 (자세한 내용 미 포함)
    List<EmploymentNoticeNoDetailResponseDto> searchNoticeByWordNoDetail(String word);

    List<EmploymentNoticeNoDetailResponseDto> findAllEmploymentNotice();
}
