package com.services;

import com.exceptions.ExcursionNotFoundException;
import com.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer getById(String id) throws ExcursionNotFoundException;
    Optional<Customer> getByName(String name);
    Optional<Customer> getByEmail(String email);
    Optional<Customer> getByIdOrNameOrEmail(Long id,String name, String email);

    List<Customer> getAllCustomers();
}
