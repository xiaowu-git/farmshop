<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>添加资讯</title>
    <%@include file="admin_head.jsp" %>
    <link href="https://cdn.bootcss.com/toastr.js/2.1.4/toastr.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/toastr.js/2.1.4/toastr.min.js"></script>
</head>

<body data-type="widgets">
<script src="${pageContext.request.contextPath }/resources/background/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 加载顶部导航栏 -->
    <jsp:include page="admin_header.jsp"/>
    <!-- 加载侧边导航栏 -->
    <jsp:include page="admin_comlist.jsp"/>

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">

                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">添加资讯</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body am-fr">

                            <form class="am-form tpl-form-line-form">
                                <div class="am-form-group">
                                    <label for="farmnews-name" class="am-u-sm-3 am-form-label">标题 <span class="tpl-form-line-small-title">Title</span></label>
                                    <div class="am-u-sm-9">
                                        <input id="farmnews-name" type="text" class="tpl-form-input" placeholder="请输入标题文字">
                                        <small>请填写标题文字5-10字左右。</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="farmnews-time" class="am-u-sm-3 am-form-label">发布时间 <span class="tpl-form-line-small-title">Time</span></label>
                                    <div class="am-u-sm-9">
                                        <input  id="farmnews-time" type="text" class="am-form-field tpl-form-no-bg" placeholder="发布时间" data-am-datepicker="" readonly="">
                                        <small>发布时间为必填</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="farmnews-user" class="am-u-sm-3 am-form-label">作者 <span class="tpl-form-line-small-title">Author</span></label>
                                    <div class="am-u-sm-9">
                                        <select id="farmnews-user" data-am-selected="{maxHeight: 200}" style="display: none;">

                                        </select>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="farmnews-type" class="am-u-sm-3 am-form-label">添加分类 <span class="tpl-form-line-small-title">Type</span></label>
                                    <div class="am-u-sm-9">
                                        <%--<input type="text" id="news-type" placeholder="请添加分类用点号隔开">--%>
                                        <select id="farmnews-type" data-am-selected="{maxHeight: 300}" style="display: none;">

                                        </select>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="farmnews-picture" class="am-u-sm-3 am-form-label">资讯图片 <span class="tpl-form-line-small-title">Images</span></label>
                                    <div class="am-u-sm-9">
                                        <div class="am-form-group am-form-file">
                                            <div class="tpl-form-file-img">
                                                <img id="preview" src="" alt="">
                                            </div>
                                            <button type="button" class="am-btn am-btn-danger am-btn-sm">
                                                <i class="am-icon-cloud-upload"></i> 添加资讯图片</button>
                                            <input id="farmnews-picture" type="file" multiple="" max="5" maxsize="5120" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*" onchange="imgPreview(this)">
                                                <%--<img src="" id="preview">--%>
                                        </div>

                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="farmnews-info" class="am-u-sm-3 am-form-label">文章内容</label>
                                    <div class="am-u-sm-9">
                                        <textarea class="" rows="10" id="farmnews-info" placeholder="请输入文章内容"></textarea>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="button" class="am-btn am-btn-primary tpl-btn-bg-color-success" id="want-addfarmnews">提交</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="${pageContext.request.contextPath }/resources/background/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/background/js/app.js"></script>
