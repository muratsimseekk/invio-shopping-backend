package com.invio.shoppingdemo.util;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.entity.Basket;

import java.util.ArrayList;
import java.util.List;

public class BasketDtoConvertion {

    public static List<BasketResponse> convertBasketList(List<Basket> basketList){
        List<BasketResponse> basketResponses = new ArrayList<>();

        basketList.stream().forEach(basket -> basketResponses.add(new BasketResponse(basket.getId()
                ,ProductDtoConvertion.convertProductList(basket.getProductList())
                ,SummaryDtoConvertion.convertSummaryList(basket.getProductList()) , basket.getTotalPrice())));

        return basketResponses;
    }

    public static BasketResponse converBasket(Basket basket){
        return new BasketResponse(basket.getId(), ProductDtoConvertion.convertProductList(basket.getProductList())
                ,SummaryDtoConvertion.convertSummaryList(basket.getProductList()), basket.getTotalPrice());
    }


}
