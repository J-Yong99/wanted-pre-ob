package com.wanted.spring.repository;

import com.wanted.spring.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Override
    <S extends Company> S save(S entity);

    @Override
    Optional<Company> findById(Long aLong);
}