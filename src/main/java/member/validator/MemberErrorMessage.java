package main.java.member.validator;

public enum MemberErrorMessage {
    NO_MONEY("[ERROR] 잔액이 부족합니다."),
    ;

    private final String message;

    MemberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
