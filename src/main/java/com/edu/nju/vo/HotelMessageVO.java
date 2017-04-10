package com.edu.nju.vo;

/**
 * Created by zhuding on 2017/3/8.
 */
public class HotelMessageVO {

    public String location = null;

    public String telephone = null;

    public String email = null;

    public String username = null;

    public String password = null;

    public String hotelName = null;

    @Override
    public String toString() {
        return "HotelMessageVO{" +
                "location='" + location + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hotelName='" + hotelName + '\'' +
                '}';
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
