package aua.capstone.storeApp.service;

import aua.capstone.storeApp.exceptions.customerExceptions.CustomerNotFoundException;
import aua.capstone.storeApp.model.dto.CustomerSessionDto;
import aua.capstone.storeApp.model.entity.Customer;
import aua.capstone.storeApp.repository.CustomerRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public boolean isCustomerExistsByEmail(String email) {
        return customerRepository.existsCustomerByEmail(email);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.getCustomerByEmail(email);
    }

    public boolean isLoginSuccessful(Customer customer, HttpSession session) {
        if (!this.isCustomerExistsByEmail(customer.getEmail())) {
            throw new CustomerNotFoundException(customer.getEmail());
        }

        Customer customerFromDb = this.getCustomerByEmail(customer.getEmail());

        if (customerFromDb.isBlocked()) {
            throw new IllegalStateException("This account is blocked and cannot log in.");
        }

        if (passwordEncoder.matches(customer.getPassword(), customerFromDb.getPassword())) {
            CustomerSessionDto customerSessionDto = new CustomerSessionDto(customerFromDb.getId());
            session.setAttribute("user", customerSessionDto);
            return true;
        }

        return false;
    }


    public boolean isEmailValid (String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regex)
                .matcher(email)
                .matches();
    }

    /*
        Must have at least one numeric character
        Must have at least one lowercase character
        Must have at least one uppercase character
        Must have at least one special symbol among @#$%
        Password length should be between 8 and 20
     */
//    public boolean isPasswordStrong(String password) {
//        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
//        return Pattern.compile(regex)
//                .matcher(password)
//                .matches();
//    }
}
