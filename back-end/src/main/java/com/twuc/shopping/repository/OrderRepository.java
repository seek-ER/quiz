package com.twuc.shopping.repository;

import com.twuc.shopping.po.OrderPO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderPO,Integer> {
    @Override
    List<OrderPO> findAll();

    Optional<OrderPO> findByName(String name);
}
