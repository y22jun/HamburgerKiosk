package admin;

public class Admin {

    private final String adminName;
    private final int adminMoney;

    public Admin(String adminName, int adminMoney) {
        this.adminName = adminName;
        this.adminMoney = adminMoney;
    }

    public String getAdminName() {
        return adminName;
    }

    public int getAdminMoney() {
        return adminMoney;
    }

}
