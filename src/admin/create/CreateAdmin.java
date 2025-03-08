package admin.create;

import admin.Admin;
import admin.create.validator.CreateAdminValidator;
import io.input.Input;
import split.Split;

public class CreateAdmin {

    private static Admin createAdmin;
    private static boolean adminExists = false;

    public static void createAdmin() {
        System.out.println("관리자의 정보를 입력하세요. ex) 관리자1, 100000");
        String inputCreateAdmin = Input.nextLine();

        try {
            CreateAdminValidator.validateInput(inputCreateAdmin);

            String[] parts = Split.splitInput(inputCreateAdmin);
            String name = parts[0].trim();
            int money = Integer.parseInt(parts[1].trim());

            createAdmin = new Admin(name, money);
            adminExists = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Admin getAdmin() {
        return createAdmin;
    }

    public static boolean isAdminExists() {
        return adminExists;
    }
}
