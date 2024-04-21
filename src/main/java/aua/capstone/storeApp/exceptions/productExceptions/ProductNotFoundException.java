package aua.capstone.storeApp.exceptions.productExceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Integer id) {
        super("No product found with id: " + id);
    }
}
