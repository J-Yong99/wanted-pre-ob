package com.wanted.spring.dto.employment_notice;

import com.wanted.spring.domain.Company;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmploymentNoticeRegisterRequestDto {
    private Long companyId;
    private String position;
    private String compensation;
    private String description;
    private String tools;
    private String region;
}
