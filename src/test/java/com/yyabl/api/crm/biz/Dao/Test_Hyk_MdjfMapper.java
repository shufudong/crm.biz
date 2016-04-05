/**
 * @Title: Test_Hyk_MdjfMapper.java
 * @Package com.yyabl.api.crm.biz.Dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月21日 上午6:54:40
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: Test_Hyk_MdjfMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月21日 上午6:54:40
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring/Spring.xml", "classpath:Spring/Spring-mybatis.xml" })
public class Test_Hyk_MdjfMapper {
	private static final Logger logger = LoggerFactory.getLogger(Test_Hyk_MdjfMapper.class);
	
	@Resource(name = "hyk_MdjfMapper")
	private Hyk_MdjfMapper hyk_MdjfMapper;

	@Test
	public void procUpdateBHZT() {
		Map<String, Object> procParam = new HashMap<String, Object>();
		procParam.put("HYID", 517018);
		procParam.put("DJJF", 500);
		procParam.put("JLBH", 684561);
		procParam.put("ProcDate", DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		hyk_MdjfMapper.procHyxfMdjfFt(procParam);
	}

	@Test
	public void selectEffectTicketByCardId() {
		try {
			int points = hyk_MdjfMapper.selectEffectPointsByCardId(2086605);
			logger.info(JSON.toJSONString(points));
		} catch (DataAccessException e) {
			logger.info(JSON.toJSONString("错误:" + e.getMessage()));
		}
	}
}
