package main.java.validator;

public enum ErrorMessage {
    INVALID_NUMBER_INPUT("[ERROR] 입력값이 범위를 벗어났습니다. (0~4 사이의 숫자만 가능)"),
    INVALID_MONEY("[ERROR] 보유금액은 0이상이어야 합니다."),
    INVALID_ADMIN_FORMAT("[ERROR] 입력 형식이 잘못되었습니다. 이름과 보유금액을 쉼표로 구분해 주세요."),
    INVALID_ADMIN_NAME_LENGTH("[ERROR] 이름은 1자 이상이어야 합니다."),
    INVALID_MONEY_FORMAT("[ERROR] 보유금액은 숫자로만 입력해주세요."),
    ADMIN_ALREADY_EXISTS("이미 관리자가 존재합니다."),
    ADMIN_NOT_FOUND("[ERROR] 아직 관리자가 생성되지 않았습니다."),
    INVALID_ADMIN_NAME("[ERROR] 관리자 이름이 일치하지 않습니다."),
    INVALID_MEMBER_FORMAT("[ERROR] 입력 형식이 잘못되었습니다. 회원 아이디와 보유금액을 쉼표로 구분해 주세요."),
    INVALID_MEMBER_ID_LENGTH("[ERROR] 아이디는 1자 이상이어야 합니다."),
    MEMBER_NOT_FOUND("[ERROR] 아직 회원이 생성되지 않았습니다."),
    INVALID_MEMBER_NAME("[ERROR] 회원 아이디가 일치하지 않습니다."),
    FILE_NULL("[ERROR] 파일이 null 입니다."),
    FILE_NOT_EXISTS("[ERROR] 파일이 존재하지 않습니다."),
    FILE_READ_ERROR("[ERROR] 파일을 읽는 중 오류가 발생했습니다."),
    FILE_WRITE_ERROR("[ERROR] 파일을 쓰는 중 오류가 발생했습니다."),
    NO_MONEY("[ERROR] 잔액이 부족합니다."),
    INVALID_PRODUCT("[ERROR] 상품이 존재하지 않습니다."),
    OUT_OF_STOCK("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다."),
    INVALID_INPUT("잘못된 입력입니다. Y 또는 N만 입력 가능합니다."),
    NULL_INPUT("[ERROR] 입력값이 null 입니다."),
    EMPTY_INPUT("[ERROR] 입력값이 비어있습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
