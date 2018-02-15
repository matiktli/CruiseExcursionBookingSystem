package com.services;

import com.models.Customer;
import com.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    //READ
    @Override
    public Optional<Customer> getById(String id){
        return getAllCustomers().parallelStream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Customer> getByName(String name){
        return getAllCustomers().parallelStream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public Optional<Customer> getByEmail(String email){
        return getAllCustomers().parallelStream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    //CREATE
    @Override
    public Customer registerNewCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    //UPDATE
    @Override
    public Customer editExistingCustomer(Customer customer) {
        return null;
    }

    //DELETE
    @Override
    public Customer deleteExistingCustomer(String id) {
        return customerRepo.deleteCustomerById(id);
    }
}
