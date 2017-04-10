package com.edu.nju.service.interfaces;

import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.vo.BookMessageVO;

/**
 * Created by zhuding on 2017/3/7.
 */
public interface OrderManageService {

    boolean book(BookMessageVO bookMessageVO) throws EntityNotFoundException;

    boolean cancelBook(String username, String orderID) throws EntityNotFoundException;

}
