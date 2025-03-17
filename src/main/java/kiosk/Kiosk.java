package main.java.kiosk;

import main.java.admin.create.CreateAdmin;
import main.java.admin.login.LoginAdmin;
import main.java.io.input.Input;
import main.java.io.output.MenuOutput;
import main.java.member.create.CreateMember;
import main.java.member.login.LoginMember;

public class Kiosk {

    public void startKiosk() {
        try {
            while (true) {
                MenuOutput.outputMenu();
                String inputMenuNumber = Input.nextLine();

                switch (inputMenuNumber) {
                    case "0" -> {
                        return;
                    }
                    case "1" -> CreateAdmin.createAdmin();
                    case "2" -> LoginAdmin.loginAdmin();
                    case "3" -> CreateMember.createMember();
                    case "4" -> LoginMember.loginMember();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
