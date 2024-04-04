package aua.capstone.storeApp.controller;

import aua.capstone.storeApp.model.entity.Customer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @GetMapping("/")
    public ResponseEntity<List<Customer>> getCustomers() {

    }

    // getting user by id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {

    }

    // registering new user
    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@RequestBody Customer customer) {

    }

    // login existing user
    @PostMapping(value = "/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Customer customer, HttpServletRequest request) {

    }
}
