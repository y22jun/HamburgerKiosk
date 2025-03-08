package main.java.admin.login.validator;

public enum LoginAdminErrorMessage {
    ADMIN_NOT_FOUND("[ERROR] 아직 관리자가 생성되지 않았습니다."),
    INVALID_ADMIN_NAME("[ERROR] 관리자 이름이 일치하지 않습니다.")
    ;

    private final String message;

    LoginAdminErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
