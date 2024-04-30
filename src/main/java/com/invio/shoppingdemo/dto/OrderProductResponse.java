package com.invio.shoppingdemo.dto;

public record OrderProductResponse(Long product_id , String product_name , Double price , Integer count) {
}
