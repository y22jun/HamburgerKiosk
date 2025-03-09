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
        int quantity = parseQuantity(parts[2].trim());
        String description = getDescription(parts[3].trim());
        String category = parts[4].trim();

        return new Product(name, price, quantity, description, category);
    }

    private int parseQuantity(String quantityStr) {
        if (quantityStr.equals(NO_PRODUCT)) {
            return 0;
        }
        return Integer.parseInt(quantityStr);
    }

    private String getDescription(String descriptionStr) {
        return descriptionStr.trim().replaceAll("\"", "");
    }

    public void writeProductsFile(List<Product> products) {
        File file = new File(FILE_PATH);
        LoadProductsFileValidator.validate(file);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("name, price, quantity, description, category\n");
            for (Product product : products) {
                writer.write(product.getName() + "," + product.getPrice() + "," + product.getQuantity() + "," + product.getDescription() + "," + product.getCategory());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
