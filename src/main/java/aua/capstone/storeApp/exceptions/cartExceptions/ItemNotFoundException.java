package aua.capstone.storeApp.exceptions.cartExceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Integer id) {
        super("Item with id:" + id + " not found");
    }
}
