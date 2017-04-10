package com.edu.nju.service.impls;

import com.edu.nju.dao.*;
import com.edu.nju.model.*;
import com.edu.nju.service.interfaces.HotelManageService;
import com.edu.nju.state.OrderState;
import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.util.PrimaryKeyUtil;
import com.edu.nju.vo.CheckinVO;
import com.edu.nju.vo.CheckoutVO;
import com.edu.nju.vo.PlanVO;
import com.edu.nju.vo.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhuding on 2017/3/8.
 */
@Service
public class HotelManageServiceImpl implements HotelManageService {

    @Autowired
    private PlanDao planDao;

    @Autowired
    private InoutRecordDao inoutRecordDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private MemberDao memberDao;

    @Override
    public String releasePlan(PlanVO planVO) {
        Plan plan = new Plan();
        plan.setId(PrimaryKeyUtil.getRandomID(planDao));
        plan.setRoomRank(planVO.roomRank);
        plan.setStartTime(planVO.startTime);
        plan.setEndTime(planVO.endTime);
        plan.setPrice(planVO.price);
        planDao.save(plan);
        return plan.getId();
    }

    @Override
    public String checkin(CheckinVO checkinVO) {
        InoutRecord inoutRecord = new InoutRecord();
        inoutRecord.setId(PrimaryKeyUtil.getRandomID(inoutRecordDao));
        inoutRecord.setRoomID(checkinVO.roomID);
        inoutRecord.setPrice(checkinVO.price);
        inoutRecord.setIdNumber(checkinVO.idNumber);
        inoutRecord.setCheckinTime(checkinVO.checkinTime);
        inoutRecord.setOrderID(checkinVO.orderID);
        inoutRecord.setMemberID(checkinVO.memberID);
        inoutRecord.setHotelID(checkinVO.hotelID);
        inoutRecord.setName(checkinVO.name);
        if (checkinVO.memberID == null)
            inoutRecord.setCash(true);
        inoutRecordDao.save(inoutRecord);
        return inoutRecord.getId();
    }

    @Override
    public boolean checkout(CheckoutVO checkoutVO) throws EntityNotFoundException {
        InoutRecord inoutRecord = inoutRecordDao.findOne(checkoutVO.recordID);
        if (inoutRecord == null) {
            throw new EntityNotFoundException("cannot find inoutrecord in " + this.getClass() + " when checkout!");
        }
        inoutRecord.setCheckoutTime(checkoutVO.checkoutTime);
        inoutRecord.setPrice(checkoutVO.price);
        inoutRecord.setCash(checkoutVO.isCash);

        if (inoutRecord.getOrderID() != null) {
            Order order = orderDao.findOne(inoutRecord.getOrderID());
            order.setOrderState(OrderState.COMPLETED.value());
            orderDao.save(order);
        }
        if (!checkoutVO.isCash && inoutRecord.getMemberID()!=null) {
            Member member = memberDao.findOne(inoutRecord.getMemberID());
            member.setBalance(member.getBalance() - inoutRecord.getPrice());
            member.setPoint(member.getPoint() + (int) inoutRecord.getPrice());
            member.setTotalspend(member.getTotalspend() + inoutRecord.getPrice());
            memberDao.save(member);
        }
        inoutRecordDao.save(inoutRecord);
        return true;
    }

    @Override
    public boolean createRoom(RoomVO roomVO) {
        Room room = new Room();
        room.setId(PrimaryKeyUtil.getRandomID(roomDao));
        room.setHotelID(roomVO.hotelID);
        room.setPrice(roomVO.price);
        room.setRoomNumber(roomVO.roomNumber);
        room.setRoomRank(roomVO.roomRank);
        roomDao.save(room);
        return true;
    }
}
