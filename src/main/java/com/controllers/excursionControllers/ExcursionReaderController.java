package com.controllers.excursionControllers;


import com.exceptions.ExcursionNotFoundException;
import com.models.Excursion;
import com.services.ExcursionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/api/excursions")
public class ExcursionReaderController {

    @Autowired
    private ExcursionServiceImp excursionServiceImp;

    @RequestMapping("/all")
    @ResponseBody
    public String findAllExcursions(){
        return excursionServiceImp.getAllExcursions().stream().toString();
    }

    @RequestMapping(value = "find")
    @ResponseBody
    public Excursion findExcursion(@RequestParam(name = "id",required = false) String id,
                                   @RequestParam(name="port_id",required = false) String port_id) throws ExcursionNotFoundException {
        // ned to be done...
        return excursionServiceImp.getById(id).get();
    }
}
