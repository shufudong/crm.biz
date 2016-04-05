/**
 * @Title: Test_BizUtil.java
 * @Package com.yyabl.api.crm.biz.Util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月24日 上午4:48:12
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Util;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @ClassName: Test_BizUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月24日 上午4:48:12
 * 
 */

public class Test_BizUtil {
	
	@Test
	public void isValidAnalyzingCard(){
		//boolean b = BizUtil.isValidAnalyzingCard(0);
		//System.out.println(b);
	}
	
	@Test
	public void getMapMemberRight(){
		String memberRight = BizUtil.getMemberRight(200);
		System.out.println(memberRight);
	}
	
	@Test
	public void getCollectionEffectCardStatus(){
		System.out.println(DateTime.parse(new DateTime().plusYears(1).toString("yyyy-MM-dd")).toString("yyyy-MM-dd hh:mm:ss"));
	}
}
