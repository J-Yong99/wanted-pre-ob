package com.wanted.spring.service;

import com.wanted.spring.domain.Company;
import com.wanted.spring.dto.company.CompanyRegisterRequestDto;
import com.wanted.spring.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    
    @Autowired
    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public Company registerCompany(CompanyRegisterRequestDto body) {
        try{
            Company company = Company.builder()
                    .name(body.getName())
                    .description(body.getDescription())
                    .build();
            return companyRepository.save(company);
        } catch (Exception e) {
            System.out.println("e = " + e);
            throw new RuntimeException(e);
        }
    }
}
