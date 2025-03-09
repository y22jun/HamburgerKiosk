package main.java.order.processor;

import main.java.admin.Admin;
import main.java.file.LoadProductsFile;
import main.java.io.input.Input;
import main.java.member.Member;
import main.java.product.Product;
import main.java.product.management.ProductManagement;
import main.java.product.validator.ProductValidator;
import main.java.split.Split;

import java.util.*;

public class OrderProcessor {

    private final LoadProductsFile loadProductsFile = new LoadProductsFile();
    private final ProductManagement productManagement;

    public OrderProcessor(ProductManagement productManagement) {
        this.productManagement = productManagement;
    }

    public void processOrder(Member member, Admin admin) {
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [치킨버거-3],[불고기버거세트-2])");
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

            if (!processProduct(productName, quantity)) {
                return 0;
            }

            totalAmount += calculateProductCost(productName, quantity);
        }
        loadProductsFile.writeProductsFile(productManagement.getProducts());
        System.out.println("=====================");
        return totalAmount;
    }

    private boolean processProduct(String productName, int quantity) {
        Product product = productManagement.findProduct(productName);

        try {
            ProductValidator.validateProduct(product);
            ProductValidator.validateStock(product, quantity);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        product.reduceStock(quantity);

        return true;
    }

    private int calculateProductCost(String productName, int quantity) {
        Product product = productManagement.findProduct(productName);
        int cost = product.getPrice() * quantity;
        printOrderSummary(product, quantity);

        return cost;
    }

    private void printOrderSummary(Product product, int quantity) {
        int cost = product.getPrice() * quantity;
        System.out.println(product.getName() + "\t" + quantity + "\t" + cost);
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
        String[] items = Split.splitInput(input);

        for (String item : items) {
            parseItem(item, orderMap);
        }
        return orderMap;
    }

    private void parseItem(String item, Map<String, Integer> orderMap) {
        String[] parts = extractParts(item);

        if (isValidParts(parts)) {
            addOrder(orderMap, parts);
        }
    }

    private String[] extractParts(String item) {
        return item.replace("[", "").replace("]", "").trim().split("-");
    }

    private boolean isValidParts(String[] parts) {
        return parts.length == 2;
    }

    private void addOrder(Map<String, Integer> orderMap, String[] parts) {
        orderMap.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
    }
}
