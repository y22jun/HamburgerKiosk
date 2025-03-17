package main.java.admin.login;

import main.java.admin.Admin;
import main.java.admin.create.CreateAdmin;
import main.java.admin.login.validator.LoginAdminValidator;
import main.java.io.input.Input;

public class LoginAdmin {

    public void loginAdmin() {
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
