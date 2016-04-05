/**
 * @Title: SmsUtil.java
 * @Package com.yyabl.api.crm.biz.Sms
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月5日 上午11:46:46
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Sms;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yyabl.api.crm.biz.Bean.ResponseBaseBean;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Sign.MD5;

/**
 * @ClassName: SmsUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2015年1月5日 上午11:46:46
 * 
 */
public class SmsUtil {
	
	static Logger logger = LoggerFactory.getLogger(SmsUtil.class);
	
	private static String URL = "http://162.105.167.123/customer/iface/sendSms";
	private static String username = "youayun";
	private static String password = "youayun";

	public static ResponseBaseBean sendSms(String phone, String text) throws GeneralException {
		ResponseBaseBean responseBaseBean = new ResponseBaseBean();
		try {
			JsonHttp jsonHttp = new JsonHttp();
			jsonHttp.setUrl(URL);
			JSONObject smsRequest = new JSONObject();
			smsRequest.put("phone", phone);
			smsRequest.put("text", text);
			smsRequest.put("username", username);
			smsRequest.put("password", MD5.encode16(password));
			String respStr = jsonHttp.requestObject(smsRequest);
			JSONObject object = JSONObject.fromObject(respStr);
			responseBaseBean.setStatus((Integer)object.get("returnCode"));
			responseBaseBean.setMessage(object.get("data").toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GeneralException(EnumGeneralException.MSG_NUMBER_FORMAT_EXCEPTION, EnumGeneralException.CODE_NUMBER_FORMAT_EXCEPTION);
		}
		return responseBaseBean;
	}
}
