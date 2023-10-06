package com.wanted.spring.dto.application;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationRegisterRequestDto {
    private Long userId;
    private Long employmentNoticeId;
}
