package root;

public enum Root {
    EXIT(0, "종료") {
        @Override
        public void execute() {
            System.out.println("프로그램을 종료합니다.");
            return;
        }
    },
    CREATE_ADMIN(1, "관리자 생성") {
        @Override
        public void execute() {
            System.out.println("관리자 생성 실행합니다.");
        }
    },
    LOGIN_ADMIN(2, "관리자 접속") {
        @Override
        public void execute() {
            System.out.println("관리자 접속을 실행합니다.");
        }
    },
    CREATE_MEMBER(3, "회원 생성") {
        @Override
        public void execute() {
            System.out.println("회원 생성을 시작합니다.");
        }
    },
    LOGIN_MEMBER(4, "회원 접속") {
        @Override
        public void execute() {
            System.out.println("회원 접속을 실행합니다.");
        }
    }
    ;

    private final int inputMenuNumber;
    private final String inputMenuDescription;

    Root(int inputMenuNumber, String inputMenuDescription) {
        this.inputMenuNumber = inputMenuNumber;
        this.inputMenuDescription = inputMenuDescription;
    }

    public int getInputMenuNumber() {
        return inputMenuNumber;
    }

    public String getInputMenuDescription() {
        return inputMenuDescription;
    }

    public abstract void execute();
}
