package com.edu.nju.service.interfaces;

import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.vo.CheckinVO;
import com.edu.nju.vo.CheckoutVO;
import com.edu.nju.vo.PlanVO;
import com.edu.nju.vo.RoomVO;

/**
 * Created by zhuding on 2017/3/8.
 */
public interface HotelManageService {

    String releasePlan(PlanVO planVO);

    String checkin(CheckinVO checkinVO);

    boolean checkout(CheckoutVO checkoutVO) throws EntityNotFoundException;

    boolean createRoom(RoomVO roomVO);

}
