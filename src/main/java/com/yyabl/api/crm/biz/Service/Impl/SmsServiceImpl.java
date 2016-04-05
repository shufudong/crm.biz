/**
 * @Title: SmsServiceImpl.java
 * @Package com.yyabl.api.crm.biz.Service.Impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 上午10:51:44
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yyabl.api.crm.biz.Bean.RespSendVerifyCodeByCardNoBean;
import com.yyabl.api.crm.biz.Bean.ResponseBaseBean;
import com.yyabl.api.crm.biz.Dao.Hyk_HyxxMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_SMS_Verify_CodeMapper;
import com.yyabl.api.crm.biz.Dao.SmsTemplateMapper;
import com.yyabl.api.crm.biz.Domain.Hyk_Hyxx;
import com.yyabl.api.crm.biz.Domain.Hyk_SMS_Verify_Code;
import com.yyabl.api.crm.biz.Domain.Hyk_SMS_Verify_CodeKey;
import com.yyabl.api.crm.biz.Domain.SmsTemplate;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.SmsService;
import com.yyabl.api.crm.biz.Sms.SmsUtil;
import com.yyabl.api.crm.biz.Util.BizUtil;

/** 
 * ClassName: SmsServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月5日 下午1:53:32 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {

	@Resource(name = "smsTemplateMapper")
	private SmsTemplateMapper smsTemplateMapper;

	@Resource(name = "hyk_HyxxMapper")
	private Hyk_HyxxMapper hyk_HyxxMapper;

	@Resource(name = "hyk_SMS_Verify_CodeMapper")
	private Hyk_SMS_Verify_CodeMapper hyk_SMS_Verify_CodeMapper;

	private final String varString = "#{verifycode}";

	public RespSendVerifyCodeByCardNoBean sendVerifyCodeByCardNo(String cardNo, int bizType) throws GeneralException,DataAccessException {
		RespSendVerifyCodeByCardNoBean respSendVerifyCodeByCardNoBean = new RespSendVerifyCodeByCardNoBean();
		
		// 生成6位随机码
		String verifyCode = BizUtil.getRandomCode(6);
		// 根据会员卡号获取会员信息
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("cardNo", cardNo);
		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectCardInfoByParamMap(paramMap);
		
		//判断会员数据是否为空
		if (hyk_Hyxx == null) {
			throw new GeneralException(EnumGeneralException.MSG_CARDID_NOT_FOUND, EnumGeneralException.CODE_CARDID_NOT_FOUND);
		}
		
		//判断手机号码是否为空
		if (hyk_Hyxx.getHykGkda().getSjhm() == null){
			throw new GeneralException(EnumGeneralException.MSG_CAN_NOT_FOUND_MOBILENO_BY_CARDNO,EnumGeneralException.CODE_CAN_NOT_FOUND_MOBILENO_BY_CARDNO);
		}
		
		//判断会员卡状态是否是有效卡
		if (!BizUtil.isValidAnalyzingCard(hyk_Hyxx.getStatus())) {
			throw new GeneralException(EnumGeneralException.MSG_CARD_IS_VALID, EnumGeneralException.CODE_CARD_IS_VALID);
		}
		
		//判断会员卡格式是否正确
		if (!BizUtil.isMobileNo(hyk_Hyxx.getHykGkda().getSjhm())) {
			throw new GeneralException(EnumGeneralException.MSG_MOBILENO_FORMAT_ERROR, EnumGeneralException.CODE_MOBILENO_FORMAT_ERROR);
		}
		
		SmsTemplate smsTemplate = smsTemplateMapper.selectByPrimaryKey(bizType);
		if (smsTemplate == null) {
			throw new GeneralException(EnumGeneralException.MSG_SMS_SEND_NOT_BIZTYPE, EnumGeneralException.CODE_SMS_SEND_NOT_BIZTYPE);
		}
		// 获取短信内容模板
		String smsTemplateStr = smsTemplate.getContext();

		// 替换短信模板中的验证码变量
		String smsContext = smsTemplateStr.replace(varString, verifyCode);

		// 发送短信
		//SmsSendReport sendReport = SMSUtil.sendSMS(hyk_Hyxx.getHykGkda().getSjhm(), smsContext);
		ResponseBaseBean responseBaseBean = SmsUtil.sendSms(hyk_Hyxx.getHykGkda().getSjhm(), smsContext);

		if (responseBaseBean.getStatus() == 1) {
			Hyk_SMS_Verify_CodeKey hyk_SMS_Verify_CodeKey = new Hyk_SMS_Verify_CodeKey();
			hyk_SMS_Verify_CodeKey.setHyid(hyk_Hyxx.getHyid());
			hyk_SMS_Verify_CodeKey.setBizType(bizType);
			Hyk_SMS_Verify_Code hyk_SMS_Verify_Code = hyk_SMS_Verify_CodeMapper.selectByPrimaryKey(hyk_SMS_Verify_CodeKey);
			if(hyk_SMS_Verify_Code == null){
				hyk_SMS_Verify_Code = new Hyk_SMS_Verify_Code();
				hyk_SMS_Verify_Code.setHyid(hyk_Hyxx.getHyid());
				hyk_SMS_Verify_Code.setBizType(bizType);
				hyk_SMS_Verify_Code.setVerifyCode(verifyCode);
				hyk_SMS_Verify_Code.setSendDate(new Date());
				hyk_SMS_Verify_CodeMapper.insert(hyk_SMS_Verify_Code);
			}else{
				hyk_SMS_Verify_Code.setVerifyCode(verifyCode);
				hyk_SMS_Verify_Code.setSendDate(new Date());
				hyk_SMS_Verify_CodeMapper.updateByPrimaryKey(hyk_SMS_Verify_Code);
			}
			respSendVerifyCodeByCardNoBean.setComplete(true);
			respSendVerifyCodeByCardNoBean.setSendDate(new Date());
			respSendVerifyCodeByCardNoBean.setBizType(bizType);
		} else {
			throw new GeneralException(responseBaseBean.getMessage(),responseBaseBean.getStatus());
		}
		
		return respSendVerifyCodeByCardNoBean;
	}

}
