package com.repositories;

import com.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,String>{

    //READ

    //CREATE

    //UPDATE

    //DELETE
    Customer deleteCustomerById(String id);

}
