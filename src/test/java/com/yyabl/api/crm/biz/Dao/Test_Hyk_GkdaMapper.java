/**
 * @Title: Test_Hyk_GkdaMapper.java
 * @Package com.yyabl.api.crm.biz.Dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月21日 上午11:57:41
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyabl.api.crm.biz.Domain.Hyk_Gkda;

/**
 * @ClassName: Test_Hyk_GkdaMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月21日 上午11:57:41
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring/Spring.xml", "classpath:Spring/Spring-mybatis.xml" })
public class Test_Hyk_GkdaMapper {
	@Resource(name = "hyk_GkdaMapper")
	private Hyk_GkdaMapper hyk_GkdaMapper;

	@Test
	public void selectByIdNumber() {
		String zjhm = "430702198203234017";
		try {
			Hyk_Gkda hyk_Gkda = hyk_GkdaMapper.selectByIdNumber(zjhm);
			System.out.println(hyk_Gkda.getSjhm());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
	}
}
