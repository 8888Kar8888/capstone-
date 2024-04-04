package aua.capstone.storeApp.controller;

import aua.capstone.storeApp.model.dto.CustomerSessionDto;
import aua.capstone.storeApp.model.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @GetMapping("/")
    public ResponseEntity<ApiResponse> checkout(HttpServletRequest request)
    {

    }
}