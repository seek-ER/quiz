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
        OrderPO orderPO;
        final Optional<OrderPO> findedOrderPO = orderRepository.findByName(order.getName());
        if (findedOrderPO.isPresent()) {
            orderPO = findedOrderPO.get();
            orderPO.setNumber(findedOrderPO.get().getNumber() + 1);
        } else {
            orderPO = OrderPO.builder().name(order.getName())
                    .price(order.getPrice())
                    .unit(order.getUnit())
                    .number(1)
                    .build();
        }
        orderRepository.save(orderPO);
    }

/*    public List<OrderPO> findAllOrders() {
        return orderRepository.findAll();
    }*/
}
