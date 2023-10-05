package com.wanted.spring.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmploymentNoticeRepositoryCustomImpl implements EmploymentNoticeRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

}
