package com.wanted.spring.repository;

import com.wanted.spring.domain.EmploymentNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentNoticeRepository extends JpaRepository<EmploymentNotice, Long> {
}