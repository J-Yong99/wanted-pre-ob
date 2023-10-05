package com.wanted.spring.repository;

import com.wanted.spring.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Override
    <S extends Application> S save(S entity);
}