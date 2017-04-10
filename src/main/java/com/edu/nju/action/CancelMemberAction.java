package com.edu.nju.action;

import com.edu.nju.service.interfaces.MemberManageService;
import com.edu.nju.state.MemberState;
import com.edu.nju.vo.MemberMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/21.
 */
@Controller
public class CancelMemberAction extends BaseAction {

    @Autowired
    private MemberManageService memberManageService;

    @Override
    public String execute() throws Exception {
        String username = (String) session.get("username");
        if (memberManageService.cancel(username)) {
            MemberMessageVO memberMessageVO = (MemberMessageVO) session.get("usermsg");
            memberMessageVO.memberState = MemberState.STOPPED;
            session.put("usermsg", memberMessageVO);
            return SUCCESS;
        } else {
            session.put("errormsg", "cancel member error!");
            return ERROR;
        }
    }
}
