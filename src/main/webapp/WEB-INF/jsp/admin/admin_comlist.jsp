
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- 侧边导航栏 -->
<div class="left-sidebar">
    <!-- 用户信息 -->
    <div class="tpl-sidebar-user-panel">
        <div class="tpl-user-panel-slide-toggleable">
            <div class="tpl-user-panel-profile-picture">
                <img src="${pageContext.request.contextPath }/resources/background/img/admin3.png" alt="">
            </div>
            <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
              ${sessionScope.admin.adminName }
          </span>
            <a href="${pageContext.request.contextPath }/admin-index-edit-show" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
        </div>
    </div>
    <!-- 菜单 -->
    <ul class="sidebar-nav">
        <li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-index-index-show" id="index">
                <i class="am-icon-home sidebar-nav-link-logo"></i> 首  页
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-member-list-show?page=1" id="user">
                <i class="am-icon-user sidebar-nav-link-logo"></i> 用 户 管 理
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="javascript:;" class="sidebar-nav-sub-title" id="supply">
                <i class="am-icon-product-hunt sidebar-nav-link-logo"></i> 供 应 管 理
                <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
            </a>
            <ul class="sidebar-nav sidebar-nav-sub">
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath }/admin-supply-list-show?page=1&state=1" id="supply1">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 待审核
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath }/admin-supply-list-show?page=1&state=2" id="supply2">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 已审核
                    </a>
                </li>
                <li class="sidebar-nav-link">
                <a href="${pageContext.request.contextPath }/admin-supply-list-show?page=1&state=3" id="supply3">
                    <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 已下架
                </a>
            </li>
            </ul>
        </li>

        <li class="sidebar-nav-link">
            <a href="javascript:;" class="sidebar-nav-sub-title" id="procurement">
                <i class="am-icon-product-hunt sidebar-nav-link-logo"></i> 采 购 管 理
                <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
            </a>
            <ul class="sidebar-nav sidebar-nav-sub">
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath }/admin-procurement-list-show?page=1&state=1" id="procurement1">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 待审核
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath }/admin-procurement-list-show?page=1&state=2" id="procurement2">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 已审核
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath }/admin-procurement-list-show?page=1&state=3" id="procurement3">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 已下架
                    </a>
                </li>
            </ul>
        </li>

        <%--<li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-procurement-list-show?page=1" id="procurement">
                <i class="am-icon-shopping-cart sidebar-nav-link-logo"></i> 采购
            </a>
        </li>--%>
        <li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-market-list-show?page=1" id="market">
                <i class="am-icon-line-chart sidebar-nav-link-logo"></i> 行 情 信 息
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-farmnews-list-show?page=1" id="farmnews">
                <i class="am-icon-newspaper-o sidebar-nav-link-logo"></i> 行 业 资 讯
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-farmstudy-list-show?page=1" id="farmstudy">
                <i class="am-icon-newspaper-o sidebar-nav-link-logo"></i> 助 农 学 堂
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-order-list-show?page=1" id="order">
                <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 订 单 列 表
            </a>
        </li>
        <%--<li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-recharge-list-show?page=1" id="recharge">
                <i class="am-icon-jpy sidebar-nav-link-logo"></i> 充值
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-coupon-list-show?page=1" id="coupon">
                <i class="am-icon-paper-plane sidebar-nav-link-logo"></i> 优惠券
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-feedback-list-show?page=1" id="userFeedback">
                <i class="am-icon-comments sidebar-nav-link-logo"></i> 用户反馈
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath }/admin-feedback-list-show?page=1" id="report">
                <i class="am-icon-pie-chart sidebar-nav-link-logo"></i> 业绩报表
            </a>
        </li>--%>
        <li class="sidebar-nav-link">
            <a href="javascript:;" class="sidebar-nav-sub-title">
                <i class="am-icon-street-view sidebar-nav-link-logo"></i> 管理员
                <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
            </a>
            <ul class="sidebar-nav sidebar-nav-sub">
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath }/admin-admin-list-show?page=1" id="admin-list">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 管理员列表
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath }/admin-admin-register-show" id="admin-register">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 添加管理员
                    </a>
                </li>
            </ul>
        </li>
    </ul>
</div>


<script type="text/javascript">
    var nav = "${requestScope.nav}";
    var elem = "#" + nav;
    if (nav == "admin-list" || nav == "admin-message") {
        $(elem).attr("class", "sub-active");
    } else {
        $(elem).attr("class", "active");
    }
</script>
