package com.edu.nju.action;

import com.edu.nju.service.interfaces.MemberManageService;
import com.edu.nju.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/16.
 */
@Controller
public class MemberRegisterAction extends BaseAction {

    private RegisterVO registerVO;

    @Autowired
    private MemberManageService memberManageService;

    @Override
    public String execute() throws Exception {
        if (memberManageService.register(registerVO)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public RegisterVO getRegisterVO() {
        return registerVO;
    }

    public void setRegisterVO(RegisterVO registerVO) {
        this.registerVO = registerVO;
    }
}
