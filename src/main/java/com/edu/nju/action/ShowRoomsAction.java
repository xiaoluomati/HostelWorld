package com.edu.nju.action;

import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.state.OrderState;
import com.edu.nju.vo.OrderVO;
import com.edu.nju.vo.RoomVO;
import com.edu.nju.vo.StatisticsDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuding on 2017/3/15.
 */
@Controller
public class ShowRoomsAction extends BaseAction {

    private String hotelID = null;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        Map<String, List<RoomVO>> map = new HashMap<>();
        List<String> hotelIDs = new ArrayList<>();
        Map<String,List<String>> orderedRooms = new HashMap<>();
        if (hotelID != null) {
            hotelIDs.add(hotelID);
        } else {
            hotelIDs = statisticsService.listAllHotelID();
        }
        for (String id : hotelIDs) {
            StatisticsDataVO statisticsDataVO = statisticsService.lisrStatisticsDataByHotel(id);
            List<String> ordered = new ArrayList<>();
            for (OrderVO order : statisticsDataVO.orders) {
                if(order.orderState==OrderState.ORDERED)
                    ordered.add(order.roomNumber);
            }
            orderedRooms.put(id, ordered);
            map.put(id, statisticsService.listAllRoom(id));
        }
        session.put("roomList", map);
        session.put("orderedRooms",orderedRooms);
        System.out.println(orderedRooms);
        return SUCCESS;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }
}
