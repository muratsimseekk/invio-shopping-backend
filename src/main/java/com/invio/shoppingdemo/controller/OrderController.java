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

    @GetMapping("/")
    public  List<OrderResponse> findAll(){
        return orderService.findAll();
    }

    // Olusturulan sepetin id si girildiginde post islemi ile siparis verilecek .
    @PostMapping("/{basketID}")
    public OrderResponse save(@RequestBody OrderEn orderEn, @PathVariable Long basketID){
       return orderService.save(orderEn, basketID);
    }

    //Order silmeye gerek yok silinmesi mantikli olmaz ancak projede calisma amacli konuldu bu method .
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
         orderService.delete(id);

         return "Order silindi " + id;
    }

}
