package com.Magazine.service;

import com.Magazine.entity.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Magazine.repository.BasketRepository;

import java.util.List;
@Service
public class ServiceBasket implements ServiceMag<Basket> {
    @Autowired
    BasketRepository basketRepository;
    @Override
    public Basket get(long basketId) {
        return basketRepository.getOne(basketId);
    }

    @Override
    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    @Override
    public void save(Basket entity) {
        basketRepository.save(entity);
    }

    @Override
    public void delete(long userId) {
        basketRepository.deleteById(userId);
    }
    
}
