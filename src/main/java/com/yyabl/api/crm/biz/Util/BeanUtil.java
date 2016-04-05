/**
 * @Title: BeanUtil.java
 * @Package com.youahui.api.crm.Biz_Client.Util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-7-13 下午8:13:48
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yyabl.api.crm.biz.Bean.RequestBaseBean;

/**
 * @author Maven
 * @version 2014-7-13
 * @ClassName: BeanUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-7-13 下午8:13:48
 * 
 */
public class BeanUtil {

	static Logger logger = LoggerFactory.getLogger(BeanUtil.class);
	static String keyPrefix = "_key_";

	/**
	 * @Title: getMap
	 * @Description: 利用反射机制将JavaBean转为Map<String,String>
	 * @param @param obj JavaBean
	 * @param @return
	 * @return Map<String,String> 返回类型
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static Map<String, String> getMap(Object obj) {
		Map<String, String> map = new HashMap<String, String>();
		Field[] fields = null;
		fields = obj.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				String fieldValue = field.get(obj).toString();
				map.put(fieldName, fieldValue);
			}
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
		}
		return map;
	}

	/**
	 * @Title: getQueryString
	 * @Description: 将JavaBean转换为请求带?的请求字符串，用于httpClient的doGet方式的调用。
	 * @param @param obj
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	public static String getRequestString(Object obj) {
		StringBuffer queryStr = new StringBuffer();
		queryStr.append("?");
		Field[] fields = null;
		fields = obj.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				String fieldName = fields[i].getName();
				String fieldValue = fields[i].get(obj).toString();
				if (i == fields.length) {
					queryStr.append(fieldName).append("=").append(fieldValue);
				} else {
					queryStr.append(fieldName).append("=").append(fieldValue).append("&");
				}
			}
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
		}
		return queryStr.toString();
	}

	public static String buildReqKeyString(RequestBaseBean requestBaseBean) {
		StringBuffer keyString = new StringBuffer();
		String[] keyFields = requestBaseBean.getKeyFields();
		if (keyFields == null) {
			logger.error("keyFields为空，不能转为字符串");
		} else {
			keyString = keyString.append(keyPrefix);
			for (String key : keyFields) {
				String value = ReflectionUtils.getFieldValue(requestBaseBean, key).toString();
				keyString = keyString.append(value);
			}
		}
		return keyString.toString();
	}
}
