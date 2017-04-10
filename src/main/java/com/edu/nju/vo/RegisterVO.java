package com.edu.nju.vo;

/**
 * Created by zhuding on 2017/3/6.
 */
public class RegisterVO {

    public String username;

    public String password;

    public int useruidentity = 0;

    public String accountNumber;

    public String idNumber;

    public String name;

    public RegisterVO() {
    }

    public RegisterVO(String username, String password, int useruidentity, String accountNumber, String idNumber, String name) {
        this.username = username;
        this.password = password;
        this.useruidentity = useruidentity;
        this.accountNumber = accountNumber;
        this.idNumber = idNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "RegisterVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", useruidentity=" + useruidentity +
                ", accountNumber='" + accountNumber + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUseruidentity() {
        return useruidentity;
    }

    public void setUseruidentity(int useruidentity) {
        this.useruidentity = useruidentity;
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
}
