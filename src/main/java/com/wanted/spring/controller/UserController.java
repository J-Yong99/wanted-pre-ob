package com.wanted.spring.controller;

import com.wanted.spring.domain.Company;
import com.wanted.spring.domain.User;
import com.wanted.spring.dto.company.CompanyRegisterRequestDto;
import com.wanted.spring.dto.user.UserRegisterRequestDto;
import com.wanted.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 등록
    @PostMapping()
    public ResponseEntity<User> registerUser(
            @RequestBody UserRegisterRequestDto body
    ){
        return ResponseEntity.ok(userService.registerUser(body));
    }
}
