package com.edu.nju.action;

import com.edu.nju.service.interfaces.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuding on 2017/3/26.
 */
@Controller
public class SettleAction extends BaseAction {

    private String hotelID;

    @Autowired
    private ManagerService managerService;

    @Override
    public String execute() throws Exception {
        List<String> hotelIDs = null;
        if (hotelID.equals("all")) {
            hotelIDs = (List<String>) session.get("hotelIDs");
        } else {
            hotelIDs = new ArrayList<>();
            hotelIDs.add(hotelID);
        }
        for (String id : hotelIDs) {
            managerService.grossSettle(id);
        }
        return SUCCESS;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }
}
