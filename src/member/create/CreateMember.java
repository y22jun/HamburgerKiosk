package member.create;

import io.input.Input;
import member.Member;
import split.Split;

public class CreateMember {

    private static Member createMember;

    public static void createMember() {

        System.out.println("회원의 정보를 입력해주세요 ex) 1, 30000");
        String inputCreateMember = Input.nextLine();

        String[] parts = Split.splitInput(inputCreateMember);
        int memberId = Integer.parseInt(parts[0].trim());
        int memberMoney = Integer.parseInt(parts[1].trim());

        createMember = new Member(memberId, memberMoney);
        System.out.println(createMember);
    }

    public static Member getMember() {
        return createMember;
    }
}
