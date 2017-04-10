package com.edu.nju.dao;

import com.edu.nju.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhuding on 2017/3/6.
 */
public interface RoomDao extends JpaRepository<Room, String> {

    List<Room> findByHotelID(String hotelID);

}
