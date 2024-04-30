package com.invio.shoppingdemo.repository;

import com.invio.shoppingdemo.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint , Long> {
}
