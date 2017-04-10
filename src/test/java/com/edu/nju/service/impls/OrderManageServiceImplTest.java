package com.edu.nju.service.impls;

import com.edu.nju.service.interfaces.OrderManageService;
import com.edu.nju.vo.BookMessageVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

/**
 * Created by zhuding on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class OrderManageServiceImplTest {

    @Autowired
    private OrderManageService orderManageService;

    @Test
    @Transactional
    public void bookTest() throws Exception {
        BookMessageVO bookMessageVO = new BookMessageVO();
        bookMessageVO.memberID = "4243546";
        bookMessageVO.roomID = "4021095";
        assertTrue(orderManageService.book(bookMessageVO));
    }

    @Test
    @Transactional
    public void cancelBookTest() throws Exception {
        assertTrue(orderManageService.cancelBook("admin", "8156404"));
    }

}