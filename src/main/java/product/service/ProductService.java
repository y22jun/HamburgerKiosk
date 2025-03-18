package main.java.product.service;

import main.java.file.LoadProductsFile;
import main.java.product.domain.Product;

import static main.java.validator.ErrorMessage.INVALID_PRODUCT;

public class ProductService {

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
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PRODUCT.getMessage()));
    }

    public void saveProducts() {
        loadProductsFile.writeProductsFile(loadProductsFile.getProducts());
    }

}
