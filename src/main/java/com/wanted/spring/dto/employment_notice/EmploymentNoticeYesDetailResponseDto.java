package com.wanted.spring.dto.employment_notice;

import com.wanted.spring.domain.EmploymentNotice;
import lombok.*;

import java.util.List;

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
    private List<Long> sameCompanyNotices;

    public static EmploymentNoticeYesDetailResponseDto fromEntity(EmploymentNotice en){
        return EmploymentNoticeYesDetailResponseDto.builder()
                .id(en.getId())
                .companyName(en.getCompany().getName())
                .position(en.getPosition())
                .compensation(en.getCompensation())
                .tools(en.getTools())
                .region(en.getRegion())
                .description(en.getDescription())
                .sameCompanyNotices(null)
                .build();
    }
}
