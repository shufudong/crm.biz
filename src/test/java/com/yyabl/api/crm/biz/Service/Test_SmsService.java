package com.yyabl.api.crm.biz.Service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.yyabl.api.crm.biz.Bean.RespSendVerifyCodeByCardNoBean;
import com.yyabl.api.crm.biz.Exception.GeneralException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring/Spring.xml", "classpath:Spring/Spring-mybatis.xml" })
public class Test_SmsService {

	private static final Logger logger = LoggerFactory.getLogger(Test_SmsService.class);

	@Resource(name = "smsService")
	private SmsService smsService;

	@Test
	public void sendVerifyCodeByCardNo() {
		try {
			RespSendVerifyCodeByCardNoBean respSendVerifyCodeByCardNoBean = smsService.sendVerifyCodeByCardNo("436745510397623", 1);
			logger.info(JSON.toJSONString(respSendVerifyCodeByCardNoBean));
		} catch (GeneralException e) {
			logger.info(JSON.toJSONString("错误:" + e.toString()));
		}
	}
}
