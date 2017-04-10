package com.edu.nju.action;

import com.edu.nju.service.interfaces.MemberManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/21.
 */
@Controller
public class RechargeAction extends BaseAction {

    private double quantity;

    @Autowired
    private MemberManageService memberManageService;

    @Override
    public String execute() throws Exception {
        String username = (String) session.get("username");
        memberManageService.recharge(username, quantity);
        session.put("usermsg", memberManageService.find(username));
        return SUCCESS;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
