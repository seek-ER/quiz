package com.twuc.shopping.controller;

import com.twuc.shopping.po.AllOrderPO;
import com.twuc.shopping.service.AllOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
public class AllOrderController {
    @Autowired
    AllOrderService allOrderService;

    @PostMapping("/allOrder")
    public ResponseEntity<Void> addAllOrder(@RequestBody AllOrderPO allOrderPO) {
        allOrderService.saveAllOrder(allOrderPO);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/showAllOrders")
    public ResponseEntity<List<AllOrderPO>> getOrders() {
        List<AllOrderPO> orders = allOrderService.findAllOrders();
        return ResponseEntity.ok(orders);
    }
}
