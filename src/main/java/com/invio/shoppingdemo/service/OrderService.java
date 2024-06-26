package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.OrderResponse;
import com.invio.shoppingdemo.entity.OrderEn;

import java.util.List;

public interface OrderService {

    OrderResponse save(OrderEn orderEn , Long basketID);

    List<OrderResponse> findAll();

    void delete(Long id);


}
