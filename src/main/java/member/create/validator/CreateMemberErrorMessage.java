package main.java.member.create.validator;

public enum CreateMemberErrorMessage {
    INVALID_MONEY("[ERROR] 보유금액은 0이상이어야 합니다."),
    INVALID_FORMAT("[ERROR] 입력 형식이 잘못되었습니다. 회원 아이디와 보유금액을 쉼표로 구분해 주세요."),
    INVALID_NAME_LENGTH("[ERROR] 아이디는 1자 이상이어야 합니다."),
    INVALID_MONEY_FORMAT("[ERROR] 보유금액은 숫자로만 입력해주세요.")
    ;

    private final String message;

    CreateMemberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
