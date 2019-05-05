<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>惠农学堂</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/assets/css/amazeui.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/personal.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../common/header.jsp" %>
<%@include file="../common/navtable.jsp" %>


<b class="line"></b>
<!--行情信息 -->
<div class="am-g am-g-fixed blog-g-fixed bloglist">
    <div class="am-u-md-9">
        <article class="blog-main">
            <h3 class="am-article-title blog-title">
                <a>${fsFarmstudy.farmstudyTitle }</a>
            </h3>
            <h4 class="am-article-meta blog-meta">作者：${fsFarmstudy.adminId }</h4>
            <h4 class="am-article-meta blog-meta">时间：<fmt:formatDate value="${fsFarmstudy.effectiveTime}" type="date"/></h4>

            <div class="am-g blog-content">
                <div class="am-u-sm-12">
                    <p>${fsFarmstudy.farmstudyInfo1 }</p>

                    <div class="">
                        <li><img src="${pageContext.request.contextPath }/${fsFarmstudy.farmstudyPicture }"/></li>
                    </div>

                    <br/>

                    <p>${fsFarmstudy.farmstudyInfo2 }</p>
                </div>

            </div>
        </article>


        <hr class="am-article-divider blog-hr">

    </div>

</div>
<%@include file="../common/footer.jsp" %>
<!--引导 -->
<%@include file="../common/navcir.jsp" %>

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${pageContext.request.contextPath }/resources/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="${pageContext.request.contextPath }/resources/assets/js/amazeui.min.js"></script>

</body>
</html>


