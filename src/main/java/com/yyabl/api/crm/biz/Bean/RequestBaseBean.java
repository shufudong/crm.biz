package com.yyabl.api.crm.biz.Bean;

import java.util.Arrays;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RequestBaseBean
 * @Description: 这是请求类的基类，所有的session bean都必须继承这个类。<br/>
 *               每个请求参数列表中都必须必须包含这个类中定义的四个字段，并且这四个字段不能为空。
 * @author Maven
 * @date 2014-6-25 下午12:53:58
 * 
 */

@Component("requestBaseBean")
public class RequestBaseBean {

	/**
	 * @Fields partenrCode : 合作商户帐号
	 */
	@NotEmpty(message = "错误：参数'partnerCode'不能为空。")
	private String partnerCode;

	/**
	 * @Fields signature : 签名
	 */
	@NotEmpty(message = "错误：参数'signature'不能为空。")
	private String signature;

	/**
	 * @Fields version : 接口版本
	 */
	@NotEmpty(message = "错误：参数'version'不能为空。")
	private String version;

	/**
	 * @Fields timeStamp : 时间戳
	 */
	@Min(value = -1, message = "错误：参数'timeStamp'必须大于0。")
	private long timeStamp;

	/**
	 * @Fields uri : 请求地址
	 */
	private String uri;

	/**
	 * @Fields keyFields : 设置需要进行重入性检查的字段，这个值需要在子类的静态初始化方法中设置。如果这个值为空，将不会对接口进行重入性检查。
	 */
	private String[] keyFields;

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String[] getKeyFields() {
		return keyFields;
	}

	public void setKeyFields(String[] keyFields) {
		this.keyFields = keyFields;
	}

	@Override
	public String toString() {
		return "RequestBaseBean [partnerCode=" + partnerCode + ", signature="
				+ signature + ", version=" + version + ", timeStamp="
				+ timeStamp + ", uri=" + uri + ", keyFields="
				+ Arrays.toString(keyFields) + ", toString()="
				+ super.toString() + "]";
	}
}
