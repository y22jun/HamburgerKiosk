package main.java.product.management;

import main.java.file.LoadProductsFile;
import main.java.product.Product;

import java.util.List;

public class ProductManagement {

    private final LoadProductsFile loadProductsFile = new LoadProductsFile();

    public void printProducts() {
        loadProductsFile.readProductsFile();
        for (Product product : loadProductsFile.getProducts()) {
            System.out.println(product);
        }
    }

    public Product findProduct(String name) {
        return loadProductsFile.getProducts().stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProducts() {
        return loadProductsFile.getProducts();
    }
}
