package com.edu.nju.dao;

import com.edu.nju.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhuding on 2017/3/5.
 */
public interface HotelDao extends JpaRepository<Hotel, String> {

    List<Hotel> findByUserID(String userID);

}