</body>
<script type="text/javascript">
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
                    $("#farmnews-type").append("<option value=''>请选择</option>");
                    for(var i=0;i<data.length;i++) {
                        $("#farmnews-type").append("<option value='"+data[i].categorySeq+"'>"+data[i].categoryName+"</option>");
                    }
                }
                else {
                    toastr.options = {positionClass: "toast-top-right"};
                    toastr.warning("data.success 失败!");
                }
            },
            error:function () {
                toastr.options = {positionClass: "toast-top-right"};
                toastr.warning("数据传输失败!");
            },
            complete:function (XMLHttpRequest,status) {
                if(status=='timeout') {
                    //如果请求超时，则弹出提示,并取消请求
                    toastr.options = {positionClass: "toast-top-right"};
                    toastr.warning("请求超时!");
                }
            }
        });

        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath }/admin-allAdmin-list",
            dataType:"json",
            async:true,
            cache:false,//不缓存
            timeout:5000,
            success:function(data) {
                if(data) {
                    $("#farmnews-user").append("<option value=''>请选择</option>");
                    for(var i=0;i<data.length;i++) {
                        $("#farmnews-user").append("<option value='"+data[i].adminId+"'>"+data[i].adminName+"</option>");
                    }
                }
                else {
                    toastr.options = {positionClass: "toast-top-right"};
                    toastr.warning("data.success 失败!");
                }
            },
            error:function () {
                toastr.options = {positionClass: "toast-top-right"};
                toastr.warning("数据传输失败!");
            },
            complete:function (XMLHttpRequest,status) {
                if(status=='timeout') {
                    //如果请求超时，则弹出提示,并取消请求
                    toastr.options = {positionClass: "toast-top-right"};
                    toastr.warning("请求超时!");
                }
            }
        });
    }



    <!--点击提交按钮后执行操作-->
    $("#want-addfarmnews").click(function(){
        var formData = new FormData();
        var farmnewsUser=$('#farmnews-user option:selected').val();
        var farmnewsType=$('#farmnews-type option:selected').val();

        var farmnewsName = $('#farmnews-name').val();
        var farmnewsTime = $('#farmnews-time').val();
        var farmnewsInfo = $('#farmnews-info').val();
        var farmnewsPicture = $("#farmnews-picture")[0].files[0];

        if(null == farmnewsUser || 0 == farmnewsUser){
            toastr.options = {positionClass: "toast-top-right"};
            toastr["error"]("请选择行业资讯发布作者！");
            return false;
        }
        if(null == farmnewsType || 0 == farmnewsType){
            toastr.options = {positionClass: "toast-top-right"};
            toastr["error"]("请选择行业资讯类型！");
            return false;
        }
        if(null == farmnewsName || "" == farmnewsName){
            toastr.options = {positionClass: "toast-top-right"};
            toastr["error"]("请填写行业资讯的标题！");
            return false;
        }
        if(farmnewsName.length > 10){
            toastr.options = {positionClass: "toast-top-right"};
            toastr.warning("请您正确填写行业资讯的标题!");
            return false;
        }
        if(null == farmnewsTime || "" == farmnewsTime){
            toastr.options = {positionClass: "toast-top-right"};
            toastr["error"]("请您填写行业资讯的发布时间！");
            return false;
        }
        if(null == farmnewsInfo || "" == farmnewsInfo){
            toastr.options = {positionClass: "toast-top-right"};
            toastr.warning("请您正确填写行业资讯的具体内容!");
            return false;
        }
        if(farmnewsInfo.length > 1000){
            toastr.options = {positionClass: "toast-top-right"};
            toastr.warning("您填写行业资讯的具体内容已经超出字数!");
            return false;
        }
        if(null == farmnewsPicture || "" == farmnewsPicture){
            toastr.options = {positionClass: "toast-top-right"};
            toastr["error"]("请您上传图片！");
            return false;
        }
        formData.append("farmnewsUser", farmnewsUser);
        formData.append("farmnewsType", farmnewsType);
        formData.append("farmnewsName", farmnewsName);
        formData.append("farmnewsTime",  farmnewsTime);
        formData.append("farmnewsInfo",  farmnewsInfo);
        formData.append("farmnewsPicture",  farmnewsPicture);


        $.ajax({
            url:"${pageContext.request.contextPath }/admin-addfarmnews-execute",
            type:'post',
            dataType:'json',
            data:formData,
            cache : false,
            processData : false,
            contentType : false,
            success:function(data){
                console.log(data);
                if(data.success){
                    toastr.options = {positionClass: "toast-top-right"};
                    toastr["success"]("发布成功");
                    window.location.href = "${pageContext.request.contextPath }/admin-farmnews-list-show?page=1";
                }else{
                    toastr.options = {positionClass: "toast-top-right"};
                    toastr["error"](data.msg ? data.msg : "发布失败");
                }
            }
            ,error:function(e){
                toastr["error"]("连接服务器超时，请稍后重试");
            }
        });
    });

</script>

</html>


