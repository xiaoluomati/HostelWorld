package com.edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhuding on 2017/3/2.
 */

@Entity
@Table(name = "plan")
public class Plan implements Serializable {

    @Id
    private String id = null;

    private String startTime = null;

    private String endTime = null;

    private String roomRank = null;

    private double price = 0.0;

    private String hotelID = null;

    public Plan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomRank() {
        return roomRank;
    }

    public void setRoomRank(String roomRank) {
        this.roomRank = roomRank;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id='" + id + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", roomRank='" + roomRank + '\'' +
                ", price=" + price +
                ", hotelID='" + hotelID + '\'' +
                '}';
    }
}
