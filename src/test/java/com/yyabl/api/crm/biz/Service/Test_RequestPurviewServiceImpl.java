/**
 * @Title: Test_RequestPurviewServiceImpl.java
 * @Package com.yyabl.api.crm.biz.Service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月26日 下午5:57:34
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyabl.api.crm.biz.Bean.ReqGetCardInfoByCardIdBean;

/**
 * @author 舒阜东
 * @version 1.0.0.0 
 * Copyright Copyright (c)  2015
 * Company 湖南友阿云商网络有限公司
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dev/Spring/Spring.xml", "classpath:dev/Spring/Spring-mybatis.xml" })
public class Test_RequestPurviewServiceImpl {

	Logger logger = LoggerFactory.getLogger(Test_RequestPurviewServiceImpl.class);

	@Resource(name = "requestPurviewService")
	private RequestPurviewService requestPurviewService;

	@Test
	public void isReentrant() {
		ReqGetCardInfoByCardIdBean reqGetCardInfoByCardIdBean = new ReqGetCardInfoByCardIdBean();
		logger.info(reqGetCardInfoByCardIdBean.toString());
	}
}
