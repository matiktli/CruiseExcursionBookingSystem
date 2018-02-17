package com.models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "bookings",
        uniqueConstraints = {@UniqueConstraint( columnNames = {"customer_id","excursion_id"})})
public class Booking implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @Min(0) @Max(10)
    private int numberOfSeatsRequired;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "excursion_id")
    private Excursion excursion;


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

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }
}
