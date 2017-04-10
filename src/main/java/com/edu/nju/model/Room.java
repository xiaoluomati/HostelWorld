package com.edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhuding on 2017/3/6.
 */
@Entity
@Table(name = "room")
public class Room implements Serializable {

    @Id
    private String id = null;

    private String hotelID = null;

    private String roomNumber = null;

    private String roomRank = null;

    private double price = 0.0;

    public Room() {
    }

    public Room(String id, String hotelID, String roomNumber, String roomRank, double price) {
        this.id = id;
        this.hotelID = hotelID;
        this.roomNumber = roomNumber;
        this.roomRank = roomRank;
        this.price = price;
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomRank() {
        return roomRank;
    }

    public void setRoomRank(String roomRank) {
        this.roomRank = roomRank;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", hotelID='" + hotelID + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomRank='" + roomRank + '\'' +
                ", price=" + price +
                '}';
    }
}
