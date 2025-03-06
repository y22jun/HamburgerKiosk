package io.input.validator;

import static io.input.validator.InputMenuErrorMessage.INVALID_NUMBER_INPUT;

public class InputMenuValidator {

    private static final int ZERO = 0;
    private static final int FOUR = 4;

    public static void validate(int inputNumber) {
        validateInvalidNumber(inputNumber);
    }

    private static void validateInvalidNumber(int inputNumber) {
        if (inputNumber < ZERO || inputNumber > FOUR) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT.getMessage());
        }
    }

}
