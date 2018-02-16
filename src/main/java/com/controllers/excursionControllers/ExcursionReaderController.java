package com.controllers.excursionControllers;


import com.models.Excursion;
import com.services.ExcursionService;
import com.services.ExcursionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/api/excursions",method = RequestMethod.GET)
public class ExcursionReaderController {

    @Autowired
    private ExcursionService excursionService;

    @RequestMapping(value = "findOne")
    @ResponseBody
    public Excursion findExcursion(@RequestParam(name = "id",required = false) String id,
                                   @RequestParam(name="port_id",required = false) String port_id) {
        // working but why??
        return excursionService.getById(id)
                .orElseGet(() ->excursionService.getByPortId(port_id).get());
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Excursion> findExcursionsWithGivenWord(@RequestParam(name = "word",defaultValue = "allexc") String word){
        return excursionService.getAllExcursionsByWord(word);
    }



}
