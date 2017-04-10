package com.edu.nju.tags;

import com.edu.nju.vo.PlanVO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhuding on 2017/3/23.
 */
public class ListPlansHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        List<PlanVO> planVOS = (List<PlanVO>) getJspContext().findAttribute("plans");
        JspWriter out = getJspContext().getOut();
        outTableHead(out);
        int index = 0;
        for (PlanVO planVO : planVOS) {
            index++;
            out.println("<tr>\n" +
                    "            <td>" + index + "</td>\n" +
                    "            <td>" + planVO.roomRank + "</td>\n" +
                    "            <td>" + planVO.price + "</td>\n" +
                    "            <td>" + planVO.startTime + "</td>\n" +
                    "            <td>" + planVO.endTime + "</td>\n" +
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
                "                <th>房间等级</th>\n" +
                "                <th>价格</th>\n" +
                "                <th>起始时间</th>\n" +
                "                <th>结束时间</th>\n" +
                "            </tr>\n" +
                "        </thead>");
        out.println("<tbody>");
    }
}
