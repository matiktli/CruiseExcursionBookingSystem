package com;

import com.models.Excursion;
import com.opencsv.CSVReader;
import com.repositories.ExcursionRepo;
import com.services.ExcursionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruiseExcursionBookingApp{

    public static void main(String[] args) {
        SpringApplication.run(CruiseExcursionBookingApp.class, args);
    }

}
