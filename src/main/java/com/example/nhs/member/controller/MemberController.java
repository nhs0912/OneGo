package com.example.nhs.member.controller;

import com.example.nhs.member.service.MemberService;
import com.example.nhs.member.service.dto.AddMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public String signUp(AddMemberRequest request) {
        memberService.save(request);
        return "redirect:/login";
    }
}
