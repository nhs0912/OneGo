package com.example.nhs.member.service;

import com.example.nhs.member.domain.Member;
import com.example.nhs.member.enums.MemberRole;
import com.example.nhs.member.repository.MemberRepository;
import com.example.nhs.member.service.dto.AddMemberRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("id로 멤버 찾는 테스트")
    void findById() {
        Long memberId = makeMember();
        Member findMember = memberService.findById(memberId);
        assertSoftly(softly -> {
                    softly.assertThat(findMember.getEmployeeId()).isEqualTo("MT01763");
                    softly.assertThat(findMember.getName()).isEqualTo("HEESEOK");
                    softly.assertThat(findMember.getRole()).isEqualTo(MemberRole.MEMBER);
                    softly.assertThat(findMember.getTeamId()).isEqualTo(1L);
                }
        );
    }

    @Test
    @DisplayName("EmployeeId로 멤버 찾는 테스트")
    void findByEmployeeId() {
        makeMember();
        Member findMember = memberService.findByEmployeeId("MT01763");
        assertSoftly(softly -> {
                    softly.assertThat(findMember.getName()).isEqualTo("HEESEOK");
                    softly.assertThat(findMember.getRole()).isEqualTo(MemberRole.MEMBER);
                    softly.assertThat(findMember.getTeamId()).isEqualTo(1L);
                }
        );
    }

    @Test
    @DisplayName("멤버 저장 서비스 테스트")
    void saveMemberTest() {
        Long mt017631Id = makeMember();

        Member findMember = memberService.findById(mt017631Id);

        assertThat(findMember.getEmployeeId()).isEqualTo("MT01763");
    }

    private Long makeMember() {
        return memberService.save(AddMemberRequest.builder()
                .employeeId("MT01763")
                .name("HEESEOK")
                .password("1234")
                .memberRole(MemberRole.MEMBER.code())
                .teamId(1L)
                .build());
    }
}