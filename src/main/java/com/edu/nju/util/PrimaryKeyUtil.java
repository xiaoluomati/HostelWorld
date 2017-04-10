package com.edu.nju.util;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Random;

/**
 * Created by zhuding on 2017/3/6.
 */
public class PrimaryKeyUtil {

    private static final int PRIMARY_KEY_LENGTH = 7;

    private PrimaryKeyUtil() {
    }

    public static String getRandomID(JpaRepository repository) {
        Random ramdom = new Random();
        String id = null;
        do {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < PRIMARY_KEY_LENGTH; i++) {
                stringBuilder.append(ramdom.nextInt(10));
            }
            id = stringBuilder.toString();
        } while (repository.findOne(id) != null);
        return id;
    }

}
