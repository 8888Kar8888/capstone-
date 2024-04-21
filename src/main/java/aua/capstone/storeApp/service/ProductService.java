package aua.capstone.storeApp.service;

import aua.capstone.storeApp.exceptions.productExceptions.ProductNotFoundException;
import aua.capstone.storeApp.model.entity.Product;
import aua.capstone.storeApp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }


}
