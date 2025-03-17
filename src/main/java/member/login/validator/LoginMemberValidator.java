package main.java.member.login.validator;

import main.java.member.Member;
import main.java.member.create.CreateMember;

import static main.java.validator.ErrorMessage.INVALID_MEMBER_NAME;
import static main.java.validator.ErrorMessage.MEMBER_NOT_FOUND;

public class LoginMemberValidator {

    public static void validateLogin(String inputAdminName) {
        validateMemberExistence();
        validateMemberName(inputAdminName);
    }

    private static void validateMemberExistence() {
        if (CreateMember.getMember() == null) {
            throw new IllegalArgumentException(MEMBER_NOT_FOUND.getMessage());
        }
    }

    private static void validateMemberName(String inputAdminName) {
        Member createMember = CreateMember.getMember();

        if (createMember.getMemberId() != Integer.parseInt(inputAdminName)) {
            throw new IllegalArgumentException(INVALID_MEMBER_NAME.getMessage());
        }
    }
}
