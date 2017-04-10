package com.edu.nju.vo;

import com.edu.nju.state.OrderState;

/**
 * Created by zhuding on 2017/3/7.
 */
public class OrderVO {

    public String id;

    public String orderTime;

    public OrderState orderState;

    public String hotelName;

    public String roomRank;

    public String roomNumber;

    public double price;

    public String memberID;

    public OrderVO() {
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "id='" + id + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", orderState=" + orderState +
                ", hotelName='" + hotelName + '\'' +
                ", roomRank='" + roomRank + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", memberID='" + memberID + '\'' +
                '}';
    }
}
