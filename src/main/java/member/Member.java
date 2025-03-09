package main.java.member;

public class Member {

    private final int memberId;
    private int money;

    public Member(int memberId, int money) {
        this.memberId = memberId;
        this.money = money;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getMoney() {
        return money;
    }

    public void decreaseMoney(int amount) {
        if (money < amount) {
            throw new IllegalArgumentException("[ERROR] 잔액이 부족합니다.");
        }
        money -= amount;
    }

}
