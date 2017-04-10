<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/16
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglist.jspf"%>
<html>
<head>
    <title>登录</title>
    <%@ include file="head.jspf"%>
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
                        <li><a href="<c:url value="/jsp/register.jsp"/>">注册</a></li>
                        <li class="active"><a href="<c:url value="/jsp/login.jsp"/>">登录</a></li>
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
                <h3>新用户？</h3>
                <p>创建账号，即可享受更多服务……</p>
                <a class="acount-btn" href="<c:url value="/jsp/register.jsp"/>">创建账号</a>
            </div>
            <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
                <h3>已注册用户？</h3>
                <p>如果您已有帐号，点击登录</p>
                <s:form action="login" theme="simple">
                    <div>
                        <span>用户名<label>*</label></span>
                        <s:textfield name="username" required="true"/>
                    </div>
                    <div>
                        <span>密码<label>*</label></span>
                        <s:password name="password" required="true"/>
                    </div>
                    <s:submit value="登录"/>
                </s:form>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
</body>
</html>
