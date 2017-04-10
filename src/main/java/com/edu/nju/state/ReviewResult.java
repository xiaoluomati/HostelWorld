package com.edu.nju.state;

/**
 * Created by zhuding on 2017/3/9.
 */
public enum ReviewResult implements IntegerConvertible {
    REJECTED(-1), UNREVIEWED(0), ACCEPTED(1);

    private int value = 0;

    private ReviewResult(int value) {
        this.value = value;
    }

    public static ReviewResult valueOf(int value) {
        switch (value) {
            case -1:
                return REJECTED;
            case 1:
                return ACCEPTED;
            case 0:
                return UNREVIEWED;
            default:
                return null;
        }
    }

    @Override
    public int value() {
        return value;
    }
}
