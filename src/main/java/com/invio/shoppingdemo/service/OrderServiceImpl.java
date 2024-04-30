package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.OrderResponse;
import com.invio.shoppingdemo.entity.OrderEn;
import com.invio.shoppingdemo.repository.OrderRepository;
import com.invio.shoppingdemo.util.OrderDtoConvertion;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void delete(Long id) {
        Optional<OrderEn> orderEn = orderRepository.findById(id);

        orderEn.ifPresent(en -> orderRepository.delete(en));


    }
}
