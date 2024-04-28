package com.invio.shoppingdemo.dto;

import java.util.List;

public record BasketResponse(Long id , List<ProductResponse> product_list) {
}
