package com.twuc.shopping.service;

import com.twuc.shopping.domain.Product;
import com.twuc.shopping.exception.ProductNotValidException;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public int addProduct(Product product) {
        final List<String> productName = productRepository.findAll().stream()
                .map(element -> element.getName()).collect(Collectors.toList());
        if (productName.contains(product.getName())){
            throw new ProductNotValidException("商品名称已存在，请输入新的商品名称");
        }
        ProductPO productPO = ProductPO.builder().name(product.getName())
                .price(product.getPrice())
                .unit(product.getUnit())
                .picture(product.getPicture()).build();
        productRepository.save(productPO);
        final int size = productRepository.findAll().size();
        return productRepository.findAll().get(size - 1).getId();
    }

    public List<ProductPO> findAllProducts() {
        return productRepository.findAll();
    }
}
