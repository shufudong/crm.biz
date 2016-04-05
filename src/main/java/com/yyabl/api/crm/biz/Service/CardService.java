/**
 * @Title: CardService.java
 * @Package com.yyabl.api.crm.biz.Service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-4 上午3:24:09
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Service;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Bean.ReqGenerateCardBean;
import com.yyabl.api.crm.biz.Bean.ReqMergeCardBean;
import com.yyabl.api.crm.biz.Domain.Hyk_Hyxx;
import com.yyabl.api.crm.biz.Exception.GeneralException;

/**
 * @author Maven
 * @version 2014-9-4
 * @ClassName: CardService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-4 上午3:24:09
 * 
 */
public interface CardService {
	/**
	 * @Title: findCardIdByParamMap
	 * @Description: 根据参数列表获取会员卡ID。目前支持的参数名有cardId,cardNo,phoneNo三种。
	 * @param @param paramMap
	 * @param @return
	 * @param @throws GeneralException
	 * @param @throws DataAccessException    设定文件
	 * @return int    会员卡ID
	 * @throws
	 */
	int findCardIdByParamMap(Map<String, Object> paramMap) throws GeneralException,DataAccessException;

	/**
	 * @Title: findCardIdByCardNo
	 * @Description: 根据会员卡号获取会员卡ID
	 * @param @param cardNo
	 * @param @return
	 * @param @throws GeneralException
	 * @param @throws DataAccessException    设定文件
	 * @return int    会员卡ID
	 * @throws
	 */
	int findCardIdByCardNo(String cardNo) throws GeneralException,DataAccessException;

	/**
	 * @Title: findCustomerInfoByCardID
	 * @Description: 根据会员卡ID获取会员卡信息,其中会员卡信息包含“HYK_HYXX”、“HYK_GKDA”、“HYKDEF”和“HYK_STATUS”4张数据表中的数据
	 * @param @param cardID
	 * @param @return
	 * @param @throws GeneralException
	 * @param @throws DataAccessException    设定文件
	 * @return Hyk_Hyxx    返回类型
	 * @throws
	 */
	Hyk_Hyxx findCustomerInfoByCardID(int cardID) throws GeneralException,DataAccessException;

	/**
	 * @Title: findMobileNoByCardNo
	 * @Description: 根据会员卡号获取手机号码
	 * @param @param cardNo
	 * @param @return
	 * @param @throws GeneralException
	 * @param @throws DataAccessException    设定文件
	 * @return String    手机号码
	 * @throws
	 */
	String findMobileNoByCardNo(String cardNo) throws GeneralException,DataAccessException;
	
	/**
	 * @Title: generateCard
	 * @Description: 创建会员卡
	 * @param @param reqGenerateCardBean
	 * @param @return
	 * @param @throws GeneralException
	 * @param @throws DataAccessException    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	int generateCard(ReqGenerateCardBean reqGenerateCardBean) throws GeneralException,DataAccessException;

	/**
	 * @Title: mergeCard
	 * @Description: <p>会员卡并卡。在线下CRM系统中，并没有会员卡并卡的业务。因此，线上会员卡的合并操作，是将线下的‘会员积分转储’和‘优惠券转储’两个功能合二为一。</p>
	 * <p>会员卡并卡操作是将源卡的积分余额和电子券余额转储到目标卡中，同时将源卡标记为“作废”状态。但源卡的历史消费记录以及相关的操作单据，不会被目标卡继承。</p>
	 * @param @param reqMergeCardBean
	 * @param @return
	 * @param @throws GeneralException
	 * @param @throws DataAccessException    设定文件
	 * @return int    单据号
	 * @throws
	 */
	int mergeCard(ReqMergeCardBean reqMergeCardBean) throws GeneralException,DataAccessException;
	
	/**
	 * @Title: getRightsOfMember
	 * @Description: 获取会员卡特权
	 * @param @param cardId
	 * @param @return
	 * @param @throws GeneralException
	 * @param @throws DataAccessException    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	String[] getRightsOfMember(int cardId) throws GeneralException,DataAccessException;
}
