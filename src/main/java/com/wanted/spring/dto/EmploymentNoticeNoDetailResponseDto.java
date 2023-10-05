package com.wanted.spring.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmploymentNoticeNoDetailResponseDto {
    private Long id;
    private String companyName;
    private String position;
    private String compensation;
    private String tools;
    private String region;
}
