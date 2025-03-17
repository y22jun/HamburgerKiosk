package main.java.member.dto;

import main.java.user.domain.User;

public record MemberInfoDto(int memberId, int money, User user) {
}
