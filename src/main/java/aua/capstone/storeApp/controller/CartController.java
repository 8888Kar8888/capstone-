package aua.capstone.storeApp.controller;

import aua.capstone.storeApp.model.dto.AddToCartDto;
import aua.capstone.storeApp.model.dto.CartDto;
import aua.capstone.storeApp.model.dto.CustomerSessionDto;
import aua.capstone.storeApp.model.dto.ModifyCartItemDto;
import aua.capstone.storeApp.model.entity.Customer;
import aua.capstone.storeApp.model.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController
{

    @PostMapping("/")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,  HttpServletRequest request)
    {
    }

    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(HttpServletRequest request)
    {
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Integer cartItemId, HttpServletRequest request)
    {
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse> modifyCartItem(@RequestBody ModifyCartItemDto modifyCartItemDto,
                                                      HttpServletRequest request)
    {

    }

}

