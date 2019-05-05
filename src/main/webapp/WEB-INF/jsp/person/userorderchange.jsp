<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>退换货管理</title>

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
                    <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">退换货管理</strong> / <small>Change</small></div>
                </div>
                <hr/>

                <div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

                    <ul class="am-avg-sm-2 am-tabs-nav am-nav am-nav-tabs">
                        <li class="am-active"><a href="#tab1">退款管理</a></li>
                        <li><a href="#tab2">售后管理</a></li>

                    </ul>

                    <div class="am-tabs-bd">
                        <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-orderprice th-price">
                                    <td class="td-inner">交易金额</td>
                                </div>
                                <div class="th th-changeprice th-price">
                                    <td class="td-inner">退款金额</td>
                                </div>
                                <div class="th th-status th-moneystatus">
                                    <td class="td-inner">交易状态</td>
                                </div>
                                <div class="th th-change th-changebuttom">
                                    <td class="td-inner">交易操作</td>
                                </div>
                            </div>

                            <div class="order-main">
                                <div class="order-list">
                                    <c:forEach items="${requestScope.orderChangeList }" var="orderUserResponse">
                                    <div class="order-title">
                                        <div class="dd-num">退款编号：<a href="javascript:;">${orderUserResponse.orderNumber}</a></div>
                                        <span>申请时间：<fmt:formatDate value="${orderUserResponse.expirationTime}" type="both"/></span>
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

                                                <ul class="td-changeorder">
                                                    <li class="td td-orderprice">
                                                        <div class="item-orderprice">
                                                            <span>交易金额：</span>${orderUserResponse.orderAmount}
                                                        </div>
                                                    </li>
                                                    <li class="td td-changeprice">
                                                        <div class="item-changeprice">
                                                            <span>退款金额：</span>${orderUserResponse.orderAmount}
                                                        </div>
                                                    </li>
                                                </ul>
                                                <div class="clear"></div>
                                            </ul>

                                            <div class="change move-right">
                                                <li class="td td-moneystatus td-status">
                                                    <div class="item-status">
                                                        <p class="Mystatus">退款成功</p>

                                                    </div>
                                                </li>
                                            </div>
                                            <li class="td td-change td-changebutton">
                                                <a href="record.html">
                                                    <div class="am-btn am-btn-danger anniu">
                                                        钱款去向</div>
                                                </a>
                                            </li>

                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>

                            </div>

                        </div>
                        <div class="am-tab-panel am-fade" id="tab2">
                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-orderprice th-price">
                                    <td class="td-inner">交易金额</td>
                                </div>
                                <div class="th th-changeprice th-price">
                                    <td class="td-inner">退款金额</td>
                                </div>
                                <div class="th th-status th-moneystatus">
                                    <td class="td-inner">交易状态</td>
                                </div>
                                <div class="th th-change th-changebuttom">
                                    <td class="td-inner">交易操作</td>
                                </div>
                            </div>

                            <%--<div class="order-main">
                                <div class="order-list">
                                    <div class="order-title">
                                        <div class="dd-num">退款编号：<a href="javascript:;">1601430</a></div>
                                        <span>申请时间：2015-12-20</span>
                                        <!--    <em>店铺：小桔灯</em>-->
                                    </div>
                                    <div class="order-content">
                                        <div class="order-left">
                                            <ul class="item-list">
                                                <li class="td td-item">
                                                    <div class="item-pic">
                                                        <a href="#" class="J_MakePoint">
                                                            <img src="../images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg">
                                                        </a>
                                                    </div>
                                                    <div class="item-info">
                                                        <div class="item-basic-info">
                                                            <a href="#">
                                                                <p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
                                                                <p class="info-little">颜色：12#川南玛瑙
                                                                    <br/>包装：裸装 </p>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </li>

                                                <ul class="td-changeorder">
                                                    <li class="td td-orderprice">
                                                        <div class="item-orderprice">
                                                            <span>交易金额：</span>72.00
                                                        </div>
                                                    </li>
                                                    <li class="td td-changeprice">
                                                        <div class="item-changeprice">
                                                            <span>退款金额：</span>70.00
                                                        </div>
                                                    </li>
                                                </ul>
                                                <div class="clear"></div>
                                            </ul>

                                            <div class="change move-right">
                                                <li class="td td-moneystatus td-status">
                                                    <div class="item-status">
                                                        <p class="Mystatus">退款成功</p>

                                                    </div>
                                                </li>
                                            </div>
                                            <li class="td td-change td-changebutton">
                                                <a href="record.html">
                                                    <div class="am-btn am-btn-danger anniu">
                                                        钱款去向</div>
                                                </a>
                                            </li>

                                        </div>
                                    </div>
                                </div>
                            </div>--%>

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
