package com.edu.nju.service.impls;

import com.edu.nju.dao.*;
import com.edu.nju.model.*;
import com.edu.nju.service.interfaces.ManagerService;
import com.edu.nju.state.ReviewResult;
import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.util.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuding on 2017/3/9.
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private ReviewRecordDao reviewRecordDao;

    @Autowired
    private UnreviewedMessageDao unreviewedMessageDao;

    @Autowired
    private InoutRecordDao inoutRecordDao;

    @Autowired
    private UserDao userDao;

    @Override
    public boolean reviewMessage(String reviewRecordID, ReviewResult reviewResult) throws EntityNotFoundException {
        ReviewRecord reviewRecord = reviewRecordDao.findOne(reviewRecordID);
        if (reviewRecord == null) {
            throw new EntityNotFoundException("cannot find reviewRecord in " + this.getClass() + " when review!");
        }
        reviewRecord.setState(reviewResult.value());
        reviewRecordDao.save(reviewRecord);
        if (reviewResult == ReviewResult.ACCEPTED) {
            UnreviewedMessage unreviewedMessage = unreviewedMessageDao.findOne(reviewRecord.getMessageID());
            Hotel hotel = null;
            if (unreviewedMessage.getHotelID() == null) {
                hotel = new Hotel();
                hotel.setId(PrimaryKeyUtil.getRandomID(hotelDao));
                hotel.setBalance(0.0);
            } else {
                hotel = hotelDao.findOne(unreviewedMessage.getHotelID());
            }
            hotel.setUserID(unreviewedMessage.getUserID());
            hotel.setTelephone(unreviewedMessage.getTelephone());
            hotel.setLocation(unreviewedMessage.getLocation());
            hotel.setEmail(unreviewedMessage.getEmail());
            hotel.setHotelName(unreviewedMessage.getHotelName());
            User user = userDao.findOne(unreviewedMessage.getUserID());
            user.setId(hotel.getId());
            hotelDao.save(hotel);
            userDao.save(user);
        }
        return true;
    }

    @Override
    public boolean grossSettle(String hotelID) throws EntityNotFoundException {
        List<InoutRecord> inoutRecords = inoutRecordDao.findByHotelIDAndIsSettledAndIsCash(hotelID, false, false);
        if (inoutRecords == null) {
            throw new EntityNotFoundException("cannot find inoutRecords in " + this.getClass() + " when grossSettle!");
        }
        double sum = 0.0;
        for (InoutRecord inoutRecord : inoutRecords) {
            sum += inoutRecord.getPrice();
            inoutRecord.setSettled(true);
        }
        inoutRecordDao.save(inoutRecords);
        Hotel hotel = hotelDao.findOne(hotelID);
        if (hotel == null) {
            throw new EntityNotFoundException("cannot find hotel in " + this.getClass() + " when grossSettle!");
        }
        hotel.setBalance(hotel.getBalance() + sum);
        hotelDao.save(hotel);
        return true;
    }
}
