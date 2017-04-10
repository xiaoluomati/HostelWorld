package com.edu.nju.vo;

import com.edu.nju.state.MemberState;
import com.edu.nju.state.UserIdentity;

/**
 * Created by zhuding on 2017/3/7.
 */
public class MemberMessageVO {

    public String id = null;

    public String accountNumber = null;

    public String idNumber = null;

    public String name = null;

    public String registerTime = null;

    public double balance = 0.0;

    public int point = 0;

    public double totalspend = 0.0;

    public MemberState memberState;

    public int remaindays = 0;

    public int pausedays = 0;

    public String username = null;

    public String password = null;

    public UserIdentity useridentity;

    @Override
    public String toString() {
        return "MemberMessageVO{" +
                "id='" + id + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", balance=" + balance +
                ", point=" + point +
                ", totalspend=" + totalspend +
                ", memberState=" + memberState +
                ", remaindays=" + remaindays +
                ", pausedays=" + pausedays +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", useridentity=" + useridentity +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
