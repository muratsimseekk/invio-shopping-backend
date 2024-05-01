package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.entity.Role;
import com.invio.shoppingdemo.entity.User;
import com.invio.shoppingdemo.repository.RoleRepository;
import com.invio.shoppingdemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthenticationService {

//    private UserRepository userRepository;
//
//    private RoleRepository roleRepository;
//
//    private PasswordEncoder passwordEncoder;
//
//    public User register(String name , String surname , String email , String password){
//        String encodedPassword = passwordEncoder.encode(password);
//        Role userRole = roleRepository.findByAuthority("USER").get();
//
//        Set<Role> roles = new HashSet<>();
//        roles.add(userRole);
//
//        User user = new User();
//
//        user.setName(name);
//        user.setSurname(surname);
//        user.setEmail(email);
//        user.setPassword1(encodedPassword);
//        user.setRoles(roles);
//
//        return userRepository.save(user);
//    }
}
