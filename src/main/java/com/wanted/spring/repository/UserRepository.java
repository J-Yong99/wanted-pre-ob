package com.wanted.spring.repository;

import com.wanted.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long aLong);

    @Override
    <S extends User> S save(S entity);
}