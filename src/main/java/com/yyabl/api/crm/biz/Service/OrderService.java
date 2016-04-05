package com.yyabl.api.crm.biz.Service;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Exception.GeneralException;

/**
 * @ClassName: OrderService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年10月14日 下午4:38:41
 * 
 */
public interface OrderService {
	
	/**
	 * @Title: getEffectPayment
	 * @Description: 根据支付方式和支付金额，计算能够参与积分的支付金额
	 * @param @param paytype 支付方式
	 * @param @param payment 支付金额
	 * @param @return
	 * @param @throws GeneralException
	 * @param @throws DataAccessException    设定文件
	 * @return double    返回类型
	 * @throws
	 */
	double getEffectPayment(int[] paytype,double[] payment) throws GeneralException,DataAccessException;
	
	
	/**
	 * @Title: getPointByErpCode
	 * @Description: 根据erp编码和会员ID,计算商品的积分分值
	 * @param @param erpCode erp编码
	 * @param @param cardId  会员ID
	 * @param @return
	 * @param @throws GeneralException
	 * @param @throws DataAccessException    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	int getPointRuleByErpCode(int mallId,String erpCode,int cardId) throws GeneralException,DataAccessException;
}
