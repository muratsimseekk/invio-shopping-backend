package com.invio.shoppingdemo.repository;

import com.invio.shoppingdemo.entity.OrderEn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEn , Long> {
}
