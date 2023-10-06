package com.wanted.spring.dto.user;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterRequestDto {
    private String name;
    private Integer age;
}
