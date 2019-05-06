<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>首页</title>
    <%@include file="../common/head.jsp" %>

    <%--<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />--%>
    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />

    <link href="${pageContext.request.contextPath }/resources/css/hmstyle.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath }/resources/css/skin.css" rel="stylesheet" type="text/css" />
    <%--<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>--%>
    <%--<script src="${pageContext.request.contextPath }/resources/assets/js/amazeui.min.js"></script>--%>

</head>

<body>
<div class="hmtop">
    <%@include file="../common/header.jsp" %>

    <div class="clear"></div>
</div>
<div class="banner">
    <!--轮播 -->
    <div class="am-slider am-slider-default scoll" data-am-flexslider id="demo-slider-0">
        <ul class="am-slides">
            <li class="banner1"><a><img src="${pageContext.request.contextPath }/resources/images/ad1.jpg" /></a></li>
            <li class="banner2"><a><img src="${pageContext.request.contextPath }/resources/images/ad2.jpg" /></a></li>
            <li class="banner3"><a><img src="${pageContext.request.contextPath }/resources/images/ad3.jpg" /></a></li>
            <li class="banner4"><a><img src="${pageContext.request.contextPath }/resources/images/ad4.jpg" /></a></li>

        </ul>
    </div>
    <div class="clear"></div>
