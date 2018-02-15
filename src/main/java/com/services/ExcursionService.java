package com.services;

import com.exceptions.ExcursionNotFoundException;
import com.models.Excursion;

import java.util.List;
import java.util.Optional;

public interface ExcursionService {

    List<Excursion> getAllExcursions();

    Optional<Excursion> getById(String id) throws ExcursionNotFoundException;
    Optional<Excursion> getByPortId(String id) throws ExcursionNotFoundException;

    List<Excursion> getAllExcursionsByWord(String word);
}
