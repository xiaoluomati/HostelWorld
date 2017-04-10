package com.edu.nju.vo;

/**
 * Created by zhuding on 2017/3/8.
 */
public class CheckoutVO {

    public String recordID = null;

    public String checkoutTime = null;

    public boolean isCash = false;

    public double price = 0.0;

    public CheckoutVO() {
    }

    public CheckoutVO(String recordID, String checkoutTime, boolean isCash, double price) {
        this.recordID = recordID;
        this.checkoutTime = checkoutTime;
        this.isCash = isCash;
        this.price = price;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public boolean isCash() {
        return isCash;
    }

    public void setCash(boolean cash) {
        isCash = cash;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    @Override
    public String toString() {
        return "CheckoutVO{" +
                "recordID='" + recordID + '\'' +
                ", checkoutTime='" + checkoutTime + '\'' +
                ", isCash=" + isCash +
                ", price=" + price +
                '}';
    }
}

