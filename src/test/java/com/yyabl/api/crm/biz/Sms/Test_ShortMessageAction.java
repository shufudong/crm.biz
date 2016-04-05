/**
 * @Title: Test_ShortMessageAction.java
 * @Package com.yyabl.api.crm.biz.Sms
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月5日 上午10:56:22
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Sms;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.yyabl.api.crm.biz.Sign.MD5;

/**
 * @ClassName: Test_ShortMessageAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2015年1月5日 上午10:56:22
 * 
 */
public class Test_ShortMessageAction {
	private static String URL="http://162.105.167.123/customer";
	
	@Test
	public void testSendSms() throws Exception{
		String url = URL + "/iface/sendSms";
		JsonHttp http = new JsonHttp();
		http.setUrl(url);
		JSONObject request = new JSONObject();
		request.put("phone", "13607447847");
		request.put("text", "测试短信");
		request.put("username", "youayun");
		request.put("password", MD5.encode16("youayun"));
		String data = http.requestObject(request);
		JSONObject object = JSONObject.fromObject(data);
		System.out.println(object.get("data"));
	}
}
