package com.example.nhs.member.domain;

import com.example.nhs.base.domain.BaseEntity;
import com.example.nhs.member.enums.MemberRole;
import com.example.nhs.member.enums.MemberStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@SuperBuilder
public class Member extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;

    @Column(name = "email", nullable = true, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "grade")
    private String grade;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Column(name = "team_id")
    private Long teamId;

    public Member(String employeeId, String password, String name) {
        this.employeeId = employeeId;
        this.password = password;
        this.name = name;
    }

    public Member(String employeeId, String password, String name, String grade, MemberRole role, MemberStatus status, Long teamId) {
        this(employeeId, password, name);
        this.role = role;
        this.grade = grade;
        this.email = email;
        this.status = status;
        this.teamId = teamId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("member"));
    }

    @Override
    public String getUsername() {
        return employeeId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    //계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        //만료되었는지 확인하는 로직
        return true; //true -> 만료되지 않았음
    }

    //계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        //계정 잠금되었는지 확인하는 로직
        return true; //true -> 잠금되지 않았음
    }

    //패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        //password가 만료되었는지 확인하는 로직
        return true; //true -> 만료되지 않았음
    }

    //계정사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        //계정이 사용 가능한지 확인하는 로직
        return true; //true -> 사용 가능
    }
}
