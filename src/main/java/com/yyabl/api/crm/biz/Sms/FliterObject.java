/**
 * @Title: FliterObject.java
 * @Package com.yyabl.api.crm.biz.Sms
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月5日 上午10:32:41
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Sms;

/**
 * @ClassName: FliterObject
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2015年1月5日 上午10:32:41
 * 
 */
public class FliterObject {
	private String property;
	private String operator;
	private Object value;

	public FliterObject(String property, Object value, String operator) {
		this.property = property;
		this.value = value;
		this.operator = operator;
	}

	public FliterObject(String property, Object value) {
		this.property = property;
		this.value = value;
		this.operator = "=";
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
