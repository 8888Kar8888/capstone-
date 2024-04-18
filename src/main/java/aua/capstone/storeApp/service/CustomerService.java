package aua.capstone.storeApp.service;

import aua.capstone.storeApp.model.entity.Customer;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CustomerService {


    public List<Customer> findAll() {

    }

    public Customer findById(Integer id) {

    }

    public boolean isCustomerExistsByEmail(String email) {

    }

    public Customer save(Customer customer) {

    }

    public Customer getCustomerByEmail(String email) {

    }

    public boolean isLoginSuccessful(Customer customer, HttpSession session) {

    }


    public boolean isEmailValid (String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regex)
                .matcher(email)
                .matches();
    }


}
