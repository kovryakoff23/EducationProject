package com.Magazine.repository;

import com.Magazine.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketProductRepository  extends JpaRepository<BasketProduct, Long> {
}
