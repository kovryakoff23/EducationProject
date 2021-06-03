package com.Magazine.service;

import com.Magazine.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.Magazine.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct implements ServiceMag<Product> {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product get(long article) {
        return productRepository.getOne(article);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product entity) {
        productRepository.save(entity);
    }

    @Override
    public void delete(long userId) {
        productRepository.deleteById(userId);
    }
}
