package com.edu.nju.service.impls;

import com.edu.nju.dao.UserDao;
import com.edu.nju.service.interfaces.MemberManageService;
import com.edu.nju.vo.MemberMessageVO;
import com.edu.nju.vo.RegisterVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by zhuding on 2017/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class MemberManageServiceImplTest {

    @Autowired
    private MemberManageService memberManageService;

    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    public void registerTest() throws Exception {
        RegisterVO registerVO = new RegisterVO("admin", "admin", 1, "23333", "342623", "admin");
        assertTrue(memberManageService.register(registerVO));
    }

    @Test
    @Transactional
    public void rechargeTest() throws Exception {
        assertTrue(memberManageService.recharge("admin", 100000));
    }

    @Test
    @Transactional
    public void pointExchangeTest() throws Exception {
        assertFalse(memberManageService.pointExchange("admin", 5000));
    }

    @Test
    @Transactional
    public void cancelTest() throws Exception {
        assertTrue(memberManageService.cancel("admin"));
    }

    @Test
    @Transactional
    public void loginTest() throws Exception {
        assertTrue(memberManageService.login("admin", "admin"));
        assertFalse(memberManageService.login("admin", "admIn"));
    }

    @Test
    @Transactional
    public void findTest() throws Exception {
        MemberMessageVO memberMessageVO = memberManageService.find("admin");
        assertEquals(memberMessageVO.name, "admin");
    }

    @Test
    @Transactional
    public void updateTest() throws Exception {
        MemberMessageVO memberMessageVO = new MemberMessageVO();
        memberMessageVO.username = "admin";
        memberMessageVO.password = "233333333";
        memberManageService.update(memberMessageVO);
        assertEquals(userDao.findOne("admin").getPassword(), "233333333");

    }

    @Test
    @Transactional
    public void removeTest() throws Exception {
        memberManageService.remove("admin");
        assertNull(userDao.findOne("admin"));
    }


}