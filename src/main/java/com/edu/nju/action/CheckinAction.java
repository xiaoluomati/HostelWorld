package com.edu.nju.action;

import com.edu.nju.service.interfaces.HotelManageService;
import com.edu.nju.service.interfaces.MemberManageService;
import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.util.DateUtil;
import com.edu.nju.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuding on 2017/3/24.
 */
@Controller
public class CheckinAction extends BaseAction {

    private String roomNumber;

    private CheckinVO checkinVO;

    @Autowired
    private HotelManageService hotelManageService;

    @Autowired
    private MemberManageService memberManageService;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        String hotelID = (String) session.get("hotelID");
        checkinVO.checkinTime = DateUtil.dateToString(new Date());
        checkinVO.hotelID = hotelID;
        if (checkinVO.orderID != null) {
            StatisticsDataVO statisticsDataVO = (StatisticsDataVO) session.get("hotelStatistics");
            List<OrderVO> orderVOS = statisticsDataVO.orders;
            OrderVO order = null;
            for (OrderVO orderVO : orderVOS) {
                if (orderVO.id.equals(checkinVO.orderID)) {
                    order = orderVO;
                    break;
                }
            }
            checkinVO.memberID = order.memberID;
            checkinVO.price = order.price;
            List<RoomVO> roomVOS = statisticsService.listAllRoom(hotelID);
            for (RoomVO roomVO : roomVOS) {
                if (roomVO.roomNumber.equals(order.roomNumber)) {
                    checkinVO.roomID = roomVO.getRoomID();
                    break;
                }
            }
            MemberMessageVO memberMessageVO = memberManageService.findByMemberID(order.memberID);
            checkinVO.name = memberMessageVO.name;
            checkinVO.idNumber = memberMessageVO.idNumber;
        } else if (checkinVO.memberID != null) {
            MemberMessageVO memberMessageVO = memberManageService.findByMemberID(checkinVO.memberID);
            checkinVO.name = memberMessageVO.name;
            checkinVO.idNumber = memberMessageVO.idNumber;
        }
//        System.out.println(checkinVO);
        Map<String, List<RoomVO>> map = (Map<String, List<RoomVO>>) session.get("roomList");
        List<RoomVO> roomVOS = map.get(hotelID);
        for (RoomVO roomVO : roomVOS) {
            if (roomVO.roomNumber.equals(roomNumber)) {
                checkinVO.roomID = roomVO.getRoomID();
                checkinVO.price = roomVO.price;
                break;
            }
        }
        session.put("lastRecordID", hotelManageService.checkin(checkinVO));
        session.put("hotelStatistics", statisticsService.lisrStatisticsDataByHotel(hotelID));
        return super.execute();
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public CheckinVO getCheckinVO() {
        return checkinVO;
    }

    public void setCheckinVO(CheckinVO checkinVO) {
        this.checkinVO = checkinVO;
    }
}
