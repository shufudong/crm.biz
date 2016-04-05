/**
 * @Title: Test_LmkDefMapper.java
 * @Package com.yyabl.api.crm.biz.Dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月21日 下午2:36:31
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyabl.api.crm.biz.Domain.LmkDef;

/**
 * @ClassName: Test_LmkDefMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月21日 下午2:36:31
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring/Spring.xml", "classpath:Spring/Spring-mybatis.xml" })
public class Test_LmkDefMapper {

	@Resource(name = "lmkDefMapper")
	private LmkDefMapper lmkDefMapper;

	@Test
	public void selectByPrimaryKey() {
		try {
			LmkDef lmkDef = lmkDefMapper.selectByPrimaryKey(7);
			System.out.println(lmkDef.getLmkName());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
	}
}
