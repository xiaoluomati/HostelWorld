package com.edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhuding on 2017/3/2.
 */

@Entity
@Table(name = "inoutrecord")
public class InoutRecord implements Serializable {

    @Id
    private String id = null;

    private String orderID = null;

    private String idNumber = null;

    private String name = null;

    private String checkinTime = null;

    private String checkoutTime = null;

    private double price = 0.0;

    private boolean isCash = false;

    private String roomID = null;

    private String hotelID = null;

    private boolean isSettled = false;

    private String memberID = null;

    public InoutRecord() {
    }

    public InoutRecord(String id, String orderID, String idNumber, String name, String checkinTime, String checkoutTime, double price, boolean isCash, String roomID, String hotelID, boolean isSettled, String memberID) {
        this.id = id;
        this.orderID = orderID;
        this.idNumber = idNumber;
        this.name = name;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
        this.price = price;
        this.isCash = isCash;
        this.roomID = roomID;
        this.hotelID = hotelID;
        this.isSettled = isSettled;
        this.memberID = memberID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCash() {
        return isCash;
    }

    public void setCash(boolean cash) {
        isCash = cash;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public boolean isSettled() {
        return isSettled;
    }

    public void setSettled(boolean settled) {
        isSettled = settled;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "InoutRecord{" +
                "id='" + id + '\'' +
                ", orderID='" + orderID + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", checkinTime='" + checkinTime + '\'' +
                ", checkoutTime='" + checkoutTime + '\'' +
                ", price=" + price +
                ", isCash=" + isCash +
                ", roomID='" + roomID + '\'' +
                ", hotelID='" + hotelID + '\'' +
                ", isSettled=" + isSettled +
                ", memberID='" + memberID + '\'' +
                '}';
    }
}