</div>
<div class="shopNav">
    <div class="slideall">

        <%--<div class="long-title"><span class="all-goods">全部分类</span></div>--%>
        <div class="nav-cont">
            <ul>
                <li class="index"><a href="${pageContext.request.contextPath }/home">首页</a></li>
                <li class="qc"><a href="${pageContext.request.contextPath }/supply-list?page=1">供应大厅</a></li>
                <li class="qc"><a href="${pageContext.request.contextPath }/procurement-list?page=1">采购大厅</a></li>
                <li class="qc"><a href="${pageContext.request.contextPath }/marketinfo-list?page=1">行情大厅</a></li>
                <li class="qc"><a href="${pageContext.request.contextPath }/farmnews-list?page=1">行业资讯</a></li>
                <li class="qc"><a target="_blank" href="${pageContext.request.contextPath }/study-list?page=1">惠农学堂</a></li>
            </ul>
        </div>

        <!--侧边导航 -->
        <%--<div id="nav" class="navfull">
            <div class="area clearfix">
                <div class="category-content" id="guide_2">

                    <div class="category">
                        <ul class="category-list" id="js_climit_li">
                            <li class="appliance js_toggle relative first">
                                <div class="category-info">
                                    <h3 class="category-name b-category-name"><i><img src="${pageContext.request.contextPath }/resources/images/meat.png"></i><a class="ml-22" title="新鲜蔬菜">新鲜蔬菜</a></h3>
                                    <em>&gt;</em></div>
                                <div class="menu-item menu-in top">
                                    <div class="area-in">
                                        <div class="area-bg">
                                            <div class="menu-srot">
                                                <div class="sort-side">
                                                    <dl class="dl-sort">
                                                        &lt;%&ndash;<dt><span title="叶菜类">叶菜类</span></dt>&ndash;%&gt;
                                                        <c:forEach items="${requestScope.fsCategoryListHome }" var="fsCategory">
                                                            <c:if test="${fsCategory.parentId == 1}">
                                                                <dd><a title="${fsCategory.categoryName}" href="#"><span>${fsCategory.categoryName}</span></a></dd>
                                                            </c:if>
                                                        </c:forEach>
                                                    </dl>

                                                </div>
                                                <div class="brand-side">
                                                    <dl class="dl-sort"><dt><span>实力商家</span></dt>
                                                        <dd><a rel="nofollow" title="新开家园官方旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >新开家园官方旗舰店</span></a></dd>
                                                    </dl>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <b class="arrow"></b>
                            </li>
                            <li class="appliance js_toggle relative">
                                <div class="category-info">
                                    <h3 class="category-name b-category-name"><i><img src="${pageContext.request.contextPath }/resources/images/cookies.png"></i><a class="ml-22" title="新鲜水果">新鲜水果</a></h3>
                                    <em>&gt;</em></div>
                                <div class="menu-item menu-in top">
                                    <div class="area-in">
                                        <div class="area-bg">
                                            <div class="menu-srot">
                                                <div class="sort-side">
                                                    <dl class="dl-sort">
                                                        &lt;%&ndash;<dt><span title="核果仁果类">核果仁果类</span></dt>&ndash;%&gt;
                                                        <c:forEach items="${requestScope.fsCategoryListHome }" var="fsCategory">
                                                            <c:if test="${fsCategory.parentId == 2}">
                                                                <dd><a title="${fsCategory.categoryName}" href="#"><span>${fsCategory.categoryName}</span></a></dd>
                                                            </c:if>
                                                        </c:forEach>
                                                    </dl>
                                                </div>
                                                <div class="brand-side">
                                                    <dl class="dl-sort"><dt><span>实力商家</span></dt>
                                                        <dd><a rel="nofollow" title="新开家园官方旗舰店" target="_blank" href="#" rel="nofollow"><span  class ="red" >新开家园官方旗舰店</span></a></dd>
                                                    </dl>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <b class="arrow"></b>
                            </li>

                            <li class="appliance js_toggle relative">
                                <div class="category-info">
                                    <h3 class="category-name b-category-name"><i><img src="${pageContext.request.contextPath }/resources/images/meat.png"></i><a class="ml-22" title="肉类、鱼类">肉类/鱼类</a></h3>
                                    <em>&gt;</em></div>
                                <div class="menu-item menu-in top">
                                    <div class="area-in">
                                        <div class="area-bg">
                                            <div class="menu-srot">
                                                <div class="sort-side">
                                                    <dl class="dl-sort">
                                                        &lt;%&ndash;<dt><span title="猪肉脯">猪肉脯</span></dt>&ndash;%&gt;
                                                        <c:forEach items="${requestScope.fsCategoryListHome }" var="fsCategory">
                                                            <c:if test="${fsCategory.parentId == 3}">
                                                                <dd><a title="${fsCategory.categoryName}" href="#"><span>${fsCategory.categoryName}</span></a></dd>
                                                            </c:if>
                                                        </c:forEach>
                                                    </dl>
                                                </div>
                                                <div class="brand-side">
                                                    <dl class="dl-sort"><dt><span>实力商家</span></dt>
                                                        <dd><a rel="nofollow" title="新开家园官方旗舰店 " target="_blank" href="#" rel="nofollow"><span  class="red" >新开家园官方旗舰店 </span></a></dd>
                                                    </dl>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <b class="arrow"></b>
                            </li>
                            <li class="appliance js_toggle relative">
                                <div class="category-info">
                                    <h3 class="category-name b-category-name"><i><img src="${pageContext.request.contextPath }/resources/images/bamboo.png"></i><a class="ml-22" title="粮油、米面">粮油/米面</a></h3>
                                    <em>&gt;</em></div>
                                <div class="menu-item menu-in top">
                                    <div class="area-in">
                                        <div class="area-bg">

                                            <div class="menu-srot">
                                                <div class="sort-side">
                                                    <dl class="dl-sort">
                                                        &lt;%&ndash;<dt><span title="豆干">豆干</span></dt>&ndash;%&gt;
                                                        <c:forEach items="${requestScope.fsCategoryListHome }" var="fsCategory">
                                                            <c:if test="${fsCategory.parentId == 4}">
                                                                <dd><a title="${fsCategory.categoryName}" href="#"><span>${fsCategory.categoryName}</span></a></dd>
                                                            </c:if>
                                                        </c:forEach>
                                                    </dl>
                                                </div>
                                                <div class="brand-side">
                                                    <dl class="dl-sort"><dt><span>实力商家</span></dt>
                                                        <dd><a rel="nofollow" title="歌芙品牌旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >歌芙品牌旗舰店</span></a></dd>
                                                    </dl>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <b class="arrow"></b>
                            </li>
                            <li class="appliance js_toggle relative">
                                <div class="category-info">
                                    <h3 class="category-name b-category-name"><i><img src="${pageContext.request.contextPath }/resources/images/nut.png"></i><a class="ml-22" title="农副、加工">农副/加工</a></h3>
                                    <em>&gt;</em></div>
                                <div class="menu-item menu-in top">
                                    <div class="area-in">
                                        <div class="area-bg">
                                            <div class="menu-srot">
                                                <div class="sort-side">
                                                    <dl class="dl-sort">
                                                        &lt;%&ndash;<dt><span title="蛋糕">坚果</span></dt>&ndash;%&gt;
                                                        <c:forEach items="${requestScope.fsCategoryListHome }" var="fsCategory">
                                                            <c:if test="${fsCategory.parentId == 5}">
                                                                <dd><a title="${fsCategory.categoryName}" href="#"><span>${fsCategory.categoryName}</span></a></dd>
                                                            </c:if>
                                                        </c:forEach>
                                                    </dl>
                                                </div>
                                                <div class="brand-side">
                                                    <dl class="dl-sort"><dt><span>实力商家</span></dt>
                                                        <dd><a rel="nofollow" title="呵呵嘿官方旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >呵呵嘿官方旗舰店</span></a></dd>
                                                    </dl>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <b class="arrow"></b>
                            </li>


                            <li class="appliance js_toggle relative">
                                <div class="category-info">
                                    <h3 class="category-name b-category-name"><i><img src="${pageContext.request.contextPath }/resources/images/candy.png"></i><a class="ml-22" title="糖果、蜜饯">糖果/蜜饯</a></h3>
                                    <em>&gt;</em></div>
                                <div class="menu-item menu-in top">
                                    <div class="area-in">
                                        <div class="area-bg">
                                            <div class="menu-srot">
                                                <div class="sort-side">
                                                    <dl class="dl-sort">
                                                        &lt;%&ndash;<dt><span title="糖果">糖果</span></dt>&ndash;%&gt;
                                                        <c:forEach items="${requestScope.fsCategoryListHome }" var="fsCategory">
                                                            <c:if test="${fsCategory.parentId == 6}">
                                                                <dd><a title="${fsCategory.categoryName}" href="#"><span>${fsCategory.categoryName}</span></a></dd>
                                                            </c:if>
                                                        </c:forEach>
                                                    </dl>
                                                </div>
                                                <div class="brand-side">
                                                    <dl class="dl-sort"><dt><span>实力商家</span></dt>
                                                        <dd><a rel="nofollow" title="YYKCLOT" target="_blank" href="#" rel="nofollow"><span  class ="red" >YYKCLOT</span></a></dd>
                                                    </dl>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <b class="arrow"></b>
                            </li>



                        </ul>
                    </div>
                </div>

            </div>
        </div>--%>


        <!--轮播-->

        <script type="text/javascript">
            (function() {
                $('.am-slider').flexslider();
            });
            $(document).ready(function() {
                $("li").hover(function() {
                    $(".category-content .category-list li.first .menu-in").css("display", "none");
                    $(".category-content .category-list li.first").removeClass("hover");
                    $(this).addClass("hover");
                    $(this).children("div.menu-in").css("display", "block")
                }, function() {
                    $(this).removeClass("hover")
                    $(this).children("div.menu-in").css("display", "none")
                });
            })
        </script>



        <!--小导航 -->
        <div class="am-g am-g-fixed smallnav">
            <div class="am-u-sm-3">
                <a href="${pageContext.request.contextPath }/supply-list?page=1"><img src="${pageContext.request.contextPath }/resources/images/huismall.jpg" />
                    <div class="title">供应大厅</div>
                </a>
            </div>
            <div class="am-u-sm-3">
                <a href="${pageContext.request.contextPath }/procurement-list?page=1"><img src="${pageContext.request.contextPath }/resources/images/moneysmall.jpg" />
                    <div class="title">采购大厅</div>
                </a>
            </div>
            <div class="am-u-sm-3">
                <a href="${pageContext.request.contextPath }/marketinfo-list?page=1"><img src="${pageContext.request.contextPath }/resources/images/huismall.jpg" />
                    <div class="title">行情大厅</div>
                </a>
            </div>
            <div class="am-u-sm-3">
                <a href="${pageContext.request.contextPath }/farmnews-list?page=1"><img src="${pageContext.request.contextPath }/resources/images/huismall.jpg" />
                    <div class="title">行业资讯</div>
                </a>
            </div>
        </div>

        <!--走马灯 -->

        <div class="marqueen">
            <span class="marqueen-title">惠农头条</span>
            <div class="demo">

                <ul>
                    <c:forEach items="${requestScope.fsFarmnewsListHome }" var="fsFarmnews">
                        <li><a target="_blank" href=""><span>[头条]</span>${fsFarmnews.farmnewsName}</a></li>
                    </c:forEach>
                    <%--<li class="title-first">
                        <a target="_blank" href="#">
                        <span>[公告]</span>商城与广州市签署战略合作协议
                        <img src="${pageContext.request.contextPath }/resources/images/TJ.jpg"></img>
                        <p>XXXXXXXXXXXXXXXXXX</p>
                        </a>
                    </li>--%>
                </ul>
                <div class="advTip"><img src="${pageContext.request.contextPath }/resources/images/advTip.jpg"/></div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <script type="text/javascript">
        if ($(window).width() < 640) {
            function autoScroll(obj) {
                $(obj).find("ul").animate({
                    marginTop: "-39px"
                }, 500, function() {
                    $(this).css({
                        marginTop: "0px"
                    }).find("li:first").appendTo(this);
                })
            }
            $(function() {
                setInterval('autoScroll(".demo")', 3000);
            })
        }
    </script>
