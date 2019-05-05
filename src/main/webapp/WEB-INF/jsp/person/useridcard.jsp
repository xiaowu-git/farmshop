<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>实名认证</title>
    <%@include file="../common/head.jsp" %>
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/stepstyle.css" rel="stylesheet" type="text/css">


</head>

<body>
<!--头 -->
<%@include file="../common/header.jsp" %>
<%@include file="../common/navtable.jsp" %>

<b class="line"></b>
<div class="center">
    <div class="col-main">
        <div class="main-wrap">

            <div class="am-cf am-padding">
                <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">实名认证</strong> / <small>Real&nbsp;authentication</small></div>
            </div>
            <hr/>
            <!--进度条-->
            <div class="m-progress">
                <div class="m-progress-list">
                    <span class="step-1 step">
                        <em class="u-progress-stage-bg"></em>
                        <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                        <p class="stage-name">实名认证</p>
                    </span>
                    <c:if test="${sessionScope.obj.userIdcard != null}">
                        <span class="step-2 step">
                        <em class="u-progress-stage-bg"></em>
                        <i class="u-stage-icon-inner">2<em class="bg" style="opacity: 1"></em></i>
                        <p class="stage-name">完成</p>
                    </span>
                    </c:if>
                    <c:if test="${sessionScope.obj.userIdcard == null}">
                        <span class="step-2 step">
                        <em class="u-progress-stage-bg"></em>
                        <i class="u-stage-icon-inner">2<em class="bg" ></em></i>
                        <p class="stage-name">完成</p>
                    </span>
                    </c:if>
                    <span class="u-progress-placeholder"></span>
                </div>
                <c:if test="${sessionScope.obj.userIdcard != null}">
                    <div class="u-progress-bar total-steps-2" style="background-color: #23c279">
                        <div class="u-progress-bar-inner" ></div>
                    </div>
                </c:if>
                <c:if test="${sessionScope.obj.userIdcard == null}">
                    <div class="u-progress-bar total-steps-2">
                        <div class="u-progress-bar-inner"></div>
                    </div>
                </c:if>

            </div>
            <form class="am-form am-form-horizontal" autocomplete="off">
                <input type="hidden" name="userId" value="${sessionScope.obj.userId }">
                <div class="am-form-group bind">
                    <label for="user-phone" class="am-form-label">手机号</label>
                    <div class="am-form-content">
                        <span id="user-phone">${sessionScope.obj.userPhone }</span>
                    </div>
                </div>
                <div class="am-form-group bind">
                    <label for="user-namepre" class="am-form-label">真实姓名</label>
                    <div class="am-form-content">
                        <span id="user-namepre">${sessionScope.obj.userName }</span>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="user-name" class="am-form-label">真实姓名</label>
                    <div class="am-form-content">
                        <input type="text" id="user-name" placeholder="请输入您的真实姓名" name="userName" value="${sessionScope.obj.userName }">
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="user-Idcard" class="am-form-label">身份证号</label>
                    <div class="am-form-content">
                        <input type="tel" id="user-Idcard" name="userIdcard" placeholder="请输入您的身份证信息" name="userIdcard" value="${sessionScope.obj.userIdcard }">
                    </div>
                </div>
                <c:if test="${sessionScope.obj.userIdcard == null}">
                    <div class="info-btn">
                        <div class="am-btn am-btn-danger" id="user-Idcard-edit">保存修改</div>
                    </div>
                </c:if>
            </form>

        </div>
        <!--底部-->
        <%@include file="../common/footer.jsp" %>
    </div>

    <%--侧边菜单--%>
    <%@include file="menulist.jsp" %>
    <!--引导 -->
    <%@include file="../common/navcir.jsp" %>
</div>

</body>

</html>
<script type="text/javascript">
    <!--点击注册按钮后执行注册操作-->
    $("#user-Idcard-edit").click(function(){
        /*var progress_idcard = document.getElementById("progress_idcard");
        var u_progress_bar = document.getElementById("u_progress_bar");
        progress_idcard.style.opacity = '1';
        u_progress_bar.style.backgroundColor = '#23c279';*/

        var userId = $('input[name="userId"]').val();
        var userName = $('input[name="userName"]').val();
        var userIdcard = $('input[name="userIdcard"]').val();
        if(null == userName || "" == userName){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请输入您的真实姓名！");
            return false;
        }
        // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
        //var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if(!(/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(userIdcard))){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("您输入的身份证号不合法!");
            return false;
        }
        if(userName.length > 10){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("姓名过长，请您输入不超过10个汉字的姓名!");
            return false;
        }
        $.ajax({
            url:"/user-idcard-execute",
            type:'post',
            dataType:'json',
            data:{
                "userId":userId,
                "userName":userName,
                "userIdcard":userIdcard
            },
            success:function(data){
                if(data.success){
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr["success"]("实名认证成功");
                    window.location.href ="${pageContext.request.contextPath }/user-idcard-show";
                }else{
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr["error"](data.msg ? data.msg : "实名认证失败");
                }
            }
            ,error:function(e){
                toastr["error"]("连接服务器超时，请稍后重试");
            }
        });
    });

</script>
