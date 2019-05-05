<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>订单详情</title>
    <%@include file="../common/head.jsp" %>
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/orstyle.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/stepstyle.css" rel="stylesheet" type="text/css">


</head>

<body>
<%@include file="../common/header.jsp" %>
<%@include file="../common/navtable.jsp" %>
<b class="line"></b>
<div class="center">
    <div class="col-main">
        <div class="main-wrap">

            <div class="user-orderinfo">

                <!--标题 -->
                <div class="am-cf am-padding">
                    <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">买家订单详情</strong> / <small>Order&nbsp;details</small></div>
                </div>
                <hr/>
                <!--进度条-->
                <div class="m-progress">
                    <div class="m-progress-list">
								<span class="step-1 step">
                                   <em class="u-progress-stage-bg"></em>
                                   <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                                   <p class="stage-name">拍下商品</p>
                                </span>
                        <c:if test="${orderUserResponse.orderState == 2}">
                            <span class="step-2 step">
                               <em class="u-progress-stage-bg"></em>
                               <i class="u-stage-icon-inner">2<em class="bg"></em></i>
                               <p class="stage-name">卖家发货</p>
                            </span>
                            <span class="step-3 step">
                               <em class="u-progress-stage-bg"></em>
                               <i class="u-stage-icon-inner">3<em class="bg"></em></i>
                               <p class="stage-name">确认收货</p>
                            </span>
                            <span class="step-4 step">
                               <em class="u-progress-stage-bg"></em>
                               <i class="u-stage-icon-inner">4<em class="bg"></em></i>
                               <p class="stage-name">交易完成</p>
                            </span>
                        </c:if>
                        <c:if test="${orderUserResponse.orderState == 3}">
                            <span class="step-2 step">
                               <em class="u-progress-stage-bg"></em>
                               <i class="u-stage-icon-inner">2<em class="bg"  style="opacity:1"></em></i>
                               <p class="stage-name">卖家发货</p>
                            </span>
                            <span class="step-3 step">
                               <em class="u-progress-stage-bg"></em>
                               <i class="u-stage-icon-inner">3<em class="bg"></em></i>
                               <p class="stage-name">确认收货</p>
                            </span>
                            <span class="step-4 step">
                               <em class="u-progress-stage-bg"></em>
                               <i class="u-stage-icon-inner">4<em class="bg"></em></i>
                               <p class="stage-name">交易完成</p>
                            </span>
                        </c:if>
                        <c:if test="${orderUserResponse.orderState == 4}">
                            <span class="step-2 step">
                               <em class="u-progress-stage-bg"></em>
                               <i class="u-stage-icon-inner">2<em class="bg" style="opacity:1"></em></i>
                               <p class="stage-name">卖家发货</p>
                            </span>
                            <span class="step-3 step">
                               <em class="u-progress-stage-bg"></em>
                               <i class="u-stage-icon-inner">3<em class="bg" style="opacity:1"></em></i>
                               <p class="stage-name">确认收货</p>
                            </span>
                            <span class="step-4 step">
                               <em class="u-progress-stage-bg" ></em>
                               <i class="u-stage-icon-inner">4<em class="bg" style="opacity:1"></em></i>
                               <p class="stage-name">交易完成</p>
                            </span>
                        </c:if>

                        <span class="u-progress-placeholder"></span>
                    </div>
                    <c:if test="${orderUserResponse.orderState == 4}">
                        <div class="u-progress-bar total-steps-4" style="background-color: #23c279">
                            <div class="u-progress-bar-inner"></div>
                        </div>
                    </c:if>
                    <c:if test="${orderUserResponse.orderState < 4}">
                        <div class="u-progress-bar total-steps-4">
                            <div class="u-progress-bar-inner"></div>
                        </div>
                    </c:if>
                </div>
                <div class="order-infoaside">
                    <div class="order-logistics">
                        <a href="#">
                            <div class="icon-log">
                                <i><img src="${pageContext.request.contextPath }/resources/images/receive.png"></i>
                            </div>
                            <c:if test="${orderUserResponse.orderState == 4}">
                                <div class="latest-logistics">
                                    <p class="text">已签收; <br>签收人：${sessionScope.obj.userName }<br>电话号码：${sessionScope.obj.userPhone }，感谢使用圆通快递，期待再次为您服务</p>
                                    <div class="time-list">
                                            <%--<span class="date">2015-12-19</span><span class="week">周六</span><span class="time">15:35:42</span>--%>
                                    </div>
                                    <div class="inquire">
                                        <span class="package-detail">物流：圆通快递</span>
                                        <span class="package-detail">快递单号: </span>
                                        <span class="package-number">xxxxxxxxxxxx</span>
                                        <a href="#">查看</a>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${orderUserResponse.orderState == 3}">
                                <div class="latest-logistics">
                                    <p class="text">卖家已经发货，<br> 卖家电话：${orderUserResponse.sellerPhone}<br>发货地址：${orderUserResponse.stationStart}</p>
                                    <div class="time-list">
                                            <%--<span class="date">2015-12-19</span><span class="week">周六</span><span class="time">15:35:42</span>--%>
                                    </div>
                                    <div class="inquire">
                                        <span class="package-detail">物流：圆通快递</span>
                                        <span class="package-detail">快递单号: </span>
                                        <span class="package-number">xxxxxxxxxxxx</span>
                                        <a href="#">查看</a>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${orderUserResponse.orderState == 2}">
                                <div class="latest-logistics">
                                    <p class="text">卖家暂未发货</p>
                                    <div class="time-list">
                                            <%--<span class="date">2015-12-19</span><span class="week">周六</span><span class="time">15:35:42</span>--%>
                                    </div>
                                    <div class="inquire">
                                        <span class="package-detail">物流：无</span>
                                    </div>
                                </div>
                            </c:if>
                            <span class="am-icon-angle-right icon"></span>
                        </a>
                        <div class="clear"></div>
                    </div>
                    <div class="order-addresslist">
                        <div class="order-address">
                            <div class="icon-add">
                            </div>
                            <p class="new-tit new-p-re">
                                <span class="new-txt">${sessionScope.obj.userName }</span>
                                <span class="new-txt-rd2">${sessionScope.obj.userPhone }</span>
                            </p>
                            <div class="new-mu_l2a new-p-re">
                                <p class="new-mu_l2cw">
                                    <span class="title">收货地址：</span>
                                    <span>${orderUserResponse.stationEnd}</span>
                                   <%-- <span class="province">湖北</span>省
                                    <span class="city">武汉</span>市
                                    <span class="dist">洪山</span>区
                                    <span class="street">雄楚大道666号(中南财经政法大学)</span></p>--%>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="order-infomain">

                    <div class="order-top">
                        <div class="th th-item">
                            <td class="td-inner">商品</td>
                        </div>
                        <div class="th th-operation">
                            <td class="td-inner">发货地</td>
                        </div>

                        <div class="th th-operation">
                            <td class="td-inner">卖家电话</td>
                        </div>

                        <%--<div class="th th-price">
                            <td class="td-inner">状态</td>
                        </div>--%>
                        <div class="th th-amount">
                            <td class="td-inner">合计</td>
                        </div>
                        <div class="th th-status">
                            <td class="td-inner">交易状态</td>
                        </div>
                        <div class="th th-change">
                            <td class="td-inner">交易操作</td>
                        </div>
                    </div>

                    <div class="order-main">

                        <div class="order-status3">
                            <div class="order-title">
                                <div class="dd-num">订单编号：<a href="javascript:;">${orderUserResponse.orderNumber}</a></div>
                                <span>成交时间：<fmt:formatDate value="${orderUserResponse.payTime }" type="both"/></span>
                            </div>
                            <div class="order-content">
                                <div class="order-left">
                                    <ul class="item-list">
                                        <li class="td td-item">
                                            <div class="item-pic">
                                                <a href="#" class="J_MakePoint">
                                                    <img src="${pageContext.request.contextPath }/${orderUserResponse.prodPicture}" class="itempic J_ItemImg">
                                                </a>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-basic-info">
                                                    <a href="#">
                                                        <p>${orderUserResponse.prodName}</p>
                                                        <p class="info-little">味道：原味
                                                            <br/>包装：普通纸盒 </p>
                                                    </a>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="td td-operation">
                                            <div class="item-operation">
                                                ${orderUserResponse.stationStart}
                                            </div>
                                        </li>
                                        <li class="td td-operation">
                                            <div class="item-operation">
                                                <span>${orderUserResponse.sellerPhone}</span>
                                            </div>
                                        </li>
                                        <%--<li class="td td-price">
                                            <div class="item-price">
                                                ${orderUserResponse.orderState}
                                            </div>
                                        </li>--%>
                                    </ul>

                                </div>
                                <div class="order-right">
                                    <li class="td td-amount">
                                        <div class="item-amount">
                                            合计：${orderUserResponse.orderAmount}
                                            <p>含运费：<span>0.00</span></p>
                                        </div>
                                    </li>
                                    <div class="move-right">
                                        <li class="td td-status">
                                            <div class="item-status">
                                                <c:if test="${orderUserResponse.orderState == 2}">
                                                    <p class="Mystatus">待发货</p>
                                                </c:if>
                                                <c:if test="${orderUserResponse.orderState == 3}">
                                                    <p class="Mystatus">待收货</p>
                                                </c:if>
                                                <c:if test="${orderUserResponse.orderState == 4}">
                                                    <p class="Mystatus">交易成功</p>
                                                </c:if>
                                                <%--<p class="Mystatus">卖家已发货</p>
                                                <p class="order-info"><a href="#">查看物流</a></p>
                                                <p class="order-info"><a href="#">延长收货</a></p>--%>
                                            </div>
                                        </li>
                                        <li class="td td-change">
                                            <c:if test="${orderUserResponse.orderState == 3}">
                                                <a href="${pageContext.request.contextPath }/user-order-receive-execute/${orderUserResponse.orderId}">
                                                    <div class="am-btn am-btn-danger anniu">确认收货</div>
                                                </a>
                                            </c:if>
                                            <c:if test="${orderUserResponse.orderState == 4}">
                                                <a href="${pageContext.request.contextPath }/user-order-remove-execute/${orderUserResponse.orderId}">
                                                    <div class="am-btn am-btn-danger anniu">删除订单</div>
                                                </a>
                                            </c:if>
                                        </li>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
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
