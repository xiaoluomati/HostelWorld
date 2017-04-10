<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/16
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglist.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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
                        <li><a href="<c:url value="/jsp/home.jsp"/>">客栈</a></li>
                        <li><a href="room.action">房间</a></li>
                        <li class="active"><a href="<c:url value="/jsp/register.jsp"/>">注册</a></li>
                        <li><a href="<c:url value="/jsp/login.jsp"/>">登录</a></li>
                    </ul>
                </div>
                <!--/.navbar-collapse-->
            </nav>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- banner -->
<div class="typo">
    <div class="container">
        <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
            <ul id="myTab" class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#member" id="member-tab" role="tab" data-toggle="tab"
                                                          aria-controls="member" aria-expanded="true">会员注册</a></li>
                <li role="presentation"><a href="#hotel" role="tab" id="hotel-tab" data-toggle="tab"
                                           aria-controls="hotel">开店注册</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="member" aria-labelledby="member-tab">
                    <s:form action="memberRegister" theme="simple">
                        <div class="register-top-grid">
                            <h3>个人信息</h3>
                            <div class="wow fadeInLeft" data-wow-delay="0.4s">
                                <span>姓名<label>*</label></span>
                                <s:textfield name="registerVO.name" required="true"/>
                            </div>
                            <div class="wow fadeInRight" data-wow-delay="0.4s">
                                <span>证件号码<label>*</label></span>
                                <s:textfield name="registerVO.idNumber" required="true"/>
                            </div>
                            <div class="wow fadeInLeft" data-wow-delay="0.4s">
                                <span>银行帐号<label>*</label></span>
                                <s:textfield name="registerVO.accountNumber" required="true"/>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="register-bottom-grid">
                            <h3>登录信息</h3>
                            <div class="wow fadeInLeft" data-wow-delay="0.4s">
                                <span>用户名<label>*</label></span>
                                <s:textfield name="registerVO.username" required="true"/>
                            </div>
                            <div class="wow fadeInRight" data-wow-delay="0.4s">
                                <span>密码<label>*</label></span>
                                <s:password name="registerVO.password" required="true"/>
                            </div>
                        </div>
                        <div class="register-but">
                            <s:submit value="注册"/>
                        </div>
                    </s:form>
                    <div class="clearfix"></div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="hotel" aria-labelledby="hotel-tab">
                    <s:form action="hotelRegister" theme="simple">
                        <div class="register-top-grid">
                            <h3>客栈信息</h3>
                            <div class="wow fadeInLeft" data-wow-delay="0.4s">
                                <span>客栈名称<label>*</label></span>
                                <s:textfield name="hotelMessageVO.hotelName" required="true"/>
                            </div>
                            <div class="wow fadeInRight" data-wow-delay="0.4s">
                                <span>邮件地址<label>*</label></span>
                                <s:textfield name="hotelMessageVO.email" required="true"/>
                            </div>
                            <div class="wow fadeInLeft" data-wow-delay="0.4s">
                                <span>联系电话<label>*</label></span>
                                <s:textfield name="hotelMessageVO.telephone" required="true"/>
                            </div>
                            <div class="wow fadeInRight" data-wow-delay="0.4s">
                                <span>地址<label>*</label></span>
                                <s:textfield name="hotelMessageVO.location" required="true"/>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="register-bottom-grid">
                            <h3>登录信息</h3>
                            <div class="wow fadeInLeft" data-wow-delay="0.4s">
                                <span>主管用户名<label>*</label></span>
                                <s:textfield name="hotelMessageVO.username" required="true"/>
                            </div>
                            <div class="wow fadeInRight" data-wow-delay="0.4s">
                                <span>密码<label>*</label></span>
                                <s:password name="hotelMessageVO.password" required="true"/>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="register-but">
                            <s:submit value="注册"/>
                        </div>
                    </s:form>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
