package com.yyabl.api.crm.biz.Service;

import java.math.BigDecimal;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Bean.ReqExchangePointToTicketBean;
import com.yyabl.api.crm.biz.Bean.ReqFlushesPointBean;
import com.yyabl.api.crm.biz.Bean.ReqFlushesTicketBean;
import com.yyabl.api.crm.biz.Bean.RespExchangePointToTicketBean;
import com.yyabl.api.crm.biz.Bean.RespGetExchangeRuleBean;
import com.yyabl.api.crm.biz.Exception.GeneralException;

/** 
 * ClassName: AccountService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月3日 下午5:11:04 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
public interface AccountService {
	
	/** 
	 * searchEffectPointAccountByMemberId:按会员卡ID查询有效积分值. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param cardId
	 * @return
	 * @throws GeneralException
	 * @throws DataAccessException 
	 * @since JDK 1.7
	 */
	int searchEffectPointAccountByMemberId(Integer cardId) throws GeneralException,DataAccessException;
	
	/** 
	 * searchEffectTicketAccountByMemberId:按会员卡ID查询有效电子券金额. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param cardId
	 * @return
	 * @throws GeneralException
	 * @throws DataAccessException 
	 * @since JDK 1.7
	 */
	int searchEffectTicketAccountByMemberId(Integer cardId) throws GeneralException,DataAccessException;
	
	/** 
	 * getExchangeRule:积分兑换电子券规则. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param cardId
	 * @return
	 * @throws GeneralException
	 * @throws DataAccessException 
	 * @since JDK 1.7
	 */
	RespGetExchangeRuleBean getExchangeRule(Integer cardId) throws GeneralException,DataAccessException;
	
	/**
	 * @Title: exchangePointToTicket
	 * @Description: 积分兑换电子券
	 * @param @param reqExchangePointToTicketBean
	 * @param @return
	 * @param @throws GeneralException
	 * @param @throws DataAccessException    设定文件
	 * @return RespExchangePointToTicketBean    返回类型
	 * @throws
	 */
	RespExchangePointToTicketBean exchangePointToTicket(ReqExchangePointToTicketBean reqExchangePointToTicketBean) throws GeneralException,DataAccessException;
	
	/** 
	 * modifyMemberPointAccount:增减积分. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param tradeNo
	 * @param partnerCode
	 * @param cardId
	 * @param points
	 * @param bizType
	 * @return
	 * @throws GeneralException
	 * @throws DataAccessException 
	 * @since JDK 1.7
	 */
	int modifyMemberPointAccount(String tradeNo,String partnerCode,Integer cardId,Double points,Integer bizType) throws GeneralException,DataAccessException;
	
	/** 
	 * cutMemberTicketAccount:减少优惠券. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param tradeNo
	 * @param partnerCode
	 * @param cardId
	 * @param tickets
	 * @param bizType
	 * @return
	 * @throws GeneralException
	 * @throws DataAccessException 
	 * @since JDK 1.7
	 */
	int cutMemberTicketAccount(String tradeNo,String partnerCode,Integer cardId,Double tickets,Integer bizType) throws GeneralException,DataAccessException;
	
	/** 
	 * modifyMemeberTicketAccount:增减优惠券<br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param cardId
	 * @param value
	 * @param tradeNo
	 * @param ticketType
	 * @param validDate
	 * @param useScope
	 * @param partnerCode
	 * @return
	 * @throws GeneralException
	 * @throws DataAccessException 
	 * @since JDK 1.7
	 */
	int modifyMemberTicketAccount(Integer cardId,BigDecimal value,String tradeNo,Integer ticketType,Long validDate,String useScope,Integer bizType,String partnerCode) throws GeneralException,DataAccessException;

	/** 
	 * flushesMemberPointAccount:积分增减冲正. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqFlushesPointBean
	 * @return
	 * @throws GeneralException
	 * @throws DataAccessException 
	 * @since JDK 1.7
	 */
	int flushesMemberPointAccount(ReqFlushesPointBean reqFlushesPointBean) throws GeneralException,DataAccessException;
	
	/** 
	 * flushesMemberTicketAccount:电子券增减冲正. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqFlushesTicketBean
	 * @return
	 * @throws GeneralException
	 * @throws DataAccessException 
	 * @since JDK 1.7
	 */
	int flushesMemberTicketAccount(ReqFlushesTicketBean reqFlushesTicketBean) throws GeneralException,DataAccessException;
}
