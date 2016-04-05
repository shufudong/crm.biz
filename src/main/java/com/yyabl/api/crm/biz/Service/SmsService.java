/**
 * @Title: SmsService.java
 * @Package com.yyabl.api.crm.biz.Service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 上午3:26:27
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Service;

import com.yyabl.api.crm.biz.Bean.RespSendVerifyCodeByCardNoBean;
import com.yyabl.api.crm.biz.Exception.GeneralException;

/**
 *@author Maven
 *@version 2014-9-9
 *
/**
 * @ClassName: SmsService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 上午3:26:27
 * 
 */
public interface SmsService {
	RespSendVerifyCodeByCardNoBean sendVerifyCodeByCardNo(String cardNo, int bizType) throws GeneralException;
}
