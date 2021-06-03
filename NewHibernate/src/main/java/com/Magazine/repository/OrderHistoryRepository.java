package com.Magazine.repository;

import com.Magazine.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository  extends JpaRepository<OrderHistory, Long> {
}
