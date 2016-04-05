package com.yyabl.api.crm.biz.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;
import com.yyabl.api.crm.biz.Bean.ResponseBaseBean;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.RequestPurviewService;

/**
 * @ClassName: RequestPurviewFilter
 * @Description: 访问权限控制
 * @author Maven
 * @date 2014-7-13 上午12:54:19
 * 
 */
@Component("requestPurviewFilter")
public class RequestPurviewFilter extends OncePerRequestFilter {

	@Resource(name = "requestPurviewService")
	private RequestPurviewService requestPurviewService;

	@Resource(name = "responseBaseBean")
	private ResponseBaseBean responseBaseBean;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		try {
			requestPurviewService.validatorRequest(request,response);
			filterChain.doFilter(request, response);
		} catch (GeneralException e) {
			responseBaseBean.setStatus(e.getErrorCode());
			responseBaseBean.setMessage(e.getMessage());
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			JSON jsonObject = (JSON) JSON.toJSON(responseBaseBean);
			out.print(jsonObject);
			out.flush();
		}
	}

}
