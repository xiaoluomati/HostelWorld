package com.edu.nju.service;

import com.edu.nju.dao.MemberDao;
import com.edu.nju.dao.MemberQualificationDao;
import com.edu.nju.model.Member;
import com.edu.nju.model.MemberQualification;
import com.edu.nju.state.MemberState;
import com.edu.nju.util.ConstantSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuding on 2017/3/28.
 */
@Service
public class MemberShipTask {

    @Autowired
    private MemberQualificationDao memberQualificationDao;

    @Autowired
    private MemberDao memberDao;

    @Scheduled(cron = "0 0 0 * * ?")
    private void doTask() {
        List<MemberQualification> memberQualifications = memberQualificationDao.findAll();
        for (MemberQualification memberQualification : memberQualifications) {
            if (memberQualification.getMemberState() == MemberState.ACTIVE.value()) {
                memberQualification.setRemaindays(memberQualification.getRemaindays() - 1);
                if (memberQualification.getRemaindays() == 0) {
                    Member member = memberDao.findOne(memberQualification.getMemberID());
                    if (member.getBalance() > ConstantSet.PRICE_OF_MEMBER_PER_YEAR) {
                        member.setBalance(member.getBalance() - ConstantSet.PRICE_OF_MEMBER_PER_YEAR);
                        member.setPoint(member.getPoint() + (int) ConstantSet.PRICE_OF_MEMBER_PER_YEAR);
                        member.setTotalspend(member.getTotalspend() + ConstantSet.PRICE_OF_MEMBER_PER_YEAR);
                        memberQualification.setRemaindays(ConstantSet.DAYS_OF_MEMBER);
                    } else {
                        memberQualification.setMemberState(MemberState.PAUSED.value());
                        memberQualification.setPausedays(0);
                    }
                    memberDao.save(member);
                }
            } else if (memberQualification.getMemberState() == MemberState.PAUSED.value()) {
                memberQualification.setPausedays(memberQualification.getPausedays() + 1);
                if (memberQualification.getPausedays() > 365) {
                    memberQualification.setMemberState(MemberState.STOPPED.value());
                }
            }
        }
        memberQualificationDao.save(memberQualifications);
    }
}
