package com.wanted.spring.controller;

import com.wanted.spring.domain.Application;
import com.wanted.spring.dto.application.ApplicationRegisterRequestDto;
import com.wanted.spring.service.ApplicationService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;
    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    // 등록
    @PostMapping
    @Operation(summary = "등록", description = "일반 유저가 지원서를 등록합니다.")
    public ResponseEntity<Application> registerApplication(
            @RequestBody ApplicationRegisterRequestDto body
    ) {
        return ResponseEntity.ok(applicationService.registerApplication(body));
    }
}
