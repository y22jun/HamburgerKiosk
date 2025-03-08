package main.java.member.create;

import main.java.io.input.Input;
import main.java.member.Member;
import main.java.member.create.validator.CreateMemberValidator;
import main.java.split.Split;

public class CreateMember {

    private static Member createMember;

    public static void createMember() {

        System.out.println("회원의 정보를 입력해주세요 ex) 1, 30000");
        String inputCreateMember = Input.nextLine();

        try {
            CreateMemberValidator.validateInput(inputCreateMember);

            String[] parts = Split.splitInput(inputCreateMember);
            int memberId = Integer.parseInt(parts[0].trim());
            int memberMoney = Integer.parseInt(parts[1].trim());

            createMember = new Member(memberId, memberMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Member getMember() {
        return createMember;
    }
}
