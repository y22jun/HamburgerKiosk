package main.java.product;

public class Product {

    private final String name;
    private final int price;
    private String quantity;
    private final String description;
    private final String category;

    public Product(String name, int price, String quantity, String description, String category) {
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

    public String getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        if (quantity.equals("품절")) {
            return String.format("- %s, %d원, %s, %s", name, price, quantity, description);
        }
        return String.format("- %s, %d원, %s개, %s", name, price, quantity, description);
    }
}
