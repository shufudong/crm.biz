package com.yyabl.api.crm.biz.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyabl.api.crm.biz.Bean.ReqCutTicketBean;
import com.yyabl.api.crm.biz.Bean.ReqExchangePointToTicketBean;
import com.yyabl.api.crm.biz.Bean.ReqFlushesPointBean;
import com.yyabl.api.crm.biz.Bean.ReqFlushesTicketBean;
import com.yyabl.api.crm.biz.Bean.ReqGetEffectPointByCardIdBean;
import com.yyabl.api.crm.biz.Bean.ReqGetEffectTicketByCardIdBean;
import com.yyabl.api.crm.biz.Bean.ReqGetExchangeRuleBean;
import com.yyabl.api.crm.biz.Bean.ReqModifyPointBean;
import com.yyabl.api.crm.biz.Bean.ReqModifyTicketBean;
import com.yyabl.api.crm.biz.Bean.RespCutTicketBean;
import com.yyabl.api.crm.biz.Bean.RespExchangePointToTicketBean;
import com.yyabl.api.crm.biz.Bean.RespFlushesPointBean;
import com.yyabl.api.crm.biz.Bean.RespFlushesTicketBean;
import com.yyabl.api.crm.biz.Bean.RespGetEffectPointByCardIdBean;
import com.yyabl.api.crm.biz.Bean.RespGetEffectTicketByCardIdBean;
import com.yyabl.api.crm.biz.Bean.RespGetExchangeRuleBean;
import com.yyabl.api.crm.biz.Bean.RespModifyPointBean;
import com.yyabl.api.crm.biz.Bean.RespModifyTicketBean;
import com.yyabl.api.crm.biz.Bean.ResponseBaseBean;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.AccountService;

