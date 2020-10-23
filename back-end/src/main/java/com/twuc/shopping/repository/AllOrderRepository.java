package com.twuc.shopping.repository;

import com.twuc.shopping.po.AllOrderPO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllOrderRepository extends PagingAndSortingRepository<AllOrderPO, Integer> {
    @Override
    List<AllOrderPO> findAll();
}
