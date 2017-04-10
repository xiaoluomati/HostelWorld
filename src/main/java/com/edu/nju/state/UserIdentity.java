package com.edu.nju.state;

/**
 * Created by zhuding on 2017/3/7.
 */
public enum UserIdentity implements IntegerConvertible {

    MEMBER(0), HOTEL_MANAGER(1), DIRECTOR(2);

    private int value = 0;

    private UserIdentity(int value) {
        this.value = value;
    }

    public static UserIdentity valueOf(int value) {
        switch (value) {
            case 0:
                return MEMBER;
            case 1:
                return HOTEL_MANAGER;
            case 2:
                return DIRECTOR;
            default:
                return null;
        }
    }

    @Override
    public int value() {
        return this.value;
    }

}
