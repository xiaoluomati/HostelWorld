package com.edu.nju.service.impls;

import com.edu.nju.dao.OrderDao;
import com.edu.nju.dao.RoomDao;
import com.edu.nju.model.Order;
import com.edu.nju.service.interfaces.OrderManageService;
import com.edu.nju.state.OrderState;
import com.edu.nju.util.DateUtil;
import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.util.PrimaryKeyUtil;
import com.edu.nju.vo.BookMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhuding on 2017/3/7.
 */
@Service
public class OrderManageServiceImpl implements OrderManageService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RoomDao roomDao;

    @Override
    public boolean book(BookMessageVO bookMessageVO) throws EntityNotFoundException {
        List<Order> orders = orderDao.findByRoomIDAndOrderState(bookMessageVO.roomID, OrderState.ORDERED.value());
        if (orders != null && orders.size() != 0) {
            return false;
        }
        Order order = new Order();
        order.setPrice(bookMessageVO.price);
        order.setHotelID(bookMessageVO.hotelID);
        order.setId(PrimaryKeyUtil.getRandomID(orderDao));
        order.setMemberID(bookMessageVO.memberID);
        order.setOrderState(OrderState.ORDERED.value());
        order.setOrderTime(DateUtil.dateToString(new Date()));
        order.setRoomID(bookMessageVO.roomID);
        orderDao.save(order);
        return true;
    }

    @Override
    public boolean cancelBook(String username, String orderID) throws EntityNotFoundException {
        Order order = orderDao.findOne(orderID);
        if (order == null) {
            throw new EntityNotFoundException("cannot find order in " + this.getClass() + " when book!");
        }
        order.setOrderState(OrderState.CANCELED.value());
        orderDao.save(order);
        return true;
    }

}
