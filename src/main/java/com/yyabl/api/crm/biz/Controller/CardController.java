/**
 * @Title: CardController.java
 * @Package com.yyabl.api.crm.biz.Controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-4 上午5:40:53
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.yyabl.api.crm.biz.Bean.ReqGenerateCardBean;
import com.yyabl.api.crm.biz.Bean.ReqGetCardIdByCardNoAndPhoneNoBean;
import com.yyabl.api.crm.biz.Bean.ReqGetCardIdByCardNoBean;
import com.yyabl.api.crm.biz.Bean.ReqGetCardIdByVerifyInfoBean;
import com.yyabl.api.crm.biz.Bean.ReqGetCardInfoByCardIdBean;
import com.yyabl.api.crm.biz.Bean.ReqGetMobileNoByCardNoBean;
import com.yyabl.api.crm.biz.Bean.ReqGetRightsOfMemberBean;
import com.yyabl.api.crm.biz.Bean.ReqMergeCardBean;
import com.yyabl.api.crm.biz.Bean.RespGenerateCardBean;
import com.yyabl.api.crm.biz.Bean.RespGetCardIdByCardNoAndPhoneNoBean;
import com.yyabl.api.crm.biz.Bean.RespGetCardIdByCardNoBean;
import com.yyabl.api.crm.biz.Bean.RespGetCardIdByVerifyInfoBean;
import com.yyabl.api.crm.biz.Bean.RespGetCardInfoByCardIdBean;
import com.yyabl.api.crm.biz.Bean.RespGetMobileNoByCardNoBean;
import com.yyabl.api.crm.biz.Bean.RespGetRightsOfMemberBean;
import com.yyabl.api.crm.biz.Bean.RespMergeCardBean;
import com.yyabl.api.crm.biz.Bean.ResponseBaseBean;
import com.yyabl.api.crm.biz.Domain.Hyk_Hyxx;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.AccountService;
import com.yyabl.api.crm.biz.Service.CardService;
import com.yyabl.api.crm.biz.Service.VerifyCodeService;

/**
 * @ClassName: CardController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-4 上午5:40:53
 * 
 */

@Controller
@RequestMapping(value = "/Card")
public class CardController {

	Logger logger = LoggerFactory.getLogger(CardController.class);

	@Resource(name = "cardService")
	private CardService cardService;

	@Resource(name = "verifyCodeService")
	private VerifyCodeService verifyCodeService;
	
	@Resource(name = "accountService")
	private AccountService accountService;

	@RequestMapping(value = "/getMobileNoByCardNo")
	@ResponseBody
	public ResponseBaseBean getMobileNoByCardNo(@Valid ReqGetMobileNoByCardNoBean reqGetMobileNoByCardNoBean, BindingResult result) {
		logger.info("接口" + reqGetMobileNoByCardNoBean.getUri() + "接收参数:" + reqGetMobileNoByCardNoBean.toString());
		RespGetMobileNoByCardNoBean respGetMobileNoByCardNoBean = new RespGetMobileNoByCardNoBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGetMobileNoByCardNoBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGetMobileNoByCardNoBean.setMessage(errorMsg.toString());
			logger.error(respGetMobileNoByCardNoBean.toString());
		} else {
			try {
				String mobileNo = cardService.findMobileNoByCardNo(reqGetMobileNoByCardNoBean.getCardNo());
				respGetMobileNoByCardNoBean.setMobileNo(mobileNo);
				respGetMobileNoByCardNoBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (GeneralException e) {
				respGetMobileNoByCardNoBean.setMessage(e.getMessage());
				respGetMobileNoByCardNoBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			} catch (DataAccessException e) {
				respGetMobileNoByCardNoBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGetMobileNoByCardNoBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			}
		}
		logger.info("接口" + reqGetMobileNoByCardNoBean.getUri() + "返回参数:" + respGetMobileNoByCardNoBean.toString());
		return respGetMobileNoByCardNoBean;
	}

	@RequestMapping(value = "/getCardIdByCardNo")
	@ResponseBody
	public ResponseBaseBean getCardIdByCardNo(@Valid ReqGetCardIdByCardNoBean reqGetCardIdByCardNoBean, BindingResult result) {
		logger.info("接口" + reqGetCardIdByCardNoBean.getUri() + "接收参数:" + reqGetCardIdByCardNoBean.toString());
		RespGetCardIdByCardNoBean respGetCardIdByCardNo = new RespGetCardIdByCardNoBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGetCardIdByCardNo.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGetCardIdByCardNo.setMessage(errorMsg.toString());
			logger.error(respGetCardIdByCardNo.toString());
		} else {
			try {
				int cardId = cardService.findCardIdByCardNo(reqGetCardIdByCardNoBean.getCardNo());
				respGetCardIdByCardNo.setCardId(cardId);
				respGetCardIdByCardNo.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (GeneralException e) {
				respGetCardIdByCardNo.setMessage(e.getMessage());
				respGetCardIdByCardNo.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			} catch (DataAccessException e) {
				respGetCardIdByCardNo.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGetCardIdByCardNo.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			}
		}
		logger.info("接口" + reqGetCardIdByCardNoBean.getUri() + "返回参数:" + respGetCardIdByCardNo.toString());
		return respGetCardIdByCardNo;
	}

