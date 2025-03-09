package main.java.product.validator;

public enum ProductErrorMessage {
    INVALID_PRODUCT("[ERROR] 상품이 존재하지 않습니다."),
    OUT_OF_STOCK("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다."),
    ;

    private final String message;

    ProductErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
