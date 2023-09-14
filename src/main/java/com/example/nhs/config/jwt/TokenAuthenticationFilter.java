package com.example.nhs.config.jwt;

import com.example.nhs.member.domain.Member;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private final TokenProvider tokenProvider;
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String REFRESH_TOKEN = "Refreshtoken";
    private final static String TOKEN_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //요청 헤더의 Authorization 키의 값 조회
        String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);
        //가져온 값에서 접두사 제거
        String accessToken = getAccessToken(authorizationHeader);

        String refreshToken = request.getHeader(REFRESH_TOKEN);

        //가져온 토큰이 유효한지 확인하고, 유효한 때는 인증 정보를 설정
        if (tokenProvider.validToken(accessToken)) {
            Authentication authentication = tokenProvider.getAuthentication(accessToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        if (!tokenProvider.validToken(accessToken) && tokenProvider.checkRefreshToken(refreshToken)) {
            Long memberId = tokenProvider.getMemberId(refreshToken);
            String employeeId = tokenProvider.getEmployeeId(refreshToken);
            String generateAccessToken = tokenProvider.generateAccessToken(Member.builder()
                    .id(memberId)
                    .employeeId(employeeId)
                    .build(), Duration.ofHours(2));

            Authentication authentication = tokenProvider.getAuthentication(generateAccessToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        if (!tokenProvider.validToken(accessToken) && !tokenProvider.checkRefreshToken(refreshToken)) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType(MediaType.APPLICATION_JSON.getType());
        }
        filterChain.doFilter(request, response);
    }

    private String getAccessToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)) {
            return authorizationHeader.substring(TOKEN_PREFIX.length());
        }
        return null;
    }
}
