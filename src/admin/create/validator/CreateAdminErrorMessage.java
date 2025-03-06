package admin.create.validator;

public enum CreateAdminErrorMessage {
    INVALID_MONEY("[ERROR] 보유금액은 0이상이어야 합니다."),
    ;

    private final String message;

    CreateAdminErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
