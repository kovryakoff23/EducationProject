package com.Magazine.repository;

import com.Magazine.entity.OrderHistoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryProductRepository  extends JpaRepository<OrderHistoryProduct, Long> {
}
