package main.java.member.login.validator;

import main.java.member.Member;
import main.java.member.create.CreateMember;

public class LoginMemberValidator {

    public static void validateLogin(String inputAdminName) {
        validateMemberExistence();
        validateMemberName(inputAdminName);
    }

    private static void validateMemberExistence() {
        if (CreateMember.getMember() == null) {
            throw new IllegalArgumentException(LoginMemberErrorMessage.MEMBER_NOT_FOUND.getMessage());
        }
    }

    private static void validateMemberName(String inputAdminName) {
        Member createMember = CreateMember.getMember();

        if (createMember.getMemberId() != Integer.parseInt(inputAdminName)) {
            throw new IllegalArgumentException(LoginMemberErrorMessage.INVALID_MEMBER_NAME.getMessage());
        }
    }
}
