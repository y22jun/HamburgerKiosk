package io.input.validator;

import static io.input.validator.InputMenuErrorMessage.INVALID_NUMBER_INPUT;

public class InputMenuValidator {

    private static final int ZERO = 0;
    private static final int FOUR = 4;

    public static void validate(String inputNumber) {
        validateInvalidNumber(inputNumber);
    }

    private static void validateNull(String inputNumber) {
        if (inputNumber == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInvalidNumber(String inputNumber) {
        int validateNumber = Integer.parseInt(inputNumber);
        if (validateNumber < ZERO || validateNumber > FOUR) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT.getMessage());
        }
    }

}
