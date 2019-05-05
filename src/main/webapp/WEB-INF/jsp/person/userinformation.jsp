<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>个人资料</title>
    <%@include file="../common/head.jsp" %>
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/infstyle.css" rel="stylesheet" type="text/css">



</head>

<body>

<%@include file="../common/header.jsp" %>
<%@include file="../common/navtable.jsp" %>

<b class="line"></b>
<div class="center">
    <div class="col-main">
        <div class="main-wrap">

            <div class="user-info">
                <!--标题 -->
                <div class="am-cf am-padding">
                    <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small></div>
                </div>
                <hr/>

                <!--头像 -->
                <div class="user-infoPic">

                    <div class="filePic">
                        <input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*">
                        <img class="am-circle am-img-thumbnail" src="${pageContext.request.contextPath }/resources/images/getAvatar.do.jpg" alt="" />
                    </div>

                    <p class="am-form-help">头像</p>

                    <div class="info-m">
                        <div><b>用户名：<i>${sessionScope.obj.userName }</i></b></div>
                        <div class="u-level">
									<span class="rank r2">
							             <s class="vip1"></s><a class="classes">铜牌会员</a>
						            </span>
                        </div>
                        <div class="u-safety">
                            <a href="safety.html">
                                账户安全
                                <span class="u-profile"><i class="bc_ee0000" style="width: 60px;" width="0">60分</i></span>
                            </a>
                        </div>
                    </div>
                </div>

                <!--个人信息 -->
                <div class="info-main">
                    <form autocomplete="off" class="am-form am-form-horizontal">

                        <input type="hidden" name="userId" value="${sessionScope.obj.userId }">
                        <%--<div class="am-form-group">
                            <label for="user-id" class="am-form-label">用户编号</label>
                            <div class="am-form-content">
                                <input type="text" id="user-id" name="userId" value="${sessionScope.obj.userId }" readonly="readonly">
                            </div>
                        </div>--%>

                        <div class="am-form-group">
                            <label for="user-name" class="am-form-label">真实姓名</label>
                            <div class="am-form-content">
                                <input type="text" id="user-name" name="userName" value="${sessionScope.obj.userName }" readonly="readonly">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="user-idcard" class="am-form-label">身份证号</label>
                            <div class="am-form-content">
                                <input type="text" id="user-idcard" name="userIdcard" value="${sessionScope.obj.userIdcard }" readonly="readonly">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="user-create-time" class="am-form-label">注册时间</label>
                            <div class="am-form-content">
                                <input type="text" id="user-create-time" name="userCreateTime" value="<fmt:formatDate value="${sessionScope.obj.userCreateTime }" type="both"/>" readonly="readonly">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="user-phone" class="am-form-label">手机号码</label>
                            <div class="am-form-content">
                                <input id="user-phone" type="tel" name="userPhone" value="${sessionScope.obj.userPhone }">

                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="user-address" class="am-form-label">收货地址</label>
                            <div class="am-form-content">
                                <input type="text" id="user-address" name="userAddress" value="${sessionScope.obj.userAddress }">
                            </div>

                            <%--<div class="am-form-content address">
                                <a href="address.html">
                                    <p class="new-mu_l2cw">
                                        <span class="province">湖北</span>省
                                        <span class="city">武汉</span>市
                                        <span class="dist">洪山</span>区
                                        <span class="street">雄楚大道666号(中南财经政法大学)</span>
                                        <span class="am-icon-angle-right"></span>
                                    </p>
                                </a>

                            </div>--%>
                        </div>
                        <div class="info-btn">
                            <div class="am-btn am-btn-danger" id="user-edit">保存修改</div>
                        </div>
                    </form>
                </div>

            </div>

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
    $("#user-edit").click(function(){
        var userId = $('input[name="userId"]').val();
        var userPhone = $('input[name="userPhone"]').val();
        var userAddress = $('input[name="userAddress"]').val();

        if(null == userPhone || "" == userPhone){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请输入您的手机号！");
            return false;
        }
        if(null == userAddress || "" == userAddress){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请输入您的收货地址！");
            return false;
        }

        var testPhone = /^[1][3,4,5,7,8][0-9]{9}$/;
        if(!(/^1[3|4|5|6|7|8][0-9]\d{4,8}$/.test(userPhone))){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("请您输入正确的手机号!");
            return false;
        }
        if(userAddress.length > 48){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("收货地址过长，请您输入不超过48个汉字的地址!");
            return false;
        }
        $.ajax({
            url:"/user-edituser-execute",
            type:'post',
            dataType:'json',
            data:{
                "userId":userId,
                "userPhone":userPhone,
                "userAddress":userAddress
            },
            success:function(data){
                if(data.success){
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr["success"]("修改信息成功!");
                    window.location.href ="${pageContext.request.contextPath }/userinfo";
                }else{
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr["error"](data.msg ? data.msg : "修改信息失败");
                }
            }
            ,error:function(e){
                toastr["error"]("连接服务器超时，请稍后重试");
            }
        });
    });

</script>
