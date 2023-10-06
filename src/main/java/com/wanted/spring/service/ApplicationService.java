package com.wanted.spring.service;

import com.wanted.spring.domain.Application;
import com.wanted.spring.domain.EmploymentNotice;
import com.wanted.spring.domain.User;
import com.wanted.spring.dto.application.ApplicationRegisterRequestDto;
import com.wanted.spring.repository.ApplicationRepository;
import com.wanted.spring.repository.EmploymentNoticeRepository;
import com.wanted.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationService {
    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;
    private final EmploymentNoticeRepository employmentNoticeRepository;

    @Autowired
    public ApplicationService(UserRepository userRepository, ApplicationRepository applicationRepository, EmploymentNoticeRepository employmentNoticeRepository) {
        this.userRepository = userRepository;
        this.applicationRepository = applicationRepository;
        this.employmentNoticeRepository = employmentNoticeRepository;
    }

    @Transactional
    public Application registerApplication(ApplicationRegisterRequestDto body) {
        User user = userRepository.findById(body.getUserId()).orElseThrow(() -> new RuntimeException("can not find user"));
        EmploymentNotice employmentNotice = employmentNoticeRepository.findById(body.getEmploymentNoticeId()).orElseThrow(() -> new RuntimeException("can not find employment notice"));
        if (user.isApplied()){throw new RuntimeException("already applied");}
        Application application = Application.builder()
                .user(user)
                .employmentNotice(employmentNotice)
                .build();
        user.setApplied(true);
        userRepository.save(user);
        applicationRepository.save(application);
        return application;
    }
}
