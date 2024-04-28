package com.invio.shoppingdemo.repository;

import com.invio.shoppingdemo.dto.ProductResponse;
import com.invio.shoppingdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product , Long> {

    @Query("select p from  Product p order by p.price asc ")
    List<Product> sortByAsc();

    @Query("select p from  Product p order by p.price desc ")
    List<Product> sortByDesc();
}
