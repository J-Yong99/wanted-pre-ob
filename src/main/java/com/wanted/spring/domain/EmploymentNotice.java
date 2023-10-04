package com.wanted.spring.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employment_notice")
public class EmploymentNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "position")
    private String position;

    @Column(name = "compensation")
    private String compensation;

    @Column(name = "description")
    private String description;

    @Column(name = "tools")
    private String tools;

    @Column(name = "region")
    private String region;

}