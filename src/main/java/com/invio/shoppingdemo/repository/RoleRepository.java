package com.invio.shoppingdemo.repository;

import com.invio.shoppingdemo.entity.Role;
import com.invio.shoppingdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<User , Long> {

    @Query("SELECT r FROM Role r WHERE r.authority = :authority")
    Optional<Role> findByAuthority ( String authority);
}
