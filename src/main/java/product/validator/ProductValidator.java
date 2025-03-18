package main.java.product.validator;

import main.java.product.domain.Product;

import static main.java.validator.ErrorMessage.INVALID_PRODUCT;
import static main.java.validator.ErrorMessage.OUT_OF_STOCK;

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
