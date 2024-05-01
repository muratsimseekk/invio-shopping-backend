package com.invio.shoppingdemo.controller;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.dto.ProductResponse;
import com.invio.shoppingdemo.entity.Product;
import com.invio.shoppingdemo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/")
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping("/")
    public ProductResponse save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public ProductResponse delete(@PathVariable Long id){
        return productService.delete(id);
    }

    //URL ye girilecek param degeri "asc" ve "desc" girilerek artan azalan islemleri yapilir.
    @GetMapping("/param")
    public List<ProductResponse> sortByPrice(@RequestParam String sort){
        return productService.determineSorting(sort);
    }






}
