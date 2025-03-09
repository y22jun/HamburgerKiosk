package main.java.order.validator;

import static main.java.order.validator.OrderErrorMessage.INVALID_INPUT;

public class OrderValidator {

    public static void validateYesOrNo(String choice) {
        if (!choice.equals("Y") && !choice.equals("N")) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
