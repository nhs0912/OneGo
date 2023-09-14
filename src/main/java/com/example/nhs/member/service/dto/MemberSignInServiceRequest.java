package com.example.nhs.member.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignInServiceRequest {
    private String employeeId;
    private String password;

    @Override
    public String toString() {
        return "employeeId = " + employeeId + " , " + "password = " + password;
    }
}
