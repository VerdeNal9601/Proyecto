package com.Mongo.EjemploMongo.dto;

import java.io.Serializable;
import java.time.LocalDate;



public class BookingDto implements Serializable {

    private static final long serialVersionUID = 1L;



    private String password;
    private LocalDate disponible;
    private LocalDate noDisponible;

    public BookingDto() {
    }

    public BookingDto( LocalDate disponible, LocalDate noDisponible, String password) {
        this.password= password;
        this.disponible = disponible;
        this.noDisponible = noDisponible;
    }

    public String getPassword(){return password;}

    public void setPassword(String password){
        this.password= password;
    }

    public LocalDate getDisponible() {
        return disponible;
    }

    public void setDisponible(LocalDate disponible) {
        this.disponible = disponible;
    }

    public LocalDate getNoDisponible() {
        return noDisponible;
    }

    public void setNoDisponible(LocalDate noDisponible) {
        this.noDisponible = noDisponible;
    }
}
