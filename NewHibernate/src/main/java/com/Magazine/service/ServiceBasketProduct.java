package com.Magazine.service;

import com.Magazine.entity.BasketProduct;
import com.Magazine.entity.UserAuthentification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Magazine.repository.BasketProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class ServiceBasketProduct implements ServiceMag<BasketProduct> {
    @Autowired
    BasketProductRepository basketProductRepository;
    @PersistenceContext
    private EntityManager em;
    @Override
    public BasketProduct get(long bpId) {
        return basketProductRepository.getOne(bpId);
    }

    @Override
    public List<BasketProduct> getAll() {
        return basketProductRepository.findAll();
    }

    @Override
    public void save(BasketProduct entity) {
        basketProductRepository.save(entity);
    }

    @Override
    public void delete(long basketProductId) {
        basketProductRepository.deleteById(basketProductId);
    }
}
