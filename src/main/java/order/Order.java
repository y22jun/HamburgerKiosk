package main.java.order;

import main.java.file.LoadProductsFile;
import main.java.product.Product;

public class Order {

    private final LoadProductsFile loadProductsFile = new LoadProductsFile();

    public void printOrder() {
        loadProductsFile.readProductsFile();
        for (Product product : loadProductsFile.getProducts()) {
            System.out.println(product.toString());
        }
    }
}
