package com.edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhuding on 2017/3/2.
 */

@Entity
@Table(name = "reviewrecord")
public class ReviewRecord implements Serializable {

    @Id
    private String id = null;

    private String messageID = null;

    private int state = 0;

    public ReviewRecord() {
    }

    public ReviewRecord(String id, String messageID, int state) {
        this.id = id;
        this.messageID = messageID;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ReviewRecord{" +
                "id='" + id + '\'' +
                ", messageID='" + messageID + '\'' +
                ", state=" + state +
                '}';
    }
}
