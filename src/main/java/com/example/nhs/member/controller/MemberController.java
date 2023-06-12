package com.example.nhs.member.controller;

import com.example.nhs.member.service.MemberService;
import com.example.nhs.member.service.dto.AddMemberRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public String signUp(AddMemberRequest request) {
        log.debug("request : {} ", request);
        memberService.save(request);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler()
                .logout(request, response,
                        SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";

    }
}
