package com.twuc.shopping.controller;

import com.twuc.shopping.po.AllOrderPO;
import com.twuc.shopping.service.AllOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
