package com.wanted.spring.repository;

import com.wanted.spring.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Override
    <S extends Company> S save(S entity);
}