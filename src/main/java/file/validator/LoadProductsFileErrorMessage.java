package main.java.file.validator;

public enum LoadProductsFileErrorMessage {
    FILE_READ_ERROR("[ERROR] 파일을 읽는 중 오류가 발생했습니다."),
    FILE_WRITE_ERROR("[ERROR] 파일을 쓰는 중 오류가 발생했습니다."),
            ;

    private final String message;

    LoadProductsFileErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
