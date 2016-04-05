/**
 * @Title: VerifyCodeServiceImpl.java
 * @Package com.yyabl.api.crm.biz.Service.Impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 下午3:23:22
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Service.Impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yyabl.api.crm.biz.Dao.Hyk_SMS_Verify_CodeMapper;
import com.yyabl.api.crm.biz.Domain.Hyk_SMS_Verify_Code;
import com.yyabl.api.crm.biz.Domain.Hyk_SMS_Verify_CodeKey;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.VerifyCodeService;

/**
 * @author Maven
 * @version 2014-9-9
 * 
 *          /**
 * @ClassName: VerifyCodeServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 下午3:23:22
 * 
 */
@Service("verifyCodeService")
public class VerifyCodeServiceImpl implements VerifyCodeService {

	@Resource(name = "hyk_SMS_Verify_CodeMapper")
	private Hyk_SMS_Verify_CodeMapper hyk_SMS_Verify_CodeMapper;

	public boolean validateCode(int cardId, String verifyCode, int bizType) throws GeneralException, DataAccessException {
		boolean isValidateCode = false;
		Hyk_SMS_Verify_CodeKey hyk_SMS_Verify_CodeKey = new Hyk_SMS_Verify_CodeKey();
		hyk_SMS_Verify_CodeKey.setHyid(cardId);
		hyk_SMS_Verify_CodeKey.setBizType(bizType);
		Hyk_SMS_Verify_Code hyk_SMS_Verify_Code = hyk_SMS_Verify_CodeMapper.selectByPrimaryKey(hyk_SMS_Verify_CodeKey);
		// 查询结果为空时，抛出异常
		if (hyk_SMS_Verify_Code == null) {
			throw new GeneralException(EnumGeneralException.MSG_VERIFYCODE_NOT_EXIST, EnumGeneralException.CODE_VERIFYCODE_NOT_EXIST);
		}
		String tmpVerifyCode = hyk_SMS_Verify_Code.getVerifyCode();
		// 验证码不匹配时，抛出异常
		if (!(verifyCode.equals(tmpVerifyCode))) {
			throw new GeneralException(EnumGeneralException.MSG_VERIFYCODE_NOT_MATCHING, EnumGeneralException.CODE_VERIFYCODE_NOT_MATCHING);
		}
		// 如果请求提交时间与系统当前时间相差超过30分钟，则认为请求超时。
		if (Math.abs(System.currentTimeMillis() - hyk_SMS_Verify_Code.getSendDate().getTime()) > 1000 * 60 * 30) {
			throw new GeneralException(EnumGeneralException.MSG_VERIFYCODE_IS_LOSE, EnumGeneralException.CODE_VERIFYCODE_IS_LOSE);
		}
		isValidateCode = true;
		return isValidateCode;
	}
}
