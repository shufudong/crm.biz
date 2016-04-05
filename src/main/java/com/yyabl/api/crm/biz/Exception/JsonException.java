/**
 * @Title: JsonException.java
 * @Package com.yyabl.api.crm.biz.Exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月5日 上午10:33:49
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Exception;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * @ClassName: JsonException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2015年1月5日 上午10:33:49
 * 
 */
public class JsonException extends RuntimeException {
	/**
	 * 未知错误
	 */
	public final static int UNKNOWN = -1;
	/**
	 * 非法请求
	 */
	final static public int illegality = -2;
	/**
	 * 操作成功
	 */
	public final static int SUCCESS = 1;

	private static final long serialVersionUID = 1122143232172398932L;
	private Class<?> rise;
	private String name;
	private Object[] arguments;
	private int code;

	/**
	 * 生成异常
	 * 
	 * @param rise
	 *            对象类
	 * @param code
	 *            错误编码
	 * @param name
	 *            错误名
	 */
	public JsonException(Class<?> rise, int code, String name) {
		this(rise, code, name, null);
	}

	/**
	 * 生成异常
	 * 
	 * @param rise
	 *            对象类
	 * @param e
	 *            其他异常
	 */
	public JsonException(Class<?> rise, Exception e) {
		this(rise, JsonException.UNKNOWN, e.getLocalizedMessage(), null);
	}

	/**
	 * 生成异常
	 * 
	 * @param rise
	 *            对象类
	 * @param code
	 *            错误编码
	 * @param name
	 *            错误名
	 * @param arguments
	 *            错误说明数组
	 */
	public JsonException(Class<?> rise, int code, String name, Object[] arguments) {
		this.rise = rise;
		this.code = code;
		this.name = name;
		this.arguments = arguments;
	}

	public String toString() {
		return "{\"code\":" + code + ",\"info\":\"" + getMessage() + "\"}";
	}

	public int getCode() {
		return code;
	}

	public Class<?> getRise() {
		return this.rise;
	}

	public String getMessage() {
		String rtv = null;
		rtv = rise.getName() + "." + name;
		for (int i = 0; arguments != null && i < arguments.length; i++) {
			rtv += i + ":" + arguments[i].toString();
		}
		return rtv;
	}

	public String getName() {
		return this.name;
	}

	public String getLocalizedMessage(Locale locale) {

		String m = null;
		String rtv = null;
		try {
			m = name;
			if (m != null && m.length() > 0 && arguments != null) {
				MessageFormat form = new MessageFormat(m);
				rtv = form.format(arguments);
			} else if (m != null && m.length() > 0 && arguments == null) {
				rtv = m;
			}
		} catch (Throwable t) {
			rtv = name;// rise.getName()+ "." +
			for (int i = 0; arguments != null && i < arguments.length; i++) {
				rtv += i + ":" + arguments[i].toString();
			}
		}
		return rtv;
	}
}
