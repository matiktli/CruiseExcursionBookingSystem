package com;

import com.models.Customer;
import com.models.Excursion;
import com.opencsv.CSVReader;
import com.repositories.ExcursionRepo;
import com.services.CustomerService;
import com.services.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class StartupDatabaseCreator implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ExcursionRepo excursionRepo;

    private static String FILE = "/home/matikitli/Programing/Projects/CruiseExcursionBookingSystem/src/main/resources/excursion.csv";
    private CSVReader reader = null;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        if(!areDatabaseEmpty()){
            return;
        }
        //EXCURSIONS
        try { createTableExcursions(); } catch (Exception e) { e.printStackTrace(); }
        //CUSTOMERS
        createTableCustomers();

    }


    private boolean areDatabaseEmpty(){
        return customerService.getAllCustomers().size()==0 &&
                excursionRepo.findAll().size()==0;
    }

    private void createTableExcursions() throws Exception{
        reader = new CSVReader(new FileReader(FILE), ',', '\'',1);
        String[] line;
        List<Excursion> list = new ArrayList<>();
        while((line = reader.readNext()) != null) {
            list.add(new Excursion(line[0], line[1], line[2]));
        }
        excursionRepo.save(list);
    }

    private void createTableCustomers(){
        Customer customer1=new Customer("Mateusz","aa@bb.cc","1234",1);
        Customer customer2=new Customer("Filip","dd@ee.ff","1234",2);
        Customer customer3=new Customer("Sandra","gg@hh.ii","1234",3);
        customerService.registerNewCustomer(customer1);
        customerService.registerNewCustomer(customer2);
        customerService.registerNewCustomer(customer3);
        System.out.println("DATABASE CREATED");

    }
}
