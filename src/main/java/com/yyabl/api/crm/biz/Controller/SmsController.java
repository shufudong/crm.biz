/**
 * @Title: SmsController.java
 * @Package com.yyabl.api.crm.biz.Controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 上午10:52:56
 * @version V1.0
 */
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

import com.yyabl.api.crm.biz.Bean.ReqSendVerifyCodeByCardNoBean;
import com.yyabl.api.crm.biz.Bean.RespSendVerifyCodeByCardNoBean;
import com.yyabl.api.crm.biz.Bean.ResponseBaseBean;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.SmsService;

/**
 * @author Maven
 * @version 2014-9-9
 * 
 *          /**
 * @ClassName: SmsController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 上午10:52:56
 * 
 */
@Controller
@RequestMapping(value = "/Sms")
public class SmsController {

	Logger logger = LoggerFactory.getLogger(SmsController.class);

	@Resource(name = "smsService")
	private SmsService smsService;

	@RequestMapping(value = "/sendVerifyCodeByCardNo")
	@ResponseBody
	public ResponseBaseBean sendVerifyCodeByCardNo(@Valid ReqSendVerifyCodeByCardNoBean reqSendVerifyCodeByCardNo, BindingResult result) {
		logger.info("接口" + reqSendVerifyCodeByCardNo.getUri() + "接收参数:" + reqSendVerifyCodeByCardNo.toString());
		RespSendVerifyCodeByCardNoBean respSendVerifyCodeByCardNo = new RespSendVerifyCodeByCardNoBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respSendVerifyCodeByCardNo.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respSendVerifyCodeByCardNo.setMessage(errorMsg.toString());
			logger.error(respSendVerifyCodeByCardNo.toString());
		} else {
			try {
				respSendVerifyCodeByCardNo = smsService.sendVerifyCodeByCardNo(reqSendVerifyCodeByCardNo.getCardNo(), reqSendVerifyCodeByCardNo.getBizType());
				respSendVerifyCodeByCardNo.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (GeneralException e) {
				respSendVerifyCodeByCardNo.setMessage(e.getMessage());
				respSendVerifyCodeByCardNo.setStatus(e.getErrorCode());
				logger.error(e.getMessage());
			} catch (DataAccessException e) {
				respSendVerifyCodeByCardNo.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respSendVerifyCodeByCardNo.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			}
		}
		logger.info("接口" + reqSendVerifyCodeByCardNo.getUri() + "返回参数:" + respSendVerifyCodeByCardNo.toString());
		return respSendVerifyCodeByCardNo;
	}
}
