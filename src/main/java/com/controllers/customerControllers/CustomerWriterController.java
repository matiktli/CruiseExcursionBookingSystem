package com.controllers.customerControllers;


import com.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/customer")
public class CustomerWriterController {

    @RequestMapping("/register")
    @ResponseBody
    String registerNewCustomer(@RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("cabineNumber") int cabineNumber){
    Customer customer = new Customer(name,email,cabineNumber);
    return customer.toString();
    }

}
