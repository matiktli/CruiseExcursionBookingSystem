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
public class CruiseExcursionBookingApp implements CommandLineRunner{

    @Autowired
    private ExcursionRepo excursionRepo;

    @Autowired
    private ExcursionServiceImp excursionServiceImp;

    private static String FILE = "/home/matikitli/Programing/Projects/CruiseExcursionBookingSystem/src/main/resources/excursion.csv";
    private CSVReader reader = null;

    public static void main(String[] args) {
        SpringApplication.run(CruiseExcursionBookingApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        reader = new CSVReader(new FileReader(FILE), ',', '\'',1);
        String[] line;
        List<Excursion> list = new ArrayList<>();
        while((line = reader.readNext()) != null) {
            list.add(new Excursion(line[0], line[1], line[2]));
        }
        excursionRepo.save(list);

    }
}
