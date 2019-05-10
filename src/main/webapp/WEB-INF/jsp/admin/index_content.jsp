<%--
  Created by IntelliJ IDEA.
  User: zhongjh
  Date: 2019/4/13 0013
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>助农电商平台后台管理</title>
    <%@include file="admin_head.jsp" %>
    <script src="${pageContext.request.contextPath }/resources/background/js/echarts.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/background/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/background/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/background/css/app.css">
    <script src="${pageContext.request.contextPath }/resources/background/js/jquery.min.js"></script>
</head>

<body data-type="index">
<div class="am-g tpl-g">
    <!-- 加载顶部导航栏 -->
    <jsp:include page="admin_header.jsp"/>
    <!-- 加载侧边导航栏 -->
    <jsp:include page="admin_comlist.jsp"/>

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span>
                        助农电商平台后台管理主页
                    </div>
                </div>
            </div>
        </div>
        <div class="row-content am-cf">
            <div class="row  am-cf">
                <%--<div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">实时数据信息</div>
                            <div class="widget-function am-fr">
                            </div>
                        </div>
                        <div class="widget-body am-fr">
                            <div class="am-fl">
                                <div class="widget-fluctuation-description-amount text-success" am-cf
                                     style="font-size: 14px;">
                                    今日用户充值金额: ${requestScope.rechargeCount} |今日已消费金额: ${requestScope.borrowCost }
                                    <br>
                                    当前供应产品数: ${requestScope.carCountOrder } |当前采购产品数: ${requestScope.carCountUsing }
                                    <br>
                                    当前发布市场行情数: ${requestScope.carCountGreen}| 当前发布行业资讯数: ${requestScope.carCountRed}
                                    <!-- <button class="widget-fluctuation-tpl-btn"><i class="am-icon-calendar"></i>更多记录</button> -->
                                </div>
                            </div>
                            <div class="am-fr am-cf">
                                <div class="widget-fluctuation-description-amount text-success" am-cf
                                     style="font-size: 18px;">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>--%>
                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                    <div class="widget widget-primary am-cf">
                        <div class="widget-statistic-header">
                            当前总用户量
                        </div>
                        <div class="widget-statistic-body">
                            <div class="widget-statistic-value">
                                ${requestScope.userCount }
                            </div>
                        </div>
                        <div class="widget-statistic-description">
                            <a href="${pageContext.request.contextPath }/admin-member-list-show?page=1"
                               style="color:#9cdcf2;">点击查看用户列表与更多用户相关操作</a>
                        </div>
                        <span class="widget-statistic-icon am-icon-user"></span>
                    </div>
                </div>
                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                    <div class="widget widget-purple am-cf">
                        <div class="widget-statistic-header">
                            当前商品总量
                        </div>
                        <div class="widget-statistic-body">
                            <div class="widget-statistic-value">
                                ${requestScope.supplyCount }
                            </div>
                            <div class="widget-statistic-description">
                                <a href="${pageContext.request.contextPath }/admin-supply-list-show?page=1&state=1"
                                   style="color:#ded5e7;">点击查看供应列表</a>
                            </div>
                            <span class="widget-statistic-icon am-icon-product-hunt"></span>
                        </div>
                    </div>
                </div>

            </div>
            <%--<div class="row am-cf">
                <div class="am-u-sm-12 am-u-md-8">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">月度财务收支计划</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body-md widget-body tpl-amendment-echarts am-fr" id="tpl-echarts">

                        </div>
                    </div>
                </div>

                <div class="am-u-sm-12 am-u-md-4">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">专用服务器负载</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body widget-body-md am-fr">

                            <div class="am-progress-title">CPU Load <span class="am-fr am-progress-title-more">28% / 100%</span></div>
                            <div class="am-progress">
                                <div class="am-progress-bar" style="width: 15%"></div>
                            </div>
                            <div class="am-progress-title">CPU Load <span class="am-fr am-progress-title-more">28% / 100%</span></div>
                            <div class="am-progress">
                                <div class="am-progress-bar  am-progress-bar-warning" style="width: 75%"></div>
                            </div>
                            <div class="am-progress-title">CPU Load <span class="am-fr am-progress-title-more">28% / 100%</span></div>
                            <div class="am-progress">
                                <div class="am-progress-bar am-progress-bar-danger" style="width: 35%"></div>
                            </div>
                        </div>
                    </div>
                </div>--%>
            </div>


            <div class="row am-cf">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-4 widget-margin-bottom-lg ">
                    <div class="tpl-user-card am-text-center widget-body-lg">
                        <div class="tpl-user-card-title" style="font-size: 20px;">
                            员工证
                        </div>
                        <img class="achievement-image" src="${pageContext.request.contextPath }/resources/background/img/admin3.png"
                             alt="" width=80 height=80>
                        <div class="achievement-subheading">
                            <p style="font-size:18px; font-weight: bold;">${sessionScope.admin.adminName }</p>
                        </div>
                        <div class="achievement-description" style="text-align: left; margin-left: 20px;">
                            <p style="font-size:16px">管理员编号：${sessionScope.admin.adminId }</p>
                            <p style="font-size:16px">联系号码：${sessionScope.admin.adminPhone }</p>
                            <p style="font-size: 16px">联系邮箱：${sessionScope.admin.adminEmail }</p>
                        </div>
                    </div>
                </div>

                <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 widget-margin-bottom-lg">

                    <div class="widget am-cf widget-body-lg">

                        <div class="widget-body  am-fr">
                            <div class="am-scrollable-horizontal ">
                                <table width="100%" class="am-table am-table-compact am-text-nowrap tpl-table-black " id="example-r">
                                    <thead>
                                    <tr>
                                        <th>惠农资讯</th>
                                        <th>作者</th>
                                        <th>时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.fsFarmnewsListIndex }" var="news">
                                        <tr class="gradeX">
                                            <td>${news.farmnewsTitle }</td>
                                            <td>
                                                <c:forEach items="${adminList}" var="admin">
                                                    <c:if test="${admin.adminId == news.userId}">
                                                        ${admin.adminName}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td><fmt:formatDate value="${news.effectiveTime}" type="both"/></td>
                                            <td>
                                                <div class="tpl-table-black-operation">
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i> 编辑
                                                    </a>
                                                    <a href="javascript:;" class="tpl-table-black-operation-del">
                                                        <i class="am-icon-trash"></i> 删除
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

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
</body>

</html>
