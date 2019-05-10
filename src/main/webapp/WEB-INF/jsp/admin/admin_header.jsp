<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- 顶部导航栏 -->
<script src="${pageContext.request.contextPath }/resources/background/js/theme.js"></script>
<header>
    <!-- logo -->
    <div class="am-fl tpl-header-logo">
        <img src="${pageContext.request.contextPath }/resources/background/img/index-logo1-3.jpg" style="width:30px; height: 30px; float: left; margin-top:14px; margin-left: 15px;">
        <div style="color: #cfcfcf; line-height: 57px; margin-left:5px; font-weight:bold; float: left;"><a href="${pageContext.request.contextPath }/admin-index-show">助农电商平台后台管理</a></div>
    </div>
    <!-- 右侧内容 -->
    <div class="tpl-header-fluid">
        <!-- 侧边切换 -->
        <div class="am-fl tpl-header-switch-button am-icon-list">
            <span>
        </span>
        </div>
        <!-- 搜索 -->
        <!-- 其它功能-->
        <div class="am-fr tpl-header-navbar">
            <ul>
                <!-- 欢迎语 -->
                <li class="am-text-sm tpl-header-navbar-welcome">
                    <a href="javascript:;">欢迎你, <span>${sessionScope.admin.adminName }</span> </a>
                </li>
                <!-- 退出 -->
                <li class="am-text-sm">
                    <a href="${pageContext.request.contextPath }/admin-index-exit-execute">
                        <span class="am-icon-sign-out"></span> 退出
                    </a>
                </li>
                <li class="am-text-sm">
                    <a id="arrows-alt">
                        <script type="text/javascript">
                            // 全屏代码
                            $("#arrows-alt").click(function () {
                                var el = document.documentElement;
                                var rfs = el.requestFullScreen || el.webkitRequestFullScreen ||
                                    el.mozRequestFullScreen || el.msRequestFullScreen;
                                if (typeof rfs != "undefined" && rfs) {
                                    rfs.call(el);
                                } else if (typeof window.ActiveXObject != "undefined") {
                                    //for IE，这里其实就是模拟了按下键盘的F11，使浏览器全屏
                                    var wscript = new ActiveXObject("WScript.Shell");
                                    if (wscript != null) {
                                        wscript.SendKeys("{F11}");
                                    }
                                }
                            });
                        </script>
                        <span class="am-icon-arrows-alt"></span> 全屏
                    </a>
                </li>
                <li class="am-text-sm">
                    <a id="compress">
                        <script type="text/javascript">
                            // 缩小
                            $("#compress").click(function exitFullScreen() {
                                var elem = document;
                                if (elem.webkitCancelFullScreen) {
                                    elem.webkitCancelFullScreen();
                                } else if (elem.mozCancelFullScreen) {
                                    elem.mozCancelFullScreen();
                                } else if (elem.cancelFullScreen) {
                                    elem.cancelFullScreen();
                                } else if (elem.exitFullscreen) {
                                    elem.exitFullscreen();
                                } else {
                                    notice.notice_show("浏览器不支持全屏API或已被禁用", null, null, null, true, true);
                                }
                            });
                        </script>
                        <span class="am-icon-compress"></span> 还原
                    </a>
                </li>
            </ul>
        </div>
    </div>
</header>
