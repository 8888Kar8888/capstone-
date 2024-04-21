package aua.capstone.storeApp.exceptions.customerExceptions;

public class CustomerNotLoggedInException extends RuntimeException {
    public CustomerNotLoggedInException() {
        super("Customer not logged in.");
    }
}
