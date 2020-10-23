package com.twuc.shopping.service;

import com.twuc.shopping.po.AllOrderPO;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.AllOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllOrderService {
    @Autowired
    AllOrderRepository allOrderRepository;

    public void saveAllOrder(AllOrderPO allOrderPO) {
        final List<OrderPO> orders = allOrderPO.getOrders();
        orders.forEach(order -> order.setAllOrderOnce(allOrderPO));
        allOrderRepository.save(allOrderPO);
    }

    public List<AllOrderPO> findAllOrders() {
        return allOrderRepository.findAll();
    }
}
