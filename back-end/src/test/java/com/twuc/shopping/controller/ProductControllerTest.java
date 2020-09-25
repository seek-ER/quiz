package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository productRepository;

    Product product;
    ProductPO productPO;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void beforeEach(){
        productRepository.deleteAll();
        productPO = ProductPO.builder().name("可乐").price(3).unit("元").picture("https://i.loli.net/2020/09/25/WuQpbHrcifP4LyU.jpg").build();
        product = Product.builder().name("可乐").price(3).unit("元").picture("https://i.loli.net/2020/09/25/WuQpbHrcifP4LyU.jpg").build();
    }

    @AfterEach
    public void afterEach(){
        productRepository.deleteAll();
    }

    @Test
    public void should_add_product() throws Exception{
        String jsonString = objectMapper.writeValueAsString(product);
        mockMvc
                .perform(post("/product").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        List<ProductPO> all = productRepository.findAll();
        assertNotNull(all);
        assertEquals("可乐",all.get(0).getName());
        assertEquals(3,all.get(0).getPrice());
        assertEquals("元",all.get(0).getUnit());
        assertEquals("https://i.loli.net/2020/09/25/WuQpbHrcifP4LyU.jpg",all.get(0).getPicture());
    }

}