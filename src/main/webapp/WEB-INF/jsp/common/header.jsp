<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--头 -->
<header>
    <article>
        <div class="mt-logo">
            <!--顶部导航条 -->
            <div class="am-container header">
                <ul class="message-l">
                    <div class="topMessage">
                        <c:if test="${sessionScope.obj == null}">
                            <div class="menu-hd">
                                <a href="${pageContext.request.contextPath }/login" target="_top" class="h">亲，请登录</a>
                                <a href="${pageContext.request.contextPath }/register" target="_top">免费注册</a>
                            </div>
                        </c:if>
                        <!-- 登录之后显示-->
                        <c:if test="${sessionScope.obj != null}">
                            <div class="menu-hd">
                                <a href="${pageContext.request.contextPath }/userindex">欢迎你: <span>${sessionScope.obj.userName }</span> </a>
                                <a href="${pageContext.request.contextPath }/logout" target="_top">退出登录</a>
                            </div>
                        </c:if>
                    </div>
                </ul>
                <ul class="message-r">
                    <div class="topMessage home">
                        <div class="menu-hd"><a href="${pageContext.request.contextPath }/home" target="_top" class="h">助农网首页</a></div>
                    </div>
                    <div class="topMessage my-shangcheng">
                        <div class="menu-hd MyShangcheng"><a href="${pageContext.request.contextPath }/userindex" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
                    </div>
                    <%--<div class="topMessage mini-cart">--%>
                        <%--<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>--%>
                    <%--</div>--%>
                    <%--<div class="topMessage favorite">--%>
                        <%--<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>--%>
                    <%--</div>--%>
                </ul>
            </div>

            <!--悬浮搜索框-->

            <div class="nav white">
                <div class="logo"><img src="${pageContext.request.contextPath }/resources/images/logo.png" /></div>
                <div class="logoBig">
                    <li><img src="${pageContext.request.contextPath }/resources/images/huilonglogo.png" /></li>
                </div>

                <div class="search-bar pr">
                    <form action="${pageContext.request.contextPath }/search-supplyProd-show" method="get">
                        <input id="searchInput" name="supply_prod_name" value="${requestScope.supplyProdName}" type="text" placeholder="搜索" autocomplete="off">
                        <input id="ai-topsearch" class="submit am-btn"  value="搜索" index="1" type="submit">
                    </form>
                </div>
            </div>

            <div class="clear"></div>
        </div>
        </div>
    </article>
</header>




