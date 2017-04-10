package com.edu.nju.tags;

import com.edu.nju.state.OrderState;
import com.edu.nju.vo.OrderVO;
import com.edu.nju.vo.StatisticsDataVO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhuding on 2017/3/22.
 */
public class ListMemberOrdersHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        StatisticsDataVO statisticsDataVO = (StatisticsDataVO) getJspContext().findAttribute("memberStatistics");
        List<OrderVO> orderVOS = statisticsDataVO.orders;
        JspWriter out = getJspContext().getOut();
        outTableHead(out);
        int i = 0;
        for (OrderVO orderVO : orderVOS) {
            i++;
            out.println("<tr>\n" +
                    "            <td>" + i + "</td>\n" +
                    "            <td>" + orderVO.hotelName + "</td>\n" +
                    "            <td>" + orderVO.roomRank + "</td>\n" +
                    "            <td>" + orderVO.roomNumber + "</td>\n" +
                    "            <td>" + orderVO.price + "</td>\n" +
                    "            <td>" + orderVO.orderTime + "</td>\n" +
                    "            <td>" + orderVO.orderState + "</td>\n" +
                    (orderVO.orderState == OrderState.ORDERED ?
                            "            <td><a class=\"hvr-shutter-in-horizontal\" href=\"/tss/cancelBook.action?orderID=" + orderVO.id + "\">取消</a></td>\n" : "<td></td>") +
                    "        </tr>");
        }
        out.println("</tbody>\n" +
                "    </table>");
    }

    private void outTableHead(JspWriter out) throws IOException {
        out.println("<table class=\"table table-striped\">");
        out.println("<thead>\n" +
                "            <tr>\n" +
                "                <th>#</th>\n" +
                "                <th>客栈名</th>\n" +
                "                <th>房间等级</th>\n" +
                "                <th>房间号</th>\n" +
                "                <th>价格</th>\n" +
                "                <th>预订时间</th>\n" +
                "                <th>订单状态</th>\n" +
                "                <th>#</th>\n" +
                "            </tr>\n" +
                "        </thead>");
        out.println("<tbody>");
    }
}
