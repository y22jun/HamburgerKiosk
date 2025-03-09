package main.java.order.processor.validator;

public enum OrderProcessorErrorMessage {
    NULL_INPUT("[ERROR] 입력값이 null 입니다."),
    EMPTY_INPUT("[ERROR] 입력값이 비어있습니다."),
    ;

    private final String message;

    OrderProcessorErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
