package com.edu.nju.action;

import com.edu.nju.service.interfaces.HotelManageService;
import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.util.DateUtil;
import com.edu.nju.vo.CheckoutVO;
import com.edu.nju.vo.InoutRecordVO;
import com.edu.nju.vo.StatisticsDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

/**
 * Created by zhuding on 2017/3/25.
 */
@Controller
public class CheckoutAction extends BaseAction {

    private String roomNumber;

    private CheckoutVO checkoutVO;

    @Autowired
    private HotelManageService hotelManageService;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        String hotelID = (String) session.get("hotelID");
        StatisticsDataVO statisticsDataVO = (StatisticsDataVO) session.get("hotelStatistics");
        List<InoutRecordVO> inoutRecordVOS = statisticsDataVO.inoutRecords;
        for (InoutRecordVO inoutRecordVO : inoutRecordVOS) {
            if (inoutRecordVO.roomNumber.equals(roomNumber) && inoutRecordVO.checkoutTime == null) {
                checkoutVO.recordID = inoutRecordVO.id;
                checkoutVO.price = inoutRecordVO.price;
//                break;
            }
        }
        checkoutVO.checkoutTime = DateUtil.dateToString(new Date());
        hotelManageService.checkout(checkoutVO);
        session.put("hotelStatistics", statisticsService.lisrStatisticsDataByHotel(hotelID));
        return SUCCESS;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public CheckoutVO getCheckoutVO() {
        return checkoutVO;
    }

    public void setCheckoutVO(CheckoutVO checkoutVO) {
        this.checkoutVO = checkoutVO;
    }
}
