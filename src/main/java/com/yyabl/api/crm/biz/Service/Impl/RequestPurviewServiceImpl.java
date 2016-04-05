package com.yyabl.api.crm.biz.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yyabl.api.crm.biz.Bean.RequestBaseBean;
import com.yyabl.api.crm.biz.Dao.ApiDefMapper;
import com.yyabl.api.crm.biz.Dao.RclMapper;
import com.yyabl.api.crm.biz.Dao.RyxxMapper;
import com.yyabl.api.crm.biz.Domain.ApiDef;
import com.yyabl.api.crm.biz.Domain.Rcl;
import com.yyabl.api.crm.biz.Domain.Ryxx;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.RequestPurviewService;
import com.yyabl.api.crm.biz.Sign.Des;
import com.yyabl.api.crm.biz.Sign.MD5;
import com.yyabl.api.crm.biz.Sign.SignCore;
import com.yyabl.api.crm.biz.Util.RequestUtil;

@Service("requestPurviewService")
public class RequestPurviewServiceImpl implements RequestPurviewService {
	
	Logger logger = LoggerFactory.getLogger(RequestPurviewServiceImpl.class);

	@Resource(name = "ryxxMapper")
	private RyxxMapper ryxxMapper;

	@Resource(name = "apiDefMapper")
	private ApiDefMapper apiDefMapper;

	@Resource(name = "rclMapper")
	private RclMapper rclMapper;

	/*
	 * @Resource(name = "requestBaseBean") private RequestBaseBean
	 * requestBaseBean;
	 */

	public void validatorRequest(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
		RequestBaseBean requestBaseBean = new RequestBaseBean();
		try {
			BeanUtils.populate(requestBaseBean, request.getParameterMap());
			requestBaseBean.setUri(request.getRequestURI());
		} catch (IllegalAccessException e) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_ERROR, EnumGeneralException.CODE_SYSTEM_ERROR);
		} catch (InvocationTargetException e) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_ERROR, EnumGeneralException.CODE_SYSTEM_ERROR);
		}

		if (!isTimeout(requestBaseBean.getTimeStamp())) {
			throw new GeneralException(EnumGeneralException.MSG_REQUEST_TIMEOUT, EnumGeneralException.CODE_REQUEST_TIMEOUT);
		}
		
		/**
		 * TODO 暂时取消日处理检测机制
		if (!isRclFinish()) {
			throw new GeneralException(EnumGeneralException.MSG_RCL_IS_NOT_FINISH, EnumGeneralException.CODE_RCL_IS_NOT_FINISH);
		}
		*/
		
		if (!isUrlEffect(requestBaseBean.getUri())) {
			throw new GeneralException(EnumGeneralException.MSG_REQUEST_URL_NOT_FOUND_OR_INVALID, EnumGeneralException.CODE_REQUEST_URL_NOT_FOUND_OR_INVALID);
		}

		if (!isPartnerCodeEffect(requestBaseBean.getPartnerCode())) {
			throw new GeneralException(EnumGeneralException.MSG_PARTNER_CODE_INVALID, EnumGeneralException.CODE_PARTNER_CODE_INVALID);
		}

		if (!isUrlAccessAuth(requestBaseBean.getPartnerCode(), request.getRequestURI())) {
			throw new GeneralException(EnumGeneralException.MSG_PARTNER_CODE_ACCESS_PERMISSION, EnumGeneralException.CODE_PARTNER_CODE_ACCESS_PERMISSION);
		}

		if (!isSignLegal(request, requestBaseBean)) {
			throw new GeneralException(EnumGeneralException.MSG_SIGNATURE_VALID, EnumGeneralException.CODE_SIGNATURE_VALID);
		}
	}

	/**
	 * @Title: isTimeout
	 * @Description: 检查请求是否超时
	 * @param @param requestTime 请求时间
	 * @param @return
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isTimeout(long requestTime) {
		// 如果请求时间超过当前系统时间30分钟，就认为请求超时
		if (Math.abs(System.currentTimeMillis() - requestTime) > 1000 * 60 * 30) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @Title: isUrlEffect
	 * @Description: 检查接口地址是否可用
	 * @param @param url 接口地址
	 * @param @return
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isUrlEffect(String url) {
		List<ApiDef> lstApiDef = apiDefMapper.selectByUrlEnabled(url);
		if (lstApiDef.size() == 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * @Title: isPartnerCodeEffect
	 * @Description: 检查合作商户帐号是否有效
	 * @param @param partenrCode 合作商户号
	 * @param @return
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isPartnerCodeEffect(String partenrCode) {
		Ryxx ryxx = ryxxMapper.selectByPersonCode(partenrCode);
		if (ryxx == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @Title: isUrlAccessAuth
	 * @Description: 检查合作商户是否具有访问接口地址的权限
	 * @param @param partenr 合作商户号
	 * @param @param url 接口地址
	 * @param @return
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isUrlAccessAuth(String partenrCode, String url) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("partenrCode", partenrCode);
		paramMap.put("url", url);
		Ryxx ryxx = ryxxMapper.selectByPersonCodeAndUrl(paramMap);
		if (ryxx == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @Title: isSignLegal
	 * @Description: 检查签名是否合法
	 * @param @param paramStr 请求参数字符串
	 * @param @return
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isSignLegal(HttpServletRequest request, RequestBaseBean requestBaseBean) {
		// 没有经过解密的密钥二进制
		String encSignKey = null;
		// 经过解密后的密钥原文
		String signKey = null;
		// 1.先将键值对提取为Map形式
		Map<String, String> reqMap = RequestUtil.getParamsMap(request);
		// 2.过滤map中的signature键
		reqMap = SignCore.paramFilter(reqMap);
		// 3.对map排序，并生成String
		String requestStr = SignCore.createLinkString(reqMap);
		// 4.获取当前合作商户的密钥
		Ryxx ryxx = ryxxMapper.selectByPersonCode(requestBaseBean.getPartnerCode());

		try {
			encSignKey = new String(ryxx.getXtczy().getLoginPassword(), "GB2312");
			signKey = Des.decrypt(encSignKey);
		} catch (UnsupportedEncodingException e) {
			logger.error("解密错误.");
		}
		if (MD5.verify(requestStr, requestBaseBean.getSignature(), signKey) == true) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc) <p>Title: isRclFinish</p> <p>Description:检查CRM日处理是否完成。 </p>
	 * 
	 * @return
	 * 
	 * @throws DataAccessException
	 * 
	 * @see com.yyabl.api.crm.biz.Service.RequestPurviewService#isRclFinish()
	 */
	@Override
	public boolean isRclFinish() throws DataAccessException {
		Rcl rcl = rclMapper.checkRclStatus();
		if (rcl.getStatus() == 0) {
			return true;
		} else {
			return false;
		}
	}

}
