package com.repositories;

import com.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,String>{

    Optional<Customer> findCustomerById(String id);
    Optional<Customer> findCustomerByName(String name);
    Optional<Customer> findCustomerByEmail(String email);
    Optional<Customer> findCustomerByIdOrNameOrEmail(Long id,String name,String email);


}
