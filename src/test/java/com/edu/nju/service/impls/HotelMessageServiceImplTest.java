package com.edu.nju.service.impls;

import com.edu.nju.service.interfaces.HotelMessageService;
import com.edu.nju.vo.HotelMessageVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

/**
 * Created by zhuding on 2017/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class HotelMessageServiceImplTest {

    @Autowired
    private HotelMessageService hotelMessageService;

    @Test
    @Transactional
    public void registerTest() throws Exception {
        HotelMessageVO hotelMessageVO = new HotelMessageVO();
        hotelMessageVO.email = "ssh@163.com";
        hotelMessageVO.location = "nju";
        hotelMessageVO.password = "manager";
        hotelMessageVO.username = "manager";
        hotelMessageVO.telephone = "123";
        assertTrue(hotelMessageService.register(hotelMessageVO));
    }

    @Test
    @Transactional
    public void modifyMessageTest() throws Exception {
        HotelMessageVO hotelMessageVO = new HotelMessageVO();
        hotelMessageVO.email = "ssh@163.com";
        hotelMessageVO.location = "nju.edu";
        hotelMessageVO.password = "manager";
        hotelMessageVO.username = "manager";
        hotelMessageVO.telephone = "123";
        assertTrue(hotelMessageService.modifyMessage("6147021", hotelMessageVO));
    }

}