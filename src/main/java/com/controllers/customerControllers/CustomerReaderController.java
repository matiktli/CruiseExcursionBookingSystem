package com.controllers.customerControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/customer")
public class CustomerReaderController {


    @RequestMapping(value = "/find",params = {"name","id","email"})
    @ResponseBody
    String findCustomer(@RequestParam(name = "name",required = false) String name,
                        @RequestParam(name = "id",required = false) String id,
                        @RequestParam(name = "email",required = false) String email){

        return "TMP";
    }
}
