package com.yyabl.api.crm.biz.Domain;

import java.util.Date;

public class Hyk_SMS_Verify_Code extends Hyk_SMS_Verify_CodeKey {
    private String verifyCode;

    private Date sendDate;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode == null ? null : verifyCode.trim();
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

	@Override
	public String toString() {
		return "Hyk_SMS_Verify_Code [verifyCode=" + verifyCode + ", sendDate=" + sendDate + "]";
	}
    
    
}