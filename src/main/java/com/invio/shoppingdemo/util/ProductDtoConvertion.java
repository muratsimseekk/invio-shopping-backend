package com.invio.shoppingdemo.util;

import com.invio.shoppingdemo.dto.ProductResponse;
import com.invio.shoppingdemo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDtoConvertion {


    public static List<ProductResponse> convertProductList(List<Product> productList){

        List<ProductResponse> productResponses = new ArrayList<>();

        productList.stream().forEach(product -> productResponses.add(new ProductResponse(product.getId(), product.getName(),product.getBrand()
                ,product.getCategory(),product.getPrice(),product.getCurrency(),product.getDescription(),product.getFeatures(),product.getAvailability()
                ,product.getStock(),product.getDimensions(),product.getWeight(),product.getColors())));

        return productResponses;
    }

    public static ProductResponse convertProduct(Product product){
        return new ProductResponse(product.getId(), product.getName(),product.getBrand()
                ,product.getCategory(),product.getPrice(),product.getCurrency(),product.getDescription(),product.getFeatures(),product.getAvailability()
                ,product.getStock(),product.getDimensions(),product.getWeight(),product.getColors());
    }

}
