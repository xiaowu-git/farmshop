<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>采购大厅</title>
    <%@include file="../common/head.jsp" %>

    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />

    <link href="${pageContext.request.contextPath }/resources/css/seastyle.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/basic/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/script.js"></script>
    <%--<style type="text/css">
        #procurement-prod-table {

        }
    </style>--%>
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
                       <%-- <li class="select-result">
                            <dl>
                                <dt>已选</dt>
                                <dd class="select-no"></dd>
                                <p class="eliminateCriteria">清除</p>
                            </dl>
                        </li>--%>
                        <div class="clear"></div>
                        <li class="select-list">
                            <dl id="select2">
                                <dt class="am-badge am-round">种类</dt>
                                <div class="dd-conent">
                                    <dd class="select-all ${requestScope.categoryId == null ? 'selected' : ''}"><a href="${pageContext.request.contextPath }/procurement-list?page=1">全部</a></dd>
                                    <c:forEach items="${requestScope.categoryList}" var="category">
                                        <dd><a class="${category.categoryId == requestScope.categoryId ? 'selected' : ''}" href="${pageContext.request.contextPath }/getBycategory?page=1&categoryId=${category.categoryId}">${category.categoryName}</a></dd>
                                    </c:forEach>
                                    <%--<dd><a href="#">水果</a></dd>--%>
                                </div>
                            </dl>
                        </li>
                    </ul>
                    <div class="clear"></div>
                </div>



                <div class="search-content">
                    <%--<div class="sort">--%>
                        <%--<li class="first"><a title="综合">综合排序</a></li>--%>
                        <%--<li><a title="销量">销量排序</a></li>--%>
                        <%--<li><a title="价格">价格优先</a></li>--%>
                    <%--</div>--%>
                    <div class="clear"></div>

                    <!--交易时间	-->

                    <%--<div class="order-time">
                        <label class="form-label" for="transaction-time">交易时间：</label>
                        <div class="show-input" id="transaction-time">
                            <select class="am-selected" data-am-selected>
                                <option value="today">今天</option>
                                <option value="sevenDays" selected="">最近一周</option>
                                <option value="oneMonth">最近一个月</option>
                                <option value="threeMonths">最近三个月</option>
                                <option class="date-trigger">自定义时间</option>
                            </select>
                        </div>
                        <div class="clear"></div>
                    </div>--%>

                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="procurement-prod-table" style="vertical-align:middle">

                        <thead>
                        <tr>
                            <th class="memo">类别</th>
                            <th class="name">采购项目</th>
                            <th class="number">采购数量</th>
                            <th class="time">发布时间</th>
                            <th class="time">截至时间</th>
                            <th class="name">买家</th>
                            <th class="action">操作</th>
                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach items="${requestScope.pageprocurementProds }" var="pageprocurementProd">
                            <tr>
                                <td class="img" style="text-align: center">
                                    <i><img src="${pageContext.request.contextPath }/${pageprocurementProd.procurementProdPicture}"
                                            style="width: 100%;max-width: 50px;border-radius: 50px;"></i>
                                </td>
                                <td class="am-text-middle">${pageprocurementProd.procurementProdName}</td>
                                <td class="am-text-middle">${pageprocurementProd.procurementProdNum}</td>
                                <td class="am-text-middle"><fmt:formatDate value="${pageprocurementProd.effectiveTime }" type="both"/></td>
                                <td class="am-text-middle"><fmt:formatDate value="${pageprocurementProd.expirationTime }" type="both"/></td>
                                <td class="am-text-middle">${pageprocurementProd.userId}</td>
                                <td class="am-text-middle">
                                    <div class="tpl-table-black-operation">
                                        <a href="${pageContext.request.contextPath }/procurement-tail-show?procurementProductsId=${pageprocurementProd.procurementProdId}">
                                            <i class="am-icon-eye"></i> 查 看
                                        </a>
                                    </div>
                                </td>
                            </tr>

                        </c:forEach>

                        </tbody>
                    </table>
                </div>

                <div class="clear"></div>
                <!--分页 -->
                <c:if test="${requestScope.pagePoint != null}">
                    <ul class="am-pagination am-pagination-right" id="procurement_page">
                        <li class=""><a href="${pageContext.request.contextPath }/procurement-list?page=${requestScope.pagePoint - 1 }">«</a></li>
                        <li class="am-active"><a>当前第${requestScope.pagePoint }页(共${requestScope.pageMax }页)</a></li>
                        <li><a href="${pageContext.request.contextPath }/procurement-list?page=${requestScope.pagePoint + 1 }">&raquo;</a></li>
                    </ul>
                </c:if>
            </div>

        </div>
        <%@include file="../common/footer.jsp" %>

    </div>

    <!--引导 -->
    <%@include file="../common/navcir.jsp" %>


</div>
<script>
    window.jQuery || document.write('<script src=\"/resources/basic/js/jquery-1.9.min.js"><\/script>');
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/basic/js/quick_links.js"></script>

<div class="theme-popover-mask"></div>

</body>
</html>
