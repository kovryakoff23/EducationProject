package com.Magazine.repository;

import com.Magazine.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository  extends JpaRepository<Discount, Long> {
}
