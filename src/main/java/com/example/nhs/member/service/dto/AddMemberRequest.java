package com.example.nhs.member.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberRequest {
    private String employeeId;
    private String password;
    private String name;

    @Override
    public String toString() {
        return "employeeId = " + employeeId + " , " + "password = " + password + " , name= " + name;
    }
}
