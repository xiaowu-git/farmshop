<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>注册</title>
    <%@include file="../common/head.jsp" %>
    <link href="${pageContext.request.contextPath }/resources/css/dlstyle.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath }/resources/assets/js/amazeui.min.js"></script>

</head>

<body>

<div class="login-boxtitle">
    <a href="${pageContext.request.contextPath }/home"><img alt="" src="${pageContext.request.contextPath }/resources/images/logobig.png" /></a>
</div>

<div class="res-banner">
    <div class="res-main">
        <div class="login-banner-bg"><span></span><img src="${pageContext.request.contextPath }/resources/images/big.jpg" /></div>
        <div class="login-box">

            <div class="am-tabs" id="doc-my-tabs">
                <ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
                    <li><a href="">用户注册</a></li>
                </ul>

                <div class="am-tabs-bd">
                    <div class="am-tab-panel">
                        <form method="post">
                            <div class="user-name">
                                <label for="username"><i class="am-icon-code-fork"></i></label>
                                <input type="text" name="YourName" id="username" placeholder="请输入用户名">
                            </div>
                            <div class="user-phone">
                                <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
                                <input type="tel" name="PhoneNumber" id="phone" placeholder="请输入手机号">
                            </div>
                            <div class="user-pass">
                                <label for="password"><i class="am-icon-lock"></i></label>
                                <input type="password" name="Password" id="password" placeholder="设置密码">
                            </div>
                            <div class="user-pass">
                                <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
                                <input type="password" name="Password1" id="passwordRepeat" placeholder="确认密码">
                            </div>
                        </form>
                        <div class="login-links">
                            <%--<label for="reader-me">
                                <input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
                            </label>--%>
                        </div>
                        <div class="am-cf">
                            <input type="submit" name="" id="signupinp" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
                        </div>

                        <hr>
                    </div>

                    <script>
                        $(function() {
                            $('#doc-my-tabs').tabs();
                        })
                    </script>

                </div>
            </div>
            <div class="login-links">
                <a href="${pageContext.request.contextPath }/login" class="zcnext am-fr am-btn-default">登录</a>
                <br />
            </div>

        </div>
    </div>
    <%@include file="../common/footer.jsp" %>
</body>

</html>

<script type="text/javascript">
    <!--点击注册按钮后执行注册操作-->
	$("#signupinp").click(function(){
		var userPhone = $('input[name="PhoneNumber"]').val();
		var userName = $('input[name="YourName"]').val();
		var userPassword = $('input[name="Password"]').val();
		var userPassword1 = $('input[name="Password1"]').val();
		if(null == userPhone || "" == userPhone){
			toastr.options = {positionClass: "toast-top-center"};
			toastr["error"]("请输入您的手机号！");
			$('input[name="Password"]').val("");
			$('input[name="Password1"]').val("");
			return false;
		}
		if(null == userName || "" == userName){
			toastr.options = {positionClass: "toast-top-center"};
			toastr["error"]("请输入用户名！");
			$('input[name="Password"]').val("");
			$('input[name="Password1"]').val("");
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
			$('input[name="Password1"]').val("");
			return false;
		 }
		if(userName.length > 10){
			toastr.options = {positionClass: "toast-top-center"};
			toastr.warning("用户名过长，请您输入不超过10个汉字的用户名!");
			$('input[name="Password"]').val("");
			$('input[name="Password1"]').val("");
			return false;
		}
		if(userPassword.length > 16){
			toastr.options = {positionClass: "toast-top-center"};
			toastr.warning("请您输入小于16位的密码!");
			$('input[name="Password"]').val("");
			$('input[name="Password1"]').val("");
			return false;
		}
		if(userPassword != userPassword1){
			toastr.options = {positionClass: "toast-top-center"};
			toastr["error"]("两次输入密码不一致，请确认！");
			$('input[name="Password"]').val("");
			$('input[name="Password1"]').val("");
			return false;
		}
		$.ajax({
			url:"/addUser",
			type:'post',
			dataType:'json',
			data:{
				"userPhone":userPhone,
				"userName":userName,
				"userPassword":userPassword
			},
			success:function(data){
				if(data.success){
					toastr.options = {positionClass: "toast-top-center"};
					toastr["success"]("注册成功");
					window.location.href ="${pageContext.request.contextPath }/login";
				}else{
					toastr.options = {positionClass: "toast-top-center"};
					toastr["error"](data.msg ? data.msg : "注册失败");
					$('input[name="Password"]').val("");
					$('input[name="Password1"]').val("");
				}
			}
			,error:function(e){
				toastr["error"]("连接服务器超时，请稍后重试");
				$('input[name="Password"]').val("");
				$('input[name="Password1"]').val("");
			}
		});
	});

</script>
