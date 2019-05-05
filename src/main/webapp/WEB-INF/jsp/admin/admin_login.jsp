<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>管理员登录</title>
    <%@include file="admin_head.jsp" %>
</head>

<body data-type="login">
<script src="${pageContext.request.contextPath }/resources/background/js/theme.js"></script>
<div class="am-g tpl-g">
    <div class="tpl-login">
        <div class="tpl-login-content">
            <div>
                <img src="${pageContext.request.contextPath }/resources/background/img/index-logo1-3.jpg" style="width:30px; height: 30px; float: left; margin-top:14px; margin-left: 15px; margin-right: 10px;">
                <p style="font-size:24px; color: #cfcfcf; line-height: 2.4em;">farmshop后台管理</p>
            </div>
            <c:if test="${requestScope.adminLoginError == 1 }">
                <span style="color:#f44336;">用户手机号或密码输入有误!请检查后重新输入</span>
            </c:if>
            <form autocomplete="off" class="am-form tpl-form-line-form" action="index-login-execute" method="post">
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" id="user-phone" placeholder="请输入管理员手机号" name="phone">
                </div>
                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="user-password" placeholder="请输入密码" name="password">
                </div>
                <br>
                <div class="am-form-group">
                    <button type="submit" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath }/resources/background/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/background/js/app.js"></script>
</body>

</html>
