package com.invio.shoppingdemo.repository;

import com.invio.shoppingdemo.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket , Long> {
}
