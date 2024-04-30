package com.invio.shoppingdemo.controller;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.dto.OrderResponse;
import com.invio.shoppingdemo.entity.Basket;
import com.invio.shoppingdemo.entity.OrderEn;
import com.invio.shoppingdemo.service.BasketService;
import com.invio.shoppingdemo.service.OrderService;
import com.invio.shoppingdemo.util.OrderDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private BasketService basketService;

    @GetMapping("/")
    public  List<OrderResponse> findAll(){
        return orderService.findAll();
    }

    @PostMapping("/{basketID}")
    public OrderResponse save(@RequestBody OrderEn orderEn, @PathVariable Long basketID){

        //TODO BasketID ile basketi bul ve order icerisine kaydet .

        Basket basket = basketService.findByBasketId(basketID);

        orderEn.setBasket(basket);
        basket.setOrderEn(orderEn);

        return orderService.save(orderEn);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
         orderService.delete(id);

         return "Order silindi " + id;
    }

}
