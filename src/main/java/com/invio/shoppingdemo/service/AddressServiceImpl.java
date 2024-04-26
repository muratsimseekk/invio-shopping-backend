package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.AddressResponse;
import com.invio.shoppingdemo.entity.Address;
import com.invio.shoppingdemo.exceptions.CommonException;
import com.invio.shoppingdemo.repository.AddressRepository;
import com.invio.shoppingdemo.util.AddressDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;

    @Override
    public List<AddressResponse> findAll() {
        return AddressDtoConvertion.convertAddressList(addressRepository.findAll());
    }

    @Override
    public AddressResponse findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()){
            return AddressDtoConvertion.convertAddress(address.get());
        }
        throw new CommonException("Ilgili Id de Adres bulunamadi . ID: "+id , HttpStatus.NOT_FOUND);
    }

    @Override
    public AddressResponse save(Address address) {
        addressRepository.save(address);
        return AddressDtoConvertion.convertAddress(address);
    }

    @Override
    public AddressResponse update(Long id, Address address) {
        Optional<Address> optional = addressRepository.findById(id);


        if (optional.isPresent()){
            optional.get().setCity(address.getCity());
            optional.get().setCountry(address.getCountry());
            optional.get().setTitle(address.getTitle());
            addressRepository.save(optional.get());
            return AddressDtoConvertion.convertAddress(optional.get());
        }
        throw new CommonException("Ilgili Id de Adres bulunamadi . ID: "+id , HttpStatus.NOT_FOUND);
    }


    @Override
    public AddressResponse delete(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()){
            addressRepository.delete(address.get());
            return AddressDtoConvertion.convertAddress(address.get());
        }
        throw new CommonException("Ilgili Id de Adres bulunamadi . ID: "+id , HttpStatus.NOT_FOUND);
    }
}
