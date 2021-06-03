package com.Magazine.service;

import com.Magazine.entity.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Magazine.repository.DiscountRepository;

import java.util.List;
@Service
public class ServiceDiscount implements ServiceMag<Discount> {
    @Autowired
    DiscountRepository discountRepository;
    @Override
    public Discount get(long userId) {
        return discountRepository.getOne(userId);
    }

    @Override
    public List<Discount> getAll() {
        return discountRepository.findAll();
    }

    @Override
    public void save(Discount entity) {
        discountRepository.save(entity);
    }

    @Override
    public void delete(long discountId) {
        discountRepository.deleteById(discountId);
    }
}
