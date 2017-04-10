package com.edu.nju.action;

import com.edu.nju.service.interfaces.MemberManageService;
import com.edu.nju.vo.MemberMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/20.
 */
@Controller
public class ModifyMemberMessageAction extends BaseAction {

    private MemberMessageVO memberMessageVO;

    @Autowired
    private MemberManageService memberManageService;

    @Override
    public String execute() throws Exception {
        memberMessageVO.username = (String) session.get("username");
        if (memberMessageVO.password == null || memberMessageVO.password.equals("")) {
            memberMessageVO.password = (String) session.get("password");
        }
        if (memberManageService.update(memberMessageVO)) {
            MemberMessageVO memberMsg = (MemberMessageVO) session.get("usermsg");
            memberMsg.name = memberMessageVO.name;
            memberMsg.idNumber = memberMessageVO.idNumber;
            memberMsg.accountNumber = memberMessageVO.accountNumber;
            memberMsg.password = memberMessageVO.password;
            session.put("password", memberMessageVO.password);
            session.put("usermsg", memberMsg);
        }
        return SUCCESS;
    }

    public MemberMessageVO getMemberMessageVO() {
        return memberMessageVO;
    }

    public void setMemberMessageVO(MemberMessageVO memberMessageVO) {
        this.memberMessageVO = memberMessageVO;
    }
}
