<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/26
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglist.jspf" %>
<html>
<head>
    <title>统计信息</title>
    <%@ include file="head.jspf" %>
    <script type="text/javascript" src="<c:url value="/resources/js/echarts.min.js"/>"></script>
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
                        <li><a href="<c:url value="/jsp/reviewMessage.jsp"/>">审批/结算</a></li>
                        <li class="active"><a href="statisticInit.action">统计信息</a></li>
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
                <li role="presentation"><a href="#inoutMsg" id="inoutMsg-tab" role="tab" data-toggle="tab"
                                           aria-controls="inoutMsg" aria-expanded="true">各店入住情况</a></li>
                <li role="presentation"><a href="#memberMsg" role="tab" id="memberMsg-tab" data-toggle="tab"
                                           aria-controls="memberMsg">会员统计数据</a></li>
                <li role="presentation"><a href="#statisticsMsg" role="tab" id="statisticsMsg-tab" data-toggle="tab"
                                           aria-controls="statisticsMsg">财务统计数据</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="inoutMsg" aria-labelledby="inoutMsg-tab">
                    <div class="col-md-5">
                        <div id="inoutgraph" style="width:720px;height:540px;"></div>
                    </div>
                    <script type="text/javascript">
                        var myChart = echarts.init(document.getElementById('inoutgraph'));
                        var option = {
                            color: ['#6cbc35'],
                            title: {
                                text: '各店入住情况'
                            },
                            tooltip: {},
                            yAxis: {
                                name: "人次",
                                min: 0,
                                interval: 1
                            },
                            xAxis: {
                                data: ${hotelNames}
                            },
                            series: [{
                                type: 'bar',
                                barWidth: '50%',
                                data: ${checkinNumbers}
                            }]
                        };
                        myChart.setOption(option);
                    </script>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="memberMsg" aria-labelledby="memberMsg-tab">
                    <div class="col-md-5">
                        <div id="membergraph" style="width:720px;height:540px;"></div>
                    </div>
                    <script type="text/javascript">
                        var myChart = echarts.init(document.getElementById('membergraph'));
                        var colors = ['#5793f3', '#d14a61'];

                        var option = {
                            color: colors,
                            title: {
                                text: '会员统计情况'
                            },
                            tooltip: {
                                trigger: 'axis',
                                axisPointer: {
                                    type: 'cross'
                                }
                            },
                            grid: {
                                right: '20%'
                            },
                            legend: {
                                data: ['预订数', '消费额']
                            },
                            xAxis: [
                                {
                                    type: 'category',
                                    axisTick: {
                                        alignWithLabel: true
                                    },
                                    data: ${memberNames}
                                }
                            ],
                            yAxis: [
                                {
                                    type: 'value',
                                    name: '消费额',
                                    min: 0,
                                    axisLine: {
                                        lineStyle: {
                                            color: colors[0]
                                        }
                                    },
                                    axisLabel: {
                                        formatter: '{value} 元'
                                    },
                                    splitLine: {
                                        show: false
                                    }
                                },
                                {
                                    type: 'value',
                                    name: '预订数',
                                    min: 0,
                                    interval: 1,
                                    axisLine: {
                                        lineStyle: {
                                            color: colors[1]
                                        }
                                    },
                                    axisLabel: {
                                        formatter: '{value} 人'
                                    },
                                    splitLine: {
                                        show: false
                                    }
                                }

                            ],
                            series: [
                                {
                                    name: '消费额',
                                    type: 'bar',
                                    yAxisIndex: 0,
                                    data:${costs}
                                },
                                {
                                    name: '预订数',
                                    type: 'bar',
                                    yAxisIndex: 1,
                                    data:${numberOfOrder}
                                }
                            ]
                        };
                        myChart.setOption(option);
                    </script>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="statisticsMsg" aria-labelledby="statisticsMsg-tab">
                    <div class="col-md-5">
                        <div id="statisticsgraph" style="width:720px;height:540px;"></div>
                    </div>
                    <script type="text/javascript">
                        var myChart = echarts.init(document.getElementById('statisticsgraph'));
                        var option = {
                            color: ['#6cbc35'],
                            title: {
                                text: '各店收入情况'
                            },
                            tooltip: {},
                            yAxis: {
                                name: "收入",
                                min: 0,
                            },
                            xAxis: {
                                data: ${hotelNames}
                            },
                            series: [{
                                type: 'bar',
                                barWidth: '50%',
                                data: ${hotelIncomes}
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
