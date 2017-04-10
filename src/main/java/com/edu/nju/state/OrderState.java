package com.edu.nju.state;

/**
 * Created by zhuding on 2017/3/7.
 */
public enum OrderState implements IntegerConvertible {

    CANCELED(-1), ORDERED(0), COMPLETED(1);

    private int value = 0;

    private OrderState(int value) {
        this.value = value;
    }

    public static OrderState valueOf(int value) {
        switch (value) {
            case -1:
                return CANCELED;
            case 1:
                return COMPLETED;
            case 0:
                return ORDERED;
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
            case -1:
                return "已取消";
            case 1:
                return "已完成";
            case 0:
                return "预订中";
            default:
                return null;
        }
    }
}
