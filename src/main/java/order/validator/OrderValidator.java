package main.java.order.validator;


import static main.java.validator.ErrorMessage.INVALID_INPUT;

public class OrderValidator {

    public static void validateYesOrNo(String choice) {
        if (!choice.equals("Y") && !choice.equals("N")) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
