<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" %>
<%--<%@ attribute name="username" required="true" %>--%>
<c:choose>
    <c:when test="${sessionScope.username==null}">
        <li><a href="<c:url value="/jsp/register.jsp"/>">注册</a></li>
        <li><a href="<c:url value="/jsp/login.jsp"/>">登录</a></li>
    </c:when>
    <c:when test="${sessionScope.useridentity==1}">
        <c:if test="${sessionScope.hotelmsg!=null}">
            <li><a href="<c:url value="/jsp/hotelmessage.jsp"/>">客栈资料</a></li>
            <li><a href="checkInit.action">入/离店登记</a></li>
        </c:if>
        <li><a href="<c:url value="logout.action"/>">登出</a></li>
    </c:when>
    <c:when test="${sessionScope.useridentity==2}">
        <li><a href="<c:url value="/jsp/reviewMessage.jsp"/>">审批/结算</a></li>
        <li><a href="statisticInit.action">统计信息</a></li>
        <li><a href="<c:url value="logout.action"/>">登出</a></li>
    </c:when>
    <c:otherwise>
        <li><a href="<c:url value="/jsp/usermessage.jsp"/>">个人资料</a></li>
        <li><a href="<c:url value="/jsp/account.jsp"/>">账户信息</a></li>
        <li><a href="<c:url value="logout.action"/>">登出</a></li>
    </c:otherwise>
</c:choose>
