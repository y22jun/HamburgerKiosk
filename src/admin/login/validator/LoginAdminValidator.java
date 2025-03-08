package admin.login.validator;

import admin.Admin;
import admin.create.CreateAdmin;

public class LoginAdminValidator {

    public static void validateLogin(String inputAdminName) {
        validateAdminExistence();
        validateAdminName(inputAdminName);
    }

    private static void validateAdminExistence() {
        if (!CreateAdmin.isAdminExists()) {
            throw new IllegalArgumentException(LoginAdminErrorMessage.ADMIN_NOT_FOUND.getMessage());
        }
    }

    private static void validateAdminName(String inputAdminName) {
        Admin createdAdmin = CreateAdmin.getAdmin();

        if (!createdAdmin.getAdminName().equals(inputAdminName)) {
            throw new IllegalArgumentException(LoginAdminErrorMessage.INVALID_ADMIN_NAME.getMessage());
        }
    }
}
