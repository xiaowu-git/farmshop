<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>个人中心</title>
    <%@include file="../common/head.jsp" %>
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/systyle.css" rel="stylesheet" type="text/css">

</head>

<body>
<!--头 -->
<%@include file="../common/header.jsp" %>
<%@include file="../common/navtable.jsp" %>
<b class="line"></b>
<div class="center">
    <div class="col-main">
        <div class="main-wrap">
            <div class="wrap-left">
                <div class="wrap-list">
                    <div class="m-user">
                        <!--个人信息 -->
                        <div class="m-bg"></div>
                        <div class="m-userinfo">
                            <div class="m-baseinfo">
                                <a href="${pageContext.request.contextPath }/userinfo">
                                    <img src="${pageContext.request.contextPath }/resources/images/getAvatar.do.jpg">
                                </a>
                                <em class="s-name">${sessionScope.obj.userName }<span class="vip1"></em>
                                <div class="s-prestige am-btn am-round">
                                    </span>会员福利</div>
                            </div>
                            <div class="m-right">
                                <div class="m-new">
                                    <a href="#"><i class="am-icon-bell-o"></i>消息</a>
                                </div>
                                <div class="m-address">
                                    <a href="#" class="i-trigger">我的收货地址</a>
                                </div>
                            </div>
                        </div>

                        <!--个人资产-->
                        <div class="m-userproperty">
                            <div class="s-bar">
                                <i class="s-icon"></i>个人资产
                            </div>
                            <p class="m-bonus">
                                <a href="${pageContext.request.contextPath }/user-wanttosupply-show">
                                    <i><img src="${pageContext.request.contextPath }/resources/images/bonus.png"/></i>
                                    <span class="m-title">供应</span>
                                    <em class="m-num">2</em>
                                </a>
                            </p>
                            <p class="m-coupon">
                                <a href="${pageContext.request.contextPath }/user-wanttoprocurement-show">
                                    <i><img src="${pageContext.request.contextPath }/resources/images/coupon.png"/></i>
                                    <span class="m-title">采购</span>
                                    <em class="m-num">2</em>
                                </a>
                            </p>
                            <%--<p class="m-bill">
                                <a href="#">
                                    <i><img src="${pageContext.request.contextPath }/resources/images/wallet.png"/></i>
                                    <span class="m-title">钱包</span>
                                    <em class="m-num">2</em>
                                </a>
                            </p>
                            <p class="m-big">
                                <a href="#">
                                    <i><img src="${pageContext.request.contextPath }/resources/images/day-to.png"/></i>
                                    <span class="m-title">签到有礼</span>
                                </a>
                            </p>
                            <p class="m-big">
                                <a href="#">
                                    <i><img src="${pageContext.request.contextPath }/resources/images/72h.png"/></i>
                                    <span class="m-title">72小时发货</span>
                                </a>
                            </p>--%>
                        </div>
                    </div>
                    <div class="box-container-bottom"></div>

                    <!--订单 -->
                    <div class="m-order">
                        <div class="s-bar">
                            <i class="s-icon"></i>我的订单
                            <a class="i-load-more-item-shadow" href="${pageContext.request.contextPath }/user-order-list">全部订单</a>
                        </div>
                        <ul>
                            <%--<li><a href="${pageContext.request.contextPath }/user-order-list"><i><img src="${pageContext.request.contextPath }/resources/images/pay.png"/></i><span>待付款</span></a></li>--%>
                            <li><a href="${pageContext.request.contextPath }/user-order-list"><i><img src="${pageContext.request.contextPath }/resources/images/send.png"/></i><span>待发货<em class="m-num">1</em></span></a></li>
                            <li><a href="${pageContext.request.contextPath }/user-order-list"><i><img src="${pageContext.request.contextPath }/resources/images/receive.png"/></i><span>待收货</span></a></li>
                            <li><a href="${pageContext.request.contextPath }/user-order-list"><i><img src="${pageContext.request.contextPath }/resources/images/comment.png"/></i><span>交易成功<em class="m-num">3</em></span></a></li>
                            <li><a href="${pageContext.request.contextPath }/user-orderchange-list"><i><img src="${pageContext.request.contextPath }/resources/images/refund.png"/></i><span>退换货</span></a></li>
                        </ul>
                    </div>
                    <!--九宫格-->
                    <div class="user-patternIcon">
                        <div class="s-bar">
                            <i class="s-icon"></i>我的常用
                        </div>
                        <ul>

                            <%--<a href="${pageContext.request.contextPath }/resources/home/shopcart.html"><li class="am-u-sm-4"><i class="am-icon-shopping-basket am-icon-md"></i><img src="${pageContext.request.contextPath }/resources/images/iconbig.png"/><p>购物车</p></li></a>
                            <a href="collection.html"><li class="am-u-sm-4"><i class="am-icon-heart am-icon-md"></i><img src="${pageContext.request.contextPath }/resources/images/iconsmall1.png"/><p>我的收藏</p></li></a>
                            <a href="${pageContext.request.contextPath }/resources/home/home.html"><li class="am-u-sm-4"><i class="am-icon-gift am-icon-md"></i><img src="${pageContext.request.contextPath }/resources/images/iconsmall0.png"/><p>为你推荐</p></li></a>
                            <a href="comment.html"><li class="am-u-sm-4"><i class="am-icon-pencil am-icon-md"></i><img src="${pageContext.request.contextPath }/resources/images/iconsmall3.png"/><p>好评宝贝</p></li></a>
                            <a href="foot.html"><li class="am-u-sm-4"><i class="am-icon-clock-o am-icon-md"></i><img src="${pageContext.request.contextPath }/resources/images/iconsmall2.png"/><p>我的足迹</p></li></a>--%>
                        </ul>
                    </div>
                    <!--物流 -->
                    <div class="m-logistics">

                        <div class="s-bar">
                            <i class="s-icon"></i>我的物流
                        </div>
                        <div class="s-content">
                            <ul class="lg-list">


                                <div class="clear"></div>



                            </ul>

                        </div>

                    </div>

                    <!--收藏夹 -->
                    <div class="you-like">
                        <div class="s-bar">我的收藏
                            <a class="am-badge am-badge-danger am-round">降价</a>
                            <a class="am-badge am-badge-danger am-round">下架</a>
                            <a class="i-load-more-item-shadow" href="#"><i class="am-icon-refresh am-icon-fw"></i>换一组</a>
                        </div>
                        <div class="s-content">


                        </div>

                        <div class="s-more-btn i-load-more-item" data-screen="0"><i class="am-icon-refresh am-icon-fw"></i>更多</div>

                    </div>

                </div>
            </div>
            <div class="wrap-right">

                <!-- 日历-->
                <div class="day-list">
                    <div class="s-bar">
                        <a class="i-history-trigger s-icon" href="#"></a>我的日历
                        <a class="i-setting-trigger s-icon" href="#"></a>
                    </div>
                    <div class="s-care s-care-noweather">
                        <div class="s-date">
                            <em id="user-day">21</em>
                            <span id="user-week">星期一</span>
                            <span id="user-year-month">2015.12</span>
                        </div>
                    </div>
                </div>
                <!--新品 -->
                <div class="new-goods">
                    <div class="s-bar">
                        <i class="s-icon"></i>今日新品
                        <a class="i-load-more-item-shadow">15款新品</a>
                    </div>
                    <div class="new-goods-info">
                        <a class="shop-info" href="#" target="_blank">
                            <div class="face-img-panel">
                                <img src="${pageContext.request.contextPath }/resources/images/imgsearch1.jpg" alt="">
                            </div>
                            <span class="new-goods-num ">4</span>
                            <span class="shop-title">剥壳松子</span>
                        </a>
                        <a class="follow " target="_blank">关注</a>
                    </div>
                </div>

                <!--热卖推荐 -->
                <div class="new-goods">
                    <div class="s-bar">
                        <i class="s-icon"></i>热卖推荐
                    </div>
                    <div class="new-goods-info">
                        <a class="shop-info" href="#" target="_blank">
                            <div >
                                <img src="${pageContext.request.contextPath }/resources/images/imgsearch1.jpg" alt="">
                            </div>
                            <span class="one-hot-goods">￥9.20</span>
                        </a>
                    </div>
                </div>

            </div>
        </div>
        <!--底部-->
        <%@include file="../common/footer.jsp" %>

    </div>

    <%--侧边菜单--%>
    <%@include file="menulist.jsp" %>
</div>
<!--引导 -->
<%@include file="../common/navcir.jsp" %>
</body>

<script type="text/javascript">
    var doneDate = new Date();
    var year = doneDate.getFullYear();
    var month = doneDate.getMonth() + 1;
    var day = doneDate.getDay();
    switch (day) {
        case 0:
            day = "星期日";
            break;
        case 1:
            day = "星期一";
            break;
        case 2:
            day = "星期二";
            break;
        case 3:
            day = "星期三";
            break;
        case 4:
            day = "星期四";
            break;
        case 5:
            day = "星期五";
            break;
        case 6:
            day = "星期六";
            break;
    }

    $("#user-week").text(day);
    var date = doneDate.getDate();
    $("#user-day").text(date);
    $("#user-year-month").text(year+"年"+month+"月");

</script>

</html>