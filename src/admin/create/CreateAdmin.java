package admin.create;

import admin.Admin;
import admin.create.validator.CreateAdminValidator;
import io.input.Input;
import split.Split;

public class CreateAdmin {

    public static void createAdmin() {
        System.out.println("관리자의 정보를 입력하세요. ex) 관리자1, 100000");
        String inputCreateAdmin = Input.nextLine();

        try {
            CreateAdminValidator.validateInput(inputCreateAdmin);

            String[] parts = Split.splitInput(inputCreateAdmin);
            String name = parts[0].trim();
            int money = Integer.parseInt(parts[1].trim());

            Admin admin = new Admin(name, money);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
