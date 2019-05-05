<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>
    <%@include file="../common/head.jsp" %>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/amazeui.css" />--%>
    <link href="${pageContext.request.contextPath }/resources/css/dlstyle.css" rel="stylesheet" type="text/css">
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.css" />
    <link href="../css/dlstyle.css" rel="stylesheet" type="text/css">--%>
</head>

<body>

<div class="login-boxtitle">
    <a href="${pageContext.request.contextPath }/home"><img alt="logo" src="${pageContext.request.contextPath }/resources/images/logobig.png" /></a>
</div>

<div class="login-banner">
    <div class="login-main">
        <div class="login-banner-bg"><span></span><img src="${pageContext.request.contextPath }/resources/images/big.jpg" /></div>
        <div class="login-box">

            <h3 class="title">登录商城</h3>

            <div class="clear"></div>

            <div class="login-form" ac>
                <form>
                    <div class="user-name">
                        <label for="user"><i class="am-icon-user"></i></label>
                        <input type="text" name="PhoneNumber" id="user" placeholder="请输入手机号">
                    </div>
                    <div class="user-pass">
                        <label for="password"><i class="am-icon-lock"></i></label>
                        <input type="password" name="Password" id="password" placeholder="请输入密码">
                    </div>
                </form>
            </div>

            <div class="login-links">
                <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
                <a href="#" class="am-fr">忘记密码</a>
                <a href="${pageContext.request.contextPath }/register" class="zcnext am-fr am-btn-default">注册</a>
                <br />
            </div>
            <div class="am-cf">
                <input type="submit" id="signininp" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
            </div>
            <div class="partner">
                <%--<h3>合作账号</h3>--%>
                <%--<div class="am-btn-group">--%>
                    <%--<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>--%>
                    <%--<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>--%>
                    <%--<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>--%>
                <%--</div>--%>
            </div>

        </div>
    </div>
</div>


<%@include file="../common/footer.jsp" %>
<script src="${pageContext.request.contextPath }/resources/assets/js/amazeui.js"></script>
<script src="${pageContext.request.contextPath }/resources/assets/js/app.js"></script>
<script type="text/javascript">
    <!--点击登录按钮后执行登录操作-->
    $("#signininp").click(function () {
        var userPhone = $('input[name="PhoneNumber"]').val();
        var userPassword = $('input[name="Password"]').val();
        if(null == userPhone || "" == userPhone){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请输入您的手机号！");
            $('input[name="Password"]').val("");
            return false;
        }
        if(null == userPassword || "" == userPassword){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请输入您的密码！");
            return false;
        }
        var testPhone = /^[1][3,4,5,7,8][0-9]{9}$/;
        if(!(/^1[3|4|5|6|7|8][0-9]\d{4,8}$/.test(userPhone))){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("请您输入正确的手机号!");
            $('input[name="Password"]').val("");
            return false;
        }
        if(userPassword.length > 16){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("请您输入小于16位的密码!");
            $('input[name="Password"]').val("");
            return false;
        }
        $.ajax({
            url:"${pageContext.request.contextPath }/dologin",
            type:'post',
            dataType:'json',
            data:{
                "userPhone":userPhone,
                "userPassword":userPassword
            },
            success:function(data){
                console.log(data);
                if(data.success){
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr["success"]("登录成功");
                    window.location.href = "${pageContext.request.contextPath }/home";
                }else{
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr["error"](data.msg ? data.msg : "登录失败");
                    $('input[name="Password"]').val("");
                }
            }
            ,error:function(e){
                toastr["error"]("连接服务器超时，请稍后重试");
                $('input[name="Password"]').val("");
            }
        });
    });

    //回车键登录
    $('input[name="Password"]').keydown(function (e) {
        if(e.keyCode == 13){
        var userPhone = $('input[name="PhoneNumber"]').val();
        var userPassword = $('input[name="Password"]').val();
        if(null == userPhone || "" == userPhone){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请输入您的手机号！");
            $('input[name="Password"]').val("");
            return false;
        }
        if(null == userPassword || "" == userPassword){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请输入您的密码！");
            return false;
        }
        var testPhone = /^[1][3,4,5,7,8][0-9]{9}$/;
        if(!(/^1[3|4|5|6|7|8][0-9]\d{4,8}$/.test(userPhone))){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("请您输入正确的手机号!");
            $('input[name="Password"]').val("");
            return false;
        }
        if(userPassword.length > 16){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("请您输入小于16位的密码!");
            $('input[name="Password"]').val("");
            return false;
        }
        $.ajax({
            url:"${pageContext.request.contextPath }/dologin",
            type:'post',
            dataType:'json',
            data:{
                "userPhone":userPhone,
                "userPassword":userPassword
            },
            success:function(data){
                console.log(data);
                if(data.success){
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr["success"]("登录成功");
                    window.location.href = "${pageContext.request.contextPath }/home";
                }else{
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr["error"](data.msg ? data.msg : "登录失败");
                    $('input[name="Password"]').val("");
                }
            }
            ,error:function(e){
                toastr["error"]("连接服务器超时，请稍后重试");
                $('input[name="Password"]').val("");
            }
        });
        }
    });


</script>
</body>

</html>
