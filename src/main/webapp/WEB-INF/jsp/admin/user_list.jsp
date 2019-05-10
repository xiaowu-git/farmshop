<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>用户列表</title>
    <%@include file="admin_head.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/background/css/amazeui.datatables.min.css" />
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
                        <div class="widget-title  am-cf">用户列表</div>
                    </div>
                    <div class="widget-body  am-fr">
                        <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                            <div class="am-form-group"></div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                            <div class="am-form-group tpl-table-list-select">
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                            <form action="${pageContext.request.contextPath }/admin-member-search-show" method="get">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" class="am-form-field" name="username" placeholder="请输入用户名">
                                    <span class="am-input-group-btn">
            								<button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
                                                    type="submit"></button>
         								</span>
                                </div>
                            </form>
                        </div>
                        <div class="am-u-sm-12">
                            <div class="am-scrollable-horizontal ">
                                <table width="100%" class="am-table am-table-compact am-table-hover am-table-bordered am-table-striped tpl-table-black" id="example-r">
                                    <thead>
                                    <tr>
                                        <th>用户编号</th>
                                        <th>用户手机</th>
                                        <th>用户姓名</th>
                                        <%--<th>用户邮箱</th>--%>
                                        <th>身份证</th>
                                        <%--<th>信用度</th>--%>
                                        <th>注册时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.pageUsers }" var="users">
                                        <tr class="gradeX">
                                            <td class="am-text-middle">${users.userId}</td>
                                            <td class="am-text-middle">${users.userPhone}</td>
                                            <td class="am-text-middle">${users.userName}</td>
                                                <%--<td class="am-text-middle">${users.userEmail}</td>--%>
                                            <td class="am-text-middle">${users.userIdcard}</td>
                                            <td class="am-text-middle"><fmt:formatDate value="${users.userCreateTime}" type="both"/></td>
                                                <%--<td class="am-text-middle">${users.userCash}</td>--%>
                                            <td class="am-text-middle">
                                                <div class="tpl-table-black-operation">
                                                        <%--<a href="${pageContext.request.contextPath }/admin-user-resetcredit-execute/${users.userId }">信用重置</a>--%>
                                                    <c:choose>
                                                        <c:when test="${users.isDeleted == '1'}">
                                                            <a href="admin-admin-removemember-execute/${users.userId}" class="tpl-table-black-operation-open">启用</a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="admin-admin-removemember-execute/${users.userId}" class="tpl-table-black-operation-del">禁用</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <c:if test="${requestScope.pagePoint != null}">
                            <div class="am-u-lg-12 am-cf" style="font-size:14px;">
                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li>
                                            <a href="${pageContext.request.contextPath }/admin-member-list-show?page=${requestScope.pagePoint - 1 }">«</a>
                                        </li>
                                        <li><a>当前第${requestScope.pagePoint }页(共${requestScope.pageMax }页)</a></li>
                                        <li><a href="#!" id="skipBtn"> 跳转到&nbsp;<input type="text" name="pagePoint"
                                                                                       style="width:20px;height: 14px; color:black; font-size: 10px;">&nbsp;页</a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath }/admin-member-list-show?page=${requestScope.pagePoint + 1 }">»</a>
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
<script src="${pageContext.request.contextPath }/resources/background/js/amazeui.datatables.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/background/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/background/js/app.js"></script>
<script type="text/javascript">
    $(function () {
        $("#skipBtn").on("click", function () {
            var page = $("#skipBtn > input").val();
            if (page == "") {
                page = 1;
            }
            window.location = "${pageContext.request.contextPath}/admin-member-list-show?page=" + page;
        });
        $("#skipBtn > input").on("click", function () {
            return false;
        });
    })

</script>

</body>

</html>
