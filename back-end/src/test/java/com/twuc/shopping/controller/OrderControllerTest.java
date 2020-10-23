package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Order;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    OrderRepository orderRepository;

    Order order;
    OrderPO orderPO;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void beforeEach(){
        orderRepository.deleteAll();
        orderPO = orderPO.builder().name("可乐").price(3).unit("元").number(1).build();
        order = Order.builder().name("可乐").price(3).unit("元").build();
    }

    @AfterEach
    public void afterEach(){
        orderRepository.deleteAll();
    }

    @Test
    public void should_add_order() throws Exception{
        String jsonString = objectMapper.writeValueAsString(order);
        mockMvc
                .perform(post("/order").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        List<OrderPO> all = orderRepository.findAll();
        assertNotNull(all);
        assertEquals("可乐",all.get(0).getName());
        assertEquals(3,all.get(0).getPrice());
        assertEquals("元",all.get(0).getUnit());
        assertEquals(1,all.get(0).getNumber());
    }
}