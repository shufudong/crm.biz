package com.yyabl.api.crm.biz.Service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Util.BizUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring/Spring.xml", "classpath:Spring/Spring-mybatis.xml" })
public class Test_OrderService {

	private static final Logger logger = LoggerFactory.getLogger(Test_SmsService.class);

	@Resource(name = "orderService")
	private OrderService orderService;

	@Test
	public void convertPaymentToArray() {
		String str = "456.0,123123.00,343234.00";
		int[] aryDouble;
		try {
			aryDouble = BizUtil.convertStringToInt(str);
			logger.info(aryDouble.toString());
		} catch (GeneralException e) {
			logger.info(e.toString());
		}
	}

	@Test
	public void convertPaytypeToArray() {
		String str = "456df,123123,343234";
		int[] aryInt;
		try {
			aryInt = BizUtil.convertStringToInt(str);
			logger.info(aryInt.toString());
		} catch (GeneralException e) {
			logger.info(e.toString());
		}
	}

	@Test
	public void getEffectPayment() {

	}

	@Test
	public void getPointRuleByErpCode() {

	}

}
