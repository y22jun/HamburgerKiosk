package main.java.member;

import main.java.user.domain.User;

import static main.java.validator.ErrorMessage.NO_MONEY;


public class Member {

    private final int memberId;
    private int money;
    private final User user;

    public Member(int memberId, int money, User user) {
        this.memberId = memberId;
        this.money = money;
        this.user = user;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getMoney() {
        return money;
    }

    public User getUser() {
        return user;
    }

    public void decreaseMoney(int amount) {
        if (money < amount) {
            throw new IllegalArgumentException(NO_MONEY.getMessage());
        }
        money -= amount;
    }

}
