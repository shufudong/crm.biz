/**
 * @Title: CardServiceImpl.java
 * @Package com.yyabl.api.crm.biz.Service.Impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-4 上午5:31:57
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Service.Impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yyabl.api.crm.biz.Bean.ReqGenerateCardBean;
import com.yyabl.api.crm.biz.Bean.ReqMergeCardBean;
import com.yyabl.api.crm.biz.Dao.ApiMergeCardItemPointMapper;
import com.yyabl.api.crm.biz.Dao.ApiMergeCardItemTicketMapper;
import com.yyabl.api.crm.biz.Dao.ApiMergeCardMapper;
import com.yyabl.api.crm.biz.Dao.ApiOrgDefMapper;
import com.yyabl.api.crm.biz.Dao.ApiPersonDefMapper;
import com.yyabl.api.crm.biz.Dao.BhztMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_BgddMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_Czk_Yhq_ZcMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_Czk_Yhq_Zc_ItemMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_GkdaMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_HyxxMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_JfbdjlmxMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_JfzcjlMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_Jfzcjl_ItemMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_JfzhMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_YhqcljlMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_YhqzhMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_ZfjlMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_Zfjl_ItemMapper;
import com.yyabl.api.crm.biz.Dao.LmkDefMapper;
import com.yyabl.api.crm.biz.Dao.RyxxMapper;
import com.yyabl.api.crm.biz.Domain.ApiMergeCard;
import com.yyabl.api.crm.biz.Domain.ApiMergeCardItemPoint;
import com.yyabl.api.crm.biz.Domain.ApiMergeCardItemTicket;
import com.yyabl.api.crm.biz.Domain.ApiOrgDef;
import com.yyabl.api.crm.biz.Domain.ApiPersonDef;
import com.yyabl.api.crm.biz.Domain.Hyk_Bgdd;
import com.yyabl.api.crm.biz.Domain.Hyk_Czk_Yhq_Zc;
import com.yyabl.api.crm.biz.Domain.Hyk_Czk_Yhq_Zc_Item;
import com.yyabl.api.crm.biz.Domain.Hyk_Gkda;
import com.yyabl.api.crm.biz.Domain.Hyk_Hyxx;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfbdjlmx;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfzcjl;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfzcjl_Item;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfzh;
import com.yyabl.api.crm.biz.Domain.Hyk_Yhqcljl;
import com.yyabl.api.crm.biz.Domain.Hyk_Yhqzh;
import com.yyabl.api.crm.biz.Domain.Hyk_YhqzhKey;
import com.yyabl.api.crm.biz.Domain.Hyk_Zfjl;
import com.yyabl.api.crm.biz.Domain.Hyk_Zfjl_Item;
import com.yyabl.api.crm.biz.Domain.LmkDef;
import com.yyabl.api.crm.biz.Domain.Ryxx;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.CardService;
import com.yyabl.api.crm.biz.Util.BizUtil;

/**
 * @author Maven
 * @version 2014-9-4
 * @ClassName: CardServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-4 上午5:31:57
 * 
 */
@Service("cardService")
public class CardServiceImpl implements CardService {

	@Resource(name = "hyk_HyxxMapper")
	private Hyk_HyxxMapper hyk_HyxxMapper;

	@Resource(name = "hyk_GkdaMapper")
	private Hyk_GkdaMapper hyk_GkdaMapper;

	@Resource(name = "bhztMapper")
	private BhztMapper bhztMapper;

	@Resource(name = "lmkDefMapper")
	private LmkDefMapper lmkDefMapper;

	@Resource(name = "ryxxMapper")
	private RyxxMapper ryxxMapper;

	@Resource(name = "apiPersonDefMapper")
	private ApiPersonDefMapper apiPersonDefMapper;

	@Resource(name = "apiOrgDefMapper")
	private ApiOrgDefMapper apiOrgDefMapper;

	@Resource(name = "hyk_JfzhMapper")
	private Hyk_JfzhMapper hyk_JfzhMapper;

	@Resource(name = "hyk_YhqzhMapper")
	private Hyk_YhqzhMapper hyk_YhqzhMapper;

	@Resource(name = "hyk_JfzcjlMapper")
	private Hyk_JfzcjlMapper hyk_JfzcjlMapper;

	@Resource(name = "hyk_Jfzcjl_ItemMapper")
	private Hyk_Jfzcjl_ItemMapper hyk_Jfzcjl_ItemMapper;

	@Resource(name = "hyk_ZfjlMapper")
	private Hyk_ZfjlMapper hyk_ZfjlMapper;

	@Resource(name = "hyk_Zfjl_ItemMapper")
	private Hyk_Zfjl_ItemMapper hyk_Zfjl_ItemMapper;

	@Resource(name = "hyk_BgddMapper")
	private Hyk_BgddMapper hyk_BgddMapper;

	@Resource(name = "hyk_JfbdjlmxMapper")
	private Hyk_JfbdjlmxMapper hyk_JfbdjlmxMapper;

	@Resource(name = "apiMergeCardMapper")
	private ApiMergeCardMapper apiMergeCardMapper;

	@Resource(name = "apiMergeCardItemPointMapper")
	private ApiMergeCardItemPointMapper apiMergeCardItemPointMapper;

