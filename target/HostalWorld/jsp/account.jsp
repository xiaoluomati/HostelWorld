<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/21
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglist.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账户信息</title>
    <%@ include file="head.jspf" %>
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
                        <li><a href="room.action">房间</a></li>
                        <li><a href="<c:url value="/jsp/usermessage.jsp"/>">个人资料</a></li>
                        <li class="active"><a href="<c:url value="/jsp/account.jsp"/>">账户信息</a></li>
                        <li><a href="<c:url value="logout.action"/>">登出</a></li>
                    </ul>
                </div>
                <!--/.navbar-collapse-->
            </nav>
            <div class="clearfix"></div>

        </div>
    </div>
</div>
<!-- banner -->
<div class="login-page">
    <div class="container">
        <div class="account_grid">
            <div class="col-md-6 login-left wow fadeInLeft" data-wow-delay="0.4s">
                <h3>积分兑换</h3>
                <s:form action="point" theme="simple">
                    <div>
                        <span>已有积分额<label>*</label></span>
                        <s:textfield value="%{#session.usermsg.point}" disabled="true"/>
                    </div>
                    <div>
                        <span>兑换积分额<label>*</label></span>
                        <s:textfield name="pointToExchange" required="true"/>
                    </div>
                    <s:submit value="兑换"/>
                </s:form>
            </div>
            <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
                <h3>充值</h3>
                <s:form action="recharge" theme="simple">
                    <div>
                        <span>会员卡余额<label>*</label></span>
                        <s:textfield value="%{#session.usermsg.balance}" disabled="true"/>
                    </div>
                    <div>
                        <span>充值额度<label>*</label></span>
                        <s:textfield name="quantity" required="true"/>
                    </div>
                    <s:submit value="充值"/>
                </s:form>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
</body>
</html>
