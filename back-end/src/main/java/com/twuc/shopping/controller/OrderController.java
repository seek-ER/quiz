package com.twuc.shopping.controller;

import com.twuc.shopping.domain.Order;
import com.twuc.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Void> addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return ResponseEntity.created(null).build();
    }

/*    @GetMapping("/orders")
    public ResponseEntity<List<OrderPO>> getOrders(){
        List<OrderPO> orders = orderService.findAllOrders();
        return ResponseEntity.ok(orders);
    }*/
}
