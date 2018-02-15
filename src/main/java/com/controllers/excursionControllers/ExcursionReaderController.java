package com.controllers.excursionControllers;


import com.models.Excursion;
import com.services.ExcursionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/excursions")
public class ExcursionReaderController {

    @Autowired
    private ExcursionServiceImp excursionServiceImp;

    @RequestMapping(value = "findOne")
    @ResponseBody
    public Excursion findExcursion(@RequestParam(name = "id",required = false) String id,
                                   @RequestParam(name="port_id",required = false) String port_id) {
        // working but why??
        return excursionServiceImp.getById(id)
                .orElseGet(() ->excursionServiceImp.getByPortId(port_id).get());
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Excursion> findExcursionsWithGivenWord(@RequestParam(name = "word") String word){
        return excursionServiceImp.getAllExcursionsByWord(word);
    }



}
