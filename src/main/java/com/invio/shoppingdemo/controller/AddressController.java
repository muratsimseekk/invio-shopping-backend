package com.invio.shoppingdemo.controller;

import com.invio.shoppingdemo.dto.AddressResponse;
import com.invio.shoppingdemo.entity.Address;
import com.invio.shoppingdemo.entity.User;
import com.invio.shoppingdemo.service.AddressService;
import com.invio.shoppingdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    private AddressService addressService;

    @GetMapping("/")
    public List<AddressResponse> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressResponse findById(@PathVariable Long id){
        return addressService.findById(id);
    }

    //Address save ederken user ID si de girilmeli.
    @PostMapping("/{id}")
    public AddressResponse save(@RequestBody Address address ,@PathVariable Long userId){

        return addressService.save(address, userId);
    }

    //Address update ederken yine userID girilmesi gerekli.

    @PutMapping("/{id}")
    public AddressResponse update(@PathVariable Long id ,@RequestBody Address address){
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    public AddressResponse delete(@PathVariable Long id){
        return addressService.delete(id);
    }

}
