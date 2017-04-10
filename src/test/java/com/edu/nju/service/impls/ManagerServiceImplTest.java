package com.edu.nju.service.impls;

import com.edu.nju.service.interfaces.ManagerService;
import com.edu.nju.state.ReviewResult;
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
public class ManagerServiceImplTest {

    @Autowired
    private ManagerService managerService;

    @Test
    @Transactional
    public void reviewMessageTest() throws Exception {
        assertTrue(managerService.reviewMessage("8760440", ReviewResult.REJECTED));
    }

    @Test
    @Transactional
    public void grossSettleTest() throws Exception {
        assertTrue(managerService.grossSettle("6147021"));
    }

}