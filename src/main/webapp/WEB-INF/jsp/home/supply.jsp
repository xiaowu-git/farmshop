<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>供应大厅</title>
    <%@include file="../common/head.jsp" %>

    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />

    <link href="${pageContext.request.contextPath }/resources/css/seastyle.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/basic/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/script.js"></script>
</head>

<body>

<!--顶部导航条 -->
<%@include file="../common/header.jsp" %>

<div class="clear"></div>
<b class="line"></b>
<div class="search" id="searchAll">
    <div class="search-list">
        <%@include file="../common/navtable.jsp" %>


        <div class="am-g am-g-fixed">
            <div class="am-u-sm-12 am-u-md-12">
                <div class="theme-popover">
                    <ul class="select">
                        <div class="clear"></div>
                        <%--<li class="select-result">--%>
                            <%--<dl>--%>
                                <%--<dt>已选</dt>--%>
                                <%--<dd class="select-no"></dd>--%>
                                <%--<p class="eliminateCriteria">清除</p>--%>
                            <%--</dl>--%>
                        <%--</li>--%>
                        <div class="clear"></div>
                        <li class="select-list">
                            <dl id="select2">
                                <dt class="am-badge am-round">种类</dt>
                                <div class="dd-conent">
                                    <dd class="select-all selected"><a href="${pageContext.request.contextPath }/supply-list?page=1">全部</a></dd>
                                    <c:forEach items="${requestScope.categoryList }" var="category">
                                        <dd><a href="${pageContext.request.contextPath}/getbycatgoryId?categoryId=${category.categoryId}&page=1">${category.categoryName }</a></dd>
                                    </c:forEach>
                                    <%--<dd><a href="#">蔬菜</a></dd>--%>
                                    <%--<dd><a href="#">水果</a></dd>--%>
                                </div>
                            </dl>
                        </li>
                    </ul>
                    <div class="clear"></div>
                </div>
                <div class="search-content">
                    <div class="sort">
                        <li class="first"><a title="综合">综合排序</a></li>
                        <li><a title="销量">销量排序</a></li>
                        <li><a title="价格">价格优先</a></li>
                    </div>
                    <div class="clear"></div>
                    <ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
                        <c:forEach items="${requestScope.pageSupplyProds }" var="pageSupplyProd">
                            <li>
                                <a href="${pageContext.request.contextPath }/user-supplyProd-show?supplyProdId=${pageSupplyProd.supplyProdId}">
                                    <div class="i-pic limit">
                                        <img src="${pageContext.request.contextPath }/${pageSupplyProd.supplyProdPicture}" href="#"/>
                                        <p class="title fl">${pageSupplyProd.supplyProdName}</p>
                                        <p class="price fl">
                                            <b>￥</b>
                                            <strong>${pageSupplyProd.supplyProdPrice}</strong>
                                        </p>
                                        <p class="number fl">
                                            库存<span>${pageSupplyProd.supplyProdNum} 斤</span>
                                        </p>
                                    </div>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="clear"></div>
                <!--分页 -->
                <c:if test="${requestScope.pagePoint != null}">
                    <ul class="am-pagination am-pagination-right" id="supply_page">
                        <li class=""><a href="${pageContext.request.contextPath }/supply-list?page=${requestScope.pagePoint - 1 }">«</a></li>
                        <li class="am-active"><a>当前第${requestScope.pagePoint }页(共${requestScope.pageMax }页)</a></li>
                        <li><a href="${pageContext.request.contextPath }/supply-list?page=${requestScope.pagePoint + 1 }">&raquo;</a></li>
                    </ul>
                </c:if>
            </div>

        </div>
        <%@include file="../common/footer.jsp" %>

</div>

<!--引导 -->
    <%@include file="../common/navcir.jsp" %>

<!--菜单 -->
    <%--<%@include file="../common/menuright.jsp" %>--%>

</div>
<script>
    window.jQuery || document.write('<script src=\"/resources/basic/js/jquery-1.9.min.js"><\/script>');
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/basic/js/quick_links.js"></script>

<div class="theme-popover-mask"></div>

</body>
</html>
