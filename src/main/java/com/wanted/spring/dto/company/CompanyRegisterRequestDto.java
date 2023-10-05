package com.wanted.spring.dto.company;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyRegisterRequestDto {
    private String name;
    private String description;
}
