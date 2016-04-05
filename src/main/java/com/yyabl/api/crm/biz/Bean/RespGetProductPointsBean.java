/**
 * @Title: RespGetProductPoints.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-12 下午4:31:39
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

/**
 * @author Maven
 * @version 2014-9-12
 * 
 *          /**
 * @ClassName: RespGetProductPoints
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-12 下午4:31:39
 * 
 */
public class RespGetProductPointsBean extends ResponseBaseBean {

	private double points;

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "RespGetProductPointsBean [points=" + points + ", toString()=" + super.toString() + "]";
	}

}
