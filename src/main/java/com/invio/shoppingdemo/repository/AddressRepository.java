package com.invio.shoppingdemo.repository;

import com.invio.shoppingdemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address , Long> {
}
