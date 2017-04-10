package com.edu.nju.service.impls;

import com.edu.nju.dao.MemberDao;
import com.edu.nju.dao.MemberQualificationDao;
import com.edu.nju.dao.UserDao;
import com.edu.nju.model.Member;
import com.edu.nju.model.MemberQualification;
import com.edu.nju.model.User;
import com.edu.nju.service.interfaces.MemberManageService;
import com.edu.nju.state.MemberState;
import com.edu.nju.state.UserIdentity;
import com.edu.nju.util.ConstantSet;
import com.edu.nju.util.DateUtil;
import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.util.PrimaryKeyUtil;
import com.edu.nju.vo.MemberMessageVO;
import com.edu.nju.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by zhuding on 2017/3/6.
 */
@Service
public class MemberManageServiceImpl implements MemberManageService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberQualificationDao memberQualificationDao;

    @Autowired
    private UserDao userDao;

    @Override
    public boolean register(RegisterVO registerVO) {
        System.out.println(registerVO == null);
        if (null != userDao.findOne(registerVO.username)) {
            return false;
        }
        Member member = new Member();
        member.setId(PrimaryKeyUtil.getRandomID(memberDao));
        member.setAccountNumber(registerVO.accountNumber);
        member.setIdNumber(registerVO.idNumber);
        member.setRegisterTime(DateUtil.dateToString(new Date()));
        member.setName(registerVO.name);
        MemberQualification memberQualification = new MemberQualification();
        memberQualification.setMemberID(member.getId());
        memberQualification.setMemberState(MemberState.PAUSED.value());
        User user = new User();
        user.setId(member.getId());
        user.setUsername(registerVO.username);
        user.setUseridentity(UserIdentity.MEMBER.value());
        user.setPassword(registerVO.password);
        memberDao.save(member);
        memberQualificationDao.save(memberQualification);
        userDao.save(user);
        return true;
    }

    @Override
    public boolean recharge(String username, double quantity) throws EntityNotFoundException {
        User user = userDao.findOne(username);
        if (user == null) {
            throw new EntityNotFoundException("cannot find user in " + this.getClass() + " when recharge!");
        }
        Member member = memberDao.findOne(user.getId());
        MemberQualification memberQualification = memberQualificationDao.findOne(user.getId());
        if (member == null || memberQualification == null) {
            throw new EntityNotFoundException("cannot find member in " + this.getClass() + " when recharge!");
        }
        member.setBalance(member.getBalance() + quantity);
        MemberState presentState = MemberState.valueOf(memberQualification.getMemberState());
        if (presentState == MemberState.PAUSED) {
            memberQualification.setMemberState(MemberState.ACTIVE.value());
            memberQualification.setPausedays(0);
            if (member.getBalance() > ConstantSet.PRICE_OF_MEMBER_PER_YEAR && memberQualification.getRemaindays() == 0) {
                member.setBalance(member.getBalance() - ConstantSet.PRICE_OF_MEMBER_PER_YEAR);
                memberQualification.setRemaindays(ConstantSet.DAYS_OF_MEMBER);
                member.setPoint(member.getPoint() + (int) ConstantSet.PRICE_OF_MEMBER_PER_YEAR);
                member.setTotalspend(member.getTotalspend() + ConstantSet.PRICE_OF_MEMBER_PER_YEAR);
            }
        } else if (presentState == MemberState.STOPPED && quantity >= ConstantSet.MIN_CHARGE_FOR_MEMBER) {
            memberQualification.setMemberState(MemberState.ACTIVE.value());
            memberQualification.setRemaindays(ConstantSet.DAYS_OF_MEMBER);
        }
        memberDao.save(member);
        memberQualificationDao.save(memberQualification);
        return true;
    }

    @Override
    public boolean cancel(String username) throws EntityNotFoundException {
        User user = userDao.findOne(username);
        if (user == null) {
            throw new EntityNotFoundException("cannot find user in " + this.getClass() + " when cancel!");
        }
        MemberQualification memberQualification = memberQualificationDao.findOne(user.getId());
        if (memberQualification == null) {
            throw new EntityNotFoundException("cannot find member in " + this.getClass() + " when cancel!");
        }
        memberQualification.setMemberState(MemberState.STOPPED.value());
        memberQualificationDao.save(memberQualification);
        return true;
    }

    @Override
    public boolean pointExchange(String username, int point) throws EntityNotFoundException {
        User user = userDao.findOne(username);
        if (user == null) {
            throw new EntityNotFoundException("cannot find user in " + this.getClass() + " when pointExchange!");
        }
        Member member = memberDao.findOne(user.getId());
        MemberQualification memberQualification = memberQualificationDao.findOne(user.getId());
        if (member == null || memberQualification == null) {
            throw new EntityNotFoundException("cannot find member in " + this.getClass() + " when pointExchange!");
        }
        if (member.getPoint() < point) {
            return false;
        }
        member.setPoint(member.getPoint() - point);
        member.setBalance(member.getBalance() + (double) point / ConstantSet.POINTS_NEEDED_FOR_EXCHANGE);
        memberDao.save(member);
        return true;
    }

    @Override
    public boolean login(String username, String password) throws EntityNotFoundException {
        User user = userDao.findOne(username);
        if (user == null) {
            throw new EntityNotFoundException("cannot find user in " + this.getClass() + " when login!");
        }
        return user.getPassword().equals(password);
    }

    @Override
    public MemberMessageVO find(String username) throws EntityNotFoundException {
        User user = userDao.findOne(username);
        if (user == null) {
            throw new EntityNotFoundException("cannot find user in " + this.getClass() + " when find!");
        }
        if (user.getId() != null) {
            Member member = memberDao.findOne(user.getId());
            MemberQualification memberQualification = memberQualificationDao.findOne(user.getId());
            return this.convert(member, memberQualification, user);
        } else {
            return this.convert(null, null, user);
        }
    }

    @Override
    public boolean update(MemberMessageVO memberMessageVO) throws EntityNotFoundException {
        User user = userDao.findOne(memberMessageVO.username);
        if (user == null) {
            throw new EntityNotFoundException("cannot find user in " + this.getClass() + " when update!");
        }
        user.setPassword(memberMessageVO.password);
        userDao.save(user);
        if (user.getId() == null) {
            return true;
        }
        Member member = memberDao.findOne(user.getId());
        if (member == null) {
            throw new EntityNotFoundException("cannot find member in " + this.getClass() + " when update!");
        }
        member.setIdNumber(memberMessageVO.idNumber);
        member.setAccountNumber(memberMessageVO.accountNumber);
        member.setName(memberMessageVO.name);
        memberDao.save(member);
        return true;
    }

    @Override
    public boolean remove(String username) throws EntityNotFoundException {
        User user = userDao.findOne(username);
        if (user == null) {
            throw new EntityNotFoundException("cannot find user in " + this.getClass() + " when remove!");
        }
        Member member = memberDao.findOne(user.getId());
        MemberQualification memberQualification = memberQualificationDao.findOne(user.getId());
        if (member == null || memberQualification == null) {
            throw new EntityNotFoundException("cannot find member in " + this.getClass() + " when remove!");
        }
        userDao.delete(username);
        memberDao.delete(user.getId());
        memberQualificationDao.delete(user.getId());
        return true;
    }

    @Override
    public MemberMessageVO findByMemberID(String memberID) throws EntityNotFoundException {
        Member member = memberDao.findOne(memberID);
        MemberMessageVO memberMessageVO = new MemberMessageVO();
        memberMessageVO.name = member.getName();
        memberMessageVO.idNumber = member.getIdNumber();
        List<User> users = userDao.findByUseridentity(UserIdentity.MEMBER.value());
        for (User user : users) {
            if (user.getId().equals(member.getId())) {
                memberMessageVO.username = user.getUsername();
                break;
            }
        }
        return memberMessageVO;
    }


    private MemberMessageVO convert(Member member, MemberQualification memberQualification, User user) {
        MemberMessageVO memberMessageVO = new MemberMessageVO();
        memberMessageVO.useridentity = UserIdentity.valueOf(user.getUseridentity());
        memberMessageVO.username = user.getUsername();
        if (member == null || memberQualification == null)
            return memberMessageVO;
        memberMessageVO.accountNumber = member.getAccountNumber();
        memberMessageVO.balance = member.getBalance();
        memberMessageVO.id = member.getId();
        memberMessageVO.idNumber = member.getIdNumber();
        memberMessageVO.memberState = MemberState.valueOf(memberQualification.getMemberState());
        memberMessageVO.name = member.getName();
        memberMessageVO.password = user.getPassword();
        memberMessageVO.pausedays = memberQualification.getPausedays();
        memberMessageVO.point = member.getPoint();
        memberMessageVO.registerTime = member.getRegisterTime();
        memberMessageVO.remaindays = memberQualification.getRemaindays();
        memberMessageVO.totalspend = member.getTotalspend();
        return memberMessageVO;
    }

}
