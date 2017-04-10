package com.edu.nju.action;

import com.edu.nju.service.interfaces.HotelManageService;
import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.vo.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * Created by zhuding on 2017/3/23.
 */
@Controller
public class AddRoomAction extends BaseAction {

    private RoomVO roomVO;

    @Autowired
    private HotelManageService hotelManageService;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        roomVO.hotelID = (String) session.get("hotelID");
        System.out.println(roomVO);
        hotelManageService.createRoom(roomVO);
        Map<String, List<RoomVO>> map = (Map<String, List<RoomVO>>) session.get("roomList");
        map.put(roomVO.hotelID, statisticsService.listAllRoom(roomVO.hotelID));
        session.put("roomList", map);
        return SUCCESS;
    }

    public RoomVO getRoomVO() {
        return roomVO;
    }

    public void setRoomVO(RoomVO roomVO) {
        this.roomVO = roomVO;
    }
}
