package com.edu.nju.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhuding on 2017/3/2.
 */

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

    @Id
    private String id = null;

    private String location = null;

    private String email = null;

    private String telephone = null;

    private String userID = null;

    private String hotelName = null;

    private double balance = 0.0;

    public Hotel() {
    }

    public Hotel(String id, String location, String email, String telephone, String userID, String hotelName, double balance) {
        this.id = id;
        this.location = location;
        this.email = email;
        this.telephone = telephone;
        this.userID = userID;
        this.hotelName = hotelName;
        this.balance = balance;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", userID='" + userID + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
