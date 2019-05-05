<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>行情信息</title>
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
<!--头 -->
<%@include file="../common/header.jsp" %>
<%@include file="../common/navtable.jsp" %>


<b class="line"></b>
<!--行情信息 -->
<div class="am-g am-g-fixed blog-g-fixed bloglist">
    <div class="am-u-md-9">
        <article class="blog-main">
            <h3 class="am-article-title blog-title">
                <a>×张毛爷爷，搞定靓妆容</a>
            </h3>
            <h4 class="am-article-meta blog-meta">2014-06-17 09:52</h4>

            <div class="am-g blog-content">
                <div class="am-u-sm-12">
                    <p>年轻的妹子爱美丽，这是人之常情，但是没有足够的经济实力，面对昂贵奢华的护肤品难免囊中羞涩。不过不用担心，年轻的资本就是，不需要投入太多，却依然有俏丽的脸蛋儿~今天小编就给妹子们准备了炙手可热的百元护肤大礼包，看看有没有自己需要的吧！</p>

                    <strong class="blog-tit"><p>一张毛爷爷<span>丨</span>基础护肤</p></strong>
                    <div class="Row">
                        <li><img src="${pageContext.request.contextPath }/resources/images/1.jpg"/></li>
                    </div>
                    <p>百元以内的基础护肤套装，小编给妹子们挑选了洗面奶、爽肤水和面霜，按照洁面和护肤的顺序，大家可以尽情将这些口碑好货加入购物车哦。</p>
                    <p>一向是；平价又好用的露得清洗面奶，加上很大一支感觉怎么都用不完的千纤草丝瓜水，最后用玉兰油面霜锁住面部水分，简直完美！</p>


                </div>

            </div>

        </article>


        <hr class="am-article-divider blog-hr">
    </div>
    <!--引导 -->
    <%@include file="../common/navcir.jsp" %>
</div>
<%@include file="../common/footer.jsp" %>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="{{assets}}js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${pageContext.request.contextPath }/resources/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="${pageContext.request.contextPath }/resources/assets/js/amazeui.min.js"></script>

</body>
</html>