	@RequestMapping(value = "/getCardIdByVerifyInfo")
	@ResponseBody
	public ResponseBaseBean getCardIdByVerifyInfo(@Valid ReqGetCardIdByVerifyInfoBean reqGetCardIdByVerifyInfo, BindingResult result) {
		logger.info("接口" + reqGetCardIdByVerifyInfo.getUri() + "接收参数:" + reqGetCardIdByVerifyInfo.toString());
		RespGetCardIdByVerifyInfoBean respGetCardIdByVerifyInfoBean = new RespGetCardIdByVerifyInfoBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGetCardIdByVerifyInfoBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGetCardIdByVerifyInfoBean.setMessage(errorMsg.toString());
			logger.error(respGetCardIdByVerifyInfoBean.toString());
		} else {
			try {
				int cardId = cardService.findCardIdByCardNo(reqGetCardIdByVerifyInfo.getCardNo());
				if (verifyCodeService.validateCode(cardId, reqGetCardIdByVerifyInfo.getVerifyCode(), reqGetCardIdByVerifyInfo.getBizType())) {
					respGetCardIdByVerifyInfoBean.setCardId(cardId);
					respGetCardIdByVerifyInfoBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
				}
			} catch (GeneralException e) {
				respGetCardIdByVerifyInfoBean.setMessage(e.getMessage());
				respGetCardIdByVerifyInfoBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			} catch (DataAccessException e) {
				respGetCardIdByVerifyInfoBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGetCardIdByVerifyInfoBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			}
		}
		logger.info("接口" + reqGetCardIdByVerifyInfo.getUri() + "返回参数:" + respGetCardIdByVerifyInfoBean.toString());
		return respGetCardIdByVerifyInfoBean;
	}

	@RequestMapping(value = "/getCardInfoByCardId")
	@ResponseBody
	public ResponseBaseBean getCardInfoByCardId(@Valid ReqGetCardInfoByCardIdBean reqGetCardInfoByCardId, BindingResult result) {
		logger.info("接口" + reqGetCardInfoByCardId.getUri() + "接收参数:" + reqGetCardInfoByCardId.toString());
		RespGetCardInfoByCardIdBean respGetCardInfoByCardIdBean = new RespGetCardInfoByCardIdBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGetCardInfoByCardIdBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGetCardInfoByCardIdBean.setMessage(errorMsg.toString());
			logger.error(respGetCardInfoByCardIdBean.toString());
		} else {
			try {
				Hyk_Hyxx cardInfo = cardService.findCustomerInfoByCardID(reqGetCardInfoByCardId.getCardId());
				int pointTotal = accountService.searchEffectPointAccountByMemberId(reqGetCardInfoByCardId.getCardId());
				int ticketTotal = accountService.searchEffectTicketAccountByMemberId(reqGetCardInfoByCardId.getCardId());
				respGetCardInfoByCardIdBean.setHyk_Hyxx(cardInfo);
				respGetCardInfoByCardIdBean.setPointTotal(pointTotal);
				respGetCardInfoByCardIdBean.setTicketTotal(ticketTotal);
				respGetCardInfoByCardIdBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (GeneralException e) {
				respGetCardInfoByCardIdBean.setMessage(e.getMessage());
				respGetCardInfoByCardIdBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			} catch (DataAccessException e) {
				respGetCardInfoByCardIdBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGetCardInfoByCardIdBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			}
		}
		logger.info("接口" + reqGetCardInfoByCardId.getUri() + "返回参数:" + respGetCardInfoByCardIdBean.toString());
		return respGetCardInfoByCardIdBean;
	}

	@RequestMapping(value = "/generateCard")
	@ResponseBody
	public ResponseBaseBean generateCard(@Valid ReqGenerateCardBean reqGenerateCardBean, BindingResult result) {
		logger.info("接口" + reqGenerateCardBean.getUri() + "接收参数:" + reqGenerateCardBean.toString());
		RespGenerateCardBean respGenerateCardBean = new RespGenerateCardBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGenerateCardBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGenerateCardBean.setMessage(errorMsg.toString());
			logger.error(respGenerateCardBean.toString());
		} else {
			try {
				int cardId = cardService.generateCard(reqGenerateCardBean);
				respGenerateCardBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
				respGenerateCardBean.setCardId(cardId);
			} catch (GeneralException e) {
				respGenerateCardBean.setMessage(e.getMessage());
				respGenerateCardBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			} catch (DataAccessException e) {
				respGenerateCardBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGenerateCardBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			}
		}
		logger.info("接口" + reqGenerateCardBean.getUri() + "返回参数:" + respGenerateCardBean.toString());
		return respGenerateCardBean;
	}

	@RequestMapping(value = "/getCardIdByCardNoAndPhoneNo")
	@ResponseBody
	public ResponseBaseBean getCardIdByCardNoAndPhoneNo(@Valid ReqGetCardIdByCardNoAndPhoneNoBean reqGetCardIdByCardNoAndPhoneNoBean, BindingResult result) {
		logger.info("接口" + reqGetCardIdByCardNoAndPhoneNoBean.getUri() + "接收参数:" + reqGetCardIdByCardNoAndPhoneNoBean.toString());
		RespGetCardIdByCardNoAndPhoneNoBean respGetCardIdByCardNoAndPhoneNoBean = new RespGetCardIdByCardNoAndPhoneNoBean();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGetCardIdByCardNoAndPhoneNoBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGetCardIdByCardNoAndPhoneNoBean.setMessage(errorMsg.toString());
			logger.error(respGetCardIdByCardNoAndPhoneNoBean.toString());
		} else {
			try {
				paramMap.put("cardNo", reqGetCardIdByCardNoAndPhoneNoBean.getCardNo());
				paramMap.put("phoneNo", reqGetCardIdByCardNoAndPhoneNoBean.getPhoneNo());
				int cardId = cardService.findCardIdByParamMap(paramMap);
				respGetCardIdByCardNoAndPhoneNoBean.setCardId(cardId);
				respGetCardIdByCardNoAndPhoneNoBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (GeneralException e) {
				respGetCardIdByCardNoAndPhoneNoBean.setMessage(e.getMessage());
				respGetCardIdByCardNoAndPhoneNoBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			} catch (DataAccessException e) {
				respGetCardIdByCardNoAndPhoneNoBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGetCardIdByCardNoAndPhoneNoBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			}
		}
		logger.info("接口" + reqGetCardIdByCardNoAndPhoneNoBean.getUri() + "返回参数:" + respGetCardIdByCardNoAndPhoneNoBean.toString());
		return respGetCardIdByCardNoAndPhoneNoBean;
	}

	@RequestMapping(value = "/mergeCard")
	@ResponseBody
	public ResponseBaseBean mergeCard(@Valid ReqMergeCardBean reqMergeCardBean, BindingResult result) {
		logger.info("接口" + reqMergeCardBean.getUri() + "接收参数:" + reqMergeCardBean.toString());
		RespMergeCardBean respMergeCardBean = new RespMergeCardBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respMergeCardBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respMergeCardBean.setMessage(errorMsg.toString());
			logger.error(respMergeCardBean.toString());
		} else {
			try {
				int orderNO = cardService.mergeCard(reqMergeCardBean);
				respMergeCardBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
				respMergeCardBean.setOrderNo(orderNO);
			} catch (GeneralException e) {
				respMergeCardBean.setMessage(e.getMessage());
				respMergeCardBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			} catch (DataAccessException e) {
				respMergeCardBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respMergeCardBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			}
		}
		logger.info("接口" + reqMergeCardBean.getUri() + "返回参数:" + respMergeCardBean.toString());
		return respMergeCardBean;
	}

	@RequestMapping(value = "/getRightsOfMember")
	@ResponseBody
	public ResponseBaseBean getRightsOfMember(@Valid ReqGetRightsOfMemberBean reqGetRightsOfMemberBean, BindingResult result) {
		logger.info("接口" + reqGetRightsOfMemberBean.getUri() + "接收参数:" + reqGetRightsOfMemberBean.toString());
		RespGetRightsOfMemberBean respGetRightsOfMemberBean = new RespGetRightsOfMemberBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGetRightsOfMemberBean.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGetRightsOfMemberBean.setMessage(errorMsg.toString());
			logger.error(respGetRightsOfMemberBean.toString());
		} else {
			try {
				String[] aryRights = cardService.getRightsOfMember(reqGetRightsOfMemberBean.getCardId());
				respGetRightsOfMemberBean.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
				respGetRightsOfMemberBean.setRights(aryRights);
			} catch (GeneralException e) {
				respGetRightsOfMemberBean.setMessage(e.getMessage());
				respGetRightsOfMemberBean.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			} catch (DataAccessException e) {
				respGetRightsOfMemberBean.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGetRightsOfMemberBean.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			}
		}
		logger.info("接口" + reqGetRightsOfMemberBean.getUri() + "返回参数:" + respGetRightsOfMemberBean.toString());
		return respGetRightsOfMemberBean;
	}
}
