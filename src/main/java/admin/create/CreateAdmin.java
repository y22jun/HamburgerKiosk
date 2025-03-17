package main.java.admin.create;

import main.java.admin.Admin;
import main.java.admin.create.validator.CreateAdminValidator;
import main.java.admin.dto.AdminInfoDto;
import main.java.io.input.Input;
import main.java.split.Split;
import main.java.user.domain.User;

public class CreateAdmin {

    private static Admin createAdmin;
    private static boolean adminExists = false;

    public AdminInfoDto createAdmin() {
        System.out.println("관리자의 정보를 입력하세요. ex) 관리자1, 100000");
        String inputCreateAdmin = Input.nextLine();

        try {
            CreateAdminValidator.validateInput(inputCreateAdmin);

            String[] parts = Split.splitInput(inputCreateAdmin);
            String name = parts[0].trim();
            int money = Integer.parseInt(parts[1].trim());

//            createAdmin = new Admin(name, money, User.ADMIN);
            adminExists = true;
            return new AdminInfoDto(name, money, User.ADMIN);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createAdmin();
        }
    }

    public static Admin getAdmin() {
        return createAdmin;
    }

    public static boolean isAdminExists() {
        return adminExists;
    }
}
