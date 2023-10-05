package com.wanted.spring.dto.employment_notice;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmploymentNoticeYesDetailResponseDto {
    private Long id;
    private String companyName;
    private String position;
    private String compensation;
    private String tools;
    private String region;
    private String description;
}
