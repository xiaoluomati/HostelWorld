package com.edu.nju.vo;

/**
 * Created by zhuding on 2017/3/9.
 */
public class ReviewMessageVO {

    public String recordID = null;

    public String hotelID = null;

    public String location = null;

    public String telephone = null;

    public String email = null;

    public String hotelName = null;

    @Override
    public String toString() {
        return "ReviewMessageVO{" +
                "recordID='" + recordID + '\'' +
                ", hotelID='" + hotelID + '\'' +
                ", location='" + location + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }
}
