package com.twuc.shopping.controller;

import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Void> addProduct(@RequestBody Product product){
        final int addedId = productService.addProduct(product);
        return ResponseEntity.created(null).header("added_Id",String.valueOf(addedId)).build();
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductPO>> getProducts(){
        List<ProductPO> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }
}
