package com.yyabl.api.crm.biz.Dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
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
import com.yyabl.api.crm.biz.Domain.Hyk_Yhqzh;
import com.yyabl.api.crm.biz.Util.BizUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring/Spring.xml", "classpath:Spring/Spring-mybatis.xml","classpath:Spring/Spring-memcached.xml" })
public class Test_Hyk_YhqzhMapper {

	private static final Logger logger = LoggerFactory.getLogger(Test_Hyk_YhqzhMapper.class);

	@Resource(name = "hyk_YhqzhMapper")
	private Hyk_YhqzhMapper hyk_YhqzhMapper;

	@Test
	public void selectEffectTicketByCardId() {
		try {
			int tickets = hyk_YhqzhMapper.selectEffectTicketsByCardId(2086605);
			System.out.println(tickets);
			logger.info(JSON.toJSONString(tickets));
		} catch (DataAccessException e) {
			logger.info(JSON.toJSONString("错误:" + e.getMessage()));
		}
	}

	@Test
	public void updateByPrimaryKey() {
		short yhqid = 0;
		try {
			Hyk_Yhqzh hyk_Yhqzh = new Hyk_Yhqzh();
			hyk_Yhqzh.setHyid(517018);
			hyk_Yhqzh.setYhqid(yhqid);
			hyk_Yhqzh.setJsrq(DateTime.parse(new DateTime("2008-04-24").toString("yyyy-MM-dd")).toDate());
			hyk_Yhqzh.setMdfwdm("");
			hyk_Yhqzh.setJe(new BigDecimal(99));
			hyk_Yhqzh.setJydjje(new BigDecimal(0));
			int rowCount = hyk_YhqzhMapper.updateByPrimaryKey(hyk_Yhqzh);
			System.out.println(rowCount);
		} catch (DataAccessException e) {
			logger.info(JSON.toJSONString("错误:" + e.getMessage()));
		}
	}
	
	@Test
	public void selectTicketByParamMap(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("cardId", 2086605);
		paramMap.put("ticketType", BizUtil.getCollectionAvailableTicketType());
		paramMap.put("validDate", DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		paramMap.put("useScope", new String(""));
		List<Hyk_Yhqzh> lst_Hyk_Yhqzh = hyk_YhqzhMapper.selectTicketByParamMap(paramMap);
		for(Hyk_Yhqzh hyk_Yhqzh : lst_Hyk_Yhqzh){
			System.out.println(hyk_Yhqzh.toString());
		}
	}
}
