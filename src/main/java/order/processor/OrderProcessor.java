package main.java.order.processor;

import main.java.admin.Admin;
import main.java.file.LoadProductsFile;
import main.java.io.input.Input;
import main.java.member.Member;
import main.java.product.Product;
import main.java.product.management.ProductManagement;

import java.util.*;

public class OrderProcessor {

    private static final String ERROR_INVALID_PRODUCT = "[ERROR] 존재하지 않는 상품: ";
    private static final String ERROR_INSUFFICIENT_STOCK = "[ERROR] 재고 부족: ";
    private static final String ORDER_PROMPT = "구매하실 상품명과 수량을 입력해 주세요. (예: [치킨버거-3],[불고기버거세트-2])";

    private final LoadProductsFile loadProductsFile = new LoadProductsFile();
    private final ProductManagement productManagement;

    public OrderProcessor(ProductManagement productManagement) {
        this.productManagement = productManagement;
    }

    public void processOrder(Member member, Admin admin) {
        System.out.println(ORDER_PROMPT);
        String inputOrder = Input.nextLine();
        Map<String, Integer> orderMap = parseOrder(inputOrder);

        int totalAmount = processItems(orderMap);
        if (totalAmount > 0) {
            finalizeOrder(member, admin, totalAmount);
        }
    }

    private int processItems(Map<String, Integer> orderMap) {
        int totalAmount = 0;
        System.out.println("=====================");
        System.out.println("상품명\t수량\t금액");

        for (String productName : orderMap.keySet()) {
            int quantity = orderMap.get(productName);
            Product product = productManagement.findProduct(productName);

            if (product == null) {
                System.out.println(ERROR_INVALID_PRODUCT + productName);
                return 0;
            }
            if (product.getQuantity() < quantity) {
                System.out.println(ERROR_INSUFFICIENT_STOCK + productName);
                return 0;
            }
            totalAmount += printOrderSummary(product, quantity);
            product.reduceStock(quantity);
        }
        loadProductsFile.writeProductsFile(productManagement.getProducts());
        System.out.println("=====================");
        return totalAmount;
    }

    private int printOrderSummary(Product product, int quantity) {
        int cost = product.getPrice() * quantity;
        System.out.println(product.getName() + "\t" + quantity + "\t" + cost);
        return cost;
    }

    private void finalizeOrder(Member member, Admin admin, int totalAmount) {
        member.decreaseMoney(totalAmount);
        admin.increaseAdminMoney(totalAmount);

        System.out.println("총 구매액: " + totalAmount);
        System.out.println("=====================");
        System.out.println("판매자: " + admin.getAdminName() + ", " + admin.getAdminMoney());
        System.out.println("구매자: " + member.getMemberId() + ", " + member.getMoney());
    }

    private Map<String, Integer> parseOrder(String input) {
        Map<String, Integer> orderMap = new HashMap<>();
        String[] items = input.split(",");

        for (String item : items) {
            String[] parts = item.replace("[", "").replace("]", "").trim().split("-");
            if (parts.length != 2) {
                continue;
            }
            orderMap.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
        }
        return orderMap;
    }
}


