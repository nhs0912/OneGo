package com.example.nhs.member.service;


import com.example.nhs.member.domain.Member;
import com.example.nhs.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
//스프링 시큐티에서 사용자 정보를 가져오는 인터페이스
public class MemberDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;

    //시용자 이름(employeeId)로 사용자의 정보를 가져오는 메서드
    @Override
    public Member loadUserByUsername(String employeeId) throws UsernameNotFoundException {
        return memberRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new IllegalArgumentException(employeeId));
    }
}
