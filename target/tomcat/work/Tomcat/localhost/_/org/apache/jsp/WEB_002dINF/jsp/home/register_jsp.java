/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-05-03 00:19:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/jsp/home/../common/head.jsp", Long.valueOf(1555166339364L));
    _jspx_dependants.put("/WEB-INF/jsp/home/../common/tag.jsp", Long.valueOf(1524899502000L));
    _jspx_dependants.put("/WEB-INF/jsp/home/../common/footer.jsp", Long.valueOf(1554138298998L));
  }

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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write('\n');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head lang=\"en\">\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>注册</title>\r\n");
      out.write("    ");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"format-detection\" content=\"telephone=no\">\n");
      out.write("<meta name=\"renderer\" content=\"webkit\">\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/assets/css/amazeui.css\" />\n");
      out.write("\n");
      out.write("<link href=\"https://cdn.bootcss.com/toastr.js/2.1.4/toastr.min.css\" rel=\"stylesheet\">\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/assets/js/jquery.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.bootcss.com/toastr.js/2.1.4/toastr.min.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/assets/js/amazeui.js\" type=\"text/javascript\"></script>");
      out.write("\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/dlstyle.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/assets/js/amazeui.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"login-boxtitle\">\r\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/home\"><img alt=\"\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/logobig.png\" /></a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"res-banner\">\r\n");
      out.write("    <div class=\"res-main\">\r\n");
      out.write("        <div class=\"login-banner-bg\"><span></span><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/big.jpg\" /></div>\r\n");
      out.write("        <div class=\"login-box\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"am-tabs\" id=\"doc-my-tabs\">\r\n");
      out.write("                <ul class=\"am-tabs-nav am-nav am-nav-tabs am-nav-justify\">\r\n");
      out.write("                    <li><a href=\"\">手机号注册</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"am-tabs-bd\">\r\n");
      out.write("                    <div class=\"am-tab-panel\">\r\n");
      out.write("                        <form method=\"post\">\r\n");
      out.write("                            <div class=\"user-phone\">\r\n");
      out.write("                                <label for=\"phone\"><i class=\"am-icon-mobile-phone am-icon-md\"></i></label>\r\n");
      out.write("                                <input type=\"tel\" name=\"PhoneNumber\" id=\"phone\" placeholder=\"请输入手机号\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"user-name\">\r\n");
      out.write("                                <label for=\"username\"><i class=\"am-icon-code-fork\"></i></label>\r\n");
      out.write("                                <input type=\"text\" name=\"YourName\" id=\"username\" placeholder=\"请填写真实姓名\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"user-pass\">\r\n");
      out.write("                                <label for=\"password\"><i class=\"am-icon-lock\"></i></label>\r\n");
      out.write("                                <input type=\"password\" name=\"Password\" id=\"password\" placeholder=\"设置密码\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"user-pass\">\r\n");
      out.write("                                <label for=\"passwordRepeat\"><i class=\"am-icon-lock\"></i></label>\r\n");
      out.write("                                <input type=\"password\" name=\"Password1\" id=\"passwordRepeat\" placeholder=\"确认密码\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                        <div class=\"login-links\">\r\n");
      out.write("                            ");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"am-cf\">\r\n");
      out.write("                            <input type=\"submit\" name=\"\" id=\"signupinp\" value=\"注册\" class=\"am-btn am-btn-primary am-btn-sm am-fl\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <hr>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <script>\r\n");
      out.write("                        $(function() {\r\n");
      out.write("                            $('#doc-my-tabs').tabs();\r\n");
      out.write("                        })\r\n");
      out.write("                    </script>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"login-links\">\r\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login\" class=\"zcnext am-fr am-btn-default\">登录</a>\r\n");
      out.write("                <br />\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"footer \">\r\n");
      out.write("    <div class=\"footer-hd \">\r\n");
      out.write("        <p>\r\n");
      out.write("            <a href=\"# \">惠农网首页</a>\r\n");
      out.write("            <b>|</b>\r\n");
      out.write("            <a href=\"# \">支付宝</a>\r\n");
      out.write("            <b>|</b>\r\n");
      out.write("            <a href=\"# \">物流</a>\r\n");
      out.write("        </p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"footer-bd \">\r\n");
      out.write("        <p>\r\n");
      out.write("            <a href=\"# \">合作伙伴</a>\r\n");
      out.write("            <a href=\"# \">联系我们</a>\r\n");
      out.write("            <a href=\"# \">网站地图</a>\r\n");
      out.write("            <em>© 2015-2025 zjh168.cn 版权所有</em>\r\n");
      out.write("        </p>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    <!--点击注册按钮后执行注册操作-->\r\n");
      out.write("\t$(\"#signupinp\").click(function(){\r\n");
      out.write("\t\tvar userPhone = $('input[name=\"PhoneNumber\"]').val();\r\n");
      out.write("\t\tvar userName = $('input[name=\"YourName\"]').val();\r\n");
      out.write("\t\tvar userPassword = $('input[name=\"Password\"]').val();\r\n");
      out.write("\t\tvar userPassword1 = $('input[name=\"Password1\"]').val();\r\n");
      out.write("\t\tif(null == userPhone || \"\" == userPhone){\r\n");
      out.write("\t\t\ttoastr.options = {positionClass: \"toast-top-center\"};\r\n");
      out.write("\t\t\ttoastr[\"error\"](\"请输入您的手机号！\");\r\n");
      out.write("\t\t\t$('input[name=\"Password\"]').val(\"\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(null == userName || \"\" == userName){\r\n");
      out.write("\t\t\ttoastr.options = {positionClass: \"toast-top-center\"};\r\n");
      out.write("\t\t\ttoastr[\"error\"](\"请输入您的真实姓名！\");\r\n");
      out.write("\t\t\t$('input[name=\"Password\"]').val(\"\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(null == userPassword || \"\" == userPassword){\r\n");
      out.write("\t\t\ttoastr.options = {positionClass: \"toast-top-center\"};\r\n");
      out.write("\t\t\ttoastr[\"error\"](\"请输入您的密码！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar testPhone = /^[1][3,4,5,7,8][0-9]{9}$/;\r\n");
      out.write("\t\tif(!(/^1[3|4|5|6|7|8][0-9]\\d{4,8}$/.test(userPhone))){\r\n");
      out.write("\t\t\ttoastr.options = {positionClass: \"toast-top-center\"};\r\n");
      out.write("\t\t\ttoastr.warning(\"请您输入正确的手机号!\");\r\n");
      out.write("\t\t\t$('input[name=\"Password\"]').val(\"\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\tif(userName.length > 10){\r\n");
      out.write("\t\t\ttoastr.options = {positionClass: \"toast-top-center\"};\r\n");
      out.write("\t\t\ttoastr.warning(\"姓名过长，请您输入不超过10个汉字的姓名!\");\r\n");
      out.write("\t\t\t$('input[name=\"Password\"]').val(\"\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(userPassword.length > 16){\r\n");
      out.write("\t\t\ttoastr.options = {positionClass: \"toast-top-center\"};\r\n");
      out.write("\t\t\ttoastr.warning(\"请您输入小于16位的密码!\");\r\n");
      out.write("\t\t\t$('input[name=\"Password\"]').val(\"\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(userPassword != userPassword1){\r\n");
      out.write("\t\t\ttoastr.options = {positionClass: \"toast-top-center\"};\r\n");
      out.write("\t\t\ttoastr[\"error\"](\"两次输入密码不一致，请确认！\");\r\n");
      out.write("\t\t\t$('input[name=\"Password\"]').val(\"\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl:\"/addUser\",\r\n");
      out.write("\t\t\ttype:'post',\r\n");
      out.write("\t\t\tdataType:'json',\r\n");
      out.write("\t\t\tdata:{\r\n");
      out.write("\t\t\t\t\"userPhone\":userPhone,\r\n");
      out.write("\t\t\t\t\"userName\":userName,\r\n");
      out.write("\t\t\t\t\"userPassword\":userPassword\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\tif(data.success){\r\n");
      out.write("\t\t\t\t\ttoastr.options = {positionClass: \"toast-top-center\"};\r\n");
      out.write("\t\t\t\t\ttoastr[\"success\"](\"注册成功\");\r\n");
      out.write("\t\t\t\t\twindow.location.href =\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login\";\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\ttoastr.options = {positionClass: \"toast-top-center\"};\r\n");
      out.write("\t\t\t\t\ttoastr[\"error\"](data.msg ? data.msg : \"注册失败\");\r\n");
      out.write("\t\t\t\t\t$('input[name=\"Password\"]').val(\"\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t,error:function(e){\r\n");
      out.write("\t\t\t\ttoastr[\"error\"](\"连接服务器超时，请稍后重试\");\r\n");
      out.write("\t\t\t\t$('input[name=\"Password\"]').val(\"\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
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
