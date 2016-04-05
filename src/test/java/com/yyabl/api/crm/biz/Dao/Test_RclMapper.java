/**
 * @Title: Test_RclMapper.java
 * @Package com.yyabl.api.crm.biz.Dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月11日 下午12:20:13
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyabl.api.crm.biz.Domain.Rcl;

/**
 * @author 舒阜东
 * @version 1.0.0.0 
 * Copyright Copyright (c)  2015
 * Company 湖南友阿云商网络有限公司
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring/Spring.xml", "classpath:Spring/Spring-mybatis.xml" })
public class Test_RclMapper {

	@Resource(name = "rclMapper")
	private RclMapper rclMapper;
	
	@Test
	public void checkRclStatus(){
		try {
			Rcl rcl = rclMapper.checkRclStatus();
			System.out.println(rcl.toString());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
	}
}
