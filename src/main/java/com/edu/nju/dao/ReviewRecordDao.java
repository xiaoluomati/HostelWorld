package com.edu.nju.dao;

import com.edu.nju.model.ReviewRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhuding on 2017/3/5.
 */
public interface ReviewRecordDao extends JpaRepository<ReviewRecord, String> {

    List<ReviewRecord> findByState(int state);

}
