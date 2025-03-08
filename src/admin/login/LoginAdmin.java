package admin.login;

import admin.Admin;
import admin.create.CreateAdmin;
import io.input.Input;

public class LoginAdmin {

    public static void loginAdmin() {
        System.out.println("관리자 이름을 입력해주세요.");
        String inputLoginAdmin = Input.nextLine();

        Admin createdAdmin = CreateAdmin.getAdmin();
        if (createdAdmin.getAdminName().equals(inputLoginAdmin)) {
            System.out.println("로그인 성공! " + createdAdmin.getAdminName() + "님 환영합니다.");
        }
    }
}
