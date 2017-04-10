package com.edu.nju.service.interfaces;

import com.edu.nju.util.EntityNotFoundException;
import com.edu.nju.vo.MemberMessageVO;
import com.edu.nju.vo.RegisterVO;

/**
 * Created by zhuding on 2017/3/6.
 */
public interface MemberManageService {

    boolean register(RegisterVO registerVO);

    boolean recharge(String username, double quantity) throws EntityNotFoundException;

    boolean cancel(String username) throws EntityNotFoundException;

    boolean pointExchange(String username, int point) throws EntityNotFoundException;

    boolean login(String username, String password) throws EntityNotFoundException;

    MemberMessageVO find(String username) throws EntityNotFoundException;

    boolean update(MemberMessageVO memberMessageVO) throws EntityNotFoundException;

    boolean remove(String username) throws EntityNotFoundException;

    MemberMessageVO findByMemberID(String memberID) throws EntityNotFoundException;

}
