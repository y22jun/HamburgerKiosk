package main.java.file.validator;

import java.io.File;

import static main.java.validator.ErrorMessage.*;

public class LoadProductsFileValidator {

    public static void validate(File file) {
        validateFileNull(file);
        validateFileExists(file);
        validateFileReadable(file);
        validateFileWriteable(file);
    }

    private static void validateFileNull(File file) {
        if (file == null) {
            throw new IllegalArgumentException(FILE_NULL.getMessage());
        }
    }

    private static void validateFileExists(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(FILE_NOT_EXISTS.getMessage());
        }
    }

    private static void validateFileReadable(File file) {
        if (!file.canRead()) {
            throw new IllegalArgumentException(FILE_READ_ERROR.getMessage());
        }
    }

    private static void validateFileWriteable(File file) {
        if (!file.canWrite()) {
            throw new IllegalArgumentException(FILE_WRITE_ERROR.getMessage());
        }
    }
}
