package com.farm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DefaultInteceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings("all")
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String uri = request.getRequestURI().replace(request.getContextPath(), "");
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String[] uris = request.getRequestURI().replaceFirst(request.getContextPath(), "").split("/");

		String url = request.getRequestURI();
		HttpSession session = request.getSession();
		if (null != url && "" != url){			
			if(url.contains("user") || url.contains("account")){
				Object obj = (Object) session.getAttribute("obj");
				if (null == obj) {
					response.sendRedirect("login");
					return false;
				}
				request.setAttribute("obj", obj);	
			}
			if(url.contains("admin")){
				if (session.getAttribute("admin") == null) {
					response.sendRedirect("index-login-show");
					return false;
				}
			}
		}
		if (uris.length > 2) {
			request.setAttribute("module", uris[1] + "/" + uris[2]);
		}
		if (uris.length > 3) {
			request.setAttribute("nav", uris[3]);
		}

		String ctx = request.getContextPath();
		String res = ctx + "/resources";
		request.setAttribute("ctx", ctx);
		request.setAttribute("res", res);
		request.setAttribute("js", res + "/js");
		request.setAttribute("css", res + "/css");
		request.setAttribute("images", res + "/images");
		response.setHeader("Pragma", "No-cache");
		return true;
	}

}
