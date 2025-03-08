package main.java.member.login.validator;

public enum LoginMemberErrorMessage {
    MEMBER_NOT_FOUND("[ERROR] 아직 회원이 생성되지 않았습니다."),
    INVALID_MEMBER_NAME("[ERROR] 회원 아이디가 일치하지 않습니다.")
    ;

    private final String message;

    LoginMemberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
