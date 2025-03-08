package member.login;

import io.input.Input;
import member.Member;
import member.create.CreateMember;
import member.login.validator.LoginMemberValidator;

public class LoginMember {

    public static void loginMember() {
        System.out.println("회원 아이디를 입력해주세요.");
        String inputLoginMember = Input.nextLine();

        try {
            LoginMemberValidator.validateLogin(inputLoginMember);

            Member createMember = CreateMember.getMember();
            System.out.println("로그인 성공! " + createMember.getMemberId() + "님 환영합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
