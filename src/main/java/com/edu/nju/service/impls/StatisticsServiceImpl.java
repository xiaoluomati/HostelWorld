package com.edu.nju.service.impls;

import com.edu.nju.dao.*;
import com.edu.nju.model.*;
import com.edu.nju.service.interfaces.MemberManageService;
import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.state.OrderState;
import com.edu.nju.state.ReviewResult;
import com.edu.nju.util.DateUtil;
import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhuding on 2017/3/9.
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private InoutRecordDao inoutRecordDao;

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberManageService memberManageService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private PlanDao planDao;

    @Autowired
    private ReviewRecordDao reviewRecordDao;

    @Autowired
    private UnreviewedMessageDao unreviewedMessageDao;

    @Override
    public StatisticsDataVO listStatisticsDataByUser(String username) throws EntityNotFoundException {
        StatisticsDataVO statisticsDataVO = new StatisticsDataVO();
        MemberMessageVO memberMessageVO = memberManageService.find(username);
        if (memberMessageVO == null) {
            throw new EntityNotFoundException("cannot find member in " + this.getClass() + " when getStatisticsData!");
        }
        String memberID = memberMessageVO.id;
        List<Order> orders = orderDao.findByMemberID(memberID);
        if (orders == null) {
            throw new EntityNotFoundException("cannot find orders in " + this.getClass() + " when getStatisticsData!");
        }
        for (Order order : orders) {
            Room room = roomDao.findOne(order.getRoomID());
            Hotel hotel = hotelDao.findOne(room.getHotelID());
            if (room == null || hotel == null) {
                throw new EntityNotFoundException("cannot find StatisticsData in " + this.getClass() + " when getStatisticsData!");
            }
            OrderVO orderVO = new OrderVO();
            orderVO.price = order.getPrice();
            orderVO.roomNumber = room.getRoomNumber();
            orderVO.roomRank = room.getRoomRank();
            orderVO.hotelName = hotel.getHotelName();
            orderVO.id = order.getId();
            orderVO.orderTime = order.getOrderTime();
            orderVO.orderState = OrderState.valueOf(order.getOrderState());
            statisticsDataVO.orders.add(orderVO);
        }
        List<InoutRecord> inoutRecords = inoutRecordDao.findByMemberID(memberID);
        if (inoutRecords == null) {
            throw new EntityNotFoundException("cannot find inoutRecords in " + this.getClass() + " when getStatisticsData!");
        }
        for (InoutRecord inoutRecord : inoutRecords) {
            InoutRecordVO inoutRecordVO = new InoutRecordVO();
            inoutRecordVO.id = inoutRecord.getId();
            inoutRecordVO.checkinTime = inoutRecord.getCheckinTime();
            inoutRecordVO.checkoutTime = inoutRecord.getCheckoutTime();
            inoutRecordVO.isCash = inoutRecord.isCash();
            inoutRecordVO.memberID = inoutRecord.getMemberID();
            inoutRecordVO.price = inoutRecord.getPrice();
            Room room = roomDao.findOne(inoutRecord.getRoomID());
            inoutRecordVO.roomNumber = room.getRoomNumber();
            Hotel hotel = hotelDao.findOne(inoutRecord.getHotelID());
            inoutRecordVO.hotelName = hotel.getHotelName();
            statisticsDataVO.inoutRecords.add(inoutRecordVO);
        }
        return statisticsDataVO;
    }

    @Override
    public StatisticsDataVO lisrStatisticsDataByHotel(String hotelID) throws EntityNotFoundException {
        List<InoutRecord> inoutRecords = inoutRecordDao.findByHotelID(hotelID);
        StatisticsDataVO statisticsDataVO = new StatisticsDataVO();
        Hotel hotel = hotelDao.findOne(hotelID);
        for (InoutRecord inoutRecord : inoutRecords) {
            InoutRecordVO inoutRecordVO = new InoutRecordVO();
            inoutRecordVO.id = inoutRecord.getId();
            inoutRecordVO.checkinTime = inoutRecord.getCheckinTime();
            inoutRecordVO.checkoutTime = inoutRecord.getCheckoutTime();
            inoutRecordVO.isCash = inoutRecord.isCash();
            inoutRecordVO.memberID = inoutRecord.getMemberID();
            inoutRecordVO.price = inoutRecord.getPrice();
            Room room = roomDao.findOne(inoutRecord.getRoomID());
            inoutRecordVO.roomNumber = room.getRoomNumber();
            inoutRecordVO.hotelName = hotel.getHotelName();
            statisticsDataVO.inoutRecords.add(inoutRecordVO);
        }
        List<Order> orders = orderDao.findByHotelID(hotelID);
        for (Order order : orders) {
            OrderVO orderVO = new OrderVO();
            Room room = roomDao.findOne(order.getRoomID());
            orderVO.price = order.getPrice();
            orderVO.roomNumber = room.getRoomNumber();
            orderVO.roomRank = room.getRoomRank();
            orderVO.memberID = order.getMemberID();
            orderVO.hotelName = hotel.getHotelName();
            orderVO.id = order.getId();
            orderVO.orderTime = order.getOrderTime();
            orderVO.orderState = OrderState.valueOf(order.getOrderState());
            statisticsDataVO.orders.add(orderVO);
        }

        return statisticsDataVO;
    }

    @Override
    public String getNameByHotelID(String hotelID) {
        return hotelDao.findOne(hotelID).getHotelName();
    }

    @Override
    public String getNameByMemberID(String memberID) {
        return memberDao.findOne(memberID).getName();
    }

    @Override
    public double getBalanceByHotelID(String hotelID) {
        return hotelDao.findOne(hotelID).getBalance();
    }

    @Override
    public List<String> listAllMemberID() {
        List<String> memberIDs = new ArrayList<>();
        List<Member> members = memberDao.findAll();
        for (Member member : members) {
            memberIDs.add(member.getId());
        }
        return memberIDs;
    }

    @Override
    public List<String> listAllHotelID() {
        List<String> hotelIDs = new ArrayList<>();
        List<Hotel> hotels = hotelDao.findAll();
        for (Hotel hotel : hotels) {
            hotelIDs.add(hotel.getId());
        }
        return hotelIDs;
    }

    @Override
    public List<HotelVO> listAllHotel() {
        List<HotelVO> hotelVOs = new ArrayList<>();
        List<Hotel> hotels = hotelDao.findAll();
        for (Hotel hotel : hotels) {
            HotelVO hotelVO = new HotelVO();
            hotelVO.id = hotel.getId();
            hotelVO.email = hotel.getEmail();
            hotelVO.location = hotel.getLocation();
            hotelVO.telephone = hotel.getTelephone();
            hotelVO.hotelName = hotel.getHotelName();
            hotelVOs.add(hotelVO);
        }
        return hotelVOs;
    }

    @Override
    public List<PlanVO> listPlanByHotelID(String hotelID) {
        List<PlanVO> planVOS = new ArrayList<>();
        List<Plan> plans = planDao.findByHotelID(hotelID);
        for (Plan plan : plans) {
            PlanVO planVO = new PlanVO();
            planVO.price = plan.getPrice();
            planVO.roomRank = plan.getRoomRank();
            planVO.startTime = plan.getStartTime();
            planVO.endTime = plan.getEndTime();
            planVOS.add(planVO);
        }
        return planVOS;
    }

    @Override
    public List<RoomVO> listAllRoom(String hotelID) {
        List<Plan> plans = planDao.findByHotelID(hotelID);
        Hotel hotel = hotelDao.findOne(hotelID);
        List<RoomVO> roomVOS = new ArrayList<>();
        List<Room> rooms = roomDao.findByHotelID(hotelID);
        String dateString = DateUtil.dateToString(new Date());
        for (Room room : rooms) {
            Plan plan = null;
            for (Plan plan1 : plans) {
                if (DateUtil.isAfter(plan1.getEndTime(), dateString) && plan1.getRoomRank().equals(room.getRoomRank())) {
                    plan = plan1;
                    break;
                }
            }
            RoomVO roomVO = new RoomVO();
            roomVO.roomID = room.getId();
            roomVO.roomRank = room.getRoomRank();
            roomVO.roomNumber = room.getRoomNumber();
            roomVO.price = plan == null ? room.getPrice() : plan.getPrice();
            roomVO.hotelName = hotel.getHotelName();
            roomVO.hotelID = hotelID;
            roomVOS.add(roomVO);
        }
        return roomVOS;
    }

    @Override
    public HotelVO getHotelByManagerID(String manageID) {
        List<Hotel> hotels = hotelDao.findByUserID(manageID);
        if (hotels == null || hotels.size() == 0) {
            return null;
        }
        Hotel hotel = hotels.get(0);
        HotelVO hotelVO = new HotelVO();
        hotelVO.id = hotel.getId();
        hotelVO.email = hotel.getEmail();
        hotelVO.location = hotel.getLocation();
        hotelVO.telephone = hotel.getTelephone();
        hotelVO.hotelName = hotel.getHotelName();
        hotelVO.balance = hotel.getBalance();
        return hotelVO;
    }

    @Override
    public List<ReviewMessageVO> listUnreviewedMessages() {
        List<ReviewMessageVO> reviewMessageVOS = new ArrayList<>();
        List<ReviewRecord> reviewRecords = reviewRecordDao.findByState(ReviewResult.UNREVIEWED.value());
        for (ReviewRecord reviewRecord : reviewRecords) {
            ReviewMessageVO reviewMessageVO = new ReviewMessageVO();
            reviewMessageVO.recordID = reviewRecord.getId();
            UnreviewedMessage unreviewedMessage = unreviewedMessageDao.findOne(reviewRecord.getMessageID());
            reviewMessageVO.email = unreviewedMessage.getEmail();
            reviewMessageVO.hotelID = unreviewedMessage.getHotelID();
            reviewMessageVO.location = unreviewedMessage.getLocation();
            reviewMessageVO.telephone = unreviewedMessage.getTelephone();
            reviewMessageVO.hotelName = unreviewedMessage.getHotelName();
            reviewMessageVOS.add(reviewMessageVO);
        }
        return reviewMessageVOS;
    }
}
