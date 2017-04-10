package com.edu.nju.tags;

import com.edu.nju.vo.HotelVO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhuding on 2017/3/13.
 */
public class ListHotelsHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {

        try {
            List<HotelVO> hotelVOS = (List<HotelVO>) getJspContext().findAttribute("hotels");
            JspWriter out = getJspContext().getOut();
            int i = 1;
            for (HotelVO hotelVO : hotelVOS) {
                boolean isStart = i % 3 == 1;
                if (isStart) out.println("<div class=\"offer-btm\">");
                out.println("<div class=\"col-md-4 offers-left\">");
                out.println("<h3>" + hotelVO.hotelName + "</h3>");
                out.println("<img src='/tss/resources/images/3.jpg' class=\"img-responsive\" alt=''>");
                out.println("<h4>" + "联系电话：" + hotelVO.telephone + "</h4>");
                out.println("<p>" + "地址：" + hotelVO.location + "</p>");
                out.println("<a class=\"hvr-shutter-in-horizontal\" href=\"/tss/room.action?hotelID=" + hotelVO.id + "\">查看房间</a>");
                out.println("</div>");
                boolean isEnd = i % 3 == 0;
                if (isEnd) out.println("</div><div class=\"clearfix\"></div>");
                i++;
            }
            if (i % 3 != 1) out.println("</div><div class=\"clearfix\"></div>");
        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }
    }
}
