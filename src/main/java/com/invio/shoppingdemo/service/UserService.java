package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.UserResponse;
import com.invio.shoppingdemo.entity.User;

import java.util.List;

public interface UserService {

    UserResponse save(User user);
    UserResponse delete(Long id);
    List<UserResponse> findAll();
    UserResponse findById(Long id);
    User findByUserId(Long id);

    UserResponse update(String name , String surname , String email , Long id);

    UserResponse updatePassword(String password , Long id);
}
