package com.Magazine.service;

import com.Magazine.entity.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Magazine.repository.OrderHistoryRepository;

import java.util.List;

@Service
public class ServiceOrderHistory implements ServiceMag<OrderHistory> {
    @Autowired
    OrderHistoryRepository orderHistoryRepository;
    @Override
    public OrderHistory get(long orderId) {
        return orderHistoryRepository.getOne(orderId);
    }

    @Override
    public List<OrderHistory> getAll() {
        return orderHistoryRepository.findAll();
    }

    @Override
    public void save(OrderHistory entity) {
        orderHistoryRepository.save(entity);
    }

    @Override
    public void delete(long orderHistoryId) {
        orderHistoryRepository.deleteById(orderHistoryId);
    }
}
