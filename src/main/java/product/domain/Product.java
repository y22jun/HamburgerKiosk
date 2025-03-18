package main.java.product.domain;

public class Product {
    private final String name;
    private final int price;
    private int quantity;
    private final String description;
    private final String category;

    public Product(String name, int price, int quantity, String description, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void reduceStock(int amount) {
        if (this.quantity < amount) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        this.quantity -= amount;
    }

    @Override
    public String toString() {
        if (quantity == 0) {
            return String.format("- %s, %d원, %s, %s", name, price, quantity, description);
        }
        return String.format("- %s, %d원, %s개, %s", name, price, quantity, description);
    }
}
