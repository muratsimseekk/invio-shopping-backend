package com.invio.shoppingdemo.util;

import com.invio.shoppingdemo.dto.OrderProductResponse;
import com.invio.shoppingdemo.entity.OrderEn;
import com.invio.shoppingdemo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderPrDtoConvertion {

    public static List<OrderProductResponse> convertPrOrderList(List<Product> productList){
        List<OrderProductResponse> responseList = new ArrayList<>();

        productList.stream().forEach(product -> responseList.add(new OrderProductResponse(product.getId()
                ,product.getName(),product.getPrice() , product.getCount() )));

        return responseList;
    }

    public static OrderProductResponse convertPrOrder(Product product){
        return new OrderProductResponse(product.getId()
                ,product.getName(),product.getPrice() , product.getCount());
    }
}