	@Resource(name = "apiMergeCardItemTicketMapper")
	private ApiMergeCardItemTicketMapper apiMergeCardItemTicketMapper;

	@Resource(name = "hyk_Czk_Yhq_ZcMapper")
	private Hyk_Czk_Yhq_ZcMapper hyk_Czk_Yhq_ZcMapper;

	@Resource(name = "hyk_Czk_Yhq_Zc_ItemMapper")
	private Hyk_Czk_Yhq_Zc_ItemMapper hyk_Czk_Yhq_Zc_ItemMapper;

	@Resource(name = "hyk_YhqcljlMapper")
	private Hyk_YhqcljlMapper hyk_YhqcljlMapper;

	// HYK_HYXX.BJ_PSW字段的默认值
	private final short flag_password = 0;

	// HYK_HYXX.STATUS字段的默认值
	private final short cardStatus = 0;

	// HYK_HYXX.FFSX字段的默认值
	private final short cardFFSX = 0;

	// HYK_GKDA.CANSMS字段的默认值
	private final short canSMS = 0;

	// HYK_GKDA.ZJLXID字段的默认值
	private final int IDType = 1;

	public int findCardIdByParamMap(Map<String, Object> paramMap) throws GeneralException, DataAccessException {
		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectCardInfoByParamMap(paramMap);
		if (hyk_Hyxx == null) {
			throw new GeneralException(EnumGeneralException.MSG_CARDID_NOT_FOUND, EnumGeneralException.CODE_CARDID_NOT_FOUND);
		}
		return hyk_Hyxx.getHyid();
	}

	public int findCardIdByCardNo(String cardNo) throws GeneralException, DataAccessException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cardNo", cardNo);
		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectCardInfoByParamMap(paramMap);
		if (hyk_Hyxx == null) {
			throw new GeneralException(EnumGeneralException.MSG_CARDID_NOT_FOUND, EnumGeneralException.CODE_CARDID_NOT_FOUND);
		}

