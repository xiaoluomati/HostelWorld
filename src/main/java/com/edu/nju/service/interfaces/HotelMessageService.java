package com.edu.nju.service.interfaces;

import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.vo.HotelMessageVO;

/**
 * Created by zhuding on 2017/3/8.
 */
public interface HotelMessageService {

    boolean register(HotelMessageVO hotelMessageVO);

    boolean modifyMessage(String hotelID, HotelMessageVO hotelMessageVO) throws EntityNotFoundException;

}
