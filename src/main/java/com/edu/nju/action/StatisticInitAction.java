package com.edu.nju.action;

import com.edu.nju.service.interfaces.MemberManageService;
import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.vo.InoutRecordVO;
import com.edu.nju.vo.StatisticsDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuding on 2017/3/26.
 */
@Controller
public class StatisticInitAction extends BaseAction {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private MemberManageService memberManageService;

    @Override
    public String execute() throws Exception {
        List<Integer> checkinNumbers = new ArrayList<>();
        List<String> hotelIDs = (List<String>) session.get("hotelIDs");
        List<String> hotelNames = new ArrayList<>();
        List<Double> hotelIncomes = new ArrayList<>();
        for (String hotelID : hotelIDs) {
            StatisticsDataVO statisticsDataVO = statisticsService.lisrStatisticsDataByHotel(hotelID);
            checkinNumbers.add(statisticsDataVO.inoutRecords.size());
            hotelNames.add("\"" + statisticsService.getNameByHotelID(hotelID) + "\"");
            hotelIncomes.add(statisticsService.getBalanceByHotelID(hotelID));
        }
        session.put("checkinNumbers", checkinNumbers);
        session.put("hotelNames", hotelNames);
        session.put("hotelIncomes", hotelIncomes);
        System.out.println(checkinNumbers);
        System.out.println(hotelNames);
        System.out.println(hotelIncomes);

        List<Integer> numberOfOrder = new ArrayList<>();
        List<Double> costs = new ArrayList<>();
        List<String> memberIDs = statisticsService.listAllMemberID();
        List<String> memberNames = new ArrayList<>();
        for (String memberID : memberIDs) {
            String username = memberManageService.findByMemberID(memberID).username;
            StatisticsDataVO statisticsDataVO = statisticsService.listStatisticsDataByUser(username);
            numberOfOrder.add(statisticsDataVO.orders.size());
            double sum = 0.0;
            for (InoutRecordVO inoutRecord : statisticsDataVO.inoutRecords) {
                sum += inoutRecord.price;
            }
            costs.add(sum);
            memberNames.add("\"" + statisticsService.getNameByMemberID(memberID) + "\"");
        }
        session.put("numberOfOrder", numberOfOrder);
        session.put("costs", costs);
        session.put("memberNames", memberNames);
        System.out.println(numberOfOrder);
        System.out.println(costs);
        System.out.println(memberNames);


        return SUCCESS;
    }
}
