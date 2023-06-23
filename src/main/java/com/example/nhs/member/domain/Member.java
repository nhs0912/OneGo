package com.example.nhs.member.domain;

import com.example.nhs.base.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = true, unique = true)
    private String email;

    @Column(name = "employeeId", nullable = false, unique = true)
    String employeeId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "grade")
    private String grade;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String status;

    @Column(name = "teamId")
    private Long teamId;

    @Builder
    public Member(String emplyeeId, String password, String name) {
        this.employeeId = emplyeeId;
        this.password = password;
        this.name = name;
    }

    @Builder
    public Member(String emplyeeId, String password, String name, String grade, String role, String status, Long teamId) {
        this(emplyeeId, password, name);
        this.role = role;
        this.grade = grade;
        this.email = email;
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
