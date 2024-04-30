package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.entity.Complaint;

import java.util.List;

public interface ComplaintService {

    String save(String complaint);
    List<Complaint> findAll();

    String delete(Long id);
}
