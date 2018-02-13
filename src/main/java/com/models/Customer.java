package com.models;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "CabineNumber")
    private int cabineNumber;

    public Customer(){}

    public Customer(String name, String email, int cabineNumber) {
        this.name = name;
        this.email = email;
        this.cabineNumber = cabineNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCabineNumber() {
        return cabineNumber;
    }

    public void setCabineNumber(int cabineNumber) {
        this.cabineNumber = cabineNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cabineNumber=" + cabineNumber +
                '}';
    }
}
