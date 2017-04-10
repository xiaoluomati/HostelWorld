package com.edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhuding on 2017/3/2.
 */

@Entity
@Table(name = "unreviewedmessage")
public class UnreviewedMessage implements Serializable {

    @Id
    private String id = null;

    private String hotelID = null;

    private String location = null;

    private String telephone = null;

    private String email = null;

    private String userID = null;

    private String hotelName = null;

    public UnreviewedMessage() {
    }

    public UnreviewedMessage(String id, String hotelID, String location, String telephone, String email, String userID, String hotelName) {
        this.id = id;
        this.hotelID = hotelID;
        this.location = location;
        this.telephone = telephone;
        this.email = email;
        this.userID = userID;
        this.hotelName = hotelName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        return "UnreviewedMessage{" +
                "id='" + id + '\'' +
                ", hotelID='" + hotelID + '\'' +
                ", location='" + location + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", userID='" + userID + '\'' +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }
}
