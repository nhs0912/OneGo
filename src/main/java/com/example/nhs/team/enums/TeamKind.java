package com.example.nhs.team.enums;

import java.util.Arrays;

public enum TeamKind {
    FO(1L, "FO"), BO(2L, "BO"), COMMON(3L, "COMMON");

    private final Long code;
    private final String value;

    TeamKind(Long code, String value) {
        this.code = code;
        this.value = value;
    }

    public static TeamKind valueFrom(Long code) {
        return Arrays.stream(values())
                .filter(role -> role.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 팀 종류 코드가 입력 되었습니다."));
    }

    public Long code() {
        return this.code;
    }

    public String value() {
        return this.value;
    }
}
