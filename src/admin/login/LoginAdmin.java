package admin.login;

import admin.Admin;
import admin.create.CreateAdmin;
import admin.login.validator.LoginAdminValidator;
import io.input.Input;

public class LoginAdmin {

    public static void loginAdmin() {
        System.out.println("관리자 이름을 입력해주세요.");
        String inputLoginAdmin = Input.nextLine();

        try {
            LoginAdminValidator.validateLogin(inputLoginAdmin);
            Admin createdAdmin = CreateAdmin.getAdmin();

            System.out.println("로그인 성공! " + createdAdmin.getAdminName() + "님 환영합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
