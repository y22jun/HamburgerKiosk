package main.java.order;

import main.java.admin.Admin;
import main.java.admin.create.CreateAdmin;
import main.java.io.input.Input;
import main.java.member.Member;
import main.java.member.create.CreateMember;
import main.java.order.processor.OrderProcessor;
import main.java.order.validator.OrderValidator;
import main.java.product.management.ProductManagement;
import main.java.product.service.ProductService;

public class Order {

    private final ProductService productService = new ProductService();
    private final OrderProcessor orderProcessor = new OrderProcessor(productService);
    private final Admin createdAdmin = CreateAdmin.getAdmin();
    private final Member createMember = CreateMember.getMember();

    public void startOrder() {
        while (true) {
            printWelcomeMessage();
            productService.printProducts();
            orderProcessor.processOrder(createMember, createdAdmin);
            if (!askContinueOrder()) {
                break;
            }
        }
    }

    private void printWelcomeMessage() {
        System.out.println("=================================");
        System.out.println("안녕하세요. " + createMember.getMemberId() + "님 햄버거 가게 입니다.");
        System.out.println("현재 접속된 관리자는 " + createdAdmin.getAdminName() + "입니다.");
    }

    private boolean askContinueOrder() {
        System.out.println("감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)");
        String choice = Input.nextLine().trim().toUpperCase();
        try {
            OrderValidator.validateYesOrNo(choice);
            return "Y".equals(choice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}