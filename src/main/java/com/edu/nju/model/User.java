package com.edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhuding on 2017/3/6.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private String id;

    @Id
    private String username;

    private String password;

    private int useridentity;

    public User() {
    }

    public User(String id, String username, String password, int useridentity) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.useridentity = useridentity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getUseridentity() {
        return useridentity;
    }

    public void setUseridentity(int useridentity) {
        this.useridentity = useridentity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", useridentity=" + useridentity +
                '}';
    }
}
