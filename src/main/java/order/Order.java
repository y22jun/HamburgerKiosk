package main.java.order;

import main.java.admin.Admin;
import main.java.admin.create.CreateAdmin;
import main.java.file.LoadProductsFile;
import main.java.io.input.Input;
import main.java.member.Member;
import main.java.member.create.CreateMember;
import main.java.product.Product;

public class Order {

    private final LoadProductsFile loadProductsFile = new LoadProductsFile();

    public void printOrder() {
        loadProductsFile.readProductsFile();
        for (Product product : loadProductsFile.getProducts()) {
            System.out.println(product.toString());
        }
    }

    public void firstPrint() {
        Admin createdAdmin = CreateAdmin.getAdmin();
        Member createMember = CreateMember.getMember();
        System.out.println("=================================");
        System.out.println("안녕하세요. " + createMember.getMemberId() + "님 햄버거 가게 입니다.");
        System.out.println("현재 접속된 관리자는 " + createdAdmin.getAdminName() + "입니다.");
    }

    public void startOrder() {
        firstPrint();
        printOrder();
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [치킨버거-3],[불고기버거세트-2])");
        String inputOrder = Input.nextLine();


    }
}