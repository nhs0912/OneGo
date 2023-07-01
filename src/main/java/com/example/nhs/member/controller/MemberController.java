package com.example.nhs.member.controller;

import com.example.nhs.config.jwt.JwtProperties;
import com.example.nhs.config.jwt.TokenProvider;
import com.example.nhs.member.domain.Member;
import com.example.nhs.member.service.MemberService;
import com.example.nhs.member.service.dto.AddMemberRequest;
import com.example.nhs.member.service.dto.SignInMemberRequest;
import com.example.nhs.member.service.dto.SignInMemberResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RequiredArgsConstructor
@RestController
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final JwtProperties jwtProperties;
    private final TokenProvider tokenProvider;

    @PostMapping("/member")
    public String signUp(@RequestBody AddMemberRequest request) {
        log.info("request ====== {} ", request);
        memberService.save(request);
        return HttpStatus.OK.toString();
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler()
                .logout(request, response,
                        SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";

    }

    @PostMapping("/signin")
    public ResponseEntity<SignInMemberResponse> signIn(@RequestBody SignInMemberRequest request) {
        log.info("signin request ====== {} ", request);
        Member member = memberService.findByEmployeeId(request.getEmployeeId());

        if (!member.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호를 확인하세요.");
        }

        String generatedToken = tokenProvider.generateToken(member, Duration.ofHours(2));

        SignInMemberResponse signInMemberResponse = SignInMemberResponse.builder()
                .token(generatedToken)
                .build();
        return new ResponseEntity<>(signInMemberResponse, HttpStatus.OK);
    }
}
