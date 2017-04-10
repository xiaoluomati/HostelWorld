package com.edu.nju.vo;

/**
 * Created by zhuding on 2017/3/7.
 */
public class BookMessageVO {

    public String memberID = null;

    public String roomID = null;

    public String hotelID = null;

    public double price = 0.0;

    public BookMessageVO() {
    }

    public BookMessageVO(String memberID, String roomID, String hotelID, double price) {
        this.memberID = memberID;
        this.roomID = roomID;
        this.hotelID = hotelID;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookMessageVO{" +
                "memberID='" + memberID + '\'' +
                ", roomID='" + roomID + '\'' +
                ", hotelID='" + hotelID + '\'' +
                ", price=" + price +
                '}';
    }
}
