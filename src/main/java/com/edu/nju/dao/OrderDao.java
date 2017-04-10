package com.edu.nju.dao;

import com.edu.nju.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhuding on 2017/3/5.
 */
public interface OrderDao extends JpaRepository<Order, String> {

    List<Order> findByMemberID(String memberID);

    List<Order> findByHotelID(String hotelID);

    List<Order> findByRoomIDAndOrderState(String roomID, int orderState);

}
