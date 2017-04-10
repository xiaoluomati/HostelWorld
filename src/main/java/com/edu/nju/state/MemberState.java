package com.edu.nju.state;

/**
 * Created by zhuding on 2017/3/7.
 */
public enum MemberState implements IntegerConvertible {

    PAUSED(0), STOPPED(-1), ACTIVE(1);

    private int value = 0;

    private MemberState(int value) {
        this.value = value;
    }

    public static MemberState valueOf(int value) {
        switch (value) {
            case 0:
                return PAUSED;
            case 1:
                return ACTIVE;
            case -1:
                return STOPPED;
            default:
                return null;
        }
    }

    @Override
    public int value() {
        return this.value;
    }

    @Override
    public String toString() {
        switch (value) {
            case 0:
                return "已暂停";
            case 1:
                return "已激活";
            case -1:
                return "已停止";
            default:
                return null;
        }
    }

}
