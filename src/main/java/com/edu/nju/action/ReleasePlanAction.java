package com.edu.nju.action;

import com.edu.nju.service.interfaces.HotelManageService;
import com.edu.nju.vo.PlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/23.
 */
@Controller
public class ReleasePlanAction extends BaseAction {

    private PlanVO planVO;

    @Autowired
    private HotelManageService hotelManageService;

    @Override
    public String execute() throws Exception {
        System.out.println(planVO);
        return super.execute();
    }

    public PlanVO getPlanVO() {
        return planVO;
    }

    public void setPlanVO(PlanVO planVO) {
        this.planVO = planVO;
    }
}
