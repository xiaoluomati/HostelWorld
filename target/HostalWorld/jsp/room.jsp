<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/15
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglist.jspf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房间</title>
    <%@include file="head.jspf"%>
</head>
<body>
<!-- banner -->
<div class="banner1">
    <div class="header">
        <div class="container">
            <div class="logo">
                <h1><a href="<c:url value="/jsp/home.jsp"/>">Hostel</a></h1>
            </div>
            <nav class="navbar navbar-default" role="navigation">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value="/jsp/home.jsp"/>">客栈</a></li>
                        <c:choose>
                            <c:when test="${sessionScope.username!=null&&sessionScope.useridentity==1&&sessionScope.hotelmsg!=null}">
                                <li class="active"><a href="room.action?hotelID=${sessionScope.hotelID}">房间</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="active"><a href="room.action">房间</a></li>
                            </c:otherwise>
                        </c:choose>
                        <cts:loginstate/>
                    </ul>
                </div>
            </nav>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- banner -->
<div class="offers">
    <div class="container">
        <hotel:listRooms/>
        <c:if test="${sessionScope.username!=null&&sessionScope.useridentity==1&&sessionScope.hotelmsg!=null}">
            <s:form action="addRoom" theme="simple">
                <div class="register-top-grid">
                    <h3>创建房间</h3>
                    <div class="wow fadeInLeft " data-wow-delay="0.4s">
                        <span>客栈编号<label>*</label></span>
                        <s:textfield required="true" disabled="true" value="%{#session.hotelID}"/>
                    </div>

                    <div class="wow fadeInRight col-md-6" data-wow-delay="0.4s">
                        <span>房间号<label>*</label></span>
                        <s:textfield name="roomVO.roomNumber" required="true"/>
                    </div>
                    <div class="wow fadeInLeft" data-wow-delay="0.4s">
                        <span>房间等级<label>*</label></span>
                        <s:select class="form-control" list="{'单人间','双人间','总统套房'}" name="roomVO.roomRank" required="true"/>
                    </div>
                    <div class="wow fadeInRight col-md-6" data-wow-delay="0.4s">
                        <span>价格<label>*</label></span>
                        <s:textfield name="roomVO.price" required="true"/>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="register-but">
                    <s:submit value="创建"/>
                </div>
            </s:form>
        </c:if>
    </div>
</div>
</body>
</html>
