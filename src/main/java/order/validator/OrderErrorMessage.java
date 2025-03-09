package main.java.order.validator;

public enum OrderErrorMessage {
    INVALID_INPUT("잘못된 입력입니다. Y 또는 N만 입력 가능합니다."),
    ;

    private final String message;

    OrderErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
