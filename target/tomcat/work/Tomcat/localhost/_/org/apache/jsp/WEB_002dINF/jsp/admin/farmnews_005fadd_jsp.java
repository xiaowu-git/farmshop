/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-22 08:13:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class farmnews_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/jsp/admin/admin_head.jsp", Long.valueOf(1555266925073L));
    _jspx_dependants.put("/WEB-INF/jsp/admin/../common/tag.jsp", Long.valueOf(1524899502000L));
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
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>添加资讯</title>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/background/css/amazeui.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/background/css/app.css\">\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/background/js/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <link href=\"https://cdn.bootcss.com/toastr.js/2.1.4/toastr.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://cdn.bootcss.com/toastr.js/2.1.4/toastr.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body data-type=\"widgets\">\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/background/js/theme.js\"></script>\r\n");
      out.write("<div class=\"am-g tpl-g\">\r\n");
      out.write("    <!-- 加载顶部导航栏 -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin_header.jsp", out, false);
      out.write("\r\n");
      out.write("    <!-- 加载侧边导航栏 -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin_comlist.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- 内容区域 -->\r\n");
      out.write("    <div class=\"tpl-content-wrapper\">\r\n");
      out.write("        <div class=\"row-content am-cf\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"am-u-sm-12 am-u-md-12 am-u-lg-12\">\r\n");
      out.write("                    <div class=\"widget am-cf\">\r\n");
      out.write("                        <div class=\"widget-head am-cf\">\r\n");
      out.write("                            <div class=\"widget-title am-fl\">添加资讯</div>\r\n");
      out.write("                            <div class=\"widget-function am-fr\">\r\n");
      out.write("                                <a href=\"javascript:;\" class=\"am-icon-cog\"></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"widget-body am-fr\">\r\n");
      out.write("\r\n");
      out.write("                            <form class=\"am-form tpl-form-line-form\">\r\n");
      out.write("                                <div class=\"am-form-group\">\r\n");
      out.write("                                    <label for=\"farmnews-name\" class=\"am-u-sm-3 am-form-label\">标题 <span class=\"tpl-form-line-small-title\">Title</span></label>\r\n");
      out.write("                                    <div class=\"am-u-sm-9\">\r\n");
      out.write("                                        <input id=\"farmnews-name\" type=\"text\" class=\"tpl-form-input\" placeholder=\"请输入标题文字\">\r\n");
      out.write("                                        <small>请填写标题文字5-10字左右。</small>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"am-form-group\">\r\n");
      out.write("                                    <label for=\"farmnews-time\" class=\"am-u-sm-3 am-form-label\">发布时间 <span class=\"tpl-form-line-small-title\">Time</span></label>\r\n");
      out.write("                                    <div class=\"am-u-sm-9\">\r\n");
      out.write("                                        <input  id=\"farmnews-time\" type=\"text\" class=\"am-form-field tpl-form-no-bg\" placeholder=\"发布时间\" data-am-datepicker=\"\" readonly=\"\">\r\n");
      out.write("                                        <small>发布时间为必填</small>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"am-form-group\">\r\n");
      out.write("                                    <label for=\"farmnews-user\" class=\"am-u-sm-3 am-form-label\">作者 <span class=\"tpl-form-line-small-title\">Author</span></label>\r\n");
      out.write("                                    <div class=\"am-u-sm-9\">\r\n");
      out.write("                                        <select id=\"farmnews-user\" data-am-selected=\"{maxHeight: 200}\" style=\"display: none;\">\r\n");
      out.write("\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"am-form-group\">\r\n");
      out.write("                                    <label for=\"farmnews-type\" class=\"am-u-sm-3 am-form-label\">添加分类 <span class=\"tpl-form-line-small-title\">Type</span></label>\r\n");
      out.write("                                    <div class=\"am-u-sm-9\">\r\n");
      out.write("                                        ");
      out.write("\r\n");
      out.write("                                        <select id=\"farmnews-type\" data-am-selected=\"{maxHeight: 300}\" style=\"display: none;\">\r\n");
      out.write("\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"am-form-group\">\r\n");
      out.write("                                    <label for=\"farmnews-picture\" class=\"am-u-sm-3 am-form-label\">资讯图片 <span class=\"tpl-form-line-small-title\">Images</span></label>\r\n");
      out.write("                                    <div class=\"am-u-sm-9\">\r\n");
      out.write("                                        <div class=\"am-form-group am-form-file\">\r\n");
      out.write("                                            <div class=\"tpl-form-file-img\">\r\n");
      out.write("                                                <img id=\"preview\" src=\"\" alt=\"\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <button type=\"button\" class=\"am-btn am-btn-danger am-btn-sm\">\r\n");
      out.write("                                                <i class=\"am-icon-cloud-upload\"></i> 添加资讯图片</button>\r\n");
      out.write("                                            <input id=\"farmnews-picture\" type=\"file\" multiple=\"\" max=\"5\" maxsize=\"5120\" allowexts=\"gif,jpeg,jpg,png,bmp\" accept=\"image/*\" onchange=\"imgPreview(this)\">\r\n");
      out.write("                                                ");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"am-form-group\">\r\n");
      out.write("                                    <label for=\"farmnews-info\" class=\"am-u-sm-3 am-form-label\">文章内容</label>\r\n");
      out.write("                                    <div class=\"am-u-sm-9\">\r\n");
      out.write("                                        <textarea class=\"\" rows=\"10\" id=\"farmnews-info\" placeholder=\"请输入文章内容\"></textarea>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"am-form-group\">\r\n");
      out.write("                                    <div class=\"am-u-sm-9 am-u-sm-push-3\">\r\n");
      out.write("                                        <button type=\"button\" class=\"am-btn am-btn-primary tpl-btn-bg-color-success\" id=\"want-addfarmnews\">提交</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/background/js/amazeui.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/background/js/app.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    //预览图片\r\n");
      out.write("    function imgPreview(fileDom) {\r\n");
      out.write("        //判断是否支持FileReader\r\n");
      out.write("        if(window.FileReader) {\r\n");
      out.write("            var reader = new FileReader();\r\n");
      out.write("        } else {\r\n");
      out.write("            alert(\"您的设备不支持图片预览功能，如需该功能请升级您的设备！\");\r\n");
      out.write("        }\r\n");
      out.write("        //获取文件\r\n");
      out.write("        var file = fileDom.files[0];\r\n");
      out.write("        var imageType = /^image\\//;\r\n");
      out.write("        //是否是图片\r\n");
      out.write("        if(!imageType.test(file.type)) {\r\n");
      out.write("            alert(\"请选择图片！\");\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        //读取完成\r\n");
      out.write("        reader.onload = function(a) {\r\n");
      out.write("            //获取图片dom\r\n");
      out.write("            var img = document.getElementById(\"preview\");\r\n");
      out.write("            //图片路径设置为读取的图片\r\n");
      out.write("            img.src = a.target.result;\r\n");
      out.write("        };\r\n");
      out.write("        reader.readAsDataURL(file);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    /*这个方法用于在加载页面时读取后台并增加select的选择数*/\r\n");
      out.write("    window.onload=function(){\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type:\"post\",\r\n");
      out.write("            url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/AddProdCategorys\",\r\n");
      out.write("            dataType:\"json\",\r\n");
      out.write("            async:true,\r\n");
      out.write("            cache:false,//不缓存\r\n");
      out.write("            timeout:5000,\r\n");
      out.write("            success:function(data) {\r\n");
      out.write("                if(data) {\r\n");
      out.write("                    $(\"#farmnews-type\").append(\"<option value=''>请选择</option>\");\r\n");
      out.write("                    for(var i=0;i<data.length;i++) {\r\n");
      out.write("                        $(\"#farmnews-type\").append(\"<option value='\"+data[i].categorySeq+\"'>\"+data[i].categoryName+\"</option>\");\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                else {\r\n");
      out.write("                    toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("                    toastr.warning(\"data.success 失败!\");\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            error:function () {\r\n");
      out.write("                toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("                toastr.warning(\"数据传输失败!\");\r\n");
      out.write("            },\r\n");
      out.write("            complete:function (XMLHttpRequest,status) {\r\n");
      out.write("                if(status=='timeout') {\r\n");
      out.write("                    //如果请求超时，则弹出提示,并取消请求\r\n");
      out.write("                    toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("                    toastr.warning(\"请求超时!\");\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type:\"post\",\r\n");
      out.write("            url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-allAdmin-list\",\r\n");
      out.write("            dataType:\"json\",\r\n");
      out.write("            async:true,\r\n");
      out.write("            cache:false,//不缓存\r\n");
      out.write("            timeout:5000,\r\n");
      out.write("            success:function(data) {\r\n");
      out.write("                if(data) {\r\n");
      out.write("                    $(\"#farmnews-user\").append(\"<option value=''>请选择</option>\");\r\n");
      out.write("                    for(var i=0;i<data.length;i++) {\r\n");
      out.write("                        $(\"#farmnews-user\").append(\"<option value='\"+data[i].adminId+\"'>\"+data[i].adminName+\"</option>\");\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                else {\r\n");
      out.write("                    toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("                    toastr.warning(\"data.success 失败!\");\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            error:function () {\r\n");
      out.write("                toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("                toastr.warning(\"数据传输失败!\");\r\n");
      out.write("            },\r\n");
      out.write("            complete:function (XMLHttpRequest,status) {\r\n");
      out.write("                if(status=='timeout') {\r\n");
      out.write("                    //如果请求超时，则弹出提示,并取消请求\r\n");
      out.write("                    toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("                    toastr.warning(\"请求超时!\");\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!--点击提交按钮后执行操作-->\r\n");
      out.write("    $(\"#want-addfarmnews\").click(function(){\r\n");
      out.write("        var formData = new FormData();\r\n");
      out.write("        var farmnewsUser=$('#farmnews-user option:selected').val();\r\n");
      out.write("        var farmnewsType=$('#farmnews-type option:selected').val();\r\n");
      out.write("\r\n");
      out.write("        var farmnewsName = $('#farmnews-name').val();\r\n");
      out.write("        var farmnewsTime = $('#farmnews-time').val();\r\n");
      out.write("        var farmnewsInfo = $('#farmnews-info').val();\r\n");
      out.write("        var farmnewsPicture = $(\"#farmnews-picture\")[0].files[0];\r\n");
      out.write("\r\n");
      out.write("        if(null == farmnewsUser || 0 == farmnewsUser){\r\n");
      out.write("            toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("            toastr[\"error\"](\"请选择行业资讯发布作者！\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        if(null == farmnewsType || 0 == farmnewsType){\r\n");
      out.write("            toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("            toastr[\"error\"](\"请选择行业资讯类型！\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        if(null == farmnewsName || \"\" == farmnewsName){\r\n");
      out.write("            toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("            toastr[\"error\"](\"请填写行业资讯的标题！\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        if(farmnewsName.length > 10){\r\n");
      out.write("            toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("            toastr.warning(\"请您正确填写行业资讯的标题!\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        if(null == farmnewsTime || \"\" == farmnewsTime){\r\n");
      out.write("            toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("            toastr[\"error\"](\"请您填写行业资讯的发布时间！\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        if(null == farmnewsInfo || \"\" == farmnewsInfo){\r\n");
      out.write("            toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("            toastr.warning(\"请您正确填写行业资讯的具体内容!\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        if(farmnewsInfo.length > 1000){\r\n");
      out.write("            toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("            toastr.warning(\"您填写行业资讯的具体内容已经超出字数!\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        if(null == farmnewsPicture || \"\" == farmnewsPicture){\r\n");
      out.write("            toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("            toastr[\"error\"](\"请您上传图片！\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        formData.append(\"farmnewsUser\", farmnewsUser);\r\n");
      out.write("        formData.append(\"farmnewsType\", farmnewsType);\r\n");
      out.write("        formData.append(\"farmnewsName\", farmnewsName);\r\n");
      out.write("        formData.append(\"farmnewsTime\",  farmnewsTime);\r\n");
      out.write("        formData.append(\"farmnewsInfo\",  farmnewsInfo);\r\n");
      out.write("        formData.append(\"farmnewsPicture\",  farmnewsPicture);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-addfarmnews-execute\",\r\n");
      out.write("            type:'post',\r\n");
      out.write("            dataType:'json',\r\n");
      out.write("            data:formData,\r\n");
      out.write("            cache : false,\r\n");
      out.write("            processData : false,\r\n");
      out.write("            contentType : false,\r\n");
      out.write("            success:function(data){\r\n");
      out.write("                console.log(data);\r\n");
      out.write("                if(data.success){\r\n");
      out.write("                    toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("                    toastr[\"success\"](\"发布成功\");\r\n");
      out.write("                    window.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin-farmnews-list-show?page=1\";\r\n");
      out.write("                }else{\r\n");
      out.write("                    toastr.options = {positionClass: \"toast-top-right\"};\r\n");
      out.write("                    toastr[\"error\"](data.msg ? data.msg : \"发布失败\");\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            ,error:function(e){\r\n");
      out.write("                toastr[\"error\"](\"连接服务器超时，请稍后重试\");\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
