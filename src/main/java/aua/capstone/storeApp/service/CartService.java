package aua.capstone.storeApp.service;


import aua.capstone.storeApp.model.dto.*;
import aua.capstone.storeApp.model.entity.Cart;
import aua.capstone.storeApp.model.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {




    public void addToCart(AddToCartDto addToCartDto, Customer customer)
    {


    }

    public List<Cart> findAllByCustomerId(Integer customerId)
    {
    }

    public CartDto getCartInfo(Integer customerId)
    {
    }

    @Transactional
    public void deleteCartItem(Integer itemId, Customer customer)
    {
    }

    @Transactional
    public void modifyCartItem(ModifyCartItemDto modifyCartItemDto, CustomerSessionDto customerSessionDto)
    {

    }


}