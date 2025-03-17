package main.java.admin.login.validator;

import main.java.admin.Admin;
import main.java.admin.create.CreateAdmin;

import static main.java.validator.ErrorMessage.ADMIN_NOT_FOUND;
import static main.java.validator.ErrorMessage.INVALID_ADMIN_NAME;

public class LoginAdminValidator {

    public static void validateLogin(String inputAdminName) {
        validateAdminExistence();
        validateAdminName(inputAdminName);
    }

    private static void validateAdminExistence() {
        if (!CreateAdmin.isAdminExists()) {
            throw new IllegalArgumentException(ADMIN_NOT_FOUND.getMessage());
        }
    }

    private static void validateAdminName(String inputAdminName) {
        Admin createdAdmin = CreateAdmin.getAdmin();

        if (!createdAdmin.getAdminName().equals(inputAdminName)) {
            throw new IllegalArgumentException(INVALID_ADMIN_NAME.getMessage());
        }
    }
}
