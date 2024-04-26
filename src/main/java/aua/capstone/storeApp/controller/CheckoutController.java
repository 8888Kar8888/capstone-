package aua.capstone.storeApp.controller;

import aua.capstone.storeApp.exceptions.customerExceptions.CustomerNotLoggedInException;
import aua.capstone.storeApp.model.dto.CustomerSessionDto;
import aua.capstone.storeApp.service.CheckoutService;
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
    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> checkout(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new CustomerNotLoggedInException();
        }
        CustomerSessionDto customerSessionDto = (CustomerSessionDto) request.getSession().getAttribute("user");
        checkoutService.checkoutRequest(customerSessionDto);

        return new ResponseEntity<>(new ApiResponse(true, "Checkout completed."), HttpStatus.OK);
    }
}