package com.edu.nju.tags;

import com.edu.nju.state.ReviewResult;
import com.edu.nju.vo.ReviewMessageVO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhuding on 2017/3/26.
 */
public class ListUnriewedMessageHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        List<ReviewMessageVO> unreviewedMessages = (List<ReviewMessageVO>) getJspContext().findAttribute("unreviewedMessages");
        JspWriter out = getJspContext().getOut();
        outTableHead(out);
        int index = 0;
        for (ReviewMessageVO unreviewedMessage : unreviewedMessages) {
            String reason = unreviewedMessage.hotelID == null ? "开店" : "修改信息";
            out.println("<tr>\n" +
                    "            <td>" + index + "</td>\n" +
                    "            <td>" + reason + "</td>\n" +
                    "            <td>" + (unreviewedMessage.hotelID == null ? "无" : unreviewedMessage.hotelID) + "</td>\n" +
                    "            <td>" + unreviewedMessage.hotelName + "</td>\n" +
                    "            <td>" + unreviewedMessage.email + "</td>\n" +
                    "            <td>" + unreviewedMessage.telephone + "</td>\n" +
                    "            <td>" + unreviewedMessage.location + "</td>\n" +
                    "            <td><a class=\"hvr-shutter-in-horizontal\" href=\"/tss/review.action?recordID=" + unreviewedMessage.recordID + "&reviewResult=" + ReviewResult.ACCEPTED.value() + "\">同意</a></td>\n" +
                    "            <td><a class=\"hvr-shutter-in-horizontal\" href=\"/tss/review.action?recordID=" + unreviewedMessage.recordID + "&reviewResult=" + ReviewResult.REJECTED.value() + "\">拒绝</a></td>\n" +
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
                "                <th>事由</th>\n" +
                "                <th>客栈编号</th>\n" +
                "                <th>客栈名称</th>\n" +
                "                <th>电子邮件</th>\n" +
                "                <th>联系电话</th>\n" +
                "                <th>地址</th>\n" +
                "                <th>#</th>\n" +
                "                <th>#</th>\n" +
                "            </tr>\n" +
                "        </thead>");
        out.println("<tbody>");
    }
}
