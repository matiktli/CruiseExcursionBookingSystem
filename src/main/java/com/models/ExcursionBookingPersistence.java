package com.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "excursionBookingPersistence")
public class ExcursionBookingPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "excursion_id")
    private Excursion excursion;

    @OneToMany(mappedBy = "excursionBookingPersistence",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Booking> listOfBookings = new ArrayList<>();

    public ExcursionBookingPersistence() {}

    public ExcursionBookingPersistence(Excursion excursion) {
        this.excursion = excursion;
    }

    public long getId() {
        return id;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    public List<Booking> getListOfBookings() {
        return listOfBookings;
    }

    public void setListOfBookings(List<Booking> listOfBookings) {
        this.listOfBookings = listOfBookings;
    }

    public void addBooking(Booking booking){
        listOfBookings.add(booking);
        booking.setExcursionBookingPersistence(this);
    }

    public void removeBooking(Booking booking){
        listOfBookings.remove(booking);
        booking.setExcursionBookingPersistence(null);
    }
}
