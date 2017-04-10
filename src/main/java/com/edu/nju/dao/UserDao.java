package com.edu.nju.dao;

import com.edu.nju.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhuding on 2017/3/6.
 */
public interface UserDao extends JpaRepository<User, String> {

    List<User> findByUseridentity(int useridentity);

}
