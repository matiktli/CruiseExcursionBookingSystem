package com.models;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "Excursions")
public class Excursion {

    @Id
    private Long id;
    private String port_id;
    private String name;

    public Excursion(){}

    public Excursion(Long id, String port_id, String name) {
        this.id = id;
        this.port_id = port_id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPort_id() {
        return port_id;
    }

    public void setPort_id(String port_id) {
        this.port_id = port_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "id=" + id +
                ", port_id='" + port_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

