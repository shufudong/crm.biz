package com.yyabl.api.crm.biz.Service.Impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Override
	public double getEffectPayment(int[] paytype, double[] payment) throws GeneralException, DataAccessException {
		if (paytype.length != payment.length) {
			throw new GeneralException(EnumGeneralException.MSG_THE_LENGTH_IS_NOT_EQUAL_TO_THE_PAYTYPE_OF_PAYMENT,
					EnumGeneralException.CODE_THE_LENGTH_IS_NOT_EQUAL_TO_THE_PAYTYPE_OF_PAYMENT);
		}
		return 0;
	}

	@Override
	public int getPointRuleByErpCode(int mallId, String erpCode, int cardId) throws GeneralException, DataAccessException {
		return 0;
	}

}
