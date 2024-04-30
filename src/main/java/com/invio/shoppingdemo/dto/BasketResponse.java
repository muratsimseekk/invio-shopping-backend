package com.invio.shoppingdemo.dto;

import java.util.List;

public record BasketResponse(Long id ,List<ProductResponse> productList, List<SummaryResponse> basket_list , Double total_price) {
}
