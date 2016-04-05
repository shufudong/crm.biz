/**
 * @Title: RespGetMobileNoByCardNoBean.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 上午5:23:38
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

/**
 * @author Maven
 * @version 2014-9-9
 * 
 *          /**
 * @ClassName: RespGetMobileNoByCardNoBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 上午5:23:38
 * 
 */
public class RespGetMobileNoByCardNoBean extends ResponseBaseBean {
	private String mobileNo;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "RespGetMobileNoByCardNoBean [mobileNo=" + mobileNo + ", toString()=" + super.toString() + "]";
	}
}
