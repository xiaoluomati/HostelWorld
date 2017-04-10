package com.edu.nju.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuding on 2017/3/7.
 */
public class StatisticsDataVO {

    public List<InoutRecordVO> inoutRecords = new ArrayList<>();

    public List<OrderVO> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "StatisticsDataVO{" +
                "inoutRecords=" + inoutRecords +
                ", orders=" + orders +
                '}';
    }
}
