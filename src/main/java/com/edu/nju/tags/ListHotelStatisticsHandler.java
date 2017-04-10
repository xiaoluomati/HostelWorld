package com.edu.nju.tags;

import com.edu.nju.vo.InoutRecordVO;
import com.edu.nju.vo.OrderVO;
import com.edu.nju.vo.StatisticsDataVO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhuding on 2017/3/23.
 */
public class ListHotelStatisticsHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        StatisticsDataVO statisticsDataVO = (StatisticsDataVO) getJspContext().findAttribute("hotelStatistics");
        List<OrderVO> orderVOS = statisticsDataVO.orders;
        List<InoutRecordVO> inoutRecordVOS = statisticsDataVO.inoutRecords;
        JspWriter out = getJspContext().getOut();
        outOrderTableHead(out);
        int i = 0;
        int numberOfCanceled = 0;
        int numberOfOrdered = 0;
        int numberOfCompleted = 0;
        for (OrderVO orderVO : orderVOS) {
            i++;
            switch (orderVO.orderState) {
                case CANCELED:
                    numberOfCanceled++;
                    break;
                case COMPLETED:
                    numberOfCompleted++;
                    break;
                case ORDERED:
                    numberOfOrdered++;
                    break;
            }
            out.println("<tr>\n" +
                    "            <td>" + i + "</td>\n" +
                    "            <td>" + orderVO.memberID + "</td>\n" +
                    "            <td>" + orderVO.roomRank + "</td>\n" +
                    "            <td>" + orderVO.roomNumber + "</td>\n" +
                    "            <td>" + orderVO.price + "</td>\n" +
                    "            <td>" + orderVO.orderTime + "</td>\n" +
                    "            <td>" + orderVO.orderState + "</td>\n" +
                    "        </tr>");
        }
        out.println("</tbody>\n" +
                "    </table>");
        out.println("<div class=\"alert alert-info\" role=\"alert\">\n" +
                "共有<strong>" + (numberOfOrdered + numberOfCanceled + numberOfCompleted) + "</strong>条预订记录,\n" +
                "其中<strong>" + numberOfOrdered + "</strong>条进行中,\n" +
                "<strong>" + numberOfCompleted + "</strong>条已完成,\n" +
                "<strong>" + numberOfCanceled + "</strong>条已取消,\n" +
                "</div>");
        getJspContext().setAttribute("numberOfOrdered", numberOfOrdered, PageContext.SESSION_SCOPE);
        getJspContext().setAttribute("numberOfCompleted", numberOfCompleted, PageContext.SESSION_SCOPE);
        getJspContext().setAttribute("numberOfCanceled", numberOfCanceled, PageContext.SESSION_SCOPE);
        outInoutTableHead(out);
        int j = 0;
        int numberOfCash = 0;
        int numberOfNotCash = 0;
        for (InoutRecordVO inoutRecordVO : inoutRecordVOS) {
            j++;
            if (inoutRecordVO.isCash) {
                numberOfCash++;
            } else {
                numberOfNotCash++;
            }
            out.println("<tr>\n" +
                    "            <td>" + j + "</td>\n" +
                    "            <td>" + (inoutRecordVO.memberID == null ? "非会员" : inoutRecordVO.memberID) + "</td>\n" +
                    "            <td>" + inoutRecordVO.roomNumber + "</td>\n" +
                    "            <td>" + inoutRecordVO.price + "</td>\n" +
                    "            <td>" + inoutRecordVO.checkinTime + "</td>\n" +
                    "            <td>" + (inoutRecordVO.checkoutTime == null ? "未出店" : inoutRecordVO.checkoutTime) + "</td>\n" +
                    "            <td>" + (inoutRecordVO.isCash ? "现金" : "会员卡") + "</td>\n" +
                    "        </tr>");
        }
        out.println("</tbody>\n" +
                "    </table>");
        out.println("<div class=\"alert alert-info\" role=\"alert\">\n" +
                "共有<strong>" + (numberOfCash + numberOfNotCash) + "</strong>条入住记录,\n" +
                "其中<strong>" + numberOfCash + "</strong>条使用现金,\n" +
                "<strong>" + numberOfNotCash + "</strong>条使用会员卡,\n" +
                "</div>");
        getJspContext().setAttribute("numberOfCash", numberOfCash, PageContext.SESSION_SCOPE);
        getJspContext().setAttribute("numberOfNotCash", numberOfNotCash, PageContext.SESSION_SCOPE);
    }

    private void outOrderTableHead(JspWriter out) throws IOException {
        out.println("<table class=\"table table-striped\">");
        out.println("<thead>\n" +
                "            <tr>\n" +
                "                <th>#</th>\n" +
                "                <th>会员卡号</th>\n" +
                "                <th>房间等级</th>\n" +
                "                <th>房间号</th>\n" +
                "                <th>价格</th>\n" +
                "                <th>预订时间</th>\n" +
                "                <th>订单状态</th>\n" +
                "            </tr>\n" +
                "        </thead>");
        out.println("<tbody>");
    }

    private void outInoutTableHead(JspWriter out) throws IOException {
        out.println("<table class=\"table table-striped\">");
        out.println("<thead>\n" +
                "            <tr>\n" +
                "                <th>#</th>\n" +
                "                <th>会员卡号</th>\n" +
                "                <th>房间号</th>\n" +
                "                <th>价格</th>\n" +
                "                <th>入住时间</th>\n" +
                "                <th>出店时间</th>\n" +
                "                <th>支付类型</th>\n" +
                "            </tr>\n" +
                "        </thead>");
        out.println("<tbody>");
    }
}
