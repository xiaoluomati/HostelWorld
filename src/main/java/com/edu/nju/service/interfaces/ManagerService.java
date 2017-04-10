package com.edu.nju.service.interfaces;

import com.edu.nju.state.ReviewResult;
import com.edu.nju.util.EntityNotFoundException;

/**
 * Created by zhuding on 2017/3/9.
 */
public interface ManagerService {

    boolean reviewMessage(String reviewRecordID, ReviewResult reviewResult) throws EntityNotFoundException;

    boolean grossSettle(String hotelID) throws EntityNotFoundException;
}
