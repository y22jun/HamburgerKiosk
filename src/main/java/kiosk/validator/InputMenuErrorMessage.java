package main.java.kiosk.validator;

public enum InputMenuErrorMessage {
    INVALID_NUMBER_INPUT("[ERROR] 입력값이 범위를 벗어났습니다. (0~4 사이의 숫자만 가능)"),
    ;

    private final String message;

    InputMenuErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
