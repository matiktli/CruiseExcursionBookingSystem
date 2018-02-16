package com.services;

import com.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    //READ
    Optional<Customer> getById(long id);
    Optional<Customer> getByName(String name);
    Optional<Customer> getByEmail(String email);
    List<Customer> getAllCustomers();

    //CREATE
    Customer registerNewCustomer(Customer customer);

    //UPDATE
    Customer editExistingCustomer(Customer customer);

    //DELETE
    Customer deleteExistingCustomer(String id);
}
