package com.Mongo.EjemploMongo.model;

import com.Mongo.EjemploMongo.dto.BookingDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document(collection = "BookingCollection")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String idBooking;
    private LocalDate disponible;
    private LocalDate noDisponible;

    private String password;

    public Booking() {
    }

    public Booking(LocalDate disponible, LocalDate noDisponible, String password) {
        this.password= password;
        this.disponible = disponible;
        this.noDisponible = noDisponible;
    }

    public Booking(BookingDto bookingDto) {
        this.disponible = bookingDto.getDisponible();
        this.noDisponible = bookingDto.getNoDisponible();
        this.password = bookingDto.getPassword();
    }

    public String getPassword(){return password;}

    public void setPassword(String password){
        this.password= password;
    }
    public String getIdBooking(){ return idBooking;}

    public void setIdBooking(String id){this.idBooking = id;}
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
