<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="menu">
    <ul>
        <li class="person" id="userindex">
            <a href="${pageContext.request.contextPath }/userindex">个人中心</a>
        </li>
        <li class="person">
            <a href="${pageContext.request.contextPath }/user-idcard-show">个人资料</a>
            <ul>
                <li id="idcard"> <a href="${pageContext.request.contextPath }/user-idcard-show">实名认证</a></li>
                <li id="userinfo"> <a href="${pageContext.request.contextPath }/userinfo">个人信息</a></li>
                <%--<li> <a href="safety.html">安全设置</a></li>
                <li> <a href="address.html">收货地址</a></li>--%>
            </ul>
        </li>
        <li class="person">
            <a href="#">我的发布</a>
            <ul>
                <li id="wanttosupply"> <a href="${pageContext.request.contextPath }/user-wanttosupply-show">我要供应</a></li>
                <li id="wanttoprocurement"> <a href="${pageContext.request.contextPath }/user-wanttoprocurement-show">我要采购</a></li>
                <li id="usersupplylist"> <a href="${pageContext.request.contextPath }/user-supply-list">我的供应</a></li>
                <li id="userprocurementlist"> <a href="${pageContext.request.contextPath }/user-procurement-list">我的采购</a></li>
            </ul>
        </li>
        <li class="person">
            <a href="#">我的交易</a>
            <ul>
                <li id="sellerorder"><a href="${pageContext.request.contextPath }/user-sellerorder-list">出售订单</a></li>
                <li id="userorder"><a href="${pageContext.request.contextPath }/user-order-list">购买订单</a></li>
                <li id="orderchange"> <a href="${pageContext.request.contextPath }/user-orderchange-list">退款售后</a></li>
            </ul>
        </li>
        <li class="person">
            <a href="#">我的资产</a>
            <ul>
                <li id="userburse"> <a href="#">我的账户</a></li>
                <li id="userbill"> <a href="#">账单明细</a></li>
            </ul>
        </li>

        <%--<li class="person">
            <a href="#">我的小窝</a>
            <ul>
                <li> <a href="#">我的收藏</a></li>
                <li> <a href="#">购物车</a></li>
            </ul>
        </li>--%>

    </ul>


</aside>

<script type="text/javascript">
    var nav = "${requestScope.nav}";
    var elem = "#" + nav;
    if (nav == "admin-list" || nav == "admin-message") {
        $(elem).attr("class", "sub-active");
    } else {
        $(elem).attr("class", "active");
    }
</script>
