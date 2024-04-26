package com.invio.shoppingdemo.util;

import com.invio.shoppingdemo.dto.AddressResponse;
import com.invio.shoppingdemo.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressDtoConvertion {


    public static List<AddressResponse> convertAddressList(List<Address> addressList){
        List<AddressResponse> addressResponses = new ArrayList<>();

        addressList.stream().forEach(address -> addressResponses.add(new AddressResponse(address.getId()
                , address.getTitle(), address.getCity(), address.getCountry(), address.getUser().getId())));


        return addressResponses;
    }

    public static AddressResponse convertAddress(Address address){
        return new AddressResponse(address.getId()
                , address.getTitle(), address.getCity(), address.getCountry(), address.getUser().getId());
    }
}