		if (!BizUtil.isValidAnalyzingCard(hyk_Hyxx.getStatus())) {
			throw new GeneralException(EnumGeneralException.MSG_CARD_IS_VALID, EnumGeneralException.CODE_CARD_IS_VALID);
		}
		return hyk_Hyxx.getHyid();
	}

	public Hyk_Hyxx findCustomerInfoByCardID(int cardID) throws GeneralException, DataAccessException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cardId", cardID);
		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectCardInfoByParamMap(paramMap);
		if (hyk_Hyxx == null) {
			throw new GeneralException(EnumGeneralException.MSG_CARDINFO_NOT_FOUND, EnumGeneralException.CODE_CARDINFO_NOT_FOUND);
		}
		return hyk_Hyxx;
	}

	public String findMobileNoByCardNo(String cardNo) throws GeneralException, DataAccessException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cardNo", cardNo);
		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectCardInfoByParamMap(paramMap);

		// 判断会员数据是否为空
		if (hyk_Hyxx == null) {
			throw new GeneralException(EnumGeneralException.MSG_CARDID_NOT_FOUND, EnumGeneralException.CODE_CARDID_NOT_FOUND);
		}

		// 判断会员卡状态是否是有效卡
		if (!BizUtil.isValidAnalyzingCard(hyk_Hyxx.getStatus())) {
			throw new GeneralException(EnumGeneralException.MSG_CARD_IS_VALID, EnumGeneralException.CODE_CARD_IS_VALID);
		}

		// 判断手机号码是否为空
		if (hyk_Hyxx.getHykGkda().getSjhm() == null) {
			throw new GeneralException(EnumGeneralException.MSG_CAN_NOT_FOUND_MOBILENO_BY_CARDNO, EnumGeneralException.CODE_CAN_NOT_FOUND_MOBILENO_BY_CARDNO);
		}

		// 判断手机格式是否正确
		if (!BizUtil.isMobileNo(hyk_Hyxx.getHykGkda().getSjhm())) {
			throw new GeneralException(EnumGeneralException.MSG_MOBILENO_FORMAT_ERROR, EnumGeneralException.CODE_MOBILENO_FORMAT_ERROR);
		}
		return hyk_Hyxx.getHykGkda().getSjhm();
	}

	/*
	 * (non-Javadoc) <p>Title: generateCard</p> <p>Description: </p>
	 * 
	 * @param reqGenerateCardBean
	 * 
	 * @return
	 * 
	 * @throws GeneralException
	 * 
	 * @throws DataAccessException
	 * 
	 * @see
	 * com.yyabl.api.crm.biz.Service.CardService#generateCard(com.yyabl.api.
	 * crm.biz.Bean.ReqGenerateCardBean)
	 */
	@Override
	public int generateCard(ReqGenerateCardBean reqGenerateCardBean) throws GeneralException, DataAccessException {
		String cardNo = reqGenerateCardBean.getCardNo();
		String IdNumber = reqGenerateCardBean.getIDNumber();
		String address = reqGenerateCardBean.getAddress();
		String phoneNo = reqGenerateCardBean.getPhoneNo();
		String partenrCode = reqGenerateCardBean.getPartnerCode();
		String memberName = reqGenerateCardBean.getMemberName();
		int cardType = reqGenerateCardBean.getCardType();
		int sex = reqGenerateCardBean.getSex();

		// 判断导入的会员卡号是否重复
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cardNo", cardNo);
		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectCardInfoByParamMap(paramMap);
		if (hyk_Hyxx != null) {
			throw new GeneralException(EnumGeneralException.MSG_CARDNO_EXIST, EnumGeneralException.CODE_CARDNO_EXIST);
		}

		// 判断证件号码是否重复
		Hyk_Gkda tmp_Hyk_Gkda = hyk_GkdaMapper.selectByIdNumber(IdNumber);
		if (tmp_Hyk_Gkda != null) {
			throw new GeneralException(EnumGeneralException.MSG_IDNUMBER_EXIST, EnumGeneralException.CODE_IDNUMBER_EXIST);
		}

		// 判断联名卡类型与实体卡类型的对应关系是否存在
		LmkDef lmkDef = lmkDefMapper.selectByPrimaryKey(cardType);
		if (lmkDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_CARDTYPE_MAPPING_NOT_FOUND, EnumGeneralException.CODE_CARDTYPE_MAPPING_NOT_FOUND);
		}

		Ryxx ryxx = ryxxMapper.selectByPersonCode(partenrCode);

		// 取调用者对应的加盟机构ID
		ApiPersonDef apiPersonDef = apiPersonDefMapper.selectByPrimaryKey(ryxx.getPersonId());
		if (apiPersonDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF,
					EnumGeneralException.CODE_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF);
		}

		// 获取加盟机构对应的实体门店ID
		ApiOrgDef apiOrgDef = apiOrgDefMapper.selectByPrimaryKey(apiPersonDef.getOrgId());
		if (apiOrgDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_ORG_AND_MALL_DEF, EnumGeneralException.CODE_SYSTEM_NOT_FOUND_ORG_AND_MALL_DEF);
		}

		// 生成实体会员卡ID
		Map<String, Object> cardIdParamMap = new HashMap<String, Object>();
		cardIdParamMap.put("TBLNAME", "HYK_HYXX");
		cardIdParamMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(cardIdParamMap);
		int cardId = (Integer) cardIdParamMap.get("NewRecNo");
		// 生成顾客资料ID
		Map<String, Object> gkIdParamMap = new HashMap<String, Object>();
		gkIdParamMap.put("TBLNAME", "HYK_GKDA");
		gkIdParamMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(gkIdParamMap);
		int gkId = (Integer) gkIdParamMap.get("NewRecNo");

		// 写HYK_HYXX表
		Hyk_Hyxx hyk_hyxx = new Hyk_Hyxx();
		hyk_hyxx.setHyid(cardId);
		hyk_hyxx.setHyktype(lmkDef.getHyktype());
		hyk_hyxx.setHykNo(cardNo);
		hyk_hyxx.setHyName(memberName);
		hyk_hyxx.setCdnr(cardNo);
		hyk_hyxx.setJkrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		// TODO 会员卡的有效期写死了，后续再改
		DateTime dateTime = new DateTime().plusYears(10);
		hyk_hyxx.setYxq(DateTime.parse(dateTime.toString("yyyy-MM-dd")).toDate());
		hyk_hyxx.setBjPsw(flag_password);
		hyk_hyxx.setDjsj(new Date());
		hyk_hyxx.setDjr(ryxx.getPersonId());
		hyk_hyxx.setDjrmc(ryxx.getPersonName());
		hyk_hyxx.setStatus(cardStatus);
		hyk_hyxx.setFfsx(cardFFSX);
		hyk_hyxx.setYbgdd("01");
		hyk_hyxx.setMdid(apiOrgDef.getMdid());
		hyk_hyxx.setGkid(gkId);
		hyk_HyxxMapper.insertSelective(hyk_hyxx);

		// 写HYK_GKDA表
		Hyk_Gkda hyk_Gkda = new Hyk_Gkda();
		hyk_Gkda.setGkid(gkId);
		hyk_Gkda.setSex((byte) sex);
		//hyk_Gkda.setCsrq(DateTime.parse(dateTime.toString("yyyy-MM-dd")).toDate());
		hyk_Gkda.setZjlxid(IDType);
		hyk_Gkda.setSfzbh(IdNumber);
		hyk_Gkda.setTxdz(address);
		hyk_Gkda.setSjhm(phoneNo);
		hyk_Gkda.setDjr(ryxx.getPersonId());
		hyk_Gkda.setDjrmc(ryxx.getPersonName());
		hyk_Gkda.setDjsj(new Date());
		hyk_Gkda.setCansms(canSMS);
		hyk_GkdaMapper.insertSelective(hyk_Gkda);

		return cardId;
	}

	/*
	 * (non-Javadoc) <p>Title: mergeCard</p> <p>Description: </p>
	 * 
	 * @param reqMergeCardBean
	 * 
	 * @return
	 * 
	 * @throws GeneralException
	 * 
	 * @throws DataAccessException
	 * 
	 * @see
	 * com.yyabl.api.crm.biz.Service.CardService#mergeCard(com.yyabl.api.crm
	 * .biz.Bean.ReqMergeCardBean)
	 */
	@Override
	public int mergeCard(ReqMergeCardBean reqMergeCardBean) throws GeneralException, DataAccessException {
		Hyk_Hyxx source_Hyk_Hyxx = hyk_HyxxMapper.selectByPrimaryKey(reqMergeCardBean.getSourceCardId());
		// 判断源会员卡是否存在
		if (source_Hyk_Hyxx == null) {
			throw new GeneralException(EnumGeneralException.MSG_MERGE_CARD_SOURCE_CARD_NOT_FOUND, EnumGeneralException.CODE_MERGE_CARD_SOURCE_CARD_NOT_FOUND);
		}
		// 判断源会员卡的状态是否为有效状态
		if (!BizUtil.isValidAnalyzingCard(source_Hyk_Hyxx.getStatus())) {
			throw new GeneralException(EnumGeneralException.MSG_MERGE_CARD_SOURCE_CARD_IS_VALID, EnumGeneralException.CODE_MERGE_CARD_SOURCE_CARD_IS_VALID);
		}

		Hyk_Hyxx target_Hyk_Hyxx = hyk_HyxxMapper.selectByPrimaryKey(reqMergeCardBean.getTargetCardId());
		// 判断目标会员卡是否存在
		if (target_Hyk_Hyxx == null) {
			throw new GeneralException(EnumGeneralException.MSG_MERGE_CARD_TARGET_CARD_NOT_FOUND, EnumGeneralException.CODE_MERGE_CARD_TARGET_CARD_NOT_FOUND);
		}
		// 判断目标会员卡的状态是否为有效状态
		if (!BizUtil.isValidAnalyzingCard(target_Hyk_Hyxx.getStatus())) {
			throw new GeneralException(EnumGeneralException.MSG_MERGE_CARD_TARGET_CARD_IS_VALID, EnumGeneralException.CODE_MERGE_CARD_TARGET_CARD_IS_VALID);
		}

		// 取人员信息
		Ryxx ryxx = ryxxMapper.selectByPersonCode(reqMergeCardBean.getPartnerCode());

		// 取调用者对应的加盟机构ID
		ApiPersonDef apiPersonDef = apiPersonDefMapper.selectByPrimaryKey(ryxx.getPersonId());
		if (apiPersonDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF,
					EnumGeneralException.CODE_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF);
		}

		// 获取加盟机构对应的实体门店ID
		ApiOrgDef apiOrgDef = apiOrgDefMapper.selectByPrimaryKey(apiPersonDef.getOrgId());
		if (apiOrgDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_ORG_AND_MALL_DEF, EnumGeneralException.CODE_SYSTEM_NOT_FOUND_ORG_AND_MALL_DEF);
		}
		// 取会员卡保管地点定义
		Hyk_Bgdd hyk_Bgdd = hyk_BgddMapper.selectByMdid(apiOrgDef.getMdid());
		if (hyk_Bgdd == null) {
			throw new GeneralException(EnumGeneralException.MSG_CAN_NOT_FOUND_MALL_MAPPING, EnumGeneralException.CODE_CAN_NOT_FOUND_MALL_MAPPING);
		}

		// 积分转储的相关业务逻辑
		// 获取源会员卡的积分余额
		Hyk_Jfzh source_Hyk_Jfzh = hyk_JfzhMapper.selectByPrimaryKey(reqMergeCardBean.getSourceCardId());
		// 获取目标会员卡的积分余额
		Hyk_Jfzh target_Hyk_Jfzh = hyk_JfzhMapper.selectByPrimaryKey(reqMergeCardBean.getTargetCardId());

		// 取API_MERGE_CARD_RECORD表的编号状态
		Map<String, Object> paramMapOrderNo = new HashMap<String, Object>();
		paramMapOrderNo.put("TBLNAME", "API_MERGE_CARD");
		paramMapOrderNo.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(paramMapOrderNo);
		int orderNo = (Integer) paramMapOrderNo.get("NewRecNo");

		// 写API调用流水表(API_MERGE_CARD)
		ApiMergeCard apiMergeCard = new ApiMergeCard();
		apiMergeCard.setJlbh(orderNo);
		apiMergeCard.setSourceCardId(reqMergeCardBean.getSourceCardId());
		apiMergeCard.setTargetCardId(reqMergeCardBean.getTargetCardId());
		apiMergeCard.setCallerId(ryxx.getPersonId());
		apiMergeCard.setCallerName(ryxx.getPersonName());
		apiMergeCard.setCallDate(new Date());
		apiMergeCardMapper.insert(apiMergeCard);

		// 将源卡进行作废，修改HYK_HYXX.STATUS
		source_Hyk_Hyxx.setStatus((short) -1);
		hyk_HyxxMapper.updateByPrimaryKey(source_Hyk_Hyxx);

		// 生成源卡的作废记录业务单据号
		Map<String, Object> paramMap_zfjl_OrderNo = new HashMap<String, Object>();
		paramMap_zfjl_OrderNo.put("TBLNAME", "HYK_ZFJL");
		paramMap_zfjl_OrderNo.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(paramMap_zfjl_OrderNo);
		int zfjl_OrderNo = (Integer) paramMap_zfjl_OrderNo.get("NewRecNo");

		// 记录源卡的‘HYK_ZFJL’表
		Hyk_Zfjl hyk_Zfjl = new Hyk_Zfjl();
		hyk_Zfjl.setJlbh(zfjl_OrderNo);
		hyk_Zfjl.setHyktype(source_Hyk_Hyxx.getHyktype());
		hyk_Zfjl.setZy("加盟机构调用‘会员卡合并’API接口后，将源卡进行作废处理。");
		hyk_Zfjl.setJe(new BigDecimal(0));
		hyk_Zfjl.setDjr(ryxx.getPersonId());
		hyk_Zfjl.setDjrmc(ryxx.getPersonName());
		hyk_Zfjl.setDjsj(new Date());
		hyk_Zfjl.setZxr(ryxx.getPersonId());
		hyk_Zfjl.setZxrmc(ryxx.getPersonName());
		hyk_Zfjl.setZxrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		hyk_Zfjl.setBjHf((short) 0);
		hyk_Zfjl.setCzdd(hyk_Bgdd.getBgdddm());
		hyk_Zfjl.setBjHf((short) 1);
		hyk_ZfjlMapper.insert(hyk_Zfjl);

		// 记录源卡的‘HYK_ZFJLITEM’表
		Hyk_Zfjl_Item hyk_Zfjl_Item = new Hyk_Zfjl_Item();
		hyk_Zfjl_Item.setJlbh(zfjl_OrderNo);
		hyk_Zfjl_Item.setHyid(reqMergeCardBean.getSourceCardId());
		if(source_Hyk_Jfzh == null){
			hyk_Zfjl_Item.setLjxfje(new BigDecimal(0));
			hyk_Zfjl_Item.setLjjf(new Double(0));
		}else{
			hyk_Zfjl_Item.setLjxfje(source_Hyk_Jfzh.getLjxfje());
			hyk_Zfjl_Item.setLjjf(source_Hyk_Jfzh.getLjjf());
		}
		hyk_Zfjl_Item.setWcljf(new Double(0));
		hyk_Zfjl_Item.setYe(new BigDecimal(0));
		hyk_Zfjl_Item.setJljye(new BigDecimal(0));
		hyk_Zfjl_ItemMapper.insert(hyk_Zfjl_Item);

		// 进行积分转储操作
		if ((source_Hyk_Jfzh == null) || (source_Hyk_Jfzh.getWcljf() == 0)) {
			// 如果源会员卡的积分账户不存在，或者积分账户余额为0，则不进行积分转储操作.
		} else {
			// 生成积分转储业务单据号
			Map<String, Object> paramMap_Jfzcjl_OrderNo = new HashMap<String, Object>();
			paramMap_Jfzcjl_OrderNo.put("TBLNAME", "HYK_JFZCJL");
			paramMap_Jfzcjl_OrderNo.put("NewRecNo", 0);
			bhztMapper.procUpdateBHZT(paramMap_Jfzcjl_OrderNo);
			int jfzcjl_OrderNo = (Integer) paramMap_Jfzcjl_OrderNo.get("NewRecNo");

			// 记录‘HYK_JFZCJL’表
			Hyk_Jfzcjl hyk_Jfzcjl = new Hyk_Jfzcjl();
			hyk_Jfzcjl.setJlbh(jfzcjl_OrderNo);
			hyk_Jfzcjl.setHyidZr(reqMergeCardBean.getTargetCardId());
			hyk_Jfzcjl.setZy("加盟机构调用‘会员卡合并’API接口后，将源卡积分转储到目标卡中。");
			hyk_Jfzcjl.setCzdd(hyk_Bgdd.getBgdddm());
			hyk_Jfzcjl.setZrjf(source_Hyk_Jfzh.getWcljf());
			hyk_Jfzcjl.setDjr(ryxx.getPersonId());
			hyk_Jfzcjl.setDjrmc(ryxx.getPersonName());
			hyk_Jfzcjl.setDjsj(new Date());
			hyk_Jfzcjl.setZxr(ryxx.getPersonId());
			hyk_Jfzcjl.setZxrmc(ryxx.getPersonName());
			hyk_Jfzcjl.setZxrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			hyk_JfzcjlMapper.insert(hyk_Jfzcjl);

			// 记录‘HYK_JFZCJLITEM’表
			Hyk_Jfzcjl_Item hyk_Jfzcjl_Item = new Hyk_Jfzcjl_Item();
			hyk_Jfzcjl_Item.setJlbh(jfzcjl_OrderNo);
			hyk_Jfzcjl_Item.setHyidZc(reqMergeCardBean.getSourceCardId());
			hyk_Jfzcjl_Item.setZcjf(source_Hyk_Jfzh.getWcljf());
			hyk_Jfzcjl_ItemMapper.insert(hyk_Jfzcjl_Item);

			// 修改目标卡的‘HYK_JFZH’表
			if (target_Hyk_Jfzh == null) {
				target_Hyk_Jfzh = new Hyk_Jfzh();
				target_Hyk_Jfzh.setHyid(reqMergeCardBean.getTargetCardId());
				target_Hyk_Jfzh.setWcljf(source_Hyk_Jfzh.getWcljf());
				target_Hyk_Jfzh.setBqjf(new Double(0));
				target_Hyk_Jfzh.setLjjf(new Double(0));
				target_Hyk_Jfzh.setXfje(new BigDecimal(0));
				target_Hyk_Jfzh.setZkje(new BigDecimal(0));
				target_Hyk_Jfzh.setLjxfje(new BigDecimal(0));
				target_Hyk_Jfzh.setLjzkje(new BigDecimal(0));
				target_Hyk_Jfzh.setXfcs(0);
				target_Hyk_Jfzh.setThcs(0);
				hyk_JfzhMapper.insert(target_Hyk_Jfzh);
			} else {
				Map<String,Object> targetParamMap = new HashMap<String,Object>();
				targetParamMap.put("point", source_Hyk_Jfzh.getWcljf());
				targetParamMap.put("cardId", reqMergeCardBean.getTargetCardId());
				hyk_JfzhMapper.modifyPointByCardId(targetParamMap);
			}

			// 记录目标卡的‘HYK_JFBDJLMX’表
			Hyk_Jfbdjlmx target_Hyk_Jfbdjlmx = new Hyk_Jfbdjlmx();
			target_Hyk_Jfbdjlmx.setHyid(reqMergeCardBean.getTargetCardId());
			target_Hyk_Jfbdjlmx.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			target_Hyk_Jfbdjlmx.setCllx((short) 11);
			target_Hyk_Jfbdjlmx.setJlbh(jfzcjl_OrderNo);
			target_Hyk_Jfbdjlmx.setWcljfbd(source_Hyk_Jfzh.getWcljf());
			target_Hyk_Jfbdjlmx.setBqjfbd(new Double(0));
			hyk_JfbdjlmxMapper.insert(target_Hyk_Jfbdjlmx);

			// 调用‘HYXF_ZX_MDJFFT_JFZC’存储过程
			Map<String, Object> procParam = new HashMap<String, Object>();
			procParam.put("ProcDate", DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			procParam.put("HYID_ZC", reqMergeCardBean.getSourceCardId());
			procParam.put("HYID_ZR", reqMergeCardBean.getTargetCardId());
			procParam.put("CLLX", 11);
			procParam.put("SJJF", source_Hyk_Jfzh.getWcljf());
			hyk_JfzcjlMapper.proc_HYXF_ZX_MDJFFT_JFZC(procParam);

			// 修改源卡的‘HYK_JFZH’表
			double source_Hyk_Jfzh_Point = source_Hyk_Jfzh.getWcljf();
			source_Hyk_Jfzh.setWcljf(new Double(0));
			hyk_JfzhMapper.updateByPrimaryKey(source_Hyk_Jfzh);

			// 记录源卡的‘HYK_JFBDJLMX’表
			Hyk_Jfbdjlmx source_Hyk_Jfbdjlmx = new Hyk_Jfbdjlmx();
			source_Hyk_Jfbdjlmx.setHyid(reqMergeCardBean.getSourceCardId());
			source_Hyk_Jfbdjlmx.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			source_Hyk_Jfbdjlmx.setCllx((short) 11);
			source_Hyk_Jfbdjlmx.setJlbh(jfzcjl_OrderNo);
			source_Hyk_Jfbdjlmx.setWcljfbd(source_Hyk_Jfzh_Point * -1);
			source_Hyk_Jfbdjlmx.setBqjfbd(new Double(0));
			hyk_JfbdjlmxMapper.insert(source_Hyk_Jfbdjlmx);

			// 写API调用流水子表(积分转储)(API_MERGE_CARD_ITEM_POINT)
			ApiMergeCardItemPoint apiMergeCardItemPoint = new ApiMergeCardItemPoint();
			apiMergeCardItemPoint.setJlbh(orderNo);
			apiMergeCardItemPoint.setZcJlbh(jfzcjl_OrderNo);
			apiMergeCardItemPointMapper.insert(apiMergeCardItemPoint);
		}

		// 进行优惠券转储操作
		List<Hyk_Yhqzh> sourceCard_Hyk_Yhqzh_List = hyk_YhqzhMapper.selectEffectTicketListByCardId(reqMergeCardBean.getSourceCardId());
		if (sourceCard_Hyk_Yhqzh_List.isEmpty()) {
			// 如果源卡的优惠券账户不存在，则不做任何操作。
		} else {
			// 生成优惠券转储业务单据号
			Map<String, Object> paramMap_yhqzc_OrderNo = new HashMap<String, Object>();
			paramMap_yhqzc_OrderNo.put("TBLNAME", "HYK_CZK_YHQ_ZC");
			paramMap_yhqzc_OrderNo.put("NewRecNo", 0);
			bhztMapper.procUpdateBHZT(paramMap_yhqzc_OrderNo);
			int yhqzc_OrderNo = (Integer) paramMap_yhqzc_OrderNo.get("NewRecNo");

			// 记录API调用表(API_MERGE_CARD_TICKET)
			ApiMergeCardItemTicket apiMergeCardItemTicket = new ApiMergeCardItemTicket();
			apiMergeCardItemTicket.setJlbh(orderNo);
			apiMergeCardItemTicket.setZcJlbh(yhqzc_OrderNo);
			apiMergeCardItemTicketMapper.insert(apiMergeCardItemTicket);

			// 取转入卡的有效优惠券总金额数
			int sourceCard_ticket_sum = hyk_YhqzhMapper.selectEffectTicketsByCardId(reqMergeCardBean.getSourceCardId());

			// 记‘优惠券转储记录表’
			Hyk_Czk_Yhq_Zc hyk_Czk_Yhq_Zc = new Hyk_Czk_Yhq_Zc();
			hyk_Czk_Yhq_Zc.setCzjpjJlbh(yhqzc_OrderNo);
			hyk_Czk_Yhq_Zc.setHyidZr(reqMergeCardBean.getTargetCardId());
			hyk_Czk_Yhq_Zc.setCzdd(hyk_Bgdd.getBgdddm());
			hyk_Czk_Yhq_Zc.setZy("加盟机构调用‘会员卡合并’API接口后，将源卡优惠券余额转储到目标卡中。");
			hyk_Czk_Yhq_Zc.setZrje(new BigDecimal(sourceCard_ticket_sum));
			hyk_Czk_Yhq_Zc.setDjr(ryxx.getPersonId());
			hyk_Czk_Yhq_Zc.setDjrmc(ryxx.getPersonName());
			hyk_Czk_Yhq_Zc.setDjsj(new Date());
			hyk_Czk_Yhq_Zc.setZxr(ryxx.getPersonId());
			hyk_Czk_Yhq_Zc.setZxrmc(ryxx.getPersonName());
			hyk_Czk_Yhq_Zc.setZxrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			hyk_Czk_Yhq_ZcMapper.insert(hyk_Czk_Yhq_Zc);

			for (int i = 0; i < sourceCard_Hyk_Yhqzh_List.size(); i++) {
				Hyk_Yhqzh sourceCard_Hyk_Yhqzh_Item = sourceCard_Hyk_Yhqzh_List.get(i);
				// 记‘优惠券转储记录明细表’(HYK_CZK_YHQ_ZC)
				Hyk_Czk_Yhq_Zc_Item hyk_Czk_Yhq_Zc_Item = new Hyk_Czk_Yhq_Zc_Item();
				hyk_Czk_Yhq_Zc_Item.setCzjpjJlbh(yhqzc_OrderNo);
				hyk_Czk_Yhq_Zc_Item.setHyidZc(reqMergeCardBean.getSourceCardId());
				hyk_Czk_Yhq_Zc_Item.setYhqid(sourceCard_Hyk_Yhqzh_Item.getYhqid());
				hyk_Czk_Yhq_Zc_Item.setJsrq(sourceCard_Hyk_Yhqzh_Item.getJsrq());
				hyk_Czk_Yhq_Zc_Item.setMdfwdm(sourceCard_Hyk_Yhqzh_Item.getMdfwdm());
				hyk_Czk_Yhq_Zc_Item.setZcje(sourceCard_Hyk_Yhqzh_Item.getJe());
				hyk_Czk_Yhq_Zc_ItemMapper.insert(hyk_Czk_Yhq_Zc_Item);

				// 设置HYK_YHQZH表的主键，用于后续的查询
				Hyk_YhqzhKey targetCard_hyk_Yhqzh_Key = new Hyk_YhqzhKey();
				targetCard_hyk_Yhqzh_Key.setHyid(reqMergeCardBean.getTargetCardId());
				targetCard_hyk_Yhqzh_Key.setYhqid(sourceCard_Hyk_Yhqzh_Item.getYhqid());
				targetCard_hyk_Yhqzh_Key.setMdfwdm(sourceCard_Hyk_Yhqzh_Item.getMdfwdm());
				targetCard_hyk_Yhqzh_Key.setJsrq(sourceCard_Hyk_Yhqzh_Item.getJsrq());

				// 根据HYK_YHQZH的主键，更新目标卡的每个批次的优惠券余额
				Hyk_Yhqzh targetCard_Hyk_Yhqzh_Item = hyk_YhqzhMapper.selectByPrimaryKey(targetCard_hyk_Yhqzh_Key);
				if (targetCard_Hyk_Yhqzh_Item == null) {
					targetCard_Hyk_Yhqzh_Item = new Hyk_Yhqzh();
					targetCard_Hyk_Yhqzh_Item.setHyid(reqMergeCardBean.getTargetCardId());
					targetCard_Hyk_Yhqzh_Item.setYhqid(sourceCard_Hyk_Yhqzh_Item.getYhqid());
					targetCard_Hyk_Yhqzh_Item.setMdfwdm(sourceCard_Hyk_Yhqzh_Item.getMdfwdm());
					targetCard_Hyk_Yhqzh_Item.setJsrq(sourceCard_Hyk_Yhqzh_Item.getJsrq());
					targetCard_Hyk_Yhqzh_Item.setJydjje(sourceCard_Hyk_Yhqzh_Item.getJydjje());
					targetCard_Hyk_Yhqzh_Item.setJe(sourceCard_Hyk_Yhqzh_Item.getJe());
					hyk_YhqzhMapper.insert(targetCard_Hyk_Yhqzh_Item);
				} else {
					targetCard_Hyk_Yhqzh_Item.setJe(targetCard_Hyk_Yhqzh_Item.getJe().add(sourceCard_Hyk_Yhqzh_Item.getJe()));
					hyk_YhqzhMapper.updateByPrimaryKey(targetCard_Hyk_Yhqzh_Item);
				}

				// 根据HYK_YHQZH的主键，将源会员卡的每个批次的优惠券余额清零。
				BigDecimal sourceCard_Hyk_Yhqzh_Item_YE = sourceCard_Hyk_Yhqzh_Item.getJe();
				sourceCard_Hyk_Yhqzh_Item.setJe(new BigDecimal(0));
				hyk_YhqzhMapper.updateByPrimaryKey(sourceCard_Hyk_Yhqzh_Item);

				// 在HYK_YHQCLJL(会员卡优惠券处理记录)表中记录源会员卡的优惠券处理记录
				Hyk_Yhqcljl sourceCard_Hyk_Yhqcljl = new Hyk_Yhqcljl();
				sourceCard_Hyk_Yhqcljl.setHyid(reqMergeCardBean.getSourceCardId());
				sourceCard_Hyk_Yhqcljl.setClsj(new Date());
				sourceCard_Hyk_Yhqcljl.setCllx((short) 5);
				sourceCard_Hyk_Yhqcljl.setJlbh(yhqzc_OrderNo);
				sourceCard_Hyk_Yhqcljl.setYhqid(sourceCard_Hyk_Yhqzh_Item.getYhqid());
				sourceCard_Hyk_Yhqcljl.setJsrq(sourceCard_Hyk_Yhqzh_Item.getJsrq());
				sourceCard_Hyk_Yhqcljl.setMdfwdm(sourceCard_Hyk_Yhqzh_Item.getMdfwdm());
				sourceCard_Hyk_Yhqcljl.setMdid(apiOrgDef.getMdid());
				sourceCard_Hyk_Yhqcljl.setZy("加盟机构调用‘会员卡合并’API接口后，将源卡的优惠券余额转储到目标卡中。");
				sourceCard_Hyk_Yhqcljl.setJfje(new BigDecimal(0));
				sourceCard_Hyk_Yhqcljl.setDfje(sourceCard_Hyk_Yhqzh_Item_YE);
				sourceCard_Hyk_Yhqcljl.setYe(new BigDecimal(0));
				hyk_YhqcljlMapper.insert(sourceCard_Hyk_Yhqcljl);

				// 在HYK_YHQCLJL(会员卡优惠券处理记录)表中记录目标会员卡的优惠券处理记录
				Hyk_Yhqcljl targetCard_Hyk_Yhqcljl = new Hyk_Yhqcljl();
				targetCard_Hyk_Yhqcljl.setHyid(reqMergeCardBean.getTargetCardId());
				targetCard_Hyk_Yhqcljl.setClsj(new Date());
				targetCard_Hyk_Yhqcljl.setCllx((short) 5);
				targetCard_Hyk_Yhqcljl.setJlbh(yhqzc_OrderNo);
				targetCard_Hyk_Yhqcljl.setYhqid(targetCard_Hyk_Yhqzh_Item.getYhqid());
				targetCard_Hyk_Yhqcljl.setJsrq(targetCard_Hyk_Yhqzh_Item.getJsrq());
				targetCard_Hyk_Yhqcljl.setMdfwdm(targetCard_Hyk_Yhqzh_Item.getMdfwdm());
				targetCard_Hyk_Yhqcljl.setMdid(apiOrgDef.getMdid());
				targetCard_Hyk_Yhqcljl.setZy("加盟机构调用‘会员卡合并’API接口后，将目标卡的优惠券余额转储到目标卡中。");
				targetCard_Hyk_Yhqcljl.setJfje(sourceCard_Hyk_Yhqzh_Item_YE);
				targetCard_Hyk_Yhqcljl.setDfje(new BigDecimal(0));
				targetCard_Hyk_Yhqcljl.setYe(targetCard_Hyk_Yhqzh_Item.getJe());
				hyk_YhqcljlMapper.insert(targetCard_Hyk_Yhqcljl);
			}
		}

		return orderNo;
	}

	/*
	 * (non-Javadoc) <p>Title: getRightsOfMember</p> <p>Description:
	 * 在这个接口实现中，会员特权通过properties文件获取。</p>
	 * 
	 * @param cardId
	 * 
	 * @return
	 * 
	 * @throws GeneralException
	 * 
	 * @throws DataAccessException
	 * 
	 * @see com.yyabl.api.crm.biz.Service.CardService#getRightsOfMember(int)
	 */
	@Override
	public String[] getRightsOfMember(int cardId) throws GeneralException, DataAccessException {
		String[] rights = null;

		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectByPrimaryKey(cardId);
		if (hyk_Hyxx == null) {
			throw new GeneralException(EnumGeneralException.MSG_CARDINFO_NOT_FOUND, EnumGeneralException.CODE_CARDINFO_NOT_FOUND);
		}

		String strRights = (String)BizUtil.getMemberRight(hyk_Hyxx.getHyktype());
		if (strRights != null) {
			rights = strRights.split(",");
		}
		return rights;
	}
}
