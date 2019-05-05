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
                    <%--<ul class="select">
                        <div class="clear"></div>
                        <li class="select-result">
                            <dl>
                                <dt>已选</dt>
                                <dd class="select-no"></dd>
                                <p class="eliminateCriteria">清除</p>
                            </dl>
                        </li>
                        <div class="clear"></div>
                        <li class="select-list">
                            <dl id="select2">
                                <dt class="am-badge am-round">种类</dt>
                                <div class="dd-conent">
                                    <dd class="select-all selected"><a href="#">全部</a></dd>
                                    <dd><a href="#">蔬菜</a></dd>
                                    <dd><a href="#">水果</a></dd>
                                </div>
                            </dl>
                        </li>
                    </ul>--%>
                    <div class="clear"></div>
                </div>



                <div class="search-content">
                    <div class="sort">
                        <%--<li class="first"><a title="综合">综合排序</a></li>
                        <li><a title="销量">销量排序</a></li>
                        <li><a title="价格">价格优先</a></li>--%>
                    </div>
                    <div class="clear"></div>

                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="procurement-prod-table" style="vertical-align:middle">

                        <thead>
                        <tr>
                            <th class="memo">市场行情</th>
                            <th class="name">产品类别</th>
                            <th class="name">所在产地</th>
                            <th class="time">统计时间</th>
                            <th class="name">平均价格</th>
                            <th class="action">操作</th>
                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach items="${requestScope.pagefsMarketinfos }" var="pagefsMarketinfo">
                            <tr>
                                <td class="img" style="text-align: center">
                                    <i><img src="${pageContext.request.contextPath }/resources/images/songzi.jpg"
                                            style="width: 100%;max-width: 50px;border-radius: 50px;"></i>
                                </td>
                                <td class="am-text-middle">${pagefsMarketinfo.marketinfoName}</td>
                                <td class="am-text-middle">${pagefsMarketinfo.marketinfoAddress}</td>
                                <td class="am-text-middle"><fmt:formatDate value="${pagefsMarketinfo.effectiveTime }" type="both"/></td>
                                <td class="am-text-middle">${pagefsMarketinfo.marketinfoProdPrice} /斤</td>
                                <td class="am-text-middle">
                                    <div class="tpl-table-black-operation">
                                        <%--<a href="${pageContext.request.contextPath }/user-marketinfo-show?marketinfoId=${pagefsMarketinfo.marketinfoId}">
                                            <i class="am-icon-eye"></i> 查 看
                                        </a>--%>
                                            <a href="#">
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
                    <ul class="am-pagination am-pagination-right" id="marketinfo_page">
                        <li class=""><a href="${pageContext.request.contextPath }/marketinfo-list?page=${requestScope.pagePoint - 1 }">«</a></li>
                        <li class="am-active"><a>当前第${requestScope.pagePoint }页(共${requestScope.pageMax }页)</a></li>
                        <li><a href="${pageContext.request.contextPath }/marketinfo-list?page=${requestScope.pagePoint + 1 }">&raquo;</a></li>
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

