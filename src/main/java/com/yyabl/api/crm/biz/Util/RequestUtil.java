package com.yyabl.api.crm.biz.Util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestUtil {
	
	static Logger logger = LoggerFactory.getLogger(RequestUtil.class);

	/**
	 * @Title: getPathInfo
	 * @Description: 从ServletRequest中获取URI中应用上下文部分以后的pathInfo。
	 * @param @param request ServletRequest实例
	 * @param @return 设定文件
	 * @return String 不包含应用上下文的路径。参数request为null时返回null，应用上下文后无内容时返回空字符串。
	 * @throws
	 */
	public static String getPathInfo(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		// 取得pathInfo
		return ((HttpServletRequest) request).getRequestURI().replaceFirst(
				((HttpServletRequest) request).getContextPath(), "");
	}

	/**
	 * @Title: getServletContext
	 * @Description: 获取Servlet上下文
	 * @param @param request 请求信息
	 * @param @return 设定文件
	 * @return ServletContext。参数request为null时返回null。
	 * @throws
	 */
	public static ServletContext getServletContext(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		// 取得ServletContext
		return request.getSession(true).getServletContext();
	}

	/**
	 * @Title: getParamsMap
	 * @Description: 将HttpServletRequest中的键-值对转换为Map<String,String>
	 * @param request
	 *            HttpServletRequest请求
	 * @param @return
	 * @return Map<String,String> 键值对
	 * @throws
	 */
	public static Map<String, String> getParamsMap(HttpServletRequest request) {
		// 创建参数表
		Map<String, String> paramsMap = new HashMap<String, String>();
		Enumeration<?> paramsName = request.getParameterNames();
		// 遍历参数request中的参数名
		while (paramsName.hasMoreElements()) {
			String paramName = (String) paramsName.nextElement();
			String paramValue = request.getParameter(paramName);
			paramsMap.put(paramName, paramValue);
		}
		return paramsMap;
	}
}
