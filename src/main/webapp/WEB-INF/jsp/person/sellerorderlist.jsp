<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
    <title>订单管理</title>
    <%@include file="../common/head.jsp" %>
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/orstyle.css" rel="stylesheet" type="text/css">

</head>

<body>
<!--头 -->
<%@include file="../common/header.jsp" %>
<%@include file="../common/navtable.jsp" %>
<b class="line"></b>
<div class="center">
    <div class="col-main">
        <div class="main-wrap">

            <div class="user-order">

                <!--标题 -->
                <div class="am-cf am-padding">
                    <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small></div>
                </div>
                <hr/>

                <div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

                    <ul class="am-avg-sm-4 am-tabs-nav am-nav am-nav-tabs">
                        <li class="am-active"><a href="#tab1">所有订单</a></li>
                        <%--<li><a href="#tab2">待付款</a></li>--%>
                        <li><a href="#tab2">待发货</a></li>
                        <li><a href="#tab3">待收货</a></li>
                        <li><a href="#tab4">交易完成</a></li>
                    </ul>

                    <%--所有订单--%>
                    <div class="am-tabs-bd">
                        <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">发货地</td>
                                </div>

                                <div class="th th-operation">
                                    <td class="td-inner">买家号码</td>
                                </div>

                                <%--<div class="th th-price">
                                    <td class="td-inner">状态</td>
                                </div>--%>

                                <%--<div class="th th-number">
                                    <td class="td-inner">数量</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">商品操作</td>
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
                                <div class="order-list">

                                    <c:forEach items="${requestScope.fsOrderUserList }" var="orderUserResponse">
                                        <div class="order-status5">
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
                                                                        <p class="info-little">颜色：原味
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

                                                            <%--
                                                            <li class="td td-operation">
                                                                <div class="item-operation">

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
                                                            </div>
                                                        </li>
                                                        <li class="td td-change">
                                                            <a href="${pageContext.request.contextPath }/user-seller-orderinfo-show?userOrderId=${orderUserResponse.orderId}">
                                                                <div class="am-btn am-btn-danger anniu">订单详情</div>
                                                            </a>
                                                        </li>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>



                                </div>

                            </div>

                        </div>


                        <%--待发货--%>
                        <div class="am-tab-panel am-fade" id="tab2">
                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">发货地</td>
                                </div>

                                <div class="th th-operation">
                                    <td class="td-inner">买家号码</td>
                                </div>

                                <%--<div class="th th-price">
                                    <td class="td-inner">状态</td>
                                </div>--%>

                                <%--<div class="th th-number">
                                    <td class="td-inner">数量</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">商品操作</td>
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

                            <%--具体内容--%>
                            <div class="order-main">
                                <div class="order-list">

                                    <c:forEach items="${requestScope.fsOrderUserList }" var="orderUserResponse">
                                        <c:if test="${orderUserResponse.orderState == 2}">
                                            <div class="order-status5">
                                                <div class="order-title">
                                                    <div class="dd-num">订单编号：<a href="javascript:;">${orderUserResponse.orderNumber}</a></div>
                                                    <span>成交时间：<fmt:formatDate value="${orderUserResponse.payTime }" type="both"/></span>
                                                    <!--    <em>店铺：小桔灯</em>-->
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
                                                                            <p class="info-little">颜色：原味
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

                                                                <%--
                                                                <li class="td td-operation">
                                                                    <div class="item-operation">

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
                                                                    <p class="Mystatus">待发货</p>
                                                                    <%--<p class="order-info"><a href="${pageContext.request.contextPath }/user-seller-orderinfo-show?userOrderId=${orderUserResponse.orderId}">订单详情</a></p>--%>
                                                                    <%--<p class="order-info"><a href="#">查看物流</a></p>--%>
                                                                </div>
                                                            </li>
                                                            <li class="td td-change">
                                                                <a href="${pageContext.request.contextPath }/user-seller-orderinfo-show?userOrderId=${orderUserResponse.orderId}">
                                                                    <div class="am-btn am-btn-danger anniu">订单详情</div>
                                                                </a>
                                                            </li>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>

                        </div>

                        <%--待收货--%>
                        <div class="am-tab-panel am-fade" id="tab3">
                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">发货地</td>
                                </div>

                                <div class="th th-operation">
                                    <td class="td-inner">买家号码</td>
                                </div>

                               <%-- <div class="th th-price">
                                    <td class="td-inner">状态</td>
                                </div>--%>

                                <%--<div class="th th-number">
                                    <td class="td-inner">数量</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">商品操作</td>
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

                            <%--具体内容--%>
                            <div class="order-main">
                                <div class="order-list">

                                    <c:forEach items="${requestScope.fsOrderUserList }" var="orderUserResponse">
                                        <c:if test="${orderUserResponse.orderState == 3}">
                                            <div class="order-status5">
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
                                                                            <p class="info-little">颜色：原味
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

                                                                <%--
                                                                <li class="td td-operation">
                                                                    <div class="item-operation">

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
                                                                    <p class="Mystatus">待收货</p>
                                                                    <%--<p class="order-info"><a href="${pageContext.request.contextPath }/user-seller-orderinfo-show?userOrderId=${orderUserResponse.orderId}">订单详情</a></p>--%>
                                                                    <%--<p class="order-info"><a href="#">查看物流</a></p>--%>
                                                                </div>
                                                            </li>
                                                            <li class="td td-change">
                                                                <a href="${pageContext.request.contextPath }/user-seller-orderinfo-show?userOrderId=${orderUserResponse.orderId}">
                                                                    <div class="am-btn am-btn-danger anniu">订单详情</div>
                                                                </a>
                                                            </li>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>

                        </div>

                        <%--待评价--%>
                        <div class="am-tab-panel am-fade" id="tab4">
                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">发货地</td>
                                </div>

                                <div class="th th-operation">
                                    <td class="td-inner">买家号码</td>
                                </div>

                                <%--<div class="th th-price">
                                    <td class="td-inner">状态</td>
                                </div>--%>

                                <%--<div class="th th-number">
                                    <td class="td-inner">数量</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">商品操作</td>
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

                            <%--具体内容--%>
                            <div class="order-main">
                                <div class="order-list">

                                    <c:forEach items="${requestScope.fsOrderUserList }" var="orderUserResponse">
                                        <c:if test="${orderUserResponse.orderState == 4}">
                                            <div class="order-status5">
                                                <div class="order-title">
                                                    <div class="dd-num">订单编号：<a href="javascript:;">${orderUserResponse.orderNumber}</a></div>
                                                    <span>成交时间：<fmt:formatDate value="${orderUserResponse.payTime }" type="both"/></span>
                                                    <!--    <em>店铺：小桔灯</em>-->
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
                                                                            <p class="info-little">颜色：原味
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

                                                                <%--
                                                                <li class="td td-operation">
                                                                    <div class="item-operation">

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
                                                                    <p class="Mystatus">交易成功</p>
                                                                    <%--<p class="order-info"><a href="${pageContext.request.contextPath }/user-seller-orderinfo-show?userOrderId=${orderUserResponse.orderId}">订单详情</a></p>--%>
                                                                    <%--<p class="order-info"><a href="#">查看物流</a></p>--%>
                                                                </div>
                                                            </li>
                                                            <li class="td td-change">
                                                                <a href="${pageContext.request.contextPath }/user-seller-orderinfo-show?userOrderId=${orderUserResponse.orderId}">
                                                                    <div class="am-btn am-btn-danger anniu">订单详情</div>
                                                                </a>
                                                            </li>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
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

