package com.edu.nju.dao;

import com.edu.nju.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhuding on 2017/3/5.
 */
public interface PlanDao extends JpaRepository<Plan, String> {

    List<Plan> findByHotelID(String hotelID);

}
