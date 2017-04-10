package com.edu.nju.vo;

/**
 * Created by zhuding on 2017/3/9.
 */
public class HotelVO {

    public String location = null;

    public String telephone = null;

    public String email = null;

    public String id = null;

    public String hotelName = null;

    public double balance = 0.0;

    public HotelVO() {
    }

    @Override
    public String toString() {
        return "HotelVO{" +
                "location='" + location + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
