package com.controllers.customerControllers;


import com.models.Customer;
import com.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/customer",method = RequestMethod.POST)
public class CustomerWriterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    @ResponseBody
    Customer registerNewCustomer(@RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("cabineNumber") int cabineNumber){
    Customer customer = new Customer(name,email,password,cabineNumber);
    return customerService.registerNewCustomer(customer);
    }

}
