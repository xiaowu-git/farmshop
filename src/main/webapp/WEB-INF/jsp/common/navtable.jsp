<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导航栏--%>
<div class="nav-table">
    <div class="long-title"><span class="all-goods">全部分类</span></div>
    <div class="nav-cont">
        <ul>
            <li class="index"><a href="${pageContext.request.contextPath }/home">首页</a></li>
            <li class="active"><a href="${pageContext.request.contextPath }/supply-list?page=1">供应大厅</a></li>
            <li class="active"><a href="${pageContext.request.contextPath }/procurement-list?page=1">采购大厅</a></li>
            <li class="qc"><a href="${pageContext.request.contextPath }/marketinfo-list?page=1">行情大厅</a></li>
            <li class="qc"><a href="${pageContext.request.contextPath }/farmnews-list?page=1">行业资讯</a></li>
            <li class="qc"><a href="${pageContext.request.contextPath }/study-list?page=1">惠农学堂</a></li>
        </ul>
    </div>
</div>
