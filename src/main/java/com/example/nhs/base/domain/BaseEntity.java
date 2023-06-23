package com.example.nhs.base.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
