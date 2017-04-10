package com.edu.nju.action;

import com.edu.nju.service.interfaces.MemberManageService;
import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.state.UserIdentity;
import com.edu.nju.vo.HotelVO;
import com.edu.nju.vo.MemberMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/17.
 */
@Controller
public class LoginAction extends BaseAction {

    private String username;

    private String password;

    @Autowired
    private MemberManageService memberManageService;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        if (memberManageService.login(username, password)) {
            session.put("username", username);
            session.put("password", password);
            MemberMessageVO memberMessageVO = memberManageService.find(username);
            session.put("useridentity", memberMessageVO.useridentity.value());
            if (memberMessageVO.useridentity == UserIdentity.MEMBER) {
                session.put("usermsg", memberMessageVO);
                session.put("memberStatistics", statisticsService.listStatisticsDataByUser(username));
            } else if (memberMessageVO.useridentity == UserIdentity.HOTEL_MANAGER) {
                HotelVO hotelVO = statisticsService.getHotelByManagerID(username);
                session.put("hotelmsg", hotelVO);
                if (hotelVO != null) {
                    session.put("hotelID", hotelVO.id);
                    session.put("hotelStatistics", statisticsService.lisrStatisticsDataByHotel(hotelVO.id));
                    session.put("rooms", statisticsService.listAllRoom(hotelVO.id));
                    session.put("plans", statisticsService.listPlanByHotelID(hotelVO.id));
                }
            } else if (memberMessageVO.useridentity == UserIdentity.DIRECTOR) {
                session.put("hotelIDs", statisticsService.listAllHotelID());
                session.put("unreviewedMessages", statisticsService.listUnreviewedMessages());
            }
            return SUCCESS;
        } else {
            session.put("errormsg", "login error");
            return ERROR;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
