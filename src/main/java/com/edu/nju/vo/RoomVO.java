package com.edu.nju.vo;

/**
 * Created by zhuding on 2017/3/9.
 */
public class RoomVO {

    public String roomID = null;

    public String hotelName = null;
    public String roomNumber = null;
    public String roomRank = null;
    public String hotelID = null;
    public double price = 0.0;

    public RoomVO() {
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomVO{" +
                "roomID='" + roomID + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomRank='" + roomRank + '\'' +
                ", hotelID='" + hotelID + '\'' +
                ", price=" + price +
                '}';
    }
}
