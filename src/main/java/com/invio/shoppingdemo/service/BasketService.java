package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.entity.Basket;
import com.invio.shoppingdemo.entity.Product;

public interface BasketService {

    BasketResponse save(Basket basket);
    BasketResponse delete(Long id);

    BasketResponse findById(Long id);

    Basket findByBasketId(Long id);

    BasketResponse addToCart(Long basketID , Long productID);

}
