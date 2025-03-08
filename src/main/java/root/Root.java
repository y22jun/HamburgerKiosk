package main.java.root;

import main.java.admin.create.CreateAdmin;
import main.java.admin.login.LoginAdmin;
import main.java.member.create.CreateMember;
import main.java.member.login.LoginMember;

import java.util.Arrays;

import static main.java.root.validator.InputMenuErrorMessage.INVALID_NUMBER_INPUT;

public enum Root {
    EXIT(0, "종료") {
        @Override
        public void execute() {
            System.out.println("프로그램을 종료합니다.");
            return;
        }
    },
    CREATE_ADMIN(1, "관리자 생성") {
        @Override
        public void execute() {
            CreateAdmin.createAdmin();
        }
    },
    LOGIN_ADMIN(2, "관리자 접속") {
        @Override
        public void execute() {
            LoginAdmin.loginAdmin();
        }
    },
    CREATE_MEMBER(3, "회원 생성") {
        @Override
        public void execute() {
            CreateMember.createMember();
        }
    },
    LOGIN_MEMBER(4, "회원 접속") {
        @Override
        public void execute() {
            LoginMember.loginMember();
        }
    }
    ;

    private final int inputMenuNumber;
    private final String inputMenuDescription;

    Root(int inputMenuNumber, String inputMenuDescription) {
        this.inputMenuNumber = inputMenuNumber;
        this.inputMenuDescription = inputMenuDescription;
    }

    public int getInputMenuNumber() {
        return inputMenuNumber;
    }

    public String getInputMenuDescription() {
        return inputMenuDescription;
    }

    public abstract void execute();

    public static Root fromNumber(String inputMenuNumber) {
        int selectNumber = Integer.parseInt(inputMenuNumber);
        return Arrays.stream(values())
                .filter(menu -> menu.inputMenuNumber == selectNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_NUMBER_INPUT.getMessage()));
    }
}
