package com.example.nhs.member.controller.dto;

import com.example.nhs.member.domain.Member;
import com.example.nhs.member.enums.MemberRole;
import com.example.nhs.member.service.dto.MemberSaveServiceRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SignUpRequest {

    private String employeeId;
    private String password;
    private String name;
    private String memberRole;
    private Long teamId;

    public SignUpRequest(){

    }
    public Member toMember(){
        return Member.builder()
                .employeeId(this.employeeId)
                .password(this.password)
                .name(this.name)
                .role(MemberRole.valueFrom(this.memberRole))
                .teamId(this.teamId)
                .build();
    }
    public MemberSaveServiceRequest toMemberSaveServiceRequest(){
        return MemberSaveServiceRequest.builder()
                .employeeId(this.employeeId)
                .password(this.password)
                .name(this.name)
                .memberRole(this.memberRole)
                .teamId(this.teamId)
                .build();
    }

}
