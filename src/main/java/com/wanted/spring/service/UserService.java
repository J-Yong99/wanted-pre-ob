package com.wanted.spring.service;

import com.wanted.spring.domain.Company;
import com.wanted.spring.domain.User;
import com.wanted.spring.dto.company.CompanyRegisterRequestDto;
import com.wanted.spring.dto.user.UserRegisterRequestDto;
import com.wanted.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserRegisterRequestDto body) {
        try{
            User user = User.builder()
                    .age(body.getAge())
                    .name(body.getName())
                    .isApplied(false)
                    .build();
            return userRepository.save(user);
        } catch (Exception e) {
            System.out.println("e = " + e);
            throw new RuntimeException(e);
        }
    }
}
