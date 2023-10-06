package com.wanted.spring.controller;

import com.wanted.spring.domain.EmploymentNotice;
import com.wanted.spring.dto.employment_notice.EmploymentNoticeNoDetailResponseDto;
import com.wanted.spring.dto.employment_notice.EmploymentNoticeRegisterRequestDto;
import com.wanted.spring.dto.employment_notice.EmploymentNoticeYesDetailResponseDto;
import com.wanted.spring.service.EmploymentNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employment-notice")
public class EmploymentNoticeController {
    private final EmploymentNoticeService employmentNoticeService;

    @Autowired
    public EmploymentNoticeController(EmploymentNoticeService employmentNoticeService) {
        this.employmentNoticeService = employmentNoticeService;
    }

    // 등록
    @PostMapping
    public ResponseEntity<EmploymentNotice> registerEmploymentNotice(
            @RequestBody EmploymentNoticeRegisterRequestDto body
    ) {
        return ResponseEntity.ok(employmentNoticeService.registerEmploymentNotice(body));
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<EmploymentNotice> updateEmploymentNotice(
            @PathVariable Long id,
            @RequestBody EmploymentNoticeRegisterRequestDto body
    ) {
        return ResponseEntity.ok(employmentNoticeService.updateEmploymentNotice(id, body));
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmploymentNotice(
            @PathVariable Long id
    ) {
        employmentNoticeService.deleteEmploymentNotice(id);
        return ResponseEntity.ok("delete employment notice id : " + id);
    }

    // 전체 조회(description 미포함)
    @GetMapping("all")
    public ResponseEntity<List<EmploymentNoticeNoDetailResponseDto>> getAllEmploymentNotice(){
        return ResponseEntity.ok(employmentNoticeService.getAllEmploymentNotice());
    }

    // 특정 단어로 쿼리(description 미포함)
    @GetMapping
    public ResponseEntity<List<EmploymentNoticeNoDetailResponseDto>> getEmploymentNoticeByWord(
            @RequestParam String word
    ){
        return ResponseEntity.ok(employmentNoticeService.getEmploymentNoticeByWord(word));
    }

    // id로 특정 공고 조회
    @GetMapping("/{id}")
    public ResponseEntity<EmploymentNotice> getSpecificEmploymentNotice(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(employmentNoticeService.getEmploymentNoticeById(id));
    }

}
