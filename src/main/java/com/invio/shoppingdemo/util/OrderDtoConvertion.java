package com.invio.shoppingdemo.util;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.dto.OrderResponse;
import com.invio.shoppingdemo.entity.OrderEn;
import org.hibernate.query.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDtoConvertion {

    public static List<OrderResponse> convertOrderList(List<OrderEn> orderEnList){

        List<OrderResponse> responseList = new ArrayList<>();

        orderEnList.stream().forEach(order -> responseList.add(new OrderResponse(order.getId()
                ,OrderPrDtoConvertion.convertPrOrderList(order.getBasket().getProductList())
                ,order.getBasket().getTotalPrice())));
        return responseList;
    }

    public static OrderResponse converOrder(OrderEn order){

        return new OrderResponse(order.getId() ,OrderPrDtoConvertion.convertPrOrderList(order.getBasket().getProductList())
                , order.getBasket().getTotalPrice());
    }

}
