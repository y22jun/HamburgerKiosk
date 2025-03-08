package main.java.member;

public class Member {

    private final int memberId;
    private final int money;

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
}
