package com.services;

import com.models.Excursion;
import com.repositories.ExcursionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExcursionServiceImp implements ExcursionService {

    @Autowired
    private ExcursionRepo excursionRepo;

    @Override
    public List<Excursion> getAllExcursions() {
        return excursionRepo.findAll();
    }

    @Override
    public Optional<Excursion> getById(Long id) {
        return getAllExcursions().parallelStream()
                .filter(excursion -> excursion.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Excursion> getByPortId(String port_id) {
        return getAllExcursions().parallelStream()
                .filter(excursion -> excursion.getPort_id().equalsIgnoreCase(port_id))
                .findFirst();

    }

    @Override
    public List<Excursion> getAllExcursionsByWord(String word){
        if(word.equals("allexc")){return getAllExcursions();}
        return getAllExcursions().stream()
                .filter(e -> e.getName().contains(word.toUpperCase()))
                .collect(Collectors.toList());
    }
}
