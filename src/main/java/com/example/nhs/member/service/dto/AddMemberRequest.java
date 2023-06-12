package com.example.nhs.member.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberRequest {
    private String employeeId;
    private String password;
}
