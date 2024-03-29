package com.example.nhs.member.controller;

import com.example.nhs.config.jwt.TokenProvider;
import com.example.nhs.member.controller.dto.SignUpRequest;
import com.example.nhs.member.controller.dto.SignUpResponse;
import com.example.nhs.member.controller.dto.TestInputIn;
import com.example.nhs.member.domain.Member;
import com.example.nhs.member.service.MemberService;
import com.example.nhs.member.service.dto.MemberSignInServiceRequest;
import com.example.nhs.member.service.dto.MemberSignInServiceResponse;
import com.example.nhs.token.service.RefreshTokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/test")
    public String testSignin(@RequestBody TestInputIn testInputIn) {
        log.info("test method 실행");
        log.info("testInputIn === {}", testInputIn);
        return "test success";
    }

    @PostMapping("/member")
    @Transactional
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest request) {
        log.info("request ====== {} ", request);
//        Member member = memberService.findByEmployeeId(request.getEmployeeId());
//
//        if(member != null){
//                throw new IllegalArgumentException("이미 가입되어있는 회원입니다.");
//        }
        Long savedId = memberService.save(request.toMemberSaveServiceRequest());

        return new ResponseEntity(HttpStatus.OK);
    }



    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler()
                .logout(request, response,
                        SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";

    }

    @PostMapping("/signin")
    public ResponseEntity<MemberSignInServiceResponse> signin(@RequestBody MemberSignInServiceRequest request) {
        log.info("signin request ====== {} ", request);
        Member member = memberService.findByEmployeeId(request.getEmployeeId());

        if (!checkPassword(member.getPassword(), request.getPassword())) {
            throw new IllegalArgumentException("비밀번호를 확인하세요.");
        }

        String generatedToken = tokenProvider.generateAccessToken(member, Duration.ofHours(2));
        String generatedRefreshToken = tokenProvider.generateRefreshToken(member, Duration.ofHours(24));
        refreshTokenService.saveRefreshToken(member.getId(), generatedRefreshToken);

        MemberSignInServiceResponse signInMemberResponse = MemberSignInServiceResponse.builder()
                .token(generatedToken)
                .refreshToken(generatedRefreshToken)
                .build();

        log.info("response === {}", signInMemberResponse);
        Authentication authentication = tokenProvider.getAuthentication(generatedToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok()
                .header("refreshToken", generatedRefreshToken)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + generatedToken)
                .build();
    }

    //Spring EL
    @PostMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "admin page 입니다.";
    }

    private boolean checkPassword(String password, String inputPassword) {
        return bCryptPasswordEncoder.matches(inputPassword, password);
    }
}
