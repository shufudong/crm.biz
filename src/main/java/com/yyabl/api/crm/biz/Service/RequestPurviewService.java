package com.yyabl.api.crm.biz.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Bean.RequestBaseBean;
import com.yyabl.api.crm.biz.Exception.GeneralException;

public interface RequestPurviewService {

	void validatorRequest(HttpServletRequest request, HttpServletResponse response) throws GeneralException;

	/**
	 * @Title: isTimeout
	 * @Description: 检查请求是否超时
	 * @param @param requestTime 请求时间
	 * @param @return
	 * @return boolean 返回类型
	 * @throws
	 */
	boolean isTimeout(long requestTime);
	
	/**
	 * @Title: isRclFinish
	 * @Description: 检查CRM日处理是否完成。
	 * @param @return
	 * @param @throws DataAccessException    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	boolean isRclFinish() throws DataAccessException;

	/**
	 * @Title: isUrlEffect
	 * @Description: 检查接口地址是否可用
	 * @param @param url 接口地址
	 * @param @return
	 * @return boolean 返回类型
	 * @throws
	 */
	boolean isUrlEffect(String url);

	/**
	 * @Title: isPartnerCodeEffect
	 * @Description: 检查合作商户帐号是否有效
	 * @param @param partenrCode 合作商户号
	 * @param @return
	 * @return boolean 返回类型
	 * @throws
	 */
	boolean isPartnerCodeEffect(String partenrCode);

	/**
	 * @Title: isUrlAccessAuth
	 * @Description: 检查合作商户是否具有访问接口地址的权限
	 * @param @param partenr 合作商户号
	 * @param @param url 接口地址
	 * @param @return
	 * @return boolean 返回类型
	 * @throws
	 */
	boolean isUrlAccessAuth(String partenr, String url);

	/**
	 * @Title: isSignLegal
	 * @Description: 检查签名是否合法
	 * @param @param paramStr 请求参数字符串
	 * @param @return
	 * @return boolean 返回类型
	 * @throws
	 */
	boolean isSignLegal(HttpServletRequest request, RequestBaseBean requestBaseBean);
}
