<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="../common/tag.jsp" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>付款成功页面</title>
    <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath }/resources/assets/css/amazeui.css"/>
    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />

    <link href="${pageContext.request.contextPath }/resources/css/sustyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/basic/js/jquery-1.7.min.js"></script>

</head>

<body>
<%@include file="../common/header.jsp" %>
<%@include file="../common/navtable.jsp" %>

<div class="clear"></div>


<div class="take-delivery">
    <div class="status">
        <h2>您已成功付款</h2>
        <div class="successInfo">
            <ul>
                <%--<li>付款金额<em>¥9.90</em></li>--%>
                <div class="user-info">
                    <p>收货人：${sessionScope.obj.userName }</p>
                    <p>联系电话：${sessionScope.obj.userPhone }</p>
                    <p>收货地址：${sessionScope.obj.userAddress }</p>
                </div>
                请认真核对您的收货信息，如有错误请联系客服

            </ul>
            <div class="option">
                <span class="info">您可以</span>
                <a href="${pageContext.request.contextPath }/userindex" class="J_MakePoint">查看<span>已买到的宝贝</span></a>
                <a href="${pageContext.request.contextPath }/userindex" class="J_MakePoint">查看<span>交易详情</span></a>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/navcir.jsp" %>

<%@include file="../common/footer.jsp" %>

</body>
</html>

