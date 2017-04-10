package com.edu.nju.dao;

import com.edu.nju.model.InoutRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhuding on 2017/3/5.
 */
public interface InoutRecordDao extends JpaRepository<InoutRecord, String> {

    List<InoutRecord> findByMemberID(String memberID);

    List<InoutRecord> findByHotelID(String hotelID);

    List<InoutRecord> findByHotelIDAndIsSettledAndIsCash(String hotelID, boolean isSettled, boolean isCash);

}
