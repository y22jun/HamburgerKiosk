package main.java.admin.dto;

import main.java.user.domain.User;

public record AdminInfoDto(String adminName, int money, User user) {
}
