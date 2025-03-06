package admin.create;

import admin.Admin;
import io.input.Input;
import separator.Separator;

public class CreateAdmin {

    public static void createAdmin() {
        System.out.println("관리자의 정보를 입력하세요. ex) 관리자1, 100000");
        String inputCreateAdmin = Input.nextLine();

        String[] parts = inputCreateAdmin.split(Separator.COMMA);
        String adminName = parts[0].trim();
        int adminMoney = Integer.parseInt(parts[1].trim());

        Admin admin = new Admin(adminName, adminMoney);
    }
}
