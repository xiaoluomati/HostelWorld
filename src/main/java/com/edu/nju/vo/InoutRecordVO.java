package com.edu.nju.vo;

/**
 * Created by zhuding on 2017/3/7.
 */
public class InoutRecordVO {

    public String id;

    public String checkinTime;

    public String checkoutTime;

    public double price;

    public boolean isCash;

    public String hotelName;

    public String roomNumber;

    public String memberID;

    public InoutRecordVO() {
    }

    @Override
    public String toString() {
        return "InoutRecordVO{" +
                "id='" + id + '\'' +
                ", checkinTime='" + checkinTime + '\'' +
                ", checkoutTime='" + checkoutTime + '\'' +
                ", price=" + price +
                ", isCash=" + isCash +
                ", hotelName='" + hotelName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", memberID='" + memberID + '\'' +
                '}';
    }
}
