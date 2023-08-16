package com.example.nhs.member.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberRequest {
    private String employeeId;
    private String password;
    private String name;
    private String memberRole;
    private Long teamId;

    @Override
    public String toString() {
        return "employeeId = " + employeeId + " , " + "password = " + password + " , name= " + name + " ,memberRole= " + memberRole +" ,teamId= " + teamId;
    }
}
