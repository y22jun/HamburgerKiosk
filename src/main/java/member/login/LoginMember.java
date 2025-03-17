package main.java.member.login;

import main.java.io.input.Input;
import main.java.member.Member;
import main.java.member.create.CreateMember;
import main.java.member.login.validator.LoginMemberValidator;
import main.java.order.Order;

public class LoginMember {

    public void loginMember() {
        System.out.println("회원 아이디를 입력해주세요.");
        String inputLoginMember = Input.nextLine();

        try {
            LoginMemberValidator.validateLogin(inputLoginMember);

            Member createMember = CreateMember.getMember();
            System.out.println("로그인 성공! " + createMember.getMemberId() + "님 환영합니다.");
            Order order = new Order();
            order.startOrder();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
