package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 
 * ClassName: ReqGenerateCardBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月4日 下午2:45:32 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
public class ReqGenerateCardBean extends RequestBaseBean {
	
	{
		super.setKeyFields(new String[]{"cardNo"});
	}
	
	/**
	 * @Fields cardNo : 会员卡号
	 */
	@NotNull(message = "属性'cardNo'不能为空.")
	@Size(min = 1, max = 20, message = "属性'cardNo'的长度必须在{min}与{max}之间.")
	private String cardNo;

	@NotNull(message = "属性'cardType'不能为空.")
	private Integer cardType;

	/**
	 * @Fields memberName : 会员姓名
	 */
	@NotNull(message = "属性'memberName'不能为空.")
	@Size(min = 1, max = 20, message = "属性'memberName'的长度必须在{min}与{max}之间.")
	private String memberName;

	/**
	 * @Fields sex : 性别
	 */
	@NotNull(message = "属性'sex'不能为空.")
	@Min(value = 0, message = "属性'sex'的值必须大于或等于{value}.")
	@Max(value = 1, message = "属性'sex'的值必须小于或等于{value}.")
	private Integer sex;

	/**
	 * @Fields IDNumber : 证件号码
	 */
	@NotNull(message = "属性'IDNumber'不能为空.")
	@Size(min = 18, max = 18, message = "属性'IDNumber'的长度必须是{min}位数.")
	private String IDNumber;

	/**
	 * @Fields phoneNo : 手机号码
	 */
	@NotNull(message = "属性'phoneNo'不能为空.")
	@Size(min = 7, max = 12, message = "属性'phoneNo'的长度必须在{min}与{max}之间.")
	private String phoneNo;

	/**
	 * @Fields address : 通讯地址
	 */
	@NotNull(message = "属性'address'不能为空.")
	@Size(min = 1, max = 100, message = "属性'address'的长度必须在{min}与{max}之间.")
	private String address;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ReqGenerateCardBean [cardNo=" + cardNo + ", cardType=" + cardType + ", memberName=" + memberName + ", sex=" + sex + ", IDNumber=" + IDNumber + ", phoneNo=" + phoneNo + ", address="
				+ address + ", toString()=" + super.toString() + "]";
	}
}
