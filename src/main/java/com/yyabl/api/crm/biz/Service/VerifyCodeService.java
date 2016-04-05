/**
 * @Title: VerifyCodeService.java
 * @Package com.yyabl.api.crm.biz.Service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 下午3:02:51
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Service;

import com.yyabl.api.crm.biz.Exception.GeneralException;

/**
 *@author Maven
 *@version 2014-9-9
 *
/**
 * @ClassName: VerifyCodeService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 下午3:02:51
 * 
 */
public interface VerifyCodeService {
	boolean validateCode(int cardId,String verifyCode,int bizType) throws GeneralException;
}
