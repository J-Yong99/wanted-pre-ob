package com.wanted.spring.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employment_notice_id")
    private EmploymentNotice employmentNotice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
