package com.edu.nju.action;

import com.edu.nju.service.interfaces.MemberManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/21.
 */
@Controller
public class PointExchangeAction extends BaseAction {

    private int pointToExchange;

    @Autowired
    private MemberManageService memberManageService;

    @Override
    public String execute() throws Exception {
        String username = (String) session.get("username");
        if (memberManageService.pointExchange(username, pointToExchange)) {
            session.put("usermsg", memberManageService.find(username));
            return SUCCESS;
        } else {
            session.put("errormsg", "point not enough!");
            return ERROR;
        }

    }

    public int getPointToExchange() {
        return pointToExchange;
    }

    public void setPointToExchange(int pointToExchange) {
        this.pointToExchange = pointToExchange;
    }
}
