<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>资讯列表</title>
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
                        <div class="widget-title  am-cf">资讯列表</div>
                    </div>
                    <div class="widget-body  am-fr">
                        <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                            <div class="am-form-group">
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <a href="admin-farmnews-addFarmnews-show" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                            <div class="am-form-group"></div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                            <div class="am-form-group tpl-table-list-select">
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                            <form action="${pageContext.request.contextPath }/admin-farmnews-search-show" method="get">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" class="am-form-field" name="farmnewsName" placeholder="请输入资讯标题">
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
                                    <th>资讯图片</th>
                                    <th>资讯标题</th>
                                    <th>作者</th>
                                    <th>分类</th>
                                    <th>发布时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${requestScope.pageFarmnews }" var="farmnews">
                                    <tr class="gradeX">
                                        <td>
                                            <img src="${pageContext.request.contextPath }/${farmnews.farmnewsPicture}" class="tpl-table-line-img" alt="">
                                        </td>

                                        <td class="am-text-middle">${farmnews.farmnewsName}</td>
                                        <c:forEach items="${adminList}" var="admin">
                                            <c:if test="${admin.adminId == farmnews.userId}">
                                                <td class="am-text-middle">${admin.adminName}</td>
                                            </c:if>
                                        </c:forEach>
                                        <%--<td class="am-text-middle">${farmnews.categoryId}</td>--%>
                                        <td class="am-text-middle"><fmt:formatDate value="${farmnews.effectiveTime }" pattern="yyyy-MM-dd" type="both"/></td>
                                        <td class="am-text-middle">
                                            <div class="tpl-table-black-operation">
                                                <a href="${pageContext.request.contextPath }/admin-farmnews-edit-show/${farmnews.farmnewsId}">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="${pageContext.request.contextPath }/admin-farmnews-remove-execute/${farmnews.farmnewsId}" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
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
                                            <a href="${pageContext.request.contextPath }/admin-farmnews-list-show?page=${requestScope.pagePoint - 1 }">«</a>
                                        </li>
                                        <li><a>当前第${requestScope.pagePoint }页(共${requestScope.pageMax }页)</a></li>
                                        <li><a href="#!" id="skipBtn"> 跳转到&nbsp;<input type="text" name="pagePoint"
                                                                                       style="width:20px;height: 14px; color:black; font-size: 10px;">&nbsp;页</a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath }/admin-farmnews-list-show?page=${requestScope.pagePoint + 1 }">»</a>
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
            window.location = "${pageContext.request.contextPath}/admin-farmnews-list-show?page=" + page;
        });
        $("#skipBtn > input").on("click", function () {
            return false;
        });
    })

</script>

</body>

</html>