package main.java.product.validator;

import main.java.product.Product;

import static main.java.product.validator.ProductErrorMessage.INVALID_PRODUCT;
import static main.java.product.validator.ProductErrorMessage.OUT_OF_STOCK;

public class ProductValidator {

    public static void validateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException(INVALID_PRODUCT.getMessage());
        }
    }

    public static void validateStock(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException(OUT_OF_STOCK.getMessage());
        }
    }
}
