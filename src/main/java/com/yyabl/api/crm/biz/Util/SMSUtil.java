/**
 * @Title: SMSUtil.java
 * @Package com.youahui.api.crm.biz.Util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-8-4 上午11:34:50
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Sms.SmsSendReport;

/**
 * @author Maven
 * @version 2014-8-4
 * @ClassName: SMSUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-8-4 上午11:34:50
 * 
 */
public class SMSUtil {
	private static String url = "http://58.63.224.35:8180/service.asmx/SendMessageStr";

	private static int id = 822;

	private static String name = "tepinhui01";

	private static String psw = "88888888";

	/**
	 * @Title: sendSMS
	 * @Description: 短信发送接口
	 * @param @param 手机号码
	 * @param @param 发送内容
	 * @throws
	 */
	public static SmsSendReport sendSMS(String mobileNo, String context) throws GeneralException {
		Long timeStamp = new Date().getTime();
		SmsSendReport smsSendReport = new SmsSendReport();
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Id", Integer.toString(id)));
		params.add(new BasicNameValuePair("name", name));
		params.add(new BasicNameValuePair("psw", psw));
		params.add(new BasicNameValuePair("phone", mobileNo));
		params.add(new BasicNameValuePair("message", context));
		params.add(new BasicNameValuePair("timestamp", Integer.toString(timeStamp.intValue() / 1000)));
		try {
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params, "UTF-8");
			post.setEntity(uefEntity);
			HttpResponse response = httpClient.execute(post);
			String strResponse = EntityUtils.toString(response.getEntity()).toLowerCase();
			String[] aryResponse = strResponse.split(",");
			for (int i = 0; i < aryResponse.length; i++) {
				String[] aryNameValuePair = aryResponse[i].split(":");
				if(aryNameValuePair.length == 2){
					BeanUtils.setProperty(smsSendReport, aryNameValuePair[0], aryNameValuePair[1]);
				}else{
					if(aryNameValuePair.length == 1){
						BeanUtils.setProperty(smsSendReport, aryNameValuePair[0], null);
					}
				}
			}
		} catch (ClientProtocolException e) {
			throw new GeneralException(EnumGeneralException.MSG_SMS_SEND_FAIL, EnumGeneralException.CODE_SMS_SEND_FAIL);
		} catch (IOException e) {
			throw new GeneralException(EnumGeneralException.MSG_SMS_SEND_FAIL, EnumGeneralException.CODE_SMS_SEND_FAIL);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new GeneralException(EnumGeneralException.MSG_SMS_SEND_FAIL, EnumGeneralException.CODE_SMS_SEND_FAIL);
		} catch (IllegalAccessException e) {
			throw new GeneralException(EnumGeneralException.MSG_SMS_SEND_FAIL, EnumGeneralException.CODE_SMS_SEND_FAIL);
		} catch (InvocationTargetException e) {
			throw new GeneralException(EnumGeneralException.MSG_SMS_SEND_FAIL, EnumGeneralException.CODE_SMS_SEND_FAIL);
		}
		return smsSendReport;
	}
}
