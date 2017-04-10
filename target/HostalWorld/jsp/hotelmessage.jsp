<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/22
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglist.jspf" %>
<html>
<head>
    <title>客栈资料</title>
    <%@ include file="head.jspf" %>
    <script src="<c:url value="/resources/js/echarts.min.js"/>"></script>
    <script type="text/javascript">
        function changeTextfield() {
            document.getElementById("shotelname").disabled = false;
            document.getElementById("slocation").disabled = false;
            document.getElementById("stelephone").disabled = false;
            document.getElementById("semail").disabled = false;
            document.getElementById("spassword").disabled = false;
            document.getElementById("change").style = "display: none";
            document.getElementById("confirm").style = "display: block";
            document.getElementById("cancel").style = "display: block";
        }
        function cancel() {
            document.getElementById("shotelname").disabled = true;
            document.getElementById("slocation").disabled = true;
            document.getElementById("stelephone").disabled = true;
            document.getElementById("semail").disabled = true;
            document.getElementById("spassword").disabled = true;
            document.getElementById("change").style = "display: block";
            document.getElementById("confirm").style = "display: none";
            document.getElementById("cancel").style = "display: none";
        }
    </script>
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
                        <li class="active"><a href="<c:url value="/jsp/hotelmessage.jsp"/>">客栈资料</a></li>
                        <li><a href="checkInit.action">入/离店登记</a></li>
                        <li><a href="<c:url value="logout.action"/>">登出</a></li>
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
        <div class="bs-tabs" role="tabpanel" data-example-id="togglable-tabs">
            <ul id="myTab" class="nav nav-tabs" role="tablist">
                <li role="presentation"><a href="#hotelMsg" id="hotelMsg-tab" role="tab" data-toggle="tab"
                                           aria-controls="hotelMsg" aria-expanded="true">客栈信息</a></li>
                <li role="presentation"><a href="#planMsg" role="tab" id="planMsg-tab" data-toggle="tab"
                                           aria-controls="planMsg">计划信息</a></li>
                <li role="presentation"><a href="#statisticsMsg" role="tab" id="statisticsMsg-tab" data-toggle="tab"
                                           aria-controls="statisticsMsg">统计信息</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="hotelMsg" aria-labelledby="hotelMsg-tab">
                    <s:form action="modifyHotel" theme="simple">
                        <div class="register-top-grid">
                            <h3>客栈信息</h3>
                            <div class="wow fadeInLeft" data-wow-delay="0.4s">
                                <span>客栈号<label>*</label></span>
                                <s:textfield id="sid" disabled="true" value="%{#session.hotelmsg.id}"/>
                            </div>
                            <div class="wow fadeInRight" data-wow-delay="0.4s">
                                <span>在线收入<label>*</label></span>
                                <s:textfield disabled="true" value="%{#session.hotelmsg.balance}"/>
                            </div>
                            <div class="wow fadeInLeft" data-wow-delay="0.4s">
                                <span>名称<label>*</label></span>
                                <s:textfield id="shotelname" name="hotelMessageVO.hotelName" disabled="true"
                                             value="%{#session.hotelmsg.hotelName}"/>
                            </div>
                            <div class="wow fadeInRight" data-wow-delay="0.4s">
                                <span>地址<label>*</label></span>
                                <s:textfield id="slocation" name="hotelMessageVO.location" disabled="true"
                                             value="%{#session.hotelmsg.location}"/>
                            </div>
                            <div class="wow fadeInRight" data-wow-delay="0.4s">
                                <span>联系电话<label>*</label></span>
                                <s:textfield id="stelephone" name="hotelMessageVO.telephone" disabled="true"
                                             value="%{#session.hotelmsg.telephone}"/>
                            </div>
                            <div class="wow fadeInLeft" data-wow-delay="0.4s">
                                <span>电子邮件<label>*</label></span>
                                <s:textfield id="semail" name="hotelMessageVO.email" disabled="true"
                                             value="%{#session.hotelmsg.email}"/>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="register-bottom-grid">
                            <h3>登录信息</h3>
                            <div class="wow fadeInLeft" data-wow-delay="0.4s">
                                <span>用户名<label>*</label></span>
                                <s:textfield value="%{#session.username}" disabled="true"/>
                            </div>
                            <div class="wow fadeInRight" data-wow-delay="0.4s">
                                <span>密码<label>*</label></span>
                                <s:password id="spassword" name="hotelMessageVO.password" disabled="true"
                                            value="%{#session.password}"/>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="register-but">
                            <s:submit value="确认修改" id="confirm" style="display: none"/>
                        </div>
                    </s:form>
                    <div class="register-but">
                        <input href="#top" type="submit" value="修改" id="change" onclick="changeTextfield()">
                        <input href="#top" type="submit" value="取消" id="cancel" style="display: none"
                               onclick="cancel()">
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade in active" id="planMsg" aria-labelledby="planMsg-tab">
                    <h3>计划列表</h3>
                    <hotel:listPlans/>
                    <s:form action="releasePlan" theme="simple">
                        <div class="booking-form">
                            <h3>发布计划</h3>
                            <div class="col-md-6">
                                <span>房间等级<label>*</label></span>
                                <s:select class="form-control" list="{'单人间','双人间','总统套房'}" name="planVO.roomRank"
                                          size="" required="true"/><br/>
                                <span>起始时间<label>*</label></span>
                                <div class="form-group">
                                    <div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy"
                                         data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
                                        <input class="form-control" size="16" type="text" value="" readonly>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-calendar"></span></span>
                                    </div>
                                    <s:hidden name="planVO.startTime" id="dtp_input1" value=""/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <span>房间价格<label>*</label></span>
                                <s:textfield name="planVO.price" required="true"/><br/>
                                <span>结束时间<label>*</label></span>
                                <div class="form-group">
                                    <div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy"
                                         data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                        <input class="form-control" size="16" type="text" value="" readonly>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-calendar"></span></span>
                                    </div>
                                    <s:hidden name="planVO.endTime" id="dtp_input2" value=""/>
                                </div>
                            </div>
                        </div>
                        <div class="register-but col-md-5">
                            <s:submit value="确认"/>
                        </div>
                    </s:form>

                    <script type="text/javascript">
                        $('.form_date').datetimepicker({
                            language: 'zh-CN',
                            weekStart: 1,
                            todayBtn: 1,
                            autoclose: 1,
                            todayHighlight: 1,
                            startView: 2,
                            minView: 2,
                            forceParse: 0,
                            pickerPosition: 'top-right'
                        });
                    </script>
                </div>
                <div role="tabpanel" class="tab-pane fade in active" id="statisticsMsg" aria-labelledby="statisticsMsg-tab">
                    <hotel:listStatistics/>
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
