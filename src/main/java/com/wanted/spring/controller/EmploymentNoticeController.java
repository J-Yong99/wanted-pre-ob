package com.wanted.spring.controller;

import com.wanted.spring.domain.EmploymentNotice;
import com.wanted.spring.dto.employment_notice.EmploymentNoticeRegisterRequestDto;
import com.wanted.spring.service.EmploymentNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/employment-notice")
public class EmploymentNoticeController {
    private final EmploymentNoticeService employmentNoticeService;

    public EmploymentNoticeController(EmploymentNoticeService employmentNoticeService) {
        this.employmentNoticeService = employmentNoticeService;
    }

    @PostMapping
    public ResponseEntity<EmploymentNotice> registerEmploymentNotice(@RequestBody EmploymentNoticeRegisterRequestDto body) {
        return ResponseEntity.ok(employmentNoticeService.registerEmploymentNotice(body));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentNotice> updateEmploymentNotice(@PathVariable Long id, @RequestBody EmploymentNoticeRegisterRequestDto body) {
        return ResponseEntity.ok(employmentNoticeService.updateEmploymentNotice(id, body));
    }

    @DeleteMapping("/{id}")
    public void deleteEmploymentNotice(@PathVariable Long id) {
        employmentNoticeService.deleteEmploymentNotice(id);
    }
}
