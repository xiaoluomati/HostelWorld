package com.edu.nju.action;

import com.edu.nju.service.interfaces.ManagerService;
import com.edu.nju.service.interfaces.StatisticsService;
import com.edu.nju.state.ReviewResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuding on 2017/3/26.
 */
@Controller
public class ReviewAction extends BaseAction {

    private String recordID;

    private int reviewResult;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public String execute() throws Exception {
        ReviewResult result = ReviewResult.valueOf(reviewResult);
        managerService.reviewMessage(recordID, result);
        session.put("unreviewedMessages", statisticsService.listUnreviewedMessages());
        return SUCCESS;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public int getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(int reviewResult) {
        this.reviewResult = reviewResult;
    }
}
