package com.controllers.excursionControllers;


import com.models.Excursion;
import com.models.ExcursionBookingPersistence;
import com.repositories.ExcursionBookingRepo;
import com.services.excursion.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/api/excursions",method = RequestMethod.GET)
public class ExcursionReaderController {

    @Autowired
    private ExcursionService excursionService;

    @Autowired
    ExcursionBookingRepo excursionBookingRepo;

    @RequestMapping(value = "findOne")
    @ResponseBody
    public Excursion findExcursion(@RequestParam(name = "id",required = false) Long id,
                                   @RequestParam(name="port_id",required = false) String port_id) {
        // working but why??
        return excursionService.getById(id)
                .orElseGet(() ->excursionService.getByPortId(port_id).get());
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Excursion> findExcursionsWithGivenWord(@RequestParam(name = "word",defaultValue = "allexc") String word){


        //TODO: EDIT THIS BAD STREAMING
        Map<Long,Integer> mapExcursionIdAndSeatsTaken=excursionBookingRepo.findAll().stream()
                .map(ExcursionBookingPersistence::getListOfBookings).collect(Collectors.toList()).stream()
                .flatMap(List::stream).collect(Collectors.toList()).stream()
                .collect(Collectors.groupingBy(a->a.getExcursionBookingPersistence().getExcursion().getId())).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e->e.getValue().stream()
                                .map(el->el.getNumberOfSeatsRequired()).reduce(0, (a,b)->a+b)));

        System.out.println(mapExcursionIdAndSeatsTaken);


        return excursionService.getAllExcursionsByWord(word);
    }





}
