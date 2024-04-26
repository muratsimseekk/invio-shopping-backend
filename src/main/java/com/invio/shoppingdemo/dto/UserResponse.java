package com.invio.shoppingdemo.dto;

import java.util.List;

public record UserResponse(Long id , String name , String surname , String email , List<AddressResponse> addressList) {
}
