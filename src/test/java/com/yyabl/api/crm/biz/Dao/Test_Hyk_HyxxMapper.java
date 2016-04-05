package com.yyabl.api.crm.biz.Dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyabl.api.crm.biz.Domain.Hyk_Hyxx;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring/Spring.xml", "classpath:Spring/Spring-mybatis.xml" })
public class Test_Hyk_HyxxMapper {
	
	@Resource(name = "hyk_HyxxMapper")
	private Hyk_HyxxMapper hyk_HyxxMapper;

	@Test
	public void selectCardIdByParamMap() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cardNo", "436745510397623");
		//param.put("phoneNo", "13607447847");
		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectCardInfoByParamMap(param);
		System.out.println(hyk_Hyxx.getHykType().getImageUrl());
	}
}
