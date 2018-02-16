package com.models;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
public class Customer {
    /*
    |----------------------------------------------------------------------|
    |IN CASE OF SWITCHING TO DAO  (in future mb)                           |
    |----------------------------------------------------------------------|
    |hierarchy: controller > service > dao > persistence & repo            |
    |return:   (Customer)|(Customer)|(Customer)| persistence               |
    |IMPORTANT: this will become CustomerPersistence                       |
    |Customer is domain object                                             |
    |CustomerDao is object to communicate with db. Data access object      |
    |CustomerPersistence(entity) is object in db                           |
    |----------------------------------------------------------------------|
    */
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "CabineNumber")
    private int cabineNumber;

    @Column(name = "Password")
    private String password;

    public Customer(){}

    public Customer(String name, String email, String password,int cabineNumber) {
        this.name = name;
        this.email = email;
        this.password=password;
        this.cabineNumber = cabineNumber;
    }

    public long getId() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
