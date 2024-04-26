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
    private UserService userService;

    @GetMapping("/")
    public List<AddressResponse> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressResponse findById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @PostMapping("/{id}")
    public AddressResponse save(@RequestBody Address address ,@PathVariable Long id){

        User user =userService.findByUserId(id);

        user.getAddressList().add(address);
        address.setUser(user);

        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public AddressResponse update(@PathVariable Long id ,@RequestBody Address address){
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    public AddressResponse delete(@PathVariable Long id){
        return addressService.delete(id);
    }

}
