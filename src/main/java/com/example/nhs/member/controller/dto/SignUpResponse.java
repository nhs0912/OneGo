package com.example.nhs.member.controller.dto;

import com.example.nhs.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SignUpResponse {
    private Long id;
    private String employeeId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedTime;

    public static SignUpResponse of(Member member) {
        return new SignUpResponse(member.getId(), member.getEmployeeId(), member.getCreatedDate(), member.getLastModifiedDate());
    }

    public SignUpResponse() {
        
    }

}