</div>
<div class="shopMainbg">
    <div class="shopMain" id="shopmain">

        <!--今日推荐 -->

        <div class="am-g am-g-fixed recommendation">
            <div class="clock am-u-sm-3">
            <img src="${pageContext.request.contextPath }/resources/images/2016.png "></img>
            <p>今日<br>推荐</p>
        </div>
        <div class="am-u-sm-4 am-u-lg-3 ">
            <div class="info ">
                <h3>真的有鱼</h3>
                <h4>开年福利篇</h4>
            </div>
            <div class="recommendationMain one">
                <a href="#"><img src="${pageContext.request.contextPath }/resources/images/tj.png "></img></a>
            </div>
        </div>
        <div class="am-u-sm-4 am-u-lg-3 ">
            <div class="info ">
                <h3>囤货过冬</h3>
                <h4>让爱早回家</h4>
            </div>
            <div class="recommendationMain two">
                <img src="${pageContext.request.contextPath }/resources/images/tj1.png "></img>
            </div>
        </div>
        <div class="am-u-sm-4 am-u-lg-3 ">
            <div class="info ">
                <h3>浪漫情人节</h3>
                <h4>甜甜蜜蜜</h4>
            </div>
            <div class="recommendationMain three">
                <img src="${pageContext.request.contextPath }/resources/images/tj2.png "></img>
            </div>
        </div>

    </div>

    <div class="clear "></div>


    <div id="f1">
        <!--蔬菜-->

        <div class="am-container ">
            <div class="shopTitle ">
                <h4>新鲜蔬菜</h4>
                <h3>一份耕耘,  一份收获</h3>
                <div class="today-brands ">
                    <a href="# ">桂花糕</a>
                    <a href="# ">奶皮酥</a>
                    <a href="# ">栗子糕 </a>
                    <a href="# ">马卡龙</a>
                    <a href="# ">铜锣烧</a>
                    <a href="# ">豌豆黄</a>
                </div>
                <span class="more ">
                    <a href="# ">更多美味<i class="am-icon-angle-right" style="padding-left:10px ;" ></i></a>
                        </span>
            </div>
        </div>
        <div class="am-g am-g-fixed floodFour">
            <div class="am-u-sm-5 am-u-md-4 text-one list ">
                <div class="word">

                    <c:forEach items="${requestScope.fsCategoryListHome }" begin="0" end="5" var="fsCategory">
                        <c:if test="${fsCategory.parentId == 1}">
                            <a class="outer" href="#"><span class="inner"><b class="text">${fsCategory.categoryName}</b></span></a>
                        </c:if>
                    </c:forEach>
                    <%--<a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>--%>
                </div>
                <a href="# ">
                    <div class="outer-con ">
                        <div class="title ">
                            开抢啦！
                        </div>
                        <div class="sub-title ">
                            家庭大礼包
                        </div>
                    </div>
                    <img src="${pageContext.request.contextPath }/resources/images/huanggua.png " />
                </a>
                <div class="triangle-topright"></div>
            </div>

            <%--显示卖的商品--%>
            <c:forEach items="${requestScope.vegetables }" var="supplyProd">
                <div class="am-u-sm-3 am-u-md-2 text-three">
                    <a href="${pageContext.request.contextPath }/user-supplyProd-show?supplyProdId=${supplyProd.supplyProdId}">
                        <img src="${pageContext.request.contextPath }/${supplyProd.supplyProdPicture}" />
                        <div class="outer-con ">
                            <div class="title ">
                                    ${supplyProd.supplyProdName}
                            </div>
                            <div class="sub-title ">
                                ¥${supplyProd.supplyProdPrice}
                            </div>
                            <i class="am-icon-shopping-basket am-icon-md  seprate"></i>
                        </div>
                    </a>
                </div>
            </c:forEach>


        <div class="clear "></div>
    </div>
    </div>


    <div id="f2">
        <!--水果-->
        <div class="am-container ">
            <div class="shopTitle ">
                <h4>新鲜水果</h4>
                <h3>赠人玫瑰,手留余香</h3>
                <div class="today-brands ">
                    <a href="# ">腰果</a>
                    <a href="# ">松子</a>
                    <a href="# ">夏威夷果 </a>
                    <a href="# ">碧根果</a>
                    <a href="# ">开心果</a>
                    <a href="# ">核桃仁</a>
                </div>
                <span class="more ">
                    <a href="# ">更多美味<i class="am-icon-angle-right" style="padding-left:10px ;" ></i></a>
                        </span>
            </div>
        </div>
        <div class="am-g am-g-fixed floodFour ">
            <div class="am-u-sm-5 am-u-md-4 text-one list">
                <div class="word">
                    <c:forEach items="${requestScope.fsCategoryListHome }" begin="41" end="46" var="fsCategory">
                        <c:if test="${fsCategory.parentId == 2}">
                            <a class="outer" href="#"><span class="inner"><b class="text">${fsCategory.categoryName}</b></span></a>
                        </c:if>
                    </c:forEach>
                </div>
                <a href="# ">
                    <img src="${pageContext.request.contextPath }/resources/images/5.jpg " />
                    <div class="outer-con ">
                        <div class="title ">
                            赠人玫瑰,手留余香
                        </div>
                    </div>
                </a>
                <div class="triangle-topright"></div>
            </div>


            <c:forEach items="${requestScope.fruits }" var="supplyProd">
                <div class="am-u-sm-3 am-u-md-2 text-three">
                    <a href="${pageContext.request.contextPath }/user-supplyProd-show?supplyProdId=${supplyProd.supplyProdId}">
                        <img src="${pageContext.request.contextPath }/${supplyProd.supplyProdPicture}" />
                        <div class="outer-con ">
                            <div class="title ">
                                    ${supplyProd.supplyProdName}
                            </div>
                            <div class="sub-title ">
                                ¥${supplyProd.supplyProdPrice}
                            </div>
                            <i class="am-icon-shopping-basket am-icon-md  seprate"></i>
                        </div>
                    </a>
                </div>
            </c:forEach>



            <div class="clear "></div>

        </div>
    </div>

        <div class="clear "></div>
        <!--行业资讯 -->

        <div class="am-container activity ">
        <div class="shopTitle ">
            <h4>行业资讯</h4>
            <h3>每期活动 优惠享不停 </h3>
            <span class="more ">
                <a href="# ">全部活动<i class="am-icon-angle-right" style="padding-left:10px ;" ></i></a>
            </span>
        </div>
        <div class="am-g am-g-fixed ">
            <c:forEach items="${requestScope.fsFarmnewsListHome }" var="fsFarmnews">
                <div class="am-u-sm-3">
                    <div class="icon-sale "></div>
                    <h4>惠农</h4>

                    <div class="activityMain ">
                        <img src="${pageContext.request.contextPath }/${fsFarmnews.farmnewsPicture}"></img>
                    </div>
                    <a href="${pageContext.request.contextPath }/user-farmnews-show?farmnewsId=${fsFarmnews.farmnewsId}" >
                        <div class="info ">
                            <h3>${fsFarmnews.farmnewsName}</h3>
                        </div>
                    </a>
                </div>
            </c:forEach>

        </div>
    </div>

        <div class="clear "></div>
    </div>
        <%@include file="../common/footer.jsp" %>




</div>
<!--引导 -->
<%@include file="../common/navcir.jsp" %>

<script>
    window.jQuery || document.write('<script src=\"/resources/basic/js/jquery.min.js\"><\/script>');
</script>
<script type="text/javascript " src="${pageContext.request.contextPath }/resources/basic/js/quick_links.js "></script>
</div>
</body>

</html>
