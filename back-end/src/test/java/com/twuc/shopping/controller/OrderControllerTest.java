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

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
        orderPO = OrderPO.builder().name("可乐").price(3).unit("元").number(1).build();
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
        assertEquals("可乐", all.get(0).getName());
        assertEquals(3, all.get(0).getPrice());
        assertEquals("元", all.get(0).getUnit());
        assertEquals(1, all.get(0).getNumber());
    }

    @Test
    public void should_add_order_given_exist_product() throws Exception {
        String jsonString = objectMapper.writeValueAsString(order);
        mockMvc
                .perform(post("/order").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc
                .perform(post("/order").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        List<OrderPO> all = orderRepository.findAll();
        assertNotNull(all);
        assertEquals("可乐", all.get(0).getName());
        assertEquals(3, all.get(0).getPrice());
        assertEquals("元", all.get(0).getUnit());
        assertEquals(2, all.get(0).getNumber());
    }

    @Test
    public void should_show_all_orders() throws Exception {
        OrderPO orderPO1 = OrderPO.builder().name("可乐1").price(3).unit("元").number(1).build();
        OrderPO orderPO2 = OrderPO.builder().name("可乐2").price(3).unit("元").number(1).build();
        orderRepository.save(orderPO);
        orderRepository.save(orderPO1);
        orderRepository.save(orderPO2);
        mockMvc
                .perform(get("/orders"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(3)));

        assertEquals(orderRepository.findAll().get(0).getName(), "可乐");
        assertEquals(orderRepository.findAll().get(1).getName(), "可乐1");
        assertEquals(orderRepository.findAll().get(2).getName(), "可乐2");
    }
}