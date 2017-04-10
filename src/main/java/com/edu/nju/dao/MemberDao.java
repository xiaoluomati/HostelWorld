package com.edu.nju.dao;

import com.edu.nju.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhuding on 2017/3/2.
 */
public interface MemberDao extends JpaRepository<Member, String> {

}
