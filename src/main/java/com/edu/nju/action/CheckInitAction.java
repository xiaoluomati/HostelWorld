package com.edu.nju.action;

import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.state.OrderState;
import com.edu.nju.vo.InoutRecordVO;
import com.edu.nju.vo.OrderVO;
import com.edu.nju.vo.RoomVO;
import com.edu.nju.vo.StatisticsDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuding on 2017/3/24.
 */
@Controller
public class CheckInitAction extends BaseAction {

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        String hotelID = (String) session.get("hotelID");
        List<RoomVO> roomVOS = statisticsService.listAllRoom(hotelID);
        List<String> roomNumbers = new ArrayList<>();
        for (RoomVO roomVO : roomVOS) {
            roomNumbers.add(roomVO.getRoomNumber());
        }

        StatisticsDataVO statisticsDataVO = (StatisticsDataVO) session.get("hotelStatistics");
        List<OrderVO> orderVOS = statisticsDataVO.orders;
        List<String> orderIDs = new ArrayList<>();
        for (OrderVO orderVO : orderVOS) {
            if (orderVO.orderState.equals(OrderState.ORDERED)) {
                orderIDs.add(orderVO.id);
//                if (roomNumbers.contains(orderVO.roomNumber)) {
//                    roomNumbers.remove(orderVO.roomNumber);
//                }
            }
        }
        List<InoutRecordVO> inoutRecordVOS = statisticsDataVO.inoutRecords;
        List<String> roomIDsCheckout = new ArrayList<>();
        for (InoutRecordVO inoutRecordVO : inoutRecordVOS) {
            if (inoutRecordVO.checkoutTime == null) {
                roomIDsCheckout.add(inoutRecordVO.roomNumber);
            }
        }
        session.put("roomIDsCheckin", roomNumbers);
        session.put("orderIDsCheckin", orderIDs);
        session.put("roomNumbersCheckout", roomIDsCheckout);
        return SUCCESS;
    }
}
