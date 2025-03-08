package main.java.file;

import main.java.file.validator.LoadProductsFileValidator;
import main.java.product.Product;
import main.java.separator.Separator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadProductsFile {

    private static final String FILE_PATH = "src/main/resources/products.md";
    private static final String NO_PRODUCT = "재고없음";
    private static final String SOLD_OUT = "품절";
    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void readProductsFile() {
        File file = new File(FILE_PATH);
        LoadProductsFileValidator.validate(file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(Separator.COMMA);
                Product product = getProduct(parts);
                products.add(product);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private Product getProduct(String[] parts) {
        String name = parts[0].trim();
        int price = Integer.parseInt(parts[1].trim());
        String quantity = parts[2].trim();
        String quantityDisplay = getQuantityDisplay(quantity);
        String description = getDescription(parts[3].trim());
        String category = parts[4].trim();

        return new Product(name, price, quantityDisplay, description, category);
    }

    private String getQuantityDisplay(String quantity) {
        if (quantity.equals(NO_PRODUCT)) {
            return SOLD_OUT;
        }
        return quantity;
    }

    private String getDescription(String descriptionStr) {
        return descriptionStr.trim().replaceAll("\"", "");
    }

    public void writeProductsFile() {
        File file = new File(FILE_PATH);
        LoadProductsFileValidator.validate(file);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("name, price, quantity, description, category\n");
            for (Product product : products) {
                String line = String.format("%s, %s, \"%s\", %s\n",
                        product.getName(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.getDescription());
                writer.write(line + product.getCategory() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
