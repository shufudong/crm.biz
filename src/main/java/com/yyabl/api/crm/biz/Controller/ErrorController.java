/**
 * @Title: ErrorController.java
 * @Package com.yyabl.api.crm.biz.Controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月9日 上午9:52:44
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyabl.api.crm.biz.Bean.ResponseBaseBean;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;

/**
 * @ClassName: ErrorController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2015年1月9日 上午9:52:44
 * 
 */

@Controller
@RequestMapping(value = "/Error")
public class ErrorController {

	Logger logger = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping(value = "/{errorCode}")
	@ResponseBody
	public ResponseBaseBean base(@PathVariable String errorCode) {
		ResponseBaseBean responseBaseBean = new ResponseBaseBean();
		responseBaseBean.setMessage(EnumGeneralException.MSG_CONTAINER_ERROR + errorCode);
		responseBaseBean.setStatus(EnumGeneralException.CODE_CONTAINER_ERROR);
		logger.error(responseBaseBean.toString());
		return responseBaseBean;
	}
}
