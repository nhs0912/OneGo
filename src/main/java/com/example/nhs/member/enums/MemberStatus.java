package com.example.nhs.member.enums;

public enum MemberStatus {

    NORMAL("01", "NORMAL"),
    TERMINATE("02", "NORMAL");

    private final String code;
    private final String value;

    MemberStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String code() {
        return this.code;
    }

    public String value(){
        return this.value;
    }
}
