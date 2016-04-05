package com.yyabl.api.crm.biz.Bean;

/**
 * @ClassName: RespGetEffectPointsByCardIdBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年9月29日 上午11:45:23
 * 
 */
public class RespGetEffectPointByCardIdBean extends ResponseBaseBean {
	
	/**
	 * @Fields points : 有效积分值
	 */
	private int points;

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "RespGetEffectPointByCardIdBean [points=" + points + ", toString()=" + super.toString() + "]";
	}

}
