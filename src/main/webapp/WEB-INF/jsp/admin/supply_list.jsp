<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>供应列表</title>
    <%@include file="admin_head.jsp" %>
    <style>
        th {
            text-align: center;
        }

        td {
            text-align: center;
        }
    </style>

</head>

<body data-type="widgets">
<!-- 加载顶部导航栏 -->
<jsp:include page="admin_header.jsp"/>
<!-- 加载侧边导航栏 -->
<jsp:include page="admin_comlist.jsp"/>

<!-- 内容区域 -->
<div class="tpl-content-wrapper">
    <div class="row-content am-cf">
        <div class="row">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title  am-cf">供应列表</div>
                    </div>
                    <div class="widget-body  am-fr">
                        <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                            <div class="am-form-group"></div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                            <div class="am-form-group tpl-table-list-select">
                                <%--<select id="supply-select" data-am-selected="{maxHeight: 200}" style="display: none;" onchange="supplyselect()">
                                    <option value="0">所有类别</option>
                                    <option value="1">待审核</option>
                                    <option value="2">已审核</option>
                                    <option value="3">已下架</option>
                                </select>--%>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                            <form action="${pageContext.request.contextPath }/admin-supply-search-show" method="get">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" class="am-form-field" name="supplyProdName" placeholder="请输入产品名称">
                                    <span class="am-input-group-btn">
            								<button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
                                                    type="submit"></button>
         								</span>
                                </div>
                            </form>
                        </div>
                        <div class="am-u-sm-12">
                            <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black ">
                                <thead>
                                <tr>
                                    <th>商品图片</th>
                                    <th>商品名称</th>
                                    <th>价格</th>
                                    <th>库存</th>
                                    <th>发布时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${requestScope.pageSupplyProds }" var="pageSupplyProd">
                                    <tr class="gradeX">
                                        <td>
                                            <img src="${pageContext.request.contextPath }/${pageSupplyProd.supplyProdPicture}" class="tpl-table-line-img" alt="">
                                        </td>
                                        <td class="am-text-middle">${pageSupplyProd.supplyProdName}</td>
                                        <td class="am-text-middle">${pageSupplyProd.supplyProdPrice}</td>
                                        <td class="am-text-middle">${pageSupplyProd.supplyProdNum}</td>
                                        <td class="am-text-middle"><fmt:formatDate value="${pageSupplyProd.effectiveTime }" type="both"/></td>
                                        <td class="am-text-middle">
                                            <div class="tpl-table-black-operation">
                                                <c:if test="${pageSupplyProd.supplyProdState == 1}">
                                                <a href="${pageContext.request.contextPath }/admin-supply-audit-execute/${pageSupplyProd.supplyProdId}/2">
                                                    <i class="am-icon-pencil"></i> 审核通过
                                                    </a>
                                                <a href="${pageContext.request.contextPath }/admin-supply-audit-execute/${pageSupplyProd.supplyProdId}/3">
                                                    <i class="am-icon-pencil"></i> 审核不通过
                                                </a>
                                                </c:if>

                                                <c:if test="${pageSupplyProd.supplyProdState == 2}">
                                                <a href="javascript:void(0);" class="tpl-table-black-operation-open">
                                                    <i class="am-icon-check-circle"></i> 已通过
                                                </a>
                                                </c:if>
                                                <c:if test="${pageSupplyProd.supplyProdState == 3}">
                                                    <a href="javascript:void(0);" class="tpl-table-black-operation-del">
                                                        <i class="am-icon-times-circle"></i> 不通过
                                                    </a>
                                                </c:if>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>




                        </div>
                        <c:if test="${requestScope.pagePoint != null}">
                            <div class="am-u-lg-12 am-cf" style="font-size:14px;">
                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li>
                                            <a href="${pageContext.request.contextPath }/admin-supply-list-show?page=${requestScope.pagePoint - 1}&state=${requestScope.state}">«</a>
                                        </li>
                                        <li><a>当前第${requestScope.pagePoint }页(共${requestScope.pageMax }页)</a></li>
                                        <li><a href="#!" id="skipBtn"> 跳转到&nbsp;<input type="text" name="pagePoint"
                                                                                       style="width:20px;height: 14px; color:black; font-size: 10px;">&nbsp;页</a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath }/admin-supply-list-show?page=${requestScope.pagePoint + 1}&state=${requestScope.state}">»</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath }/resources/background/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/background/js/app.js"></script>
<script type="text/javascript">
    $(function () {
        $("#skipBtn").on("click", function () {
            var page = $("#skipBtn > input").val();
            if (page == "") {
                page = 1;
            }
            window.location = "${pageContext.request.contextPath}/admin-supply-list-show?page=" + page;
        });
        $("#skipBtn > input").on("click", function () {
            return false;
        });
    })
    
    function supplyselect() {
        var farmstudyType=$('#supply-select option:selected').val();
        alert(farmstudyType)
    }

</script>

</body>

</html>
