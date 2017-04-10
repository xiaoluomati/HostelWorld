package com.edu.nju.action;

import com.edu.nju.service.interfaces.OrderManageService;
import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.vo.BookMessageVO;
import com.edu.nju.vo.MemberMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/22.
 */
@Controller
public class BookAction extends BaseAction {

    private String roomID;

    private String hotelID;

    private double price;

    @Autowired
    private OrderManageService orderManageService;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        String username = (String) session.get("username");
        if (username == null) {
            return LOGIN;
        }
        String memberID = ((MemberMessageVO) (session.get("usermsg"))).id;
        if (orderManageService.book(new BookMessageVO(memberID, roomID, hotelID, price))) {
            session.put("memberStatistics", statisticsService.listStatisticsDataByUser(username));
            return SUCCESS;
        } else {
            session.put("errormsg", "faile to book!");
            return ERROR;
        }

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }
}
