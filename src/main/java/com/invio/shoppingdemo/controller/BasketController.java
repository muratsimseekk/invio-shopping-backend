package com.invio.shoppingdemo.controller;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.entity.Basket;
import com.invio.shoppingdemo.entity.Product;
import com.invio.shoppingdemo.service.BasketService;
import com.invio.shoppingdemo.service.ProductService;
import com.invio.shoppingdemo.util.BasketDtoConvertion;
import lombok.AllArgsConstructor;
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
    public BasketResponse save(@RequestBody Basket basket){
        return basketService.save(basket);

    }

    @DeleteMapping("/{id}")
    public BasketResponse delete(@PathVariable Long id){
        return basketService.delete(id);
    }

    @PostMapping("/{basketID}/addToCart/{productID}")
    public BasketResponse addToCart(@PathVariable Long basketID, @PathVariable Long productID){

        return basketService.addToCart(basketID, productID);
    }

}
