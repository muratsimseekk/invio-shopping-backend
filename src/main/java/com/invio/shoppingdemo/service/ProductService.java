package com.invio.shoppingdemo.service;


import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.dto.ProductResponse;
import com.invio.shoppingdemo.entity.Product;
import com.invio.shoppingdemo.repository.ProductRepository;

import java.util.List;

public interface ProductService {

    List<ProductResponse> findAll();
    ProductResponse findById(Long id);
    Product findByProductId(Long id);

    ProductResponse save(Product product);
    ProductResponse delete(Long id);

    List<ProductResponse> sortByAsc();
    List<ProductResponse> sortByDesc();

    List<ProductResponse> determineSorting(String sort);




}
