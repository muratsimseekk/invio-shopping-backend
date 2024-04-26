package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.AddressResponse;
import com.invio.shoppingdemo.entity.Address;

import java.util.List;

public interface AddressService {

    List<AddressResponse> findAll();
    AddressResponse findById(Long id);
    AddressResponse save(Address address);
    AddressResponse update(Long id,Address address);
    AddressResponse delete(Long id);




}
