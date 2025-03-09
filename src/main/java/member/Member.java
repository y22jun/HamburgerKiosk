package main.java.member;

import static main.java.member.validator.MemberErrorMessage.NO_MONEY;

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
            throw new IllegalArgumentException(NO_MONEY.getMessage());
        }
        money -= amount;
    }

}
