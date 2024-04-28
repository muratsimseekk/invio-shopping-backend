package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.entity.Basket;
import com.invio.shoppingdemo.entity.Product;

public interface BasketService {

    Basket save(Basket basket);
    BasketResponse delete(Long id);

    BasketResponse findById(Long id);

    Basket findByBasketId(Long id);




}
