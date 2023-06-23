package com.example.nhs.team.domain;

import com.example.nhs.base.domain.BaseEntity;
import jakarta.persistence.*;

@Entity
public class Team extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
