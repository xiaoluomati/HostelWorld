package com.edu.nju.action;

import com.edu.nju.service.interfaces.HotelMessageService;
import com.edu.nju.vo.HotelMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/16.
 */
@Controller
public class HotelRegisterAction extends BaseAction {

    private HotelMessageVO hotelMessageVO;

    @Autowired
    private HotelMessageService hotelMessageService;

    @Override
    public String execute() throws Exception {
        if (hotelMessageService.register(hotelMessageVO)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public HotelMessageVO getHotelMessageVO() {
        return hotelMessageVO;
    }

    public void setHotelMessageVO(HotelMessageVO hotelMessageVO) {
        this.hotelMessageVO = hotelMessageVO;
    }
}
