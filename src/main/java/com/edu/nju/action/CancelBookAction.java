package com.edu.nju.action;

import com.edu.nju.service.interfaces.OrderManageService;
import com.edu.nju.service.interfaces.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/22.
 */
@Controller
public class CancelBookAction extends BaseAction {

    private String orderID;

    @Autowired
    private OrderManageService orderManageService;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        String username = (String) session.get("username");
        orderManageService.cancelBook((String) session.get("username"), orderID);
        session.put("memberStatistics", statisticsService.listStatisticsDataByUser((String) session.get("username")));
        return SUCCESS;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}
