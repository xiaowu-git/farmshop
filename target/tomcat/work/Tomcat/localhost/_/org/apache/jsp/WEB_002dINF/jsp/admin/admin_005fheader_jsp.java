/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-22 05:28:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005fheader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 顶部导航栏 -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/background/js/theme.js\"></script>\r\n");
      out.write("<header>\r\n");
      out.write("    <!-- logo -->\r\n");
      out.write("    <div class=\"am-fl tpl-header-logo\">\r\n");
      out.write("        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/background/img/index-logo1-3.jpg\" style=\"width:30px; height: 30px; float: left; margin-top:14px; margin-left: 15px;\">\r\n");
      out.write("        <div style=\"color: #cfcfcf; line-height: 57px; margin-left:5px; font-weight:bold; float: left;\">farmshop后台管理</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- 右侧内容 -->\r\n");
      out.write("    <div class=\"tpl-header-fluid\">\r\n");
      out.write("        <!-- 侧边切换 -->\r\n");
      out.write("        <div class=\"am-fl tpl-header-switch-button am-icon-list\">\r\n");
      out.write("            <span>\r\n");
      out.write("        </span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- 搜索 -->\r\n");
      out.write("        <!-- 其它功能-->\r\n");
      out.write("        <div class=\"am-fr tpl-header-navbar\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <!-- 欢迎语 -->\r\n");
      out.write("                <li class=\"am-text-sm tpl-header-navbar-welcome\">\r\n");
      out.write("                    <a href=\"javascript:;\">欢迎你, <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.admin.adminName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span> </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- 退出 -->\r\n");
      out.write("                <li class=\"am-text-sm\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-index-exit-execute\">\r\n");
      out.write("                        <span class=\"am-icon-sign-out\"></span> 退出\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"am-text-sm\">\r\n");
      out.write("                    <a id=\"arrows-alt\">\r\n");
      out.write("                        <script type=\"text/javascript\">\r\n");
      out.write("                            // 全屏代码\r\n");
      out.write("                            $(\"#arrows-alt\").click(function () {\r\n");
      out.write("                                var el = document.documentElement;\r\n");
      out.write("                                var rfs = el.requestFullScreen || el.webkitRequestFullScreen ||\r\n");
      out.write("                                    el.mozRequestFullScreen || el.msRequestFullScreen;\r\n");
      out.write("                                if (typeof rfs != \"undefined\" && rfs) {\r\n");
      out.write("                                    rfs.call(el);\r\n");
      out.write("                                } else if (typeof window.ActiveXObject != \"undefined\") {\r\n");
      out.write("                                    //for IE，这里其实就是模拟了按下键盘的F11，使浏览器全屏\r\n");
      out.write("                                    var wscript = new ActiveXObject(\"WScript.Shell\");\r\n");
      out.write("                                    if (wscript != null) {\r\n");
      out.write("                                        wscript.SendKeys(\"{F11}\");\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("                            });\r\n");
      out.write("                        </script>\r\n");
      out.write("                        <span class=\"am-icon-arrows-alt\"></span> 全屏\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"am-text-sm\">\r\n");
      out.write("                    <a id=\"compress\">\r\n");
      out.write("                        <script type=\"text/javascript\">\r\n");
      out.write("                            // 缩小\r\n");
      out.write("                            $(\"#compress\").click(function exitFullScreen() {\r\n");
      out.write("                                var elem = document;\r\n");
      out.write("                                if (elem.webkitCancelFullScreen) {\r\n");
      out.write("                                    elem.webkitCancelFullScreen();\r\n");
      out.write("                                } else if (elem.mozCancelFullScreen) {\r\n");
      out.write("                                    elem.mozCancelFullScreen();\r\n");
      out.write("                                } else if (elem.cancelFullScreen) {\r\n");
      out.write("                                    elem.cancelFullScreen();\r\n");
      out.write("                                } else if (elem.exitFullscreen) {\r\n");
      out.write("                                    elem.exitFullscreen();\r\n");
      out.write("                                } else {\r\n");
      out.write("                                    notice.notice_show(\"浏览器不支持全屏API或已被禁用\", null, null, null, true, true);\r\n");
      out.write("                                }\r\n");
      out.write("                            });\r\n");
      out.write("                        </script>\r\n");
      out.write("                        <span class=\"am-icon-compress\"></span> 还原\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}