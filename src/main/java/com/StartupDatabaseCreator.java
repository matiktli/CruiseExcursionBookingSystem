package com;

import com.models.Booking;
import com.models.Customer;
import com.models.Excursion;
import com.models.ExcursionBookingPersistence;
import com.opencsv.CSVReader;
import com.repositories.BookingRepo;
import com.repositories.ExcursionBookingRepo;
import com.repositories.ExcursionRepo;
import com.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class StartupDatabaseCreator implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ExcursionRepo excursionRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ExcursionBookingRepo excursionBookingRepo;

    private static String FILE = "/home/matikitli/Programing/Projects/CruiseExcursionBookingSystem/src/main/resources/excursion.csv";
    private CSVReader reader = null;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        if(!areDatabaseEmpty()){
            return;
        }
        else {
            //EXCURSIONS
            try {
                createTableExcursions();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //CUSTOMERS
            createTableCustomers();
            //BOOKINGS
            createTableBookings();

            System.out.println("DATABASE CREATED");
        }

    }

    private void createTableBookings() {

        Booking booking1 = new Booking(4);
        booking1.setCustomer(customerService.getAllCustomers().get(0));

        Booking booking2 = new Booking(3);
        booking2.setCustomer(customerService.getAllCustomers().get(1));

        ExcursionBookingPersistence excursionBookingPersistence = new ExcursionBookingPersistence(excursionRepo.findAll().get(0));
        excursionBookingPersistence.addBooking(booking1);
        excursionBookingPersistence.addBooking(booking2);

        excursionBookingRepo.save(excursionBookingPersistence);

        Booking booking3 = new Booking(7);
        booking3.setCustomer(customerService.getAllCustomers().get(2));

        Booking booking4 = new Booking(3);
        booking4.setCustomer(customerService.getAllCustomers().get(1));

        ExcursionBookingPersistence excursionBookingPersistence2 = new ExcursionBookingPersistence(excursionRepo.findAll().get(10));
        excursionBookingPersistence2.addBooking(booking3);
        excursionBookingPersistence2.addBooking(booking4);

        excursionBookingRepo.save(excursionBookingPersistence2);

        Booking booking5 = new Booking(7);
        booking5.setCustomer(customerService.getAllCustomers().get(2));

        Booking booking6 = new Booking(3);
        booking6.setCustomer(customerService.getAllCustomers().get(1));

        ExcursionBookingPersistence excursionBookingPersistence3 = new ExcursionBookingPersistence(excursionRepo.findAll().get(10));
        excursionBookingPersistence3.addBooking(booking5);
        excursionBookingPersistence3.addBooking(booking6);

        excursionBookingRepo.save(excursionBookingPersistence3);

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
            list.add(new Excursion(Long.parseLong(line[0]), line[1], line[2]));
        }
        excursionRepo.save(list);
    }

    private void createTableCustomers(){
        Customer customer1=new Customer("Mateusz","aa@bb.cc","1234",1);
        Customer customer2=new Customer("Filip","dd@ee.ff","1234",2);
        Customer customer3=new Customer("Sandra","gg@hh.ii","1234",3);
        Customer customer4=new Customer("Arek","jj@kk.ll","1234",3);
        Customer customer5=new Customer("Swirek","mm@nn.oo","1234",9);

        customerService.registerNewCustomer(customer1);
        customerService.registerNewCustomer(customer2);
        customerService.registerNewCustomer(customer3);
        customerService.registerNewCustomer(customer4);
        customerService.registerNewCustomer(customer5);


    }
}
