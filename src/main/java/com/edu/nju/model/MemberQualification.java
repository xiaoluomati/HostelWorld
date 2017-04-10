package com.edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhuding on 2017/3/2.
 */

@Entity
@Table(name = "memberqualification")
public class MemberQualification implements Serializable {

    @Id
    private String memberID = null;

    private int memberState = 0;

    private int remaindays = 0;

    private int pausedays = 0;

    public MemberQualification() {
    }

    public MemberQualification(String memberID, int memberState, int remaindays, int pausedays) {
        this.memberID = memberID;
        this.memberState = memberState;
        this.remaindays = remaindays;
        this.pausedays = pausedays;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public int getMemberState() {
        return memberState;
    }

    public void setMemberState(int memberState) {
        this.memberState = memberState;
    }

    public int getRemaindays() {
        return remaindays;
    }

    public void setRemaindays(int remaindays) {
        this.remaindays = remaindays;
    }

    public int getPausedays() {
        return pausedays;
    }

    public void setPausedays(int pausedays) {
        this.pausedays = pausedays;
    }

    @Override
    public String toString() {
        return "MemberQualification{" +
                "memberID='" + memberID + '\'' +
                ", memberState=" + memberState +
                ", remaindays=" + remaindays +
                ", pausedays=" + pausedays +
                '}';
    }
}
