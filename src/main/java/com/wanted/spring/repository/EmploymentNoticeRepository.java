package com.wanted.spring.repository;

import com.wanted.spring.domain.EmploymentNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmploymentNoticeRepository extends JpaRepository<EmploymentNotice, Long> {
    @Override
    <S extends EmploymentNotice> S save(S entity);

    @Override
    Optional<EmploymentNotice> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    // company_id로 list<id>가져오기
    // %검색어%로 해당하는 list<EN>가져오기
}