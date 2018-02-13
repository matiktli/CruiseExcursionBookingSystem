package com.services;

import com.exceptions.ExcursionNotFoundException;
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

    @Override
    public Customer getById(String id) throws ExcursionNotFoundException {
        return Optional.of(getAllCustomers().parallelStream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst().get()).orElseThrow(() -> new ExcursionNotFoundException("xd"));
    }

    @Override
    public Optional<Customer> getByName(String name) {
        return Optional.of(getAllCustomers().parallelStream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .findFirst().get());
    }

    @Override
    public Optional<Customer> getByEmail(String email) {
        return Optional.of(getAllCustomers().parallelStream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
                .findFirst().get());
    }

    @Override
    public Optional<Customer> getByIdOrNameOrEmail(Long id, String name, String email) {
        return Optional.empty();
    }

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }
}
