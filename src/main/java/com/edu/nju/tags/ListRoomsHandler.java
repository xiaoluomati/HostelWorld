package com.edu.nju.tags;

import com.edu.nju.vo.RoomVO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuding on 2017/3/16.
 */
public class ListRoomsHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        Map<String, List<RoomVO>> map = (Map<String, List<RoomVO>>) getJspContext().findAttribute("roomList");
        Map<String,List<String>> orderedRooms = (Map<String,List<String>>) getJspContext().findAttribute("orderedRooms");
        JspWriter out = getJspContext().getOut();
        boolean showBookLink = (getJspContext().findAttribute("username") == null) || ((int) getJspContext().findAttribute("useridentity") == 0);
        for (String s : map.keySet()) {
            List<RoomVO> roomVOS = map.get(s);
            if (roomVOS.size() == 0)
                continue;
            out.println("<div class=\"alert alert-info\" role=\"alert\">\n" +
                    "<strong>" + roomVOS.get(0).hotelName + "</strong>\n" +
                    "</div>");
            outTableHead(out, showBookLink);
            int i = 0;
            for (RoomVO roomVO : roomVOS) {
                i++;
                out.println("<tr>\n" +
                        "            <td>" + i + "</td>\n" +
                        "            <td>" + roomVO.roomRank + "</td>\n" +
                        "            <td>" + roomVO.roomNumber + "</td>\n" +
                        "            <td>" + roomVO.price + "</td>\n" +
                        (showBookLink&&!orderedRooms.get(roomVO.hotelID).contains(roomVO.roomNumber) ?
                                "            <td><a class=\"hvr-shutter-in-horizontal\" href=\"/tss/book.action?roomID=" + roomVO.roomID + "&hotelID=" + roomVO.hotelID + "&price=" + roomVO.price + "\">预订</a></td>\n" : "") +
                        "        </tr>");
            }
            out.println("</tbody>\n" +
                    "    </table>");
        }

    }

    private void outTableHead(JspWriter out, boolean showBookLink) throws IOException {
        out.println("<table class=\"table table-striped\">");
        out.println("<thead>\n" +
                "            <tr>\n" +
                "                <th>#</th>\n" +
                "                <th>房间等级</th>\n" +
                "                <th>房间号</th>\n" +
                "                <th>价格</th>\n" +
                (showBookLink ?
                        "                <th>#</th>\n" : "") +
                "            </tr>\n" +
                "        </thead>");
        out.println("<tbody>");
    }
}
