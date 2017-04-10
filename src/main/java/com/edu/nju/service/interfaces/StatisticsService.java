package com.edu.nju.service.interfaces;

import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.vo.*;

import java.util.List;

/**
 * Created by zhuding on 2017/3/9.
 */
public interface StatisticsService {

    StatisticsDataVO listStatisticsDataByUser(String username) throws EntityNotFoundException;

    StatisticsDataVO lisrStatisticsDataByHotel(String hotelID) throws EntityNotFoundException;

    String getNameByHotelID(String hotelID);

    String getNameByMemberID(String memberID);

    double getBalanceByHotelID(String hotelID);

    List<String> listAllMemberID();

    List<String> listAllHotelID();

    List<HotelVO> listAllHotel();

    List<PlanVO> listPlanByHotelID(String hotelID);

    List<RoomVO> listAllRoom(String hotelID);

    HotelVO getHotelByManagerID(String manageID);

    List<ReviewMessageVO> listUnreviewedMessages();

}
