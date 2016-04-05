/**
 * @Title: SignCore.java
 * @Package com.youahui.api.crm.biz.Sgin
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-7-13 下午6:14:55
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Sign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SignCore
 * @Description: 验证请求签名的核心类，配合RequestUtil和MD5使用。
 * @author Maven
 * @date 2014-7-13 下午6:14:55
 * 
 */
public class SignCore {
	/**
	 * @Title: paramFilter
	 * @Description: 去掉Map<String,String>中参数名为"signature"的键值对，和去掉参数值为空的键值对之后，返回一个新的Map<String,String>。
	 * @param Map
	 *            <String,String> 签名参数组
	 * @param @return
	 * @return Map<String,String> 去掉空值与签名参数后的新签名参数组
	 * @throws
	 */
	public static Map<String, String> paramFilter(Map<String, String> sArray) {
		Map<String, String> result = new HashMap<String, String>();
		
		if (sArray == null || sArray.size() <= 0) {
			return result;
		}
		
		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("signature") || key.equalsIgnoreCase("uri")) {
				continue;
			}
			result.put(key, value);
		}
		return result;
	}

	/**
	 * @Title: createLinkString
	 * @Description:把数组所有元素排序，并按照"参数=参数值"的模式用“&”字符拼接成字符串
	 * @param Map
	 *            <String,String> params 需要排序并参与字符拼接的参数主
	 * @param @return
	 * @return String 拼接后的字符串
	 * @throws
	 */
	public static String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		StringBuffer paramStringBuffer = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			// 拼接时，不包含最后一个&字符
			if (i == keys.size() - 1) {
				paramStringBuffer.append(key).append("=").append(value);
			} else {
				paramStringBuffer.append(key).append("=").append(value).append("&");
			}
		}
		return paramStringBuffer.toString();
	}
}
