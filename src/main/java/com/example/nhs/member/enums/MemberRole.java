package com.example.nhs.member.enums;

import java.util.Arrays;

public enum MemberRole {
    ADMIN("01", "ADMIN"), MEMBER("02", "MEMBER");

    private final String code;
    private final String value;

    MemberRole(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static MemberRole valueFrom(String code) {
        return Arrays.stream(values())
                .filter(role -> role.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 멤버 코드가 입력 되었습니다."));
    }

    public String code() {
        return this.code;
    }

    public String value() {
        return this.value;
    }
}
