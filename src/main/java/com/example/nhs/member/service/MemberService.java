package com.example.nhs.member.service;

import com.example.nhs.member.domain.Member;
import com.example.nhs.member.enums.MemberRole;
import com.example.nhs.member.enums.MemberStatus;
import com.example.nhs.member.repository.MemberRepository;
import com.example.nhs.member.service.dto.MemberSaveServiceRequest;
import com.example.nhs.team.enums.TeamKind;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long save(MemberSaveServiceRequest dto) {
        log.info("dto info = {}", dto);
        return memberRepository.save(Member.builder()
                .employeeId(dto.getEmployeeId())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .name(dto.getName())
                .status(MemberStatus.NORMAL)
                .teamId(TeamKind.valueFrom(dto.getTeamId()).code())
                .role(MemberRole.valueFrom(dto.getMemberRole()))
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build()).getId();
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    public Member findByEmployeeId(String employeeId) {
        return memberRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
