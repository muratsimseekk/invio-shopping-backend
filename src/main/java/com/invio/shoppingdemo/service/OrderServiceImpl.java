package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.OrderResponse;
import com.invio.shoppingdemo.entity.OrderEn;
import com.invio.shoppingdemo.repository.OrderRepository;
import com.invio.shoppingdemo.util.OrderDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    @Override
    public OrderResponse save(OrderEn orderEn) {

        orderRepository.save(orderEn);
        return OrderDtoConvertion.converOrder(orderEn);

    }

    @Override
    public List<OrderResponse> findAll() {

        List<OrderEn> orderEnList = orderRepository.findAll();
        return OrderDtoConvertion.convertOrderList(orderEnList);

    }
}
