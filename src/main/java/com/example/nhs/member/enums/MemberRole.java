package com.example.nhs.member.enums;

public enum MemberRole {
    ADMIN("01", "ADMIN"), MEMBER("02", "MEMBER");

    private final String code;
    private final String value;

    MemberRole(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String code() {
        return this.code;
    }

    public String value() {
        return this.value;
    }
}
