package main.java.admin.create.validator;

public enum CreateAdminErrorMessage {
    INVALID_MONEY("[ERROR] 보유금액은 0이상이어야 합니다."),
    INVALID_FORMAT("[ERROR] 입력 형식이 잘못되었습니다. 이름과 보유금액을 쉼표로 구분해 주세요."),
    INVALID_NAME_LENGTH("[ERROR] 이름은 1자 이상이어야 합니다."),
    INVALID_MONEY_FORMAT("[ERROR] 보유금액은 숫자로만 입력해주세요."),
    ADMIN_ALREADY_EXISTS("이미 관리자가 존재합니다.")
    ;

    private final String message;

    CreateAdminErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
