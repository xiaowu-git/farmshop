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

public final class admin_005fcomlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- 侧边导航栏 -->\r\n");
      out.write("<div class=\"left-sidebar\">\r\n");
      out.write("    <!-- 用户信息 -->\r\n");
      out.write("    <div class=\"tpl-sidebar-user-panel\">\r\n");
      out.write("        <div class=\"tpl-user-panel-slide-toggleable\">\r\n");
      out.write("            <div class=\"tpl-user-panel-profile-picture\">\r\n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/background/img/admin3.png\" alt=\"\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <span class=\"user-panel-logged-in-text\">\r\n");
      out.write("              <i class=\"am-icon-circle-o am-text-success tpl-user-panel-status-icon\"></i>\r\n");
      out.write("              ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.admin.adminName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("          </span>\r\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-index-edit-show\" class=\"tpl-user-panel-action-link\"> <span class=\"am-icon-pencil\"></span> 账号设置</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- 菜单 -->\r\n");
      out.write("    <ul class=\"sidebar-nav\">\r\n");
      out.write("        <li class=\"sidebar-nav-link\">\r\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-index-index-show\" id=\"index\">\r\n");
      out.write("                <i class=\"am-icon-home sidebar-nav-link-logo\"></i> 首  页\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"sidebar-nav-link\">\r\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-member-list-show?page=1\" id=\"user\">\r\n");
      out.write("                <i class=\"am-icon-user sidebar-nav-link-logo\"></i> 用  户\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"sidebar-nav-link\">\r\n");
      out.write("            <a href=\"javascript:;\" class=\"sidebar-nav-sub-title\" id=\"supply\">\r\n");
      out.write("                <i class=\"am-icon-product-hunt sidebar-nav-link-logo\"></i> 供  应\r\n");
      out.write("                <span class=\"am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"sidebar-nav sidebar-nav-sub\">\r\n");
      out.write("                <li class=\"sidebar-nav-link\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-supply-list-show?page=1&state=1\" id=\"supply1\">\r\n");
      out.write("                        <span class=\"am-icon-angle-right sidebar-nav-link-logo\"></span> 待审核\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"sidebar-nav-link\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-supply-list-show?page=1&state=2\" id=\"supply2\">\r\n");
      out.write("                        <span class=\"am-icon-angle-right sidebar-nav-link-logo\"></span> 已审核\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"sidebar-nav-link\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-supply-list-show?page=1&state=3\" id=\"supply3\">\r\n");
      out.write("                        <span class=\"am-icon-angle-right sidebar-nav-link-logo\"></span> 已下架\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("\r\n");
      out.write("        <li class=\"sidebar-nav-link\">\r\n");
      out.write("            <a href=\"javascript:;\" class=\"sidebar-nav-sub-title\" id=\"procurement\">\r\n");
      out.write("                <i class=\"am-icon-product-hunt sidebar-nav-link-logo\"></i> 采  购\r\n");
      out.write("                <span class=\"am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"sidebar-nav sidebar-nav-sub\">\r\n");
      out.write("                <li class=\"sidebar-nav-link\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-procurement-list-show?page=1&state=1\" id=\"procurement1\">\r\n");
      out.write("                        <span class=\"am-icon-angle-right sidebar-nav-link-logo\"></span> 待审核\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"sidebar-nav-link\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-procurement-list-show?page=1&state=2\" id=\"procurement2\">\r\n");
      out.write("                        <span class=\"am-icon-angle-right sidebar-nav-link-logo\"></span> 已审核\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"sidebar-nav-link\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-procurement-list-show?page=1&state=3\" id=\"procurement3\">\r\n");
      out.write("                        <span class=\"am-icon-angle-right sidebar-nav-link-logo\"></span> 已下架\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <li class=\"sidebar-nav-link\">\r\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-market-list-show?page=1\" id=\"market\">\r\n");
      out.write("                <i class=\"am-icon-line-chart sidebar-nav-link-logo\"></i> 行  情\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"sidebar-nav-link\">\r\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-farmnews-list-show?page=1\" id=\"farmnews\">\r\n");
      out.write("                <i class=\"am-icon-newspaper-o sidebar-nav-link-logo\"></i> 资  讯\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"sidebar-nav-link\">\r\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-farmstudy-list-show?page=1\" id=\"farmstudy\">\r\n");
      out.write("                <i class=\"am-icon-newspaper-o sidebar-nav-link-logo\"></i> 学  堂\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"sidebar-nav-link\">\r\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-order-list-show?page=1\" id=\"order\">\r\n");
      out.write("                <i class=\"am-icon-wpforms sidebar-nav-link-logo\"></i> 订  单\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <li class=\"sidebar-nav-link\">\r\n");
      out.write("            <a href=\"javascript:;\" class=\"sidebar-nav-sub-title\">\r\n");
      out.write("                <i class=\"am-icon-street-view sidebar-nav-link-logo\"></i> 管理员\r\n");
      out.write("                <span class=\"am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"sidebar-nav sidebar-nav-sub\">\r\n");
      out.write("                <li class=\"sidebar-nav-link\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-admin-list-show?page=1\" id=\"admin-list\">\r\n");
      out.write("                        <span class=\"am-icon-angle-right sidebar-nav-link-logo\"></span> 管理员列表\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"sidebar-nav-link\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-admin-register-show\" id=\"admin-register\">\r\n");
      out.write("                        <span class=\"am-icon-angle-right sidebar-nav-link-logo\"></span> 添加管理员\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var nav = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.nav}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var elem = \"#\" + nav;\r\n");
      out.write("    if (nav == \"admin-list\" || nav == \"admin-message\") {\r\n");
      out.write("        $(elem).attr(\"class\", \"sub-active\");\r\n");
      out.write("    } else {\r\n");
      out.write("        $(elem).attr(\"class\", \"active\");\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
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