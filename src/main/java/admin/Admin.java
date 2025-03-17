package main.java.admin;

import main.java.user.domain.User;

public class Admin {

    private final String adminName;
    private int adminMoney;
    private final User user;

    public Admin(String adminName, int adminMoney, User user) {
        this.adminName = adminName;
        this.adminMoney = adminMoney;
        this.user = user;
    }

    public String getAdminName() {
        return adminName;
    }

    public int getAdminMoney() {
        return adminMoney;
    }

    public User getUser() {
        return user;
    }

    public void increaseAdminMoney(int amount) {
        adminMoney += amount;
    }

}
