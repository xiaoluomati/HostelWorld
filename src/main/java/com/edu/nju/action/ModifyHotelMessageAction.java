package com.edu.nju.action;

import com.edu.nju.service.interfaces.HotelMessageService;
import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.vo.HotelMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/23.
 */
@Controller
public class ModifyHotelMessageAction extends BaseAction {

    private HotelMessageVO hotelMessageVO;

    @Autowired
    private HotelMessageService hotelMessageService;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        System.out.println(hotelMessageVO);
        String hotelID = (String) session.get("hotelID");
        hotelMessageVO.username = (String) session.get("username");
        if (hotelMessageVO.password == null || hotelMessageVO.password.equals("")) {
            hotelMessageVO.password = (String) session.get("password");
        }
        hotelMessageService.modifyMessage(hotelID, hotelMessageVO);
        session.put("password", hotelMessageVO.password);
        return SUCCESS;
    }

    public HotelMessageVO getHotelMessageVO() {
        return hotelMessageVO;
    }

    public void setHotelMessageVO(HotelMessageVO hotelMessageVO) {
        this.hotelMessageVO = hotelMessageVO;
    }
}
