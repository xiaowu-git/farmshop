<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>我要供应</title>
    <%@include file="../common/head.jsp" %>
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/refstyle.css" rel="stylesheet" type="text/css">

</head>

<body>
<!--头 -->
<%@include file="../common/header.jsp" %>
<%@include file="../common/navtable.jsp" %>

<b class="line"></b>
<div class="center">
    <div class="col-main">
        <div class="main-wrap">
            <!--标题 -->
            <div class="am-cf am-padding">
                <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">我要供应</strong> / <small>Want&nbsp;to&nbsp;supply</small></div>
            </div>
            <hr/>
            <div class="comment-list">
                <!--进度条-->
                <div class="m-progress">
                    <div class="m-progress-list">
							<span class="step-1 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                                <p class="stage-name">卖家申请<br>供应</p>
                            </span>
                        <span class="step-2 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">2<em class="bg"></em></i>
                                <p class="stage-name">平台审核<br>处理申请</p>
                            </span>
                        <span class="step-3 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">3<em class="bg"></em></i>
                                <p class="stage-name">平台审核<br>成功发布</p>
                            </span>
                        <span class="u-progress-placeholder"></span>
                    </div>
                    <div class="u-progress-bar total-steps-2">
                        <div class="u-progress-bar-inner"></div>
                    </div>
                </div>

                <div class="clear"></div>

                <div class="m-prod-main">
                    <div class="item-comment">
                        <div class="am-form-group">
                            <label for="prod-type" class="am-form-label">产品类型</label>
                            <div class="am-form-content">
                                <select data-am-selected="{maxHeight: 300}" id="prod-type" onchange="">
                                    <%--<option value="a" selected>仅产品</option>--%>
                                </select>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="prod-name" class="am-form-label">产品名称</label>
                            <div class="am-form-content">
                                <input type="text" id="prod-name" placeholder="如：东北大白菜">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="prod-money" class="am-form-label">产品单价</label>
                            <div class="am-form-content">
                                <%--<span class="am-form-content-label">￥</span>--%>
                                <input type="text" id="prod-money" placeholder="如：8.88">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="prod-number" class="am-form-label">产品数量</label>
                            <div class="am-form-content">
                                <input type="text" id="prod-number" placeholder="如：100">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="prod-info" class="am-form-label">产品说明<span>（可不填）</span></label>
                            <div class="am-form-content">
                                <textarea placeholder="请输入产品说明" id="prod-info"></textarea>
                            </div>
                        </div>

                    </div>
                    <label for="prod-picture" class="am-form-label">产品图片</label>
                    <div class="prod-tip" id="prod-picture">
                        <div class="filePic" >
                            <input id="input-img" type="file" class="inputPic" value="选择凭证图片" name="file" max="5" maxsize="5120" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*" onchange="imgPreview(this)">
                            <img src="${pageContext.request.contextPath }/resources/images/image.jpg" alt="">
                        </div>
                        <span class="desc">上传产品图片&nbsp;</span>
                        <%--<img id="preview" src="${pageContext.request.contextPath }/resources/images/tw1.jpg" style="width: auto">--%>
                        <img id="preview" />
                    </div>
                    <div class="info-btn">
                        <div class="am-btn am-btn-danger" id="want-supply">提交申请</div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
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
<script type="text/javascript">

    /*这个方法用于在加载页面时读取后台并增加select的选择数*/
    window.onload=function(){
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath }/AddProdCategorys",
            dataType:"json",
            async:true,
            cache:false,//不缓存
            timeout:5000,
            success:function(data) {
                if(data) {
                    //测试返回数据的正确的使用形式，删除即可
                    // alert("测试:"+data[0].courseName);
                    // alert("测试2:"+data.length);

                    $("#prod-type").append("<option value=''>请选择</option>");
                    for(var i=0;i<data.length;i++) {
                        $("#prod-type").append("<option value='"+data[i].categorySeq+"'>"+data[i].categoryName+"</option>");
                    }
                }
                else {
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr.warning("data.success 失败!");
                }
            },
            error:function () {
                toastr.options = {positionClass: "toast-top-center"};
                toastr.warning("数据传输失败!");
            },
            complete:function (XMLHttpRequest,status) {
                if(status=='timeout') {
                    //如果请求超时，则弹出提示,并取消请求
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr.warning("请求超时!");
                }
            }
        });
    }

    <!--点击提交按钮后执行操作-->
    $("#want-supply").click(function(){
        var formData = new FormData();
        var prodType=$('#prod-type option:selected').val();
        // toastr["error"](prodType.text());
        var prodName = $('#prod-name').val();
        var prodMoney = $('#prod-money').val();
        var prodNum = $('#prod-number').val();
        var prodInfo = $('#prod-info').val();
        // var prodPicture = $('#prod-picture').val();
        var prodPicture = $("#input-img")[0].files[0];

        if(null == prodType || 0 == prodType){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请选择产品类型！");
            return false;
        }
        if(null == prodName || "" == prodName){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请填写产品名称！");
            return false;
        }
        if(prodName.length > 5){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("请您正确填写产品名称!");
            return false;
        }
        if(null == prodMoney || "" == prodMoney){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请您填写产品单价！");
            return false;
        }
        if(prodMoney.length > 5){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("请您正确填写产品单价!");
            return false;
        }
        if(null == prodNum || "" == prodNum){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请您填写产品库存！");
            return false;
        }
        if(prodNum.length > 5){
            toastr.options = {positionClass: "toast-top-center"};
            toastr.warning("请您正确填写产品库存!");
            return false;
        }
        if(null != prodInfo || "" != prodInfo){
            if(prodInfo.length > 100){
                toastr.options = {positionClass: "toast-top-center"};
                toastr.warning("请您正确填写产品说明!");
                return false;
            }
        }
        if(null == prodPicture || "" == prodPicture){
            toastr.options = {positionClass: "toast-top-center"};
            toastr["error"]("请您上传图片！");
            return false;
        }
        formData.append("prodType", prodType);
        formData.append("prodName", prodName);
        formData.append("prodMoney",  prodMoney);
        formData.append("prodNum",  prodNum);
        formData.append("prodInfo",  prodInfo);
        formData.append("prodPicture",  prodPicture);


        $.ajax({
            url:"${pageContext.request.contextPath }/user-wantsupply-execute",
            type:'post',
            dataType:'json',
            data:formData,
            cache : false,
            processData : false,
            contentType : false,
            success:function(data){
                console.log(data);
                if(data.success){
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr["success"]("供应成功");
                    window.location.href = "${pageContext.request.contextPath }/home";
                }else{
                    toastr.options = {positionClass: "toast-top-center"};
                    toastr["error"](data.msg ? data.msg : "供应失败");
                }
            }
            ,error:function(e){
                toastr["error"]("连接服务器超时，请稍后重试");
            }
        });
    });

    //预览图片
    function imgPreview(fileDom) {
        //判断是否支持FileReader
        if(window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }
        //获取文件
        var file = fileDom.files[0];
        var imageType = /^image\//;
        //是否是图片
        if(!imageType.test(file.type)) {
            alert("请选择图片！");
            return;
        }
        //读取完成
        reader.onload = function(a) {
            //获取图片dom
            var img = document.getElementById("preview");
            //图片路径设置为读取的图片
            img.src = a.target.result;
        };
        reader.readAsDataURL(file);
    }


</script>

</html>
