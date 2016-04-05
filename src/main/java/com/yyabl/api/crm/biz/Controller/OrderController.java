/**
 * @Title: OrderController.java
 * @Package com.yyabl.api.crm.biz.Controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-4 上午5:41:03
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

import com.yyabl.api.crm.biz.Bean.ReqGetProductPointsBean;
import com.yyabl.api.crm.biz.Bean.RespGetProductPointsBean;
import com.yyabl.api.crm.biz.Bean.ResponseBaseBean;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.OrderService;
import com.yyabl.api.crm.biz.Util.BizUtil;

/**
 * 
 * @ClassName: OrderController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-4 上午5:41:03
 * 
 */

@Controller
@RequestMapping(value = "/Order")
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Resource(name = "orderService")
	OrderService orderService;

	@RequestMapping(value = "/getProductPoints")
	@ResponseBody
	public ResponseBaseBean getProductPoints(@Valid ReqGetProductPointsBean reqGetProductPoints, BindingResult result) {
		logger.info("接口"+reqGetProductPoints.getUri()+"接收参数:"+reqGetProductPoints.toString());
		RespGetProductPointsBean respGetProductPoints = new RespGetProductPointsBean();
		if (result.hasFieldErrors()) {
			List<FieldError> lstFieldError = result.getFieldErrors();
			StringBuffer errorMsg = new StringBuffer();
			for (FieldError fieldError : lstFieldError) {
				errorMsg.append(fieldError.getDefaultMessage());
			}
			respGetProductPoints.setStatus(EnumGeneralException.CODE_REQUEST_VALID);
			respGetProductPoints.setMessage(errorMsg.toString());
			logger.error(respGetProductPoints.toString());
		} else {
			try {
				// 将'支付金额'字符串转为数组
				double[] payment = BizUtil.convertStringToDouble(reqGetProductPoints.getPayment());
				// 将'支付方式'字符串转为数组
				int[] paytype = BizUtil.convertStringToInt(reqGetProductPoints.getPayType());
				// 获取能够参与积分的支付金额合计
				double effectPayment = orderService.getEffectPayment(paytype, payment);
				// 获取积分规则(每一元积多少分)
				double pointRule = orderService.getPointRuleByErpCode(reqGetProductPoints.getMallId(), reqGetProductPoints.getErpCode(),
						reqGetProductPoints.getCardId());
				// 有效积分乘以积分规则既为该商品的积分数
				respGetProductPoints.setPoints(effectPayment * pointRule);
				respGetProductPoints.setStatus(EnumGeneralException.CODE_RESPONSE_SUCCESS);
			} catch (GeneralException e) {
				respGetProductPoints.setStatus(e.getErrorCode());
				respGetProductPoints.setMessage(e.getMessage());
				logger.error(e.getMessage());
			} catch (DataAccessException e) {
				respGetProductPoints.setMessage(EnumGeneralException.MSG_DATA_ACCESS_EXCEPTION);
				respGetProductPoints.setStatus(EnumGeneralException.CODE_DATA_ACCESS_EXCEPTION);
				logger.error(e.getMessage());
			}
		}
		logger.info("接口"+reqGetProductPoints.getUri()+"返回参数:"+respGetProductPoints.toString());
		return respGetProductPoints;
	}
}
