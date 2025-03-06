package io.input;

import io.input.validator.InputMenuValidator;

import java.util.Scanner;

public class Input {

    private static Scanner SCANNER;

    private Input() {}

    private static Scanner getInstance() {
        if (SCANNER == null) {
            SCANNER = new Scanner(System.in);
        }
        return SCANNER;
    }

    public static String nextLine() {
        String inputMenuNumber = getInstance().nextLine();
        InputMenuValidator.validate(inputMenuNumber);
        return inputMenuNumber;
    }

    public static int nextInt() {
        return getInstance().nextInt();
    }

    public static void close() {
        if (SCANNER != null) {
            SCANNER.close();
            SCANNER = null;
        }
    }

}
