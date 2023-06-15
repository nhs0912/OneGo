package com.example.nhs.token.service;

import com.example.nhs.config.jwt.TokenProvider;
import com.example.nhs.member.domain.Member;
import com.example.nhs.member.service.MemberService;
import com.example.nhs.token.domain.RefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final MemberService memberService;

    public String createNewAccessToken(String refreshToken) {
        //토큰 유효성 검사에 실패하면 예외 발생
        if (!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        RefreshToken foundRefreshToken = refreshTokenService.findByRefreshToken(refreshToken);
        Long memberId = foundRefreshToken.getMemberId();

        Member member = memberService.findById(memberId);
        return tokenProvider.generateToken(member, Duration.ofHours(2));
    }
}
