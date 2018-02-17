package com;

import com.models.Booking;
import com.models.Customer;
import com.models.Excursion;
import com.opencsv.CSVReader;
import com.repositories.BookingRepo;
import com.repositories.ExcursionRepo;
import com.services.customer.CustomerService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class StartupDatabaseCreator implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ExcursionRepo excursionRepo;

    @Autowired
    private BookingRepo bookingRepo;

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


            Map<Long, Integer> mapExcIdAndSeats=bookingRepo.findAll().stream()
                    .collect(Collectors.groupingBy(booking->booking.getExcursion().getId())).entrySet().stream()
                    .collect(Collectors.toMap(ee->ee.getKey(),
                                                e->e.getValue().stream()
                    .map(el->el.getNumberOfSeatsRequired()).reduce(0,(a,b)->a+b)));

            System.out.println(mapExcIdAndSeats);


            System.out.println("DATABASE CREATED");
        }

    }

    private void createTableBookings() {

        Booking booking1 = new Booking(4);
        booking1.setCustomer(customerService.getAllCustomers().get(0));
        booking1.setExcursion(excursionRepo.findAll().get(0));

        Booking booking2 = new Booking(3);
        booking2.setCustomer(customerService.getAllCustomers().get(1));
        booking2.setExcursion(excursionRepo.findAll().get(0));

        Booking booking3 = new Booking(7);
        booking3.setCustomer(customerService.getAllCustomers().get(2));
        booking3.setExcursion(excursionRepo.findAll().get(10));

        Booking booking4 = new Booking(3);
        booking4.setCustomer(customerService.getAllCustomers().get(1));
        booking4.setExcursion(excursionRepo.findAll().get(10));

        Booking booking5 = new Booking(7);
        booking5.setCustomer(customerService.getAllCustomers().get(2));
        booking5.setExcursion(excursionRepo.findAll().get(20));

        Booking booking6 = new Booking(3);
        booking6.setCustomer(customerService.getAllCustomers().get(1));
        booking6.setExcursion(excursionRepo.findAll().get(1));

        bookingRepo.save(Arrays.asList(booking1,booking2,booking3,booking4,booking5,booking6));

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
