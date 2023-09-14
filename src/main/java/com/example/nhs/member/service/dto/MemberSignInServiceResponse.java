package com.example.nhs.member.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberSignInServiceResponse {
    private String token;
    private String refreshToken;
}
