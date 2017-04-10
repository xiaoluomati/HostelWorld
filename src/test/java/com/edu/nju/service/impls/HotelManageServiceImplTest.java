package com.edu.nju.service.impls;

import com.edu.nju.service.interfaces.HotelManageService;
import com.edu.nju.vo.CheckinVO;
import com.edu.nju.vo.CheckoutVO;
import com.edu.nju.vo.PlanVO;
import com.edu.nju.vo.RoomVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhuding on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class HotelManageServiceImplTest {

    @Autowired
    private HotelManageService hotelManageService;

    @Test
    @Transactional
    public void releasePlanTest() throws Exception {
        PlanVO planVO = new PlanVO();
        planVO.roomRank = "S";
        planVO.startTime = "2017-03-08";
        planVO.endTime = "2017-03-31";
        planVO.price = 328.0;
        assertNotNull(hotelManageService.releasePlan(planVO));
    }

    @Test
    @Transactional
    public void checkinTest() throws Exception {
        CheckinVO checkinVO = new CheckinVO();
        checkinVO.checkinTime = "2017-03-09";
        checkinVO.hotelID = "6147021";
        checkinVO.idNumber = "342623";
        checkinVO.name = "admin";
        checkinVO.orderID = "9913625";
        checkinVO.roomID = "4021095";
        checkinVO.memberID = "4243546";
        assertNotNull(hotelManageService.checkin(checkinVO));
    }

    @Test
    public void checkoutTest() throws Exception {
        CheckoutVO checkoutVO = new CheckoutVO();
        checkoutVO.isCash = false;
        checkoutVO.checkoutTime = "2017-03-10";
        checkoutVO.price = 328.0;
        checkoutVO.recordID = "5025258";
        assertTrue(hotelManageService.checkout(checkoutVO));
    }

    @Test
    public void createRoomTest() throws Exception {
        RoomVO roomVO = new RoomVO();
        roomVO.price = 328.0;
        roomVO.roomNumber = "222";
        roomVO.roomRank = "S";
        roomVO.hotelID = "6147021";
        assertTrue(hotelManageService.createRoom(roomVO));
    }

}