/**
 * @Title: Test_BhztMapper.java
 * @Package com.yyabl.api.crm.biz.Dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月20日 下午10:59:08
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: Test_BhztMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月20日 下午10:59:08
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring/Spring.xml", "classpath:Spring/Spring-mybatis.xml" })
public class Test_BhztMapper {
	
	Logger logger = LoggerFactory.getLogger(Test_BhztMapper.class);

	@Resource(name = "bhztMapper")
	private BhztMapper bhztMapper;

	@Test
	public void procUpdateBHZT() {
		/*
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("TBLNAME", "TEST");
		param.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(param);
		System.out.println(JSON.toJSONString(param.get("NewRecNo")));
		*/
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("TBLNAME", "HYK_VIPJLCLJL");
		paramMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(paramMap);
		int orderNo = (Integer) paramMap.get("NewRecNo");
		logger.info(String.valueOf(orderNo));
	}
}
