package aua.capstone.storeApp.service;

import aua.capstone.storeApp.model.dto.CustomerSessionDto;
import aua.capstone.storeApp.model.entity.Cart;
import aua.capstone.storeApp.model.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CheckoutService {



    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void checkoutRequest(CustomerSessionDto customerSessionDto) {

    }


}