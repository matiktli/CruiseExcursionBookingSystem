package com.services;

import com.exceptions.ExcursionNotFoundException;
import com.models.Excursion;
import com.repositories.ExcursionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExcursionServiceImp implements ExcursionService {

    @Autowired
    private ExcursionRepo excursionRepo;

    @Override
    public List<Excursion> getAllExcursions() {
        return excursionRepo.findAll();
    }

    @Override
    public Optional<Excursion> getById(String id) throws ExcursionNotFoundException {
        return Optional.of(getAllExcursions().parallelStream()
                .filter(excursion -> excursion.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ExcursionNotFoundException(id)));
    }

    @Override
    public Optional<Excursion> getByPortId(String id) throws ExcursionNotFoundException {
        return Optional.of(getAllExcursions().parallelStream()
                .filter(excursion -> excursion.getPort_id().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new ExcursionNotFoundException(id)));

    }
}
