<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/22
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglist.jspf" %>
<html>
<head>
    <title>入/离店登记</title>
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
                        <li><a href="<c:url value="/jsp/hotelmessage.jsp"/>">客栈资料</a></li>
                        <li class="active"><a href="checkInit.action">入/离店登记</a></li>
                        <li><a href="<c:url value="logout.action"/>">登出</a></li>
                    </ul>
                </div>
            </nav>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- banner -->
<div class="login-page">
    <div class="container">
        <div class="account_grid">
            <div class="col-md-5 login-left wow fadeInLeft" data-wow-delay="0.4s">
                <s:form action="checkin" theme="simple">
                    <h3>登记入住</h3>
                    <div>
                        <label for="existOrder"><span>已有订单？</span></label>
                        <input type="checkbox" id="existOrder" data-group-cls="btn-group-justified" />
                        <label for="existMember"><span>是会员吗？</span></label>
                        <input type="checkbox" id="existMember" data-group-cls="btn-group-justified"/>
                    </div>
                    <div>
                        <label for="orderID"><span>订单号*</span></label>
                        <s:select id="orderID" name="checkinVO.orderID" class="form-control" list="%{#session.orderIDsCheckin}" required="true" disabled="false"/>
                    </div>
                    <div>
                        <label for="memberID"><span>会员卡号</span></label>
                        <s:textfield id="memberID" name="checkinVO.memberID" class="form-control" required="true" disabled="true"/>
                    </div>
                    <div>
                        <label for="roomID"><span>房间号</span></label>
                        <s:select id="roomID" name="roomNumber" class="form-control" list="%{#session.roomIDsCheckin}" required="true" disabled="true"/>
                    </div>
                    <div>
                        <label for="name"><span>姓名</span></label>
                        <s:textfield id="name" name="checkinVO.name" class="form-control" required="true" disabled="true"/>
                    </div>
                    <div>
                        <label for="idNumber"><span>证件号码</span></label>
                        <s:textfield id="idNumber" name="checkinVO.idNumber" class="form-control" required="true" disabled="true"/>
                    </div>
                    <s:submit value="入住"/>
                </s:form>
            </div>
            <div class="col-md-6 col-md-offset-1 login-right wow fadeInRight" data-wow-delay="0.4s">
                <s:form action="checkout" theme="simple">
                    <h3>登记离店</h3>
                    <div>
                        <label for="roomIDout"><span>房间号</span></label>
                        <s:select id="roomIDout" name="roomNumber" class="form-control" list="%{#session.roomNumbersCheckout}" required="true"/>
                    </div>
                    <div>
                        <label for="isMember"><span>是会员吗？</span></label>
                        <input type="checkbox" id="isMember" data-group-cls="btn-group-justified"/>
                        <label for="isCash"><span>现金付款？</span></label>
                        <input type="checkbox" id="isCash" data-group-cls="btn-group-justified" disabled="disabled"/>
                        <s:hidden id="cash" name="checkoutVO.cash"/>
                    </div>
                    <s:submit value="确认"/>
                </s:form>
            </div>
            <div class="clearfix"></div>
        </div>

    </div>
    <script type="text/javascript">
        $(':checkbox').checkboxpicker();
        $('#existMember').prop('checked', true);
        $('#existOrder').prop('checked', true);
        $('#existMember').prop('disabled', true);
        $('#existOrder').on('change', function() {
            if($('#existOrder').prop('checked')){
                $('#existMember').prop('checked', true);
                $('#existMember').prop('disabled', true);
                document.getElementById("orderID").disabled = false;
                document.getElementById("roomID").disabled = true;
                document.getElementById("memberID").disabled = true;
                document.getElementById("name").disabled = true;
                document.getElementById("idNumber").disabled = true;
            }else{
                $('#existMember').prop('disabled', false);
                document.getElementById("orderID").disabled = true;
                document.getElementById("roomID").disabled = false;
                document.getElementById("memberID").disabled = !$('#existMember').prop('checked');
                document.getElementById("name").disabled = true;
                document.getElementById("idNumber").disabled = true;
            }
        });
        $('#existMember').on('change', function() {
            document.getElementById("memberID").disabled = !$('#existMember').prop('checked');
            document.getElementById("name").disabled = $('#existMember').prop('checked');
            document.getElementById("idNumber").disabled = $('#existMember').prop('checked');
        });
        $('#isCash').on('change', function() {
            document.getElementById("cash").value = $('#isCash').prop('checked');
        });
        $('#isMember').on('change', function() {
            if(!$('#isMember').prop('checked')){
                $('#isCash').prop('checked', true);
            }
            $('#isCash').prop('disabled', !$('#isMember').prop('checked'));
        });
    </script>
</div>
</body>
</html>
