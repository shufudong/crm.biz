/**
 * @Title: RespGetRightsOfMemberBean.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月30日 上午6:34:25
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

import java.util.Arrays;

/**
 * @ClassName: RespGetRightsOfMemberBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月30日 上午6:34:25
 * 
 */
public class RespGetRightsOfMemberBean extends ResponseBaseBean {
	private String[] rights;

	public String[] getRights() {
		return rights;
	}

	public void setRights(String[] rights) {
		this.rights = rights;
	}

	@Override
	public String toString() {
		return "RespGetRightsOfMemberBean [rights=" + Arrays.toString(rights) + ", toString()=" + super.toString() + "]";
	}
}
