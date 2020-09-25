package com.twuc.shopping.service;

import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public int addProduct(Product product) {
        ProductPO productPO = ProductPO.builder().name(product.getName())
                .price(product.getPrice())
                .unit(product.getUnit())
                .picture(product.getPicture()).build();
        productRepository.save(productPO);
        final int size = productRepository.findAll().size();
        return productRepository.findAll().get(size - 1).getId();
    }
}