/** 
 * ClassName: AccountController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月3日 下午2:16:44 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/Account")
public class AccountController {
	
	Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Resource(name = "accountService")
	private AccountService accountService;

	/** 
	 * getEffectPointByCardId:(这里用一句话描述这个方法的作用). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqGetEffectPointsByCardIdBean
	 * @param result
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "/getEffectPointByCardId")
	@ResponseBody
	public ResponseBaseBean getEffectPointByCardId(@Valid ReqGetEffectPointByCardIdBean reqGetEffectPointsByCardIdBean, BindingResult result) {
		logger.info("接口"+reqGetEffectPointsByCardIdBean.getUri()+"接收参数:"+reqGetEffectPointsByCardIdBean.toString());
		RespGetEffectPointByCardIdBean respGetEffectPointByCardIdBean = new RespGetEffectPointByCardIdBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGetEffectPointByCardIdBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGetEffectPointByCardIdBean.setMessage(errorMsg.toString());
			logger.error(respGetEffectPointByCardIdBean.toString());
		} else {
			try {
				respGetEffectPointByCardIdBean.setPoints(accountService.searchEffectPointAccountByMemberId(reqGetEffectPointsByCardIdBean.getCardId()));
				respGetEffectPointByCardIdBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (DataAccessException e) {
				respGetEffectPointByCardIdBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGetEffectPointByCardIdBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			} catch (GeneralException e) {
				respGetEffectPointByCardIdBean.setMessage(e.getMessage());
				respGetEffectPointByCardIdBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			}
		}
		logger.info("接口"+reqGetEffectPointsByCardIdBean.getUri()+"返回参数:"+respGetEffectPointByCardIdBean.toString());
		return respGetEffectPointByCardIdBean;
	}

	/** 
	 * getEffectTicketByCardId:(这里用一句话描述这个方法的作用). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqGetEffectTicketsByCardIdBean
	 * @param result
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "/getEffectTicketByCardId")
	@ResponseBody
	public ResponseBaseBean getEffectTicketByCardId(@Valid ReqGetEffectTicketByCardIdBean reqGetEffectTicketsByCardIdBean, BindingResult result) {
		logger.info("接口"+reqGetEffectTicketsByCardIdBean.getUri()+"接收参数:"+reqGetEffectTicketsByCardIdBean.toString());
		RespGetEffectTicketByCardIdBean respGetEffectTicketByCardIdBean = new RespGetEffectTicketByCardIdBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGetEffectTicketByCardIdBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGetEffectTicketByCardIdBean.setMessage(errorMsg.toString());
			logger.error(respGetEffectTicketByCardIdBean.toString());
		} else {
			try {
				respGetEffectTicketByCardIdBean.setTickets(accountService.searchEffectTicketAccountByMemberId(reqGetEffectTicketsByCardIdBean.getCardId()));
				respGetEffectTicketByCardIdBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (DataAccessException e) {
				respGetEffectTicketByCardIdBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGetEffectTicketByCardIdBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			} catch (GeneralException e) {
				respGetEffectTicketByCardIdBean.setMessage(e.getMessage());
				respGetEffectTicketByCardIdBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			}
		}
		logger.info("接口"+reqGetEffectTicketsByCardIdBean.getUri()+"返回参数:"+respGetEffectTicketByCardIdBean.toString());
		return respGetEffectTicketByCardIdBean;
	}

	/** 
	 * exchangePointToTicket:(这里用一句话描述这个方法的作用). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqExchangePointToTicketBean
	 * @param result
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "/exchangePointToTicket")
	@ResponseBody
	public ResponseBaseBean exchangePointToTicket(@Valid ReqExchangePointToTicketBean reqExchangePointToTicketBean, BindingResult result) {
		logger.info("接口"+reqExchangePointToTicketBean.getUri()+"接收参数:"+reqExchangePointToTicketBean.toString());
		RespExchangePointToTicketBean respExchangePointToTicketBean = new RespExchangePointToTicketBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respExchangePointToTicketBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respExchangePointToTicketBean.setMessage(errorMsg.toString());
			logger.error(respExchangePointToTicketBean.toString());
		} else {
			try {
				RespExchangePointToTicketBean tmpRespExchangePointToTicketBean = accountService.exchangePointToTicket(reqExchangePointToTicketBean);
				respExchangePointToTicketBean.setOrderNo(tmpRespExchangePointToTicketBean.getOrderNo());
				respExchangePointToTicketBean.setPoint(tmpRespExchangePointToTicketBean.getPoint());
				respExchangePointToTicketBean.setTicket(tmpRespExchangePointToTicketBean.getTicket());
				respExchangePointToTicketBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (DataAccessException e) {
				respExchangePointToTicketBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respExchangePointToTicketBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			} catch (GeneralException e) {
				respExchangePointToTicketBean.setMessage(e.getMessage());
				respExchangePointToTicketBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			}
		}
		logger.info("接口"+reqExchangePointToTicketBean.getUri()+"返回参数:"+respExchangePointToTicketBean.toString());
		return respExchangePointToTicketBean;
	}

	/** 
	 * modifyPoint:(这里用一句话描述这个方法的作用). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqCutPointBean
	 * @param result
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "/modifyPoint")
	@ResponseBody
	public ResponseBaseBean modifyPoint(@Valid ReqModifyPointBean reqCutPointBean, BindingResult result) {
		logger.info("接口"+reqCutPointBean.getUri()+"接收参数:"+reqCutPointBean.toString());
		RespModifyPointBean respCutPointBean = new RespModifyPointBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respCutPointBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respCutPointBean.setMessage(errorMsg.toString());
			logger.error(respCutPointBean.toString());
		} else {
			try {
				int orderNo = accountService.modifyMemberPointAccount(reqCutPointBean.getTradeNo(), reqCutPointBean.getPartnerCode(),
						reqCutPointBean.getCardId(), reqCutPointBean.getValues(), reqCutPointBean.getBizType());
				respCutPointBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
				respCutPointBean.setOrderNo(orderNo);
			} catch (DataAccessException e) {
				respCutPointBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respCutPointBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			} catch (GeneralException e) {
				respCutPointBean.setMessage(e.getMessage());
				respCutPointBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			}
		}
		logger.info("接口"+reqCutPointBean.getUri()+"返回参数:"+respCutPointBean.toString());
		return respCutPointBean;
	}

	/** 
	 * cutTicket:(这里用一句话描述这个方法的作用). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqCutTicket
	 * @param result
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "/cutTicket")
	@ResponseBody
	public ResponseBaseBean cutTicket(@Valid ReqCutTicketBean reqCutTicket, BindingResult result) {
		logger.info("接口"+reqCutTicket.getUri()+"接收参数:"+reqCutTicket.toString());
		RespCutTicketBean respCutTicketBean = new RespCutTicketBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respCutTicketBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respCutTicketBean.setMessage(errorMsg.toString());
			logger.error(respCutTicketBean.toString());
		} else {
			try {
				int orderNo = accountService.cutMemberTicketAccount(reqCutTicket.getTradeNo(), reqCutTicket.getPartnerCode(), reqCutTicket.getCardId(),
						reqCutTicket.getValues(), reqCutTicket.getBizType());
				respCutTicketBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
				respCutTicketBean.setOrderNo(orderNo);
			} catch (DataAccessException e) {
				respCutTicketBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respCutTicketBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			} catch (GeneralException e) {
				respCutTicketBean.setMessage(e.getMessage());
				respCutTicketBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			}
		}
		logger.info("接口"+reqCutTicket.getUri()+"返回参数:"+respCutTicketBean.toString());
		return respCutTicketBean;
	}

	/** 
	 * flushesTicket:(这里用一句话描述这个方法的作用). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqFlushesTicket
	 * @param result
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "/flushesTicket")
	@ResponseBody
	public ResponseBaseBean flushesTicket(@Valid ReqFlushesTicketBean reqFlushesTicket, BindingResult result) {
		logger.info("接口"+reqFlushesTicket.getUri()+"接收参数:"+reqFlushesTicket.toString());
		RespFlushesTicketBean respFlushesTicketBean = new RespFlushesTicketBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respFlushesTicketBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respFlushesTicketBean.setMessage(errorMsg.toString());
			logger.error(respFlushesTicketBean.toString());
		} else {
			try{
				int orderNo = accountService.flushesMemberTicketAccount(reqFlushesTicket);
				respFlushesTicketBean.setOrderNo(orderNo);
				respFlushesTicketBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			}catch (DataAccessException e) {
				respFlushesTicketBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respFlushesTicketBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			} catch (GeneralException e) {
				respFlushesTicketBean.setMessage(e.getMessage());
				respFlushesTicketBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			}
		}
		logger.info("接口"+reqFlushesTicket.getUri()+"返回参数:"+respFlushesTicketBean.toString());
		return respFlushesTicketBean;
	}

	/** 
	 * flushesPoint:(这里用一句话描述这个方法的作用). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqFlushesPointBean
	 * @param result
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "/flushesPoint")
	@ResponseBody
	public ResponseBaseBean flushesPoint(@Valid ReqFlushesPointBean reqFlushesPointBean, BindingResult result) {
		RespFlushesPointBean respFlushesPointBean = new RespFlushesPointBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respFlushesPointBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respFlushesPointBean.setMessage(errorMsg.toString());
		} else {
			try{
				int orderNo = accountService.flushesMemberPointAccount(reqFlushesPointBean);
				respFlushesPointBean.setOrderNo(orderNo);
				respFlushesPointBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			}catch (DataAccessException e) {
				respFlushesPointBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respFlushesPointBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			} catch (GeneralException e) {
				respFlushesPointBean.setMessage(e.getMessage());
				respFlushesPointBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			}
		}
		logger.info("接口"+reqFlushesPointBean.getUri()+"返回参数:"+respFlushesPointBean.toString());
		return respFlushesPointBean;
	}

	/** 
	 * getExchangeRule:(这里用一句话描述这个方法的作用). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqExchangeRuleBean
	 * @param result
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "/getExchangeRule")
	@ResponseBody
	public ResponseBaseBean getExchangeRule(@Valid ReqGetExchangeRuleBean reqExchangeRuleBean, BindingResult result) {
		logger.info("接口"+reqExchangeRuleBean.getUri()+"接收参数:"+reqExchangeRuleBean.toString());
		RespGetExchangeRuleBean respGetExchangeRuleBean = new RespGetExchangeRuleBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGetExchangeRuleBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGetExchangeRuleBean.setMessage(errorMsg.toString());
			logger.error(respGetExchangeRuleBean.toString());
		} else {
			try {
				respGetExchangeRuleBean = accountService.getExchangeRule(reqExchangeRuleBean.getCardId());
				respGetExchangeRuleBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (DataAccessException e) {
				respGetExchangeRuleBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGetExchangeRuleBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			} catch (GeneralException e) {
				respGetExchangeRuleBean.setMessage(e.getMessage());
				respGetExchangeRuleBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			}
		}
		logger.info("接口"+reqExchangeRuleBean.getUri()+"返回参数:"+respGetExchangeRuleBean.toString());
		return respGetExchangeRuleBean;
	}
	
	/** 
	 * modifyTicket:(这里用一句话描述这个方法的作用). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author 舒阜东
	 * @param reqModifyTicketBean
	 * @param result
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value="/modifyTicket")
	@ResponseBody
	public ResponseBaseBean modifyTicket(@Valid ReqModifyTicketBean reqModifyTicketBean,BindingResult result){
		logger.info("接口"+reqModifyTicketBean.getUri()+"接收参数:"+reqModifyTicketBean.toString());
		RespModifyTicketBean respModifyTicketBean = new RespModifyTicketBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respModifyTicketBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respModifyTicketBean.setMessage(errorMsg.toString());
			logger.error(respModifyTicketBean.toString());
		} else {
			try {
				int orderNo = accountService.modifyMemberTicketAccount(reqModifyTicketBean.getCardId(), reqModifyTicketBean.getValues(), reqModifyTicketBean.getTradeNo(), reqModifyTicketBean.getTicketType(), reqModifyTicketBean.getValidDate(), reqModifyTicketBean.getUseScope(), reqModifyTicketBean.getBizType(), reqModifyTicketBean.getPartnerCode());
				respModifyTicketBean.setOrderNo(orderNo);
				respModifyTicketBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (DataAccessException e) {
				respModifyTicketBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respModifyTicketBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			} catch (GeneralException e) {
				respModifyTicketBean.setMessage(e.getMessage());
				respModifyTicketBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			}
		}
		logger.info("接口"+reqModifyTicketBean.getUri()+"返回参数:"+respModifyTicketBean.toString());
		return respModifyTicketBean;
	}

}
