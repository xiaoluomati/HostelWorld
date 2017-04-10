<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/26
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglist.jspf" %>
<html>
<head>
    <title>审批/结算</title>
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
                        <li class="active"><a href="<c:url value="/jsp/reviewMessage.jsp"/>">审批/结算</a></li>
                        <li><a href="statisticInit.action">统计信息</a></li>
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
<div class="offers">
    <div class="container">
        <div class="bs-tabs" role="tabpanel" data-example-id="togglable-tabs">
            <ul id="myTab" class="nav nav-tabs" role="tablist">
                <li role="presentation"><a href="#reviewMsg" id="reviewMsg-tab" role="tab" data-toggle="tab"
                                           aria-controls="reviewMsg" aria-expanded="true">审批</a></li>
                <li role="presentation"><a href="#settleMsg" role="tab" id="settleMsg-tab" data-toggle="tab"
                                           aria-controls="settleMsg">结算</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div role="tabpanel" class="tab-pane fade" id="reviewMsg" aria-labelledby="hotelMsg-tab">
                    <director:listMessages/>
                </div>
                <div role="tabpanel" class="tab-pane fade col-md-5" id="settleMsg" aria-labelledby="hotelMsg-tab">
                    <s:form action="settle" theme="simple">
                        <div>
                            <label for="hotelID"><span>客栈编号</span></label>
                            <s:select id="hotelID" name="hotelID" class="form-control" list="%{#session.hotelIDs}" required="true"/>
                        </div>
                        <div class="register-but">
                            <s:submit value="结      算"/>
                        </div>
                    </s:form>
                    <div class="register-but">
                        <input href="/tss/settle.action?hotelID=all" type="submit" value="结算所有">
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(function () {
                $('#myTab a:first').tab('show')
            })
        </script>
    </div>
</div>
</body>
</html>
