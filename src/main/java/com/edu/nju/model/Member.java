package com.edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhuding on 2017/3/1.
 */
@Entity
@Table(name = "member")
public class Member implements Serializable {

    @Id
    private String id = null;

    private String accountNumber = null;

    private String idNumber = null;

    private String name = null;

    private String registerTime = null;

    private double balance = 0.0;

    private int point = 0;

    private double totalspend = 0.0;

    public Member() {
    }

    public Member(String id, String accountNumber, String idNumber, String name, String registerTime, double balance, int point, double totalspend) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.idNumber = idNumber;
        this.name = name;
        this.registerTime = registerTime;
        this.balance = balance;
        this.point = point;
        this.totalspend = totalspend;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public double getTotalspend() {
        return totalspend;
    }

    public void setTotalspend(double totalspend) {
        this.totalspend = totalspend;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", balance=" + balance +
                ", point=" + point +
                ", totalspend=" + totalspend +
                '}';
    }
}
