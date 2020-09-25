package com.twuc.shopping.controller;

import com.twuc.shopping.domain.Product;
import com.twuc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Void> addProduct(@RequestBody Product product){
        final int addedId = productService.addProduct(product);
        return ResponseEntity.created(null).header("added_Id",String.valueOf(addedId)).build();
    }
}
