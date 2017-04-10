package com.edu.nju.vo;

/**
 * Created by zhuding on 2017/3/8.
 */
public class PlanVO {

    public String hotelID = null;

    public String startTime = null;

    public String endTime = null;

    public double price = 0.0;

    public String roomRank = null;

    public PlanVO() {
    }

    @Override
    public String toString() {
        return "PlanVO{" +
                "hotelID='" + hotelID + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", price=" + price +
                ", roomRank='" + roomRank + '\'' +
                '}';
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
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
}
