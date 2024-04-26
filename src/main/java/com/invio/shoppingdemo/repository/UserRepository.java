package com.invio.shoppingdemo.repository;

import com.invio.shoppingdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
