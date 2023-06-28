package com.example.nhs.base.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public abstract class BaseEntity {
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    @PrePersist //데이터 생성이 이루어질때 사전 작업
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate //데이터 수정이 이루어질 때 사전 작업
    public void preUpdate() {
        this.lastModifiedDate = LocalDateTime.now();
    }
}
