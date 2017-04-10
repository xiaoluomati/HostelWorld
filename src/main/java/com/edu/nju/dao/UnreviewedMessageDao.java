package com.edu.nju.dao;

import com.edu.nju.model.UnreviewedMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhuding on 2017/3/5.
 */
public interface UnreviewedMessageDao extends JpaRepository<UnreviewedMessage, String> {

}
