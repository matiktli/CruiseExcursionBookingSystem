package com.models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "bookings")
public class Booking implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @Min(0) @Max(10)
    private int numberOfSeatsRequired;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "excursionBooking_id")
    private ExcursionBookingPersistence excursionBookingPersistence;


    public Booking() {}

    public Booking(int numberOfSeatsRequired) {
        this.numberOfSeatsRequired = numberOfSeatsRequired;
    }

    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Booking setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public int getNumberOfSeatsRequired() {
        return numberOfSeatsRequired;
    }

    public void setNumberOfSeatsRequired(int numberOfSeatsRequired) {
        this.numberOfSeatsRequired = numberOfSeatsRequired;
    }

    public ExcursionBookingPersistence getExcursionBookingPersistence() {
        return excursionBookingPersistence;
    }

    public void setExcursionBookingPersistence(ExcursionBookingPersistence excursionBookingPersistence) {
        this.excursionBookingPersistence = excursionBookingPersistence;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", numberOfSeatsRequired=" + numberOfSeatsRequired +
                ", excursionBookingPersistence=" + excursionBookingPersistence +
                '}';
    }
}
