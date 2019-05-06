package com.codegym.cms.service;

import com.codegym.cms.model.Customer;

import java.util.List;

public interface CustomerService {
    Iterable<Customer> findAll();

    void save(Customer customer);

    void remove(int id);

    Customer findById(int id);

}
