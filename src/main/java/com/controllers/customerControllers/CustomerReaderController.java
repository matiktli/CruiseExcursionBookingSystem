package com.controllers.customerControllers;

import com.models.Customer;
import com.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/api/customers",method = RequestMethod.GET)
public class CustomerReaderController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/findOne",params = {"name","id","email"})
    @ResponseBody
    public Customer findOneCustomer(@RequestParam(name = "id",required = false) long id,
                                    @RequestParam(name = "name",required = false) String name,
                                    @RequestParam(name = "email",required = false) String email) {

        return customerService.getById(id)
                .orElseGet(()->customerService.getByName(name)
                        .orElseGet(()->customerService.getByEmail(email).get()));
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    List<Customer> findAllCustomers(){
        return customerService.getAllCustomers();
    }
}
