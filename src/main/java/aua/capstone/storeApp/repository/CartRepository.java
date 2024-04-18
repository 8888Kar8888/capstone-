package aua.capstone.storeApp.repository;

import aua.capstone.storeApp.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByCustomerId(Integer customerId);
    Cart findAllByCustomerIdAndProductId(Integer customerId, Integer productId);
}
