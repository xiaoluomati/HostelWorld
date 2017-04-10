<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/10
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglist.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客栈</title>
    <%@include file="head.jspf" %>
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
                        <li class="active"><a href="<c:url value="/jsp/home.jsp"/>">客栈</a></li>
                        <li><a href="room.action">房间</a></li>
                        <cts:loginstate/>
                    </ul>
                </div>
                <!--/.navbar-collapse-->
            </nav>
            <div class="clearfix"></div>

        </div>
    </div>
</div>
<!-- banner -->
<!-- offers -->
<div class="offers">
    <div class="container">
        <c:if test="${sessionScope.username!=null&&sessionScope.hotelmsg==null&&sessionScope.useridentity==1}">
            <div class="alert alert-danger" role="alert">
                <strong>您的客栈正在审核中...</strong>
            </div>
        </c:if>
        <div class="well">
            欢迎来到Hostel
        </div>
        <hotel:listHotels/>
    </div>
</div>
<!-- offers -->
</body>
</html>
