package member.login;

import io.input.Input;
import member.Member;
import member.create.CreateMember;

public class LoginMember {

    public static void loginMember() {
        System.out.println("회원 아이디를 입력해주세요.");
        String inputLoginMember = Input.nextLine();

        Member createMember = CreateMember.getMember();
        if (createMember.getMemberId() == Integer.parseInt(inputLoginMember)) {
            System.out.println("로그인 성공! " + createMember.getMemberId() + "님 환영합니다.");
        }
    }
}
