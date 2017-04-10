package com.edu.nju.vo;

/**
 * Created by zhuding on 2017/3/8.
 */
public class CheckinVO {

    public String orderID = null;

    public String memberID = null;

    public String idNumber = null;

    public String name = null;

    public String checkinTime = null;

    public String roomID = null;

    public String hotelID = null;

    public double price = 0.0;

    public CheckinVO() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
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

    @Override
    public String toString() {
        return "CheckinVO{" +
                "orderID='" + orderID + '\'' +
                ", memberID='" + memberID + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", checkinTime='" + checkinTime + '\'' +
                ", roomID='" + roomID + '\'' +
                ", hotelID='" + hotelID + '\'' +
                ", price=" + price +
                '}';
    }
}
