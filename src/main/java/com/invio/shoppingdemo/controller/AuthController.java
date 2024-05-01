package com.invio.shoppingdemo.controller;

import com.invio.shoppingdemo.dto.UserResponse;
import com.invio.shoppingdemo.entity.User;
import com.invio.shoppingdemo.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
//
//    private AuthenticationService authenticationService;
//
//
//    @PostMapping("/register")
//    public User register(@RequestBody User user){
//        return authenticationService.register(user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
//    }
//

}
