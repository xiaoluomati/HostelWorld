package com.edu.nju.action;

import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.vo.HotelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by zhuding on 2017/3/13.
 */
@Controller
public class ShowHotelsAction extends BaseAction {

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        List<HotelVO> hotelVOS = statisticsService.listAllHotel();
        session.put("hotels", hotelVOS);
        return SUCCESS;
    }
}
