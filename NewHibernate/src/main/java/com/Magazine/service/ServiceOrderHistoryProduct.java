package com.Magazine.service;

import com.Magazine.entity.OrderHistoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Magazine.repository.OrderHistoryProductRepository;

import java.util.List;
@Service
public class ServiceOrderHistoryProduct implements ServiceMag<OrderHistoryProduct> {
    @Autowired
    OrderHistoryProductRepository orderHistoryRepository;
    @Override
    public OrderHistoryProduct get(long orderId) {
        return orderHistoryRepository.getOne(orderId);
    }

    @Override
    public List<OrderHistoryProduct> getAll() {
        return orderHistoryRepository.findAll();
    }

    @Override
    public void save(OrderHistoryProduct entity) {
        orderHistoryRepository.save(entity);
    }

    @Override
    public void delete(long orderHistoryProductId) {
        orderHistoryRepository.deleteById(orderHistoryProductId);
    }
}
