package com.twuc.shopping.service;

import com.twuc.shopping.domain.Order;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void addOrder(Order order) {
        OrderPO orderPO = OrderPO.builder().name(order.getName())
                .price(order.getPrice())
                .unit(order.getUnit()).build();
        final Optional<OrderPO> findedOrderPO = orderRepository.findByName(order.getName());
        if (findedOrderPO.isPresent()) {
            orderPO.setNumber(findedOrderPO.get().getNumber() + 1);
        } else {
            orderPO.setNumber(1);
        }
        orderRepository.save(orderPO);
    }

/*    public List<OrderPO> findAllOrders() {
        return orderRepository.findAll();
    }*/
}
