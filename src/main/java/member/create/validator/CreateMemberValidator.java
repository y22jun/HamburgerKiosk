package main.java.member.create.validator;

import main.java.split.Split;

public class CreateMemberValidator {

    public static void validateInput(String input) {
        String[] parts = Split.splitInput(input);

        validateFormat(parts);
        String name = parts[0].trim();
        String money = parts[1].trim();

        validateName(name);
        validateMoney(money);
    }

    private static void validateFormat(String[] parts) {
        if (parts.length != 2) {
            throw new IllegalArgumentException(CreateMemberErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    private static void validateName(String name) {
        validateNameLength(name);
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CreateMemberErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }

    private static void validateMoney(String money) {
        validateMoneyFormat(money);
        validateMoneyNonNegative(money);
    }

    private static void validateMoneyFormat(String money) {
        try {
            Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(CreateMemberErrorMessage.INVALID_MONEY_FORMAT.getMessage());
        }
    }

    private static void validateMoneyNonNegative(String money) {
        int memberMoney = Integer.parseInt(money);
        if (memberMoney < 0) {
            throw new IllegalArgumentException(CreateMemberErrorMessage.INVALID_MONEY.getMessage());
        }
    }
}
