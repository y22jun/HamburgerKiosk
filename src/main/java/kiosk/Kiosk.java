package main.java.kiosk;

import main.java.admin.create.CreateAdmin;
import main.java.admin.login.LoginAdmin;
import main.java.io.input.Input;
import main.java.io.output.MenuOutput;
import main.java.member.create.CreateMember;
import main.java.member.login.LoginMember;
import main.java.order.Order;

public class Kiosk {

    private final CreateAdmin createAdmin = new CreateAdmin();
    private final LoginAdmin loginAdmin = new LoginAdmin();
    private final CreateMember createMember = new CreateMember();
    private final LoginMember loginMember = new LoginMember();
    private final Order order = new Order();

    public void startKiosk() {
        try {
            while (true) {
                MenuOutput.outputMenu();
                String inputMenuNumber = Input.nextLine();

                switch (inputMenuNumber) {
                    case "0" -> {
                        return;
                    }
                    case "1" -> createAdmin.createAdmin();
                    case "2" -> loginAdmin.loginAdmin();
                    case "3" -> createMember.createMember();
                    case "4" -> loginMember.loginMember();

                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void startOrder() {
        order.startOrder();
    }
}
