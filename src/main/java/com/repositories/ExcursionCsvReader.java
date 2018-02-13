package com.repositories;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ExcursionCsvReader {

    @Autowired
    private ExcursionRepo excursionRepo;

    private static String FILE = "/home/matikitli/Programing/Projects/CruiseExcursionBookingSystem/src/main/resources/excursion.csv";
    private CSVReader reader = null;

    public void readFile() throws IOException {

    }

}
