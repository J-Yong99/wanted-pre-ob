package com.wanted.spring.service;

import com.wanted.spring.domain.Company;
import com.wanted.spring.domain.EmploymentNotice;
import com.wanted.spring.dto.company.CompanyRegisterRequestDto;
import com.wanted.spring.dto.employment_notice.EmploymentNoticeRegisterRequestDto;
import com.wanted.spring.repository.CompanyRepository;
import com.wanted.spring.repository.EmploymentNoticeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmploymentNoticeService {
    private final EmploymentNoticeRepository employmentNoticeRepository;
    private final CompanyRepository companyRepository;

    public EmploymentNoticeService(EmploymentNoticeRepository employmentNoticeRepository, CompanyRepository companyRepository) {
        this.employmentNoticeRepository = employmentNoticeRepository;
        this.companyRepository = companyRepository;
    }

    public EmploymentNotice registerEmploymentNotice(EmploymentNoticeRegisterRequestDto body) {
        try{
            Company company = companyRepository.findById(body.getCompanyId()).orElseThrow(() -> new RuntimeException("can not find company"));
            EmploymentNotice employmentNotice = EmploymentNotice.builder()
                    .region(body.getRegion())
                    .tools(body.getTools())
                    .description(body.getDescription())
                    .compensation(body.getCompensation())
                    .position(body.getPosition())
                    .company(company)
                    .build();
            return employmentNoticeRepository.save(employmentNotice);
        } catch (Exception e) {
            System.out.println("e = " + e);
            throw new RuntimeException(e);
        }
    }

    public void deleteEmploymentNotice(Long id) {
        EmploymentNotice employmentNotice = employmentNoticeRepository.findById(id).orElseThrow();
        employmentNoticeRepository.delete(employmentNotice);
    }

    public EmploymentNotice updateEmploymentNotice(Long id, EmploymentNoticeRegisterRequestDto body) {
        EmploymentNotice employmentNotice = employmentNoticeRepository.findById(id).orElseThrow(() -> new RuntimeException("can not find employment notice"));
        Company company = companyRepository.findById(body.getCompanyId()).orElseThrow(() -> new RuntimeException("can not find company"));
        employmentNotice.setCompany(company);
        employmentNotice.setDescription(body.getDescription());
        employmentNotice.setRegion(body.getRegion());
        employmentNotice.setPosition(body.getPosition());
        employmentNotice.setCompensation(body.getCompensation());
        employmentNotice.setTools(body.getTools());
        employmentNoticeRepository.save(employmentNotice);
        return employmentNotice;
    }
}
