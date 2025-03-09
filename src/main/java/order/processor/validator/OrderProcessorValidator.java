package main.java.order.processor.validator;

import main.java.separator.Separator;

import static main.java.order.processor.validator.OrderProcessorErrorMessage.EMPTY_INPUT;
import static main.java.order.processor.validator.OrderProcessorErrorMessage.NULL_INPUT;

public class OrderProcessorValidator {

    public static void validate(String input) {
        validateNull(input);
        validateEmpty(input);
        validateFirstInput(input);
        validateLastInput(input);
    }

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_INPUT.getMessage());
        }
    }

    public static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    public static void validateFirstInput(String input) {
        char firstCharacter = input.charAt(0);
        if (firstCharacter != Separator.LEFT_SQUARE_BRACKET) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLastInput(String input) {
        char lastCharacter = input.charAt(input.length() - 1);
        if (lastCharacter != Separator.RIGHT_SQUARE_BRACKET) {
            throw new IllegalArgumentException();
        }
    }


}
