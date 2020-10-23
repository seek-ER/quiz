package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.po.AllOrderPO;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.AllOrderRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AllOrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    AllOrderRepository allOrderRepository;

    @Autowired
    OrderRepository orderRepository;

    OrderPO orderPO1;
    OrderPO orderPO2;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void beforeEach() {
        allOrderRepository.deleteAll();
        orderPO1 = OrderPO.builder().name("可乐").price(3).unit("元").number(1).build();
        orderPO2 = OrderPO.builder().name("雪碧").price(3).unit("元").number(2).build();
    }

    @AfterEach
    public void afterEach() {
        allOrderRepository.deleteAll();
    }

    @Test
    public void should_add_allOrder() throws Exception {
        final ArrayList<OrderPO> orderPOS = new ArrayList<>();
        orderPOS.add(orderPO1);
        orderPOS.add(orderPO2);
        final AllOrderPO allOrderPO = AllOrderPO.builder().orders(orderPOS).build();
        String jsonString = objectMapper.writeValueAsString(allOrderPO);
        mockMvc
                .perform(post("/allOrder").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        List<AllOrderPO> all = allOrderRepository.findAll();
        assertEquals(1, all.size());

        assertEquals(2, orderRepository.findAll().size());
    }
}