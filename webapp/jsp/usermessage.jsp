<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/20
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglist.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户资料</title>
    <%@ include file="head.jspf" %>
    <script type="text/javascript">
        function changeTextfield() {
            document.getElementById("sname").disabled=false;
            document.getElementById("sidnumber").disabled=false;
            document.getElementById("saccount").disabled=false;
            document.getElementById("spassword").disabled=false;
            document.getElementById("change").style="display: none";
            document.getElementById("cancelMember").style="display: none";
            document.getElementById("confirm").style="display: block";
            document.getElementById("cancel").style="display: block";
        }
        function cancel() {
            document.getElementById("sname").disabled=true;
            document.getElementById("sidnumber").disabled=true;
            document.getElementById("saccount").disabled=true;
            document.getElementById("spassword").disabled=true;
            document.getElementById("change").style="display: block";
            document.getElementById("cancelMember").style="display: block";
            document.getElementById("confirm").style="display: none";
            document.getElementById("cancel").style="display: none";
        }
    </script>
    <script src="<c:url value="/resources/js/echarts.min.js"/>"></script>
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
                        <li class="active"><a href="<c:url value="/jsp/usermessage.jsp"/>">个人资料</a></li>
                        <li><a href="<c:url value="/jsp/account.jsp"/>">账户信息</a></li>
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
        <div class= "bs-tabs" role="tabpanel" data-example-id="togglable-tabs">
            <ul id="myTab" class="nav nav-tabs" role="tablist">
                <li role="presentation"><a href="#memberMsg" id="memberMsg-tab" role="tab" data-toggle="tab"
                                                          aria-controls="memberMsg" aria-expanded="true">会员信息</a></li>
                <li role="presentation"><a href="#orderMsg" role="tab" id="orderMsg-tab" data-toggle="tab"
                                           aria-controls="orderMsg">预订信息</a></li>
                <li role="presentation"><a href="#statisticsMsg" role="tab" id="statisticsMsg-tab" data-toggle="tab"
                                           aria-controls="statisticsMsg">统计信息</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="memberMsg" aria-labelledby="memberMsg-tab">
                    <s:form action="modifyMember" theme="simple">
                    <div class="register-top-grid">
                        <h3>个人信息</h3>
                        <div class="wow fadeInLeft" data-wow-delay="0.4s">
                            <span>姓名<label>*</label></span>
                            <s:textfield id="sname" name="memberMessageVO.name" disabled="true" value="%{#session.usermsg.name}"/>
                        </div>
                        <div class="wow fadeInRight" data-wow-delay="0.4s">
                            <span>证件号码<label>*</label></span>
                            <s:textfield id="sidnumber" name="memberMessageVO.idNumber" disabled="true" value="%{#session.usermsg.idNumber}"/>
                        </div>
                        <div class="wow fadeInLeft" data-wow-delay="0.4s">
                            <span>银行帐号<label>*</label></span>
                            <s:textfield id="saccount" name="memberMessageVO.accountNumber" disabled="true"
                                         value="%{#session.usermsg.accountNumber}"/>
                        </div>
                        <div class="wow fadeInRight" data-wow-delay="0.4s">
                            <span>会员卡号<label>*</label></span>
                            <s:textfield value="%{#session.usermsg.id}" disabled="true"/>
                        </div>
                        <div class="wow fadeInLeft" data-wow-delay="0.4s">
                            <span>会员卡余额<label>*</label></span>
                            <s:textfield value="%{#session.usermsg.balance}" disabled="true"/>
                        </div>
                        <div class="wow fadeInRight" data-wow-delay="0.4s">
                            <span>会员状态<label>*</label></span>
                            <s:textfield value="%{#session.usermsg.memberState}" disabled="true"/>
                        </div>
                        <div class="wow fadeInLeft" data-wow-delay="0.4s">
                            <span>会员积分<label>*</label></span>
                            <s:textfield value="%{#session.usermsg.point}" disabled="true"/>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="register-bottom-grid">
                        <h3>登录信息</h3>
                        <div class="wow fadeInLeft" data-wow-delay="0.4s">
                            <span>用户名<label>*</label></span>
                            <s:textfield value="%{#session.usermsg.username}" disabled="true"/>
                        </div>
                        <div class="wow fadeInRight" data-wow-delay="0.4s">
                            <span>密码<label>*</label></span>
                            <s:password id="spassword" name="memberMessageVO.password" disabled="true" value="%{#session.usermsg.password}"/>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="register-but">
                        <s:submit value="确认修改" id="confirm" style="display: none"/>
                    </div>
                </s:form>
                    <div class="register-but">
                        <input href="#top" type="submit" value="修改" id="change" onclick="changeTextfield()">
                        <input href="#top" type="submit" value="取消" id="cancel" style="display: none" onclick="cancel()">
                    </div>
                    <s:form action="cancelMember" theme="simple">
                        <div class="register-but">
                            <s:submit id="cancelMember" value="取消会员资格"/>
                        </div>
                    </s:form>
                </div>
                <div role="tabpanel" class="tab-pane fade in active" id="orderMsg" aria-labelledby="orderMsg-tab">
                    <member:listOrders/>
                </div>
                <div role="tabpanel" class="tab-pane fade in active" id="statisticsMsg" aria-labelledby="statisticsMsg-tab">
                    <member:listStatistics/>
                    <div class="col-md-5">
                        <div id="ordergraph" style="width:500px;height:400px;"></div>
                    </div>
                    <script type="text/javascript">
                        var myChart = echarts.init(document.getElementById('ordergraph'));
                        var option = {
                            color: ['#6cbc35'],
                            title: {
                                text: '预订记录'
                            },
                            tooltip: {},
                            yAxis:{
                                min: 0,
                                interval: 1
                            },
                            xAxis: {
                                data: ['进行中','已完成','已取消']
                            },
                            series: [{
                                type: 'bar',
                                barWidth: '50%',
                                data: [${numberOfOrdered}, ${numberOfCompleted}, ${numberOfCanceled}]
                            }]
                        };
                        myChart.setOption(option);
                    </script>
                    <div class="col-md-5 col-md-offset-1">
                        <div id="inoutgraph" style="width:500px;height:400px;"></div>
                    </div>
                    <script type="text/javascript">
                        var myChart = echarts.init(document.getElementById('inoutgraph'));
                        var option = {
                            color: ['#6cbc35'],
                            title: {
                                text: '入住记录'
                            },
                            tooltip: {},
                            yAxis:{
                                min: 0,
                                interval: 1
                            },
                            xAxis: {
                                data: ['现金支付','会员卡支付']
                            },
                            series: [{
                                type: 'bar',
                                barWidth: '50%',
                                data: [${numberOfCash}, ${numberOfNotCash}]
                            }]
                        };
                        myChart.setOption(option);
                    </script>
                </div>
            </div>
            <script>
                $(function () {
                    $('#myTab a:first').tab('show')
                })
            </script>
        </div>
    </div>
</div>

</body>
</html>
