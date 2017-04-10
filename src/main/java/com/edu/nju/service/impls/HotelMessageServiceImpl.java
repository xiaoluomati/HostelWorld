package com.edu.nju.service.impls;

import com.edu.nju.dao.ReviewRecordDao;
import com.edu.nju.dao.UnreviewedMessageDao;
import com.edu.nju.dao.UserDao;
import com.edu.nju.model.ReviewRecord;
import com.edu.nju.model.UnreviewedMessage;
import com.edu.nju.model.User;
import com.edu.nju.service.interfaces.HotelMessageService;
import com.edu.nju.state.ReviewResult;
import com.edu.nju.state.UserIdentity;
import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.util.PrimaryKeyUtil;
import com.edu.nju.vo.HotelMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhuding on 2017/3/9.
 */
@Service
public class HotelMessageServiceImpl implements HotelMessageService {

    @Autowired
    private UnreviewedMessageDao unreviewedMessageDao;

    @Autowired
    private ReviewRecordDao reviewRecordDao;

    @Autowired
    private UserDao userDao;

    @Override
    public boolean register(HotelMessageVO hotelMessageVO) {
        if (null != userDao.findOne(hotelMessageVO.username))
            return false;
        User user = new User();
        this.writeData(null, user, hotelMessageVO);
        return true;
    }

    @Override
    public boolean modifyMessage(String hotelID, HotelMessageVO hotelMessageVO) throws EntityNotFoundException {
        User user = userDao.findOne(hotelMessageVO.username);
        if (user == null) {
            throw new EntityNotFoundException("cannot find user in " + this.getClass() + " when modify");
        }
        this.writeData(hotelID, user, hotelMessageVO);
        return true;
    }

    private void writeData(String hotelID, User user, HotelMessageVO hotelMessageVO) {
        user.setPassword(hotelMessageVO.password);
        user.setUsername(hotelMessageVO.username);
        user.setId(null);
        user.setUseridentity(UserIdentity.HOTEL_MANAGER.value());
        UnreviewedMessage unreviewedMessage = new UnreviewedMessage();
        unreviewedMessage.setId(PrimaryKeyUtil.getRandomID(unreviewedMessageDao));
        unreviewedMessage.setEmail(hotelMessageVO.email);
        unreviewedMessage.setHotelID(hotelID);
        unreviewedMessage.setHotelName(hotelMessageVO.hotelName);
        unreviewedMessage.setLocation(hotelMessageVO.location);
        unreviewedMessage.setTelephone(hotelMessageVO.telephone);
        unreviewedMessage.setUserID(hotelMessageVO.username);
        ReviewRecord reviewRecord = new ReviewRecord();
        reviewRecord.setId(PrimaryKeyUtil.getRandomID(reviewRecordDao));
        reviewRecord.setMessageID(unreviewedMessage.getId());
        reviewRecord.setState(ReviewResult.UNREVIEWED.value());
        userDao.save(user);
        unreviewedMessageDao.save(unreviewedMessage);
        reviewRecordDao.save(reviewRecord);
    }
}
