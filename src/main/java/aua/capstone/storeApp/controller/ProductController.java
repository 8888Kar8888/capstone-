package aua.capstone.storeApp.controller;

import aua.capstone.storeApp.model.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    // get all products
    @GetMapping("/")
    public ResponseEntity<List<Product>> all()
    {

    }

    // get product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id)
    {

    }
}
