package com.example.nhs.member.service;

import com.example.nhs.member.domain.Member;
import com.example.nhs.member.repository.MemberRepository;
import com.example.nhs.member.service.dto.AddMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddMemberRequest dto) {
        return memberRepository.save(Member.builder()
                .emplyeeId(dto.getEmployeeId())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
