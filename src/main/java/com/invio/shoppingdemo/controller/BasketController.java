package com.invio.shoppingdemo.controller;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.entity.Basket;
import com.invio.shoppingdemo.entity.Product;
import com.invio.shoppingdemo.service.BasketService;
import com.invio.shoppingdemo.service.ProductService;
import com.invio.shoppingdemo.util.BasketDtoConvertion;
import lombok.AllArgsConstructor;
import org.hibernate.type.descriptor.java.LocaleJavaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
@AllArgsConstructor
public class BasketController {

    private BasketService basketService;
    private ProductService productService;
    @GetMapping("/{id}")
    public BasketResponse findById(@PathVariable Long id){
        return basketService.findById(id);
    }

    @PostMapping("/")
    public Basket save(@RequestBody Basket basket){
        return basketService.save(basket);
    }

    @DeleteMapping("/{id}")
    public BasketResponse delete(@PathVariable Long id){
        return basketService.delete(id);
    }

    @PostMapping("/{basketID}/{productID}")
    public Basket addToCart(@PathVariable Long basketID, @PathVariable Long productID){

        Basket basket1 = basketService.findByBasketId(basketID);

        Product product = productService.findByProductId(productID);

        basket1.getProductList().add(product);
        return basketService.save(basket1);

    }

}
