package com.yyabl.api.crm.biz.Service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yyabl.api.crm.biz.Bean.ReqExchangePointToTicketBean;
import com.yyabl.api.crm.biz.Bean.ReqFlushesPointBean;
import com.yyabl.api.crm.biz.Bean.ReqFlushesTicketBean;
import com.yyabl.api.crm.biz.Bean.RespExchangePointToTicketBean;
import com.yyabl.api.crm.biz.Bean.RespGetExchangeRuleBean;
import com.yyabl.api.crm.biz.Dao.ApiFlushesPointMapper;
import com.yyabl.api.crm.biz.Dao.ApiFlushesTicketMapper;
import com.yyabl.api.crm.biz.Dao.ApiOrgDefMapper;
import com.yyabl.api.crm.biz.Dao.ApiPersonDefMapper;
import com.yyabl.api.crm.biz.Dao.Api_Hyk_JfbdjlMapper;
import com.yyabl.api.crm.biz.Dao.Api_Hyk_YhqcljlMapper;
import com.yyabl.api.crm.biz.Dao.Api_Hyk_Yhqcljl_ItemMapper;
import com.yyabl.api.crm.biz.Dao.BhztMapper;
import com.yyabl.api.crm.biz.Dao.Enum_Czk_Yhq_CllxMapper;
import com.yyabl.api.crm.biz.Dao.Enum_Hyk_Jfbd_CllxMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_BgddMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_Czk_Yhq_CkjlMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_Czk_Yhq_QkjlMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_HyxxMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_JfbddMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_JfbdjlmxMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_Jfbdjlmx_MdMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_JfflgzMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_JfzhMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_MdjfMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_VipjlcljlMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_VipjlcljlmxMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_YhqcljlMapper;
import com.yyabl.api.crm.biz.Dao.Hyk_YhqzhMapper;
import com.yyabl.api.crm.biz.Dao.RyxxMapper;
import com.yyabl.api.crm.biz.Dao.YhqDefMapper;
import com.yyabl.api.crm.biz.Domain.ApiFlushesPoint;
import com.yyabl.api.crm.biz.Domain.ApiFlushesTicket;
import com.yyabl.api.crm.biz.Domain.ApiOrgDef;
import com.yyabl.api.crm.biz.Domain.ApiPersonDef;
import com.yyabl.api.crm.biz.Domain.Api_Hyk_Jfbdjl;
import com.yyabl.api.crm.biz.Domain.Api_Hyk_Yhqcljl;
import com.yyabl.api.crm.biz.Domain.Api_Hyk_Yhqcljl_Item;
import com.yyabl.api.crm.biz.Domain.Enum_Czk_Yhq_Cllx;
import com.yyabl.api.crm.biz.Domain.Enum_Hyk_Jfbd_Cllx;
import com.yyabl.api.crm.biz.Domain.Hyk_Bgdd;
import com.yyabl.api.crm.biz.Domain.Hyk_Czk_Yhq_Ckjl;
import com.yyabl.api.crm.biz.Domain.Hyk_Czk_Yhq_Qkjl;
import com.yyabl.api.crm.biz.Domain.Hyk_Hyxx;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfbdd;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfbdjlmx;
import com.yyabl.api.crm.biz.Domain.Hyk_JfbdjlmxKey;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfbdjlmx_Md;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfbdjlmx_MdKey;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfflgz;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfzh;
import com.yyabl.api.crm.biz.Domain.Hyk_Mdjf;
import com.yyabl.api.crm.biz.Domain.Hyk_MdjfKey;
import com.yyabl.api.crm.biz.Domain.Hyk_Vipjlcljl;
import com.yyabl.api.crm.biz.Domain.Hyk_Vipjlcljlmx;
import com.yyabl.api.crm.biz.Domain.Hyk_Yhqcljl;
import com.yyabl.api.crm.biz.Domain.Hyk_Yhqzh;
import com.yyabl.api.crm.biz.Domain.Hyk_YhqzhKey;
import com.yyabl.api.crm.biz.Domain.Ryxx;
import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;
import com.yyabl.api.crm.biz.Service.AccountService;
import com.yyabl.api.crm.biz.Util.BizUtil;

/**
 * ClassName: AccountServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年2月3日 下午2:16:25 <br/>
 * 
 * @author 舒阜东
 * @version
 * @since JDK 1.7
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Resource(name = "hyk_YhqzhMapper")
	private Hyk_YhqzhMapper hyk_YhqzhMapper;

	@Resource(name = "hyk_JfzhMapper")
	private Hyk_JfzhMapper hyk_JfzhMapper;

	@Resource(name = "hyk_MdjfMapper")
	private Hyk_MdjfMapper hyk_MdjfMapper;

	@Resource(name = "bhztMapper")
	private BhztMapper bhztMapper;

	@Resource(name = "hyk_HyxxMapper")
	private Hyk_HyxxMapper hyk_HyxxMapper;

	@Resource(name = "hyk_JfflgzMapper")
	private Hyk_JfflgzMapper hyk_JfflgzMapper;

	@Resource(name = "ryxxMapper")
	private RyxxMapper ryxxMapper;

	@Resource(name = "api_Hyk_YhqcljlMapper")
	private Api_Hyk_YhqcljlMapper api_Hyk_YhqcljlMapper;

	@Resource(name = "api_Hyk_Yhqcljl_ItemMapper")
	private Api_Hyk_Yhqcljl_ItemMapper api_Hyk_Yhqcljl_ItemMapper;

	@Resource(name = "apiPersonDefMapper")
	private ApiPersonDefMapper apiPersonDefMapper;

	@Resource(name = "apiOrgDefMapper")
	private ApiOrgDefMapper apiOrgDefMapper;

	@Resource(name = "hyk_VipjlcljlMapper")
	private Hyk_VipjlcljlMapper hyk_VipjlcljlMapper;

	@Resource(name = "hyk_JfbdjlmxMapper")
	private Hyk_JfbdjlmxMapper hyk_JfbdjlmxMapper;

	@Resource(name = "hyk_Jfbdjlmx_MdMapper")
	private Hyk_Jfbdjlmx_MdMapper hyk_Jfbdjlmx_MdMapper;

	@Resource(name = "hyk_VipjlcljlmxMapper")
	private Hyk_VipjlcljlmxMapper hyk_VipjlcljlmxMapper;

	@Resource(name = "hyk_YhqcljlMapper")
	private Hyk_YhqcljlMapper hyk_YhqcljlMapper;

	@Resource(name = "enum_Hyk_Jfbd_CllxMapper")
	private Enum_Hyk_Jfbd_CllxMapper enum_Hyk_Jfbd_CllxMapper;

	@Resource(name = "enum_Czk_Yhq_CllxMapper")
	private Enum_Czk_Yhq_CllxMapper enum_Czk_Yhq_CllxMapper;

	@Resource(name = "api_Hyk_JfbdjlMapper")
	private Api_Hyk_JfbdjlMapper api_Hyk_JfbdjlMapper;

	@Resource(name = "hyk_JfbddMapper")
	private Hyk_JfbddMapper hyk_JfbddMapper;

	@Resource(name = "hyk_BgddMapper")
	private Hyk_BgddMapper hyk_BgddMapper;

	@Resource(name = "apiFlushesPointMapper")
	private ApiFlushesPointMapper apiFlushesPointMapper;

	@Resource(name = "apiFlushesTicketMapper")
	private ApiFlushesTicketMapper apiFlushesTicketMapper;

	@Resource(name = "hyk_Czk_Yhq_QkjlMapper")
	private Hyk_Czk_Yhq_QkjlMapper hyk_Czk_Yhq_QkjlMapper;

	@Resource(name = "hyk_Czk_Yhq_CkjlMapper")
	private Hyk_Czk_Yhq_CkjlMapper hyk_Czk_Yhq_CkjlMapper;

	@Resource(name = "yhqDefMapper")
	private YhqDefMapper yhqDefMapper;

	private final static String[] exchangeRuleContext = {
			"1、食品、日用百货、针面、床上用品、儿童、文化体育用品、鞋帽、化妆品、服装、国产钟表、体育用品、合金饰品、纯银饰品或饰品等按1元/分标准进行积分。",
			"2、休闲服装按2元/分标准进行积分。",
			"3、小家电按5元/分标准进行积分。",
			"4、二线奢侈品按10元/分标准进行积分。",
			"5、大家电、健身器材、计算机类、手机、精品钟表、黄铂金、珠宝、家具、烟酒、一线奢侈品按20元/分标准进行积分。",
			"6、长沙友阿奥特莱斯购物公园健身器材、烟酒按20元/分标准进行积分，其余商品均按10元/分标准进行积分。\r\n特殊加盟店、非商品经营区域及特殊柜组不参与积分；集团用户消费或支票结算时会员卡（按门市价格购买除外）不予积分；电子券及促销返券消费不积分；未带会员卡视为自动放弃本次积分，积分不予补录。如发现会员存在嫌疑的违规积分现象，会员卡将作停卡处理，如确定会员确实有违规现象，会员卡将作废处理。\r\n为保护您的积分权益，请在消费后保留您的购物小票，以便在清查违规卡时，能有效辨别卡内积分的所有权归属，如属黄牛党在促销活动时蓄意操作，将无条件终止会员卡（即使有购物小票），且我公司将拒接该身份证再次办卡。" };

	// 积分兑换规则(500分兑换10元电子券)
	private final int exchangeRulePoint = 500;
	private final int exchangeRuleTicket = 10;

	// 优惠券类型ID
	private final short ticketType = 0;

	// 业务类型
	private final short bizType = 7;

	// 会员卡积分处理明细的序号。目前接口中只有一种积分规则，因此这个值始终会是1，以后如果有多种规则存在，则此值需要改为动态的。
	private final short hyk_jfcljlmx_xh = 1;

	// 会员卡积分处理明细中的回报方式。固定值为1。
	private final short hyk_jfcljlmx_hbfs = 1;

	// 会员卡优惠券处理记录中的处理类型。固定值为1。
	private final short hyk_yhqcljl_cllx = 1;

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yyabl.api.crm.biz.Service.AccountService#searchEffectPointAccountByMemberId(int)
	 */
	@Override
	public int searchEffectPointAccountByMemberId(Integer cardId) throws GeneralException, DataAccessException {
		int balance = hyk_MdjfMapper.selectEffectPointsByCardId(cardId);
		return balance;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yyabl.api.crm.biz.Service.AccountService#searchEffectTicketAccountByMemberId(int)
	 */
	@Override
	public int searchEffectTicketAccountByMemberId(Integer cardId) throws GeneralException, DataAccessException {
		int balance = hyk_YhqzhMapper.selectEffectTicketsByCardId(cardId);
		return balance;
	}

	@Override
	public int modifyMemberPointAccount(String tradeNo, String partnerCode, Integer cardId, Double points, Integer bizType) throws GeneralException, DataAccessException {

		// 判断要修改的参数值是否为0，如果为0，返回异常信息。
		if (points == 0) {
			throw new GeneralException(EnumGeneralException.MSG_CUTPOINT_CAN_NOT_EQUAL_ZORE, EnumGeneralException.CODE_CUTPOINT_CAN_NOT_EQUAL_ZORE);
		}

		// 判断bizType是否存在
		// TODO 如果后期需要增加权限控制，需要在这个逻辑中做进一步判断。
		Enum_Hyk_Jfbd_Cllx enum_Hyk_Jfbd_Cllx = enum_Hyk_Jfbd_CllxMapper.selectByPrimaryKey(bizType);
		if (enum_Hyk_Jfbd_Cllx == null) {
			throw new GeneralException(EnumGeneralException.MSG_BIZ_TYPE_NOT_DEFAULT, EnumGeneralException.CODE_BIZ_TYPE_NOT_DEFAULT);
		}

		// 取当前积分账户中的未处理积分值
		Hyk_Jfzh hyk_Jfzh = hyk_JfzhMapper.selectByPrimaryKey(cardId);
		int wcljf;
		if (hyk_Jfzh == null) {
			wcljf = 0;
		} else {
			wcljf = hyk_Jfzh.getWcljf().intValue();
		}

		// 如果是扣减积分操作(points<0)，首先要判断当前积分余额是否足够本次扣减操作。
		if (wcljf + points < 0) {
			throw new GeneralException(EnumGeneralException.MSG_CURRENT_POINT_NOT_ENOUGH_MODIFY, EnumGeneralException.CODE_CURRENT_POINT_NOT_ENOUGH_MODIFY);
		}

		// 写积分账户表
		if (hyk_Jfzh == null) {
			Hyk_Jfzh tmp_Hyk_Jfzh = new Hyk_Jfzh();
			tmp_Hyk_Jfzh.setHyid(cardId);
			tmp_Hyk_Jfzh.setWcljf(points);
			tmp_Hyk_Jfzh.setXfje(new BigDecimal(0));
			tmp_Hyk_Jfzh.setZkje(new BigDecimal(0));
			tmp_Hyk_Jfzh.setBqjf(new Double(0));
			tmp_Hyk_Jfzh.setLjjf(new Double(0));
			tmp_Hyk_Jfzh.setLjxfje(new BigDecimal(0));
			tmp_Hyk_Jfzh.setLjzkje(new BigDecimal(0));
			hyk_JfzhMapper.insertSelective(tmp_Hyk_Jfzh);
		} else {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("point", points);
			paramMap.put("cardId", cardId);
			hyk_JfzhMapper.modifyPointByCardId(paramMap);
		}

		// 取人员信息
		Ryxx ryxx = ryxxMapper.selectByPersonCode(partnerCode);

		// 取调用者对应的加盟机构ID
		ApiPersonDef apiPersonDef = apiPersonDefMapper.selectByPrimaryKey(ryxx.getPersonId());
		if (apiPersonDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF, EnumGeneralException.CODE_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF);
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

		// 生成单据号
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("TBLNAME", "HYK_JFBDD");
		paramMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(paramMap);
		int orderNo = (Integer) paramMap.get("NewRecNo");

		// 写API调用记录表(API_HYK_JFBDJL)
		Api_Hyk_Jfbdjl api_Hyk_Jfbdjl = new Api_Hyk_Jfbdjl();
		api_Hyk_Jfbdjl.setJlbh(orderNo);
		api_Hyk_Jfbdjl.setTradeNo(tradeNo);
		api_Hyk_Jfbdjl.setCallerId(ryxx.getPersonId());
		api_Hyk_Jfbdjl.setCallerName(ryxx.getPersonName());
		api_Hyk_Jfbdjl.setCallDate(new Date());
		api_Hyk_Jfbdjl.setCardId(cardId);
		api_Hyk_Jfbdjl.setPoints(points);
		api_Hyk_Jfbdjl.setBizType(bizType);
		api_Hyk_Jfbdjl.setFlagFlushed(false);
		api_Hyk_JfbdjlMapper.insertSelective(api_Hyk_Jfbdjl);

		// 写积分变动记录表
		Hyk_Jfbdd hyk_Jfbdd = new Hyk_Jfbdd();
		hyk_Jfbdd.setJlbh(orderNo);
		hyk_Jfbdd.setHyid(cardId);
		hyk_Jfbdd.setCzdd(hyk_Bgdd.getBgdddm());
		hyk_Jfbdd.setWcljfOld(new Double(wcljf));
		hyk_Jfbdd.setTzjf(new Double(points));
		hyk_Jfbdd.setDjr(ryxx.getPersonId());
		hyk_Jfbdd.setDjrmc(ryxx.getPersonName());
		hyk_Jfbdd.setXfje(new BigDecimal(0));
		hyk_Jfbdd.setDjsj(new Date());
		hyk_Jfbdd.setZxr(ryxx.getPersonId());
		hyk_Jfbdd.setDjrmc(ryxx.getPersonName());
		hyk_Jfbdd.setZxrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		hyk_JfbddMapper.insertSelective(hyk_Jfbdd);

		// 写门店积分表
		Hyk_MdjfKey hyk_MdjfKey = new Hyk_MdjfKey();
		hyk_MdjfKey.setHyid(cardId);
		hyk_MdjfKey.setMdid(apiOrgDef.getMdid());

		Hyk_Mdjf hyk_Mdjf = hyk_MdjfMapper.selectByPrimaryKey(hyk_MdjfKey);
		if (hyk_Mdjf == null) {
			hyk_Mdjf = new Hyk_Mdjf();
			hyk_Mdjf.setHyid(cardId);
			hyk_Mdjf.setMdid(apiOrgDef.getMdid());
			hyk_Mdjf.setWcljf(new Double(points));
			hyk_Mdjf.setXfje(new Double(0));
			hyk_Mdjf.setZkje(new BigDecimal(0));
			hyk_Mdjf.setBqjf(new Double(0));
			hyk_Mdjf.setLjjf(new Double(0));
			hyk_Mdjf.setLjxfje(new BigDecimal(0));
			hyk_Mdjf.setLjzkje(new BigDecimal(0));
			hyk_MdjfMapper.insertSelective(hyk_Mdjf);
		} else {
			hyk_Mdjf.setWcljf(hyk_Mdjf.getWcljf() + new Double(points));
			hyk_MdjfMapper.updateByPrimaryKeySelective(hyk_Mdjf);
		}

		// 写会员卡积分变动明细表
		Hyk_JfbdjlmxKey hyk_JfbdjlmxKey = new Hyk_JfbdjlmxKey();
		hyk_JfbdjlmxKey.setJlbh(orderNo);
		hyk_JfbdjlmxKey.setHyid(cardId);
		hyk_JfbdjlmxKey.setCllx(bizType.shortValue());
		hyk_JfbdjlmxKey.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());

		Hyk_Jfbdjlmx hyk_Jfbdjlmx = hyk_JfbdjlmxMapper.selectByPrimaryKey(hyk_JfbdjlmxKey);
		if (hyk_Jfbdjlmx == null) {
			hyk_Jfbdjlmx = new Hyk_Jfbdjlmx();
			hyk_Jfbdjlmx.setJlbh(orderNo);
			hyk_Jfbdjlmx.setHyid(cardId);
			hyk_Jfbdjlmx.setCllx(bizType.shortValue());
			hyk_Jfbdjlmx.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			hyk_Jfbdjlmx.setWcljfbd(points);
			hyk_Jfbdjlmx.setBqjfbd(new Double(0));
			hyk_JfbdjlmxMapper.insertSelective(hyk_Jfbdjlmx);
		} else {
			hyk_Jfbdjlmx.setWcljfbd(hyk_Jfbdjlmx.getWcljfbd() + new Double(points));
			hyk_JfbdjlmxMapper.updateByPrimaryKeySelective(hyk_Jfbdjlmx);
		}

		// 写会员积分变动记录明细(门店)表
		Hyk_Jfbdjlmx_MdKey hyk_Jfbdjlmx_MdKey = new Hyk_Jfbdjlmx_MdKey();
		hyk_Jfbdjlmx_MdKey.setHyid(cardId);
		hyk_Jfbdjlmx_MdKey.setMdid(apiOrgDef.getMdid());
		hyk_Jfbdjlmx_MdKey.setCllx(bizType.shortValue());
		hyk_Jfbdjlmx_MdKey.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());

		Hyk_Jfbdjlmx_Md hyk_Jfbdjlmx_Md = hyk_Jfbdjlmx_MdMapper.selectByPrimaryKey(hyk_Jfbdjlmx_MdKey);
		if (hyk_Jfbdjlmx_Md == null) {
			hyk_Jfbdjlmx_Md = new Hyk_Jfbdjlmx_Md();
			hyk_Jfbdjlmx_Md.setHyid(cardId);
			hyk_Jfbdjlmx_Md.setMdid(apiOrgDef.getMdid());
			hyk_Jfbdjlmx_Md.setCllx(bizType.shortValue());
			hyk_Jfbdjlmx_Md.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			hyk_Jfbdjlmx_Md.setWcljfbd(points);
			hyk_Jfbdjlmx_Md.setBqjfbd(new Double(0));
			hyk_Jfbdjlmx_MdMapper.insertSelective(hyk_Jfbdjlmx_Md);
		} else {
			hyk_Jfbdjlmx_Md.setWcljfbd(hyk_Jfbdjlmx_Md.getWcljfbd() + new Double(points));
			hyk_Jfbdjlmx_MdMapper.updateByPrimaryKeySelective(hyk_Jfbdjlmx_Md);
		}

		return orderNo;
	}

	@Override
	public int cutMemberTicketAccount(String tradeNo, String partnerCode, Integer cardId, Double tickets, Integer bizType) throws GeneralException, DataAccessException {
		// 判断bizType是否存在
		// TODO 如果后期需要增加权限控制，需要在这个逻辑中做进一步判断。
		Enum_Czk_Yhq_Cllx enum_Czk_Yhq_Cllx = enum_Czk_Yhq_CllxMapper.selectByPrimaryKey(bizType);
		if (enum_Czk_Yhq_Cllx == null) {
			throw new GeneralException(EnumGeneralException.MSG_BIZ_TYPE_NOT_DEFAULT, EnumGeneralException.CODE_BIZ_TYPE_NOT_DEFAULT);
		}

		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectByPrimaryKey(cardId);
		// 判断会员卡的状态是否为有效状态
		if (!BizUtil.isValidAnalyzingCard(hyk_Hyxx.getStatus())) {
			throw new GeneralException(EnumGeneralException.MSG_CARD_IS_VALID, EnumGeneralException.CODE_CARD_IS_VALID);
		}

		// 取当前有效的优惠券账户金额合计
		int effectCountPoint = hyk_YhqzhMapper.selectEffectTicketsByCardId(cardId);
		if (effectCountPoint - tickets < 0) {
			throw new GeneralException(EnumGeneralException.MSG_TICKET_BALANCE_LESS_EXCHANGE_POINT, EnumGeneralException.CODE_TICKET_BALANCE_LESS_EXCHANGE_POINT);
		}

		// 取人员信息
		Ryxx ryxx = ryxxMapper.selectByPersonCode(partnerCode);

		// 取调用者对应的加盟机构ID
		ApiPersonDef apiPersonDef = apiPersonDefMapper.selectByPrimaryKey(ryxx.getPersonId());
		if (apiPersonDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF, EnumGeneralException.CODE_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF);
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

		// 生成单据号
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("TBLNAME", "API_HYK_YHQCLJL");
		paramMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(paramMap);
		int orderNo = (Integer) paramMap.get("NewRecNo");

		// 写接口调用记录表(API_HYK_YHQCLJL)
		Api_Hyk_Yhqcljl api_Hyk_Yhqcljl = new Api_Hyk_Yhqcljl();
		api_Hyk_Yhqcljl.setJlbh(orderNo);
		api_Hyk_Yhqcljl.setTradeNo(tradeNo);
		api_Hyk_Yhqcljl.setCardId(cardId);
		api_Hyk_Yhqcljl.setTickets(tickets);
		api_Hyk_Yhqcljl.setBizType(bizType);
		api_Hyk_Yhqcljl.setCallerId(ryxx.getPersonId());
		api_Hyk_Yhqcljl.setCallerName(ryxx.getPersonName());
		api_Hyk_Yhqcljl.setCallDate(new Date());
		api_Hyk_Yhqcljl.setFlagFlushed(false);
		api_Hyk_YhqcljlMapper.insert(api_Hyk_Yhqcljl);

		List<Hyk_Yhqzh> lstHyk_Yhqzh = hyk_YhqzhMapper.selectEffectTicketListByCardId(cardId);
		int i = 0;
		while (tickets > 0) {
			Hyk_Yhqzh itemHyk_Yhqzh = lstHyk_Yhqzh.get(i);

			double jyje = 0;
			if (itemHyk_Yhqzh.getJe().doubleValue() < tickets) {
				jyje = itemHyk_Yhqzh.getJe().doubleValue();
			} else {
				jyje = tickets;
			}

			// 生成优惠券取款记录(HYK_CZK_YHQ_QKJL)的流水表
			Map<String, Object> qkjl_ParamMap = new HashMap<String, Object>();
			qkjl_ParamMap.put("TBLNAME", "HYK_YHQ_QKJL");
			qkjl_ParamMap.put("NewRecNo", 0);
			bhztMapper.procUpdateBHZT(qkjl_ParamMap);
			int qkjlOrderNo = (Integer) qkjl_ParamMap.get("NewRecNo");

			// 写优惠券取款记录表(HYK_CZK_YHQ_QKJL).
			Hyk_Czk_Yhq_Qkjl hyk_Czk_Yhq_Qkjl = new Hyk_Czk_Yhq_Qkjl();
			hyk_Czk_Yhq_Qkjl.setCzjpjJlbh(qkjlOrderNo);
			hyk_Czk_Yhq_Qkjl.setHyid(cardId);
			hyk_Czk_Yhq_Qkjl.setYhqid(itemHyk_Yhqzh.getYhqid().intValue());
			hyk_Czk_Yhq_Qkjl.setJsrq(itemHyk_Yhqzh.getJsrq());
			hyk_Czk_Yhq_Qkjl.setMdfwdm(itemHyk_Yhqzh.getMdfwdm());
			hyk_Czk_Yhq_Qkjl.setYje(itemHyk_Yhqzh.getJe());
			hyk_Czk_Yhq_Qkjl.setQkje(new BigDecimal(jyje));
			hyk_Czk_Yhq_Qkjl.setZy("加盟机构调用‘优惠券扣减’API接口。");
			hyk_Czk_Yhq_Qkjl.setDjr(ryxx.getPersonId());
			hyk_Czk_Yhq_Qkjl.setDjrmc(ryxx.getPersonName());
			hyk_Czk_Yhq_Qkjl.setDjsj(new Date());
			hyk_Czk_Yhq_Qkjl.setZxr(ryxx.getPersonId());
			hyk_Czk_Yhq_Qkjl.setZxrmc(ryxx.getPersonName());
			hyk_Czk_Yhq_Qkjl.setZxrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			hyk_Czk_Yhq_Qkjl.setCzdd(hyk_Bgdd.getBgdddm());
			hyk_Czk_Yhq_QkjlMapper.insert(hyk_Czk_Yhq_Qkjl);

			// 修改优惠券账户表(HYK_YHQZH)
			Hyk_Yhqzh hyk_Yhqzh = new Hyk_Yhqzh();
			hyk_Yhqzh.setHyid(cardId);
			hyk_Yhqzh.setJe(new BigDecimal(itemHyk_Yhqzh.getJe().doubleValue() - jyje));
			hyk_Yhqzh.setJsrq(itemHyk_Yhqzh.getJsrq());
			hyk_Yhqzh.setJydjje(itemHyk_Yhqzh.getJydjje());
			hyk_Yhqzh.setMdfwdm(itemHyk_Yhqzh.getMdfwdm());
			hyk_Yhqzh.setYhqid(itemHyk_Yhqzh.getYhqid());
			hyk_YhqzhMapper.updateByPrimaryKey(hyk_Yhqzh);

			// 记录优惠券处理记录表(HYK_YHQCLJL)
			Hyk_Yhqcljl hyk_Yhqcljl = new Hyk_Yhqcljl();
			hyk_Yhqcljl.setHyid(cardId);
			hyk_Yhqcljl.setClsj(new Date());
			hyk_Yhqcljl.setCllx((short) 2);
			hyk_Yhqcljl.setJlbh(qkjlOrderNo);
			hyk_Yhqcljl.setYhqid(itemHyk_Yhqzh.getYhqid());
			hyk_Yhqcljl.setJsrq(itemHyk_Yhqzh.getJsrq());
			hyk_Yhqcljl.setMdfwdm(itemHyk_Yhqzh.getMdfwdm());
			hyk_Yhqcljl.setZy("加盟机构调用‘优惠券扣减’API接口。");
			hyk_Yhqcljl.setJfje(new BigDecimal(0));
			hyk_Yhqcljl.setDfje(new BigDecimal(jyje));
			hyk_Yhqcljl.setYe(new BigDecimal(itemHyk_Yhqzh.getJe().doubleValue() - jyje));
			hyk_YhqcljlMapper.insert(hyk_Yhqcljl);

			// 写接口调用记录明细表(API_HYK_YHQCLJL_ITEM)
			Api_Hyk_Yhqcljl_Item api_Hyk_Yhqcljl_Item = new Api_Hyk_Yhqcljl_Item();
			api_Hyk_Yhqcljl_Item.setJlbh(orderNo);
			api_Hyk_Yhqcljl_Item.setCardId(cardId);
			api_Hyk_Yhqcljl_Item.setYhqid(itemHyk_Yhqzh.getYhqid().intValue());
			api_Hyk_Yhqcljl_Item.setJsrq(itemHyk_Yhqzh.getJsrq());
			api_Hyk_Yhqcljl_Item.setMdfwdm(itemHyk_Yhqzh.getMdfwdm());
			api_Hyk_Yhqcljl_Item.setJe(jyje);
			api_Hyk_Yhqcljl_Item.setCzJlbh(qkjlOrderNo);
			api_Hyk_Yhqcljl_ItemMapper.insert(api_Hyk_Yhqcljl_Item);

			tickets = tickets - jyje;
			i++;
		}

		return orderNo;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yyabl.api.crm.biz.Service.AccountService#flushesMemberPointAccount(com.yyabl.api.crm.biz.Bean.ReqFlushesPointBean)
	 */
	@Override
	public int flushesMemberPointAccount(ReqFlushesPointBean reqFlushesPointBean) throws GeneralException, DataAccessException {
		Api_Hyk_Jfbdjl api_Hyk_Jfbdjl = api_Hyk_JfbdjlMapper.selectByPrimaryKey(reqFlushesPointBean.getOrderNo());
		// 如果找不到原单据号，则抛出异常
		if (api_Hyk_Jfbdjl == null) {
			throw new GeneralException(EnumGeneralException.MSG_FLUSHES_EROR_NOT_FOUND_ORDER_NO, EnumGeneralException.CODE_FLUSHES_ERROR_NOT_FOUND_ORDER_NO);
		}
		// 如果原单据已经进行了冲正，则抛出异常
		if (api_Hyk_Jfbdjl.getFlagFlushed() == true) {
			throw new GeneralException(EnumGeneralException.MSG_FLUSHES_ERROR_IS_FLUSED, EnumGeneralException.CODE_FLUSHES_ERROR_IS_FLUSED);
		}

		int cardId = api_Hyk_Jfbdjl.getCardId();
		Double points = api_Hyk_Jfbdjl.getPoints();

		Hyk_Jfzh hyk_Jfzh = hyk_JfzhMapper.selectByPrimaryKey(cardId);
		// 如果当前积分值不足以进行冲正，则抛出异常
		if (hyk_Jfzh.getWcljf() + (points * -1) < 0) {
			throw new GeneralException(EnumGeneralException.MSG_FLUSEHS_ERROR_POINT_NOT_ENOUGH, EnumGeneralException.CODE_FLUSEHS_ERROR_POINT_NOT_ENOUGH);
		}

		// 取人员信息
		Ryxx ryxx = ryxxMapper.selectByPersonCode(reqFlushesPointBean.getPartnerCode());

		// 取调用者对应的加盟机构ID
		ApiPersonDef apiPersonDef = apiPersonDefMapper.selectByPrimaryKey(ryxx.getPersonId());
		if (apiPersonDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF, EnumGeneralException.CODE_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF);
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

		// 修改原单据号(BFCRM.API_HYK_JFBDJL)的FLAG_FLUSHED标记为true
		api_Hyk_Jfbdjl.setFlagFlushed(true);
		api_Hyk_JfbdjlMapper.updateByPrimaryKey(api_Hyk_Jfbdjl);

		// 生成'积分冲正记录'(API_FLUSHES_POINT)的单据号
		Map<String, Object> flushesParamMap = new HashMap<String, Object>();
		flushesParamMap.put("TBLNAME", "API_FLUSHES_POINT");
		flushesParamMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(flushesParamMap);
		int flushesOrderNo = (Integer) flushesParamMap.get("NewRecNo");

		// 写积分冲正记录表(BFCRM.API_FLUSHES_POINT)
		ApiFlushesPoint apiFlushesPoint = new ApiFlushesPoint();
		apiFlushesPoint.setJlbh(flushesOrderNo);
		apiFlushesPoint.setOldJlbh(api_Hyk_Jfbdjl.getJlbh());
		apiFlushesPoint.setCallerId(ryxx.getPersonId());
		apiFlushesPoint.setCallerName(ryxx.getPersonName());
		apiFlushesPoint.setCallDate(new Date());
		apiFlushesPointMapper.insert(apiFlushesPoint);

		// 修改HYK_JFZH表
		Map<String, Object> jfzhParamMap = new HashMap<String, Object>();
		jfzhParamMap.put("point", points * -1);
		jfzhParamMap.put("cardId", cardId);
		hyk_JfzhMapper.modifyPointByCardId(jfzhParamMap);

		// 修改HYK_MDJF表
		Hyk_MdjfKey hyk_MdjfKey = new Hyk_MdjfKey();
		hyk_MdjfKey.setHyid(cardId);
		hyk_MdjfKey.setMdid(apiOrgDef.getMdid());

		Hyk_Mdjf hyk_Mdjf = hyk_MdjfMapper.selectByPrimaryKey(hyk_MdjfKey);
		if (hyk_Mdjf == null) {
			hyk_Mdjf = new Hyk_Mdjf();
			hyk_Mdjf.setHyid(cardId);
			hyk_Mdjf.setMdid(apiOrgDef.getMdid());
			hyk_Mdjf.setWcljf(new Double(points * -1));
			hyk_Mdjf.setXfje(new Double(0));
			hyk_Mdjf.setZkje(new BigDecimal(0));
			hyk_Mdjf.setBqjf(new Double(0));
			hyk_Mdjf.setLjjf(new Double(0));
			hyk_Mdjf.setLjxfje(new BigDecimal(0));
			hyk_Mdjf.setLjzkje(new BigDecimal(0));
			hyk_MdjfMapper.insertSelective(hyk_Mdjf);
		} else {
			hyk_Mdjf.setWcljf(hyk_Mdjf.getWcljf() + new Double(points * -1));
			hyk_MdjfMapper.updateByPrimaryKeySelective(hyk_Mdjf);
		}

		// 生成'积分变动单'(HYK_JFBDD)的单据号
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("TBLNAME", "HYK_JFBDD");
		paramMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(paramMap);
		int orderNo = (Integer) paramMap.get("NewRecNo");

		// 记HYK_JFBDJL表
		Hyk_Jfbdd hyk_Jfbdd = new Hyk_Jfbdd();
		hyk_Jfbdd.setJlbh(orderNo);
		hyk_Jfbdd.setHyid(cardId);
		hyk_Jfbdd.setCzdd(hyk_Bgdd.getBgdddm());
		hyk_Jfbdd.setWcljfOld(hyk_Jfzh.getWcljf());
		hyk_Jfbdd.setTzjf(new Double(points * -1));
		hyk_Jfbdd.setDjr(ryxx.getPersonId());
		hyk_Jfbdd.setDjrmc(ryxx.getPersonName());
		hyk_Jfbdd.setXfje(new BigDecimal(0));
		hyk_Jfbdd.setDjsj(new Date());
		hyk_Jfbdd.setZxr(ryxx.getPersonId());
		hyk_Jfbdd.setDjrmc(ryxx.getPersonName());
		hyk_Jfbdd.setZxrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		hyk_JfbddMapper.insertSelective(hyk_Jfbdd);

		// 写会员卡积分变动明细表
		Hyk_JfbdjlmxKey hyk_JfbdjlmxKey = new Hyk_JfbdjlmxKey();
		hyk_JfbdjlmxKey.setJlbh(orderNo);
		hyk_JfbdjlmxKey.setHyid(cardId);
		hyk_JfbdjlmxKey.setCllx((short) bizType);
		hyk_JfbdjlmxKey.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());

		Hyk_Jfbdjlmx hyk_Jfbdjlmx = hyk_JfbdjlmxMapper.selectByPrimaryKey(hyk_JfbdjlmxKey);
		if (hyk_Jfbdjlmx == null) {
			hyk_Jfbdjlmx = new Hyk_Jfbdjlmx();
			hyk_Jfbdjlmx.setJlbh(orderNo);
			hyk_Jfbdjlmx.setHyid(cardId);
			hyk_Jfbdjlmx.setCllx((short) bizType);
			hyk_Jfbdjlmx.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			hyk_Jfbdjlmx.setWcljfbd(points * -1);
			hyk_Jfbdjlmx.setBqjfbd(new Double(0));
			hyk_JfbdjlmxMapper.insertSelective(hyk_Jfbdjlmx);
		} else {
			hyk_Jfbdjlmx.setWcljfbd(hyk_Jfbdjlmx.getWcljfbd() + new Double(points * -1));
			hyk_JfbdjlmxMapper.updateByPrimaryKeySelective(hyk_Jfbdjlmx);
		}

		// 写会员积分变动记录明细(门店)表
		Hyk_Jfbdjlmx_MdKey hyk_Jfbdjlmx_MdKey = new Hyk_Jfbdjlmx_MdKey();
		hyk_Jfbdjlmx_MdKey.setHyid(cardId);
		hyk_Jfbdjlmx_MdKey.setMdid(apiOrgDef.getMdid());
		hyk_Jfbdjlmx_MdKey.setCllx((short) bizType);
		hyk_Jfbdjlmx_MdKey.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());

		Hyk_Jfbdjlmx_Md hyk_Jfbdjlmx_Md = hyk_Jfbdjlmx_MdMapper.selectByPrimaryKey(hyk_Jfbdjlmx_MdKey);
		if (hyk_Jfbdjlmx_Md == null) {
			hyk_Jfbdjlmx_Md = new Hyk_Jfbdjlmx_Md();
			hyk_Jfbdjlmx_Md.setHyid(cardId);
			hyk_Jfbdjlmx_Md.setMdid(apiOrgDef.getMdid());
			hyk_Jfbdjlmx_Md.setCllx((short) bizType);
			hyk_Jfbdjlmx_Md.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			hyk_Jfbdjlmx_Md.setWcljfbd(points * -1);
			hyk_Jfbdjlmx_Md.setBqjfbd(new Double(0));
			hyk_Jfbdjlmx_MdMapper.insertSelective(hyk_Jfbdjlmx_Md);
		} else {
			hyk_Jfbdjlmx_Md.setWcljfbd(hyk_Jfbdjlmx_Md.getWcljfbd() + new Double(points * -1));
			hyk_Jfbdjlmx_MdMapper.updateByPrimaryKeySelective(hyk_Jfbdjlmx_Md);
		}

		return flushesOrderNo;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yyabl.api.crm.biz.Service.AccountService#flushesMemberTicketAccount(com.yyabl.api.crm.biz.Bean.ReqFlushesTicketBean)
	 */
	@Override
	public int flushesMemberTicketAccount(ReqFlushesTicketBean reqFlushesTicketBean) throws GeneralException, DataAccessException {
		Api_Hyk_Yhqcljl api_Hyk_Yhqcljl = api_Hyk_YhqcljlMapper.selectByPrimaryKey(reqFlushesTicketBean.getOrderNo());
		// 如果找不到原单据号，则抛出异常
		if (api_Hyk_Yhqcljl == null) {
			throw new GeneralException(EnumGeneralException.MSG_FLUSHES_EROR_NOT_FOUND_ORDER_NO, EnumGeneralException.CODE_FLUSHES_ERROR_NOT_FOUND_ORDER_NO);
		}

		// 如果原单据已经进行了冲正，则抛出异常
		if (api_Hyk_Yhqcljl.getFlagFlushed() == true) {
			throw new GeneralException(EnumGeneralException.MSG_FLUSHES_ERROR_IS_FLUSED, EnumGeneralException.CODE_FLUSHES_ERROR_IS_FLUSED);
		}

		int cardId = api_Hyk_Yhqcljl.getCardId();

		// 取人员信息
		Ryxx ryxx = ryxxMapper.selectByPersonCode(reqFlushesTicketBean.getPartnerCode());

		// 取调用者对应的加盟机构ID
		ApiPersonDef apiPersonDef = apiPersonDefMapper.selectByPrimaryKey(ryxx.getPersonId());
		if (apiPersonDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF, EnumGeneralException.CODE_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF);
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

		// 修改原单据的冲正状态
		api_Hyk_Yhqcljl.setFlagFlushed(true);
		api_Hyk_YhqcljlMapper.updateByPrimaryKey(api_Hyk_Yhqcljl);

		// 生成'电子券冲正记录'(API_FLUSHES_TICKET)的单据号
		Map<String, Object> flushesParamMap = new HashMap<String, Object>();
		flushesParamMap.put("TBLNAME", "API_FLUSHES_TICKET");
		flushesParamMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(flushesParamMap);
		int flushesOrderNo = (Integer) flushesParamMap.get("NewRecNo");

		// 写电子券冲正记录表
		ApiFlushesTicket apiFlushesTicket = new ApiFlushesTicket();
		apiFlushesTicket.setJlbh(flushesOrderNo);
		apiFlushesTicket.setOldJlbh(api_Hyk_Yhqcljl.getJlbh());
		apiFlushesTicket.setCallerId(ryxx.getPersonId());
		apiFlushesTicket.setCallerName(ryxx.getPersonName());
		apiFlushesTicket.setCallDate(new Date());
		apiFlushesTicketMapper.insert(apiFlushesTicket);

		// 取扣劵时的明细表
		List<Api_Hyk_Yhqcljl_Item> lstApi_Hyk_Yhqcljl_Item = api_Hyk_Yhqcljl_ItemMapper.selectByPramaryKey(api_Hyk_Yhqcljl.getJlbh());
		// 根据扣券明细表，退回到每个批次的劵账户中
		for (int i = 0; i < lstApi_Hyk_Yhqcljl_Item.size(); i++) {
			Api_Hyk_Yhqcljl_Item api_Hyk_Yhqcljl_Item = lstApi_Hyk_Yhqcljl_Item.get(i);

			// 根据优惠券账户表的主键，查询当前优惠券账户的批次信息
			Hyk_YhqzhKey hyk_YhqzhKey = new Hyk_YhqzhKey();
			hyk_YhqzhKey.setHyid(cardId);
			hyk_YhqzhKey.setJsrq(api_Hyk_Yhqcljl_Item.getJsrq());
			hyk_YhqzhKey.setMdfwdm(api_Hyk_Yhqcljl_Item.getMdfwdm());
			hyk_YhqzhKey.setYhqid(api_Hyk_Yhqcljl_Item.getYhqid().shortValue());
			Hyk_Yhqzh hyk_Yhqzh = hyk_YhqzhMapper.selectByPrimaryKey(hyk_YhqzhKey);

			// 更新优惠券账户表
			if (hyk_Yhqzh == null) {
				hyk_Yhqzh = new Hyk_Yhqzh();
				hyk_Yhqzh.setHyid(cardId);
				hyk_Yhqzh.setJe(new BigDecimal(api_Hyk_Yhqcljl_Item.getJe()));
				hyk_Yhqzh.setJsrq(api_Hyk_Yhqcljl_Item.getJsrq());
				hyk_Yhqzh.setJydjje(new BigDecimal(0));
				hyk_Yhqzh.setMdfwdm(api_Hyk_Yhqcljl_Item.getMdfwdm());
				hyk_Yhqzh.setYhqid(api_Hyk_Yhqcljl_Item.getYhqid().shortValue());
				hyk_YhqzhMapper.insert(hyk_Yhqzh);
			} else {
				hyk_Yhqzh.setJe(hyk_Yhqzh.getJe().add(new BigDecimal(api_Hyk_Yhqcljl_Item.getJe())));
				hyk_YhqzhMapper.updateByPrimaryKey(hyk_Yhqzh);
			}

			// 生成优惠券存款记录表(HYK_CZK_YHQ_CKJL)的单据号
			Map<String, Object> ckjl_ParamMap = new HashMap<String, Object>();
			ckjl_ParamMap.put("TBLNAME", "HYK_YHQ_CKJL");
			ckjl_ParamMap.put("NewRecNo", 0);
			bhztMapper.procUpdateBHZT(ckjl_ParamMap);
			int ckjlOrderNo = (Integer) ckjl_ParamMap.get("NewRecNo");

			// 写优惠券存款记录表(HYK_CZK_YHQ_CKJL)
			Hyk_Czk_Yhq_Ckjl hyk_Czk_Yhq_Ckjl = new Hyk_Czk_Yhq_Ckjl();
			hyk_Czk_Yhq_Ckjl.setCzjpjJlbh(ckjlOrderNo);
			hyk_Czk_Yhq_Ckjl.setHyid(cardId);
			hyk_Czk_Yhq_Ckjl.setYhqid(api_Hyk_Yhqcljl_Item.getYhqid());
			hyk_Czk_Yhq_Ckjl.setJsrq(api_Hyk_Yhqcljl_Item.getJsrq());
			hyk_Czk_Yhq_Ckjl.setMdfwdm(api_Hyk_Yhqcljl_Item.getMdfwdm());
			hyk_Czk_Yhq_Ckjl.setYje(hyk_Yhqzh.getJe());
			hyk_Czk_Yhq_Ckjl.setCkje(new BigDecimal(api_Hyk_Yhqcljl_Item.getJe()));
			hyk_Czk_Yhq_Ckjl.setZy("加盟机构调用‘优惠券扣减冲正’API接口。");
			hyk_Czk_Yhq_Ckjl.setDjr(ryxx.getPersonId());
			hyk_Czk_Yhq_Ckjl.setDjrmc(ryxx.getPersonName());
			hyk_Czk_Yhq_Ckjl.setDjsj(new Date());
			hyk_Czk_Yhq_Ckjl.setZxr(ryxx.getPersonId());
			hyk_Czk_Yhq_Ckjl.setZxrmc(ryxx.getPersonName());
			hyk_Czk_Yhq_Ckjl.setZxrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			hyk_Czk_Yhq_Ckjl.setCzdd(hyk_Bgdd.getBgdddm());
			hyk_Czk_Yhq_CkjlMapper.insert(hyk_Czk_Yhq_Ckjl);

			// 写优惠券处理记录表(HYK_YHQCLJL)
			Hyk_Yhqcljl hyk_Yhqcljl = new Hyk_Yhqcljl();
			hyk_Yhqcljl.setHyid(cardId);
			hyk_Yhqcljl.setClsj(new Date());
			hyk_Yhqcljl.setCllx((short) 1);
			hyk_Yhqcljl.setJlbh(ckjlOrderNo);
			hyk_Yhqcljl.setYhqid(api_Hyk_Yhqcljl_Item.getYhqid().shortValue());
			hyk_Yhqcljl.setJsrq(api_Hyk_Yhqcljl_Item.getJsrq());
			hyk_Yhqcljl.setMdfwdm(api_Hyk_Yhqcljl_Item.getMdfwdm());
			hyk_Yhqcljl.setZy("加盟机构调用‘优惠券扣减冲正’API接口。");
			hyk_Yhqcljl.setJfje(new BigDecimal(api_Hyk_Yhqcljl_Item.getJe()));
			hyk_Yhqcljl.setDfje(new BigDecimal(0));
			hyk_Yhqcljl.setYe(hyk_Yhqzh.getJe());
			hyk_YhqcljlMapper.insert(hyk_Yhqcljl);
		}
		return flushesOrderNo;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yyabl.api.crm.biz.Service.AccountService#exchangePointToTicket(com.yyabl.api.crm.biz.Bean.ReqExchangePointToTicketBean)
	 */
	@Override
	public RespExchangePointToTicketBean exchangePointToTicket(ReqExchangePointToTicketBean parameterBean) throws GeneralException, DataAccessException {
		RespExchangePointToTicketBean returnBean = new RespExchangePointToTicketBean();
		String partenrCode = parameterBean.getPartnerCode();
		int paramCardId = parameterBean.getCardId();
		int paramPoint = parameterBean.getPoint();
		double wcljf = 0;
		int usePoint = 0;
		int exChangeNumber = 0;

		// 判断HYK_JFZH是否存在
		Hyk_Jfzh hyk_Jfzh = hyk_JfzhMapper.selectByPrimaryKey(paramCardId);
		if (hyk_Jfzh == null) {
			throw new GeneralException(EnumGeneralException.MSG_CARD_POINT_ACCOUNT_NOT_FOUND, EnumGeneralException.CODE_CARD_POINT_ACCOUNT_NOT_FOUND);
		} else {
			wcljf = hyk_Jfzh.getWcljf();
		}

		int wcljf_md = hyk_MdjfMapper.selectEffectPointsByCardId(paramCardId);
		// 因为HYK_JFZH与HYK_MDJF之间有微小的差异，因此判断两个值之间的差额不能大于1.
		if (Math.abs(wcljf - wcljf_md) > 1) {
			throw new GeneralException(EnumGeneralException.MSG_EXCHANGE_POINT_TO_TICKET_POINT_VALUE_EXCEPTION, EnumGeneralException.CODE_EXCHANGE_POINT_TO_TICKET_POINT_VALUE_EXCEPTION);
		}

		// 判断用户输入的积分是否小余兑换积分规则(500分)
		if (paramPoint < exchangeRulePoint) {
			throw new GeneralException(EnumGeneralException.MSG_EXCHANGE_POINT_LESS_RULE, EnumGeneralException.CODE_EXCHANGE_POINT_LESS_RULE);
		}

		// 判断积分账户的余额是否足够用于本次积分兑券。
		if (paramPoint > wcljf) {
			throw new GeneralException(EnumGeneralException.MSG_POINT_BALANCE_LESS_EXCHANGE_POINT, EnumGeneralException.CODE_POINT_BALANCE_LESS_EXCHANGE_POINT);
		}

		// 判断用户输入的兑换积分是否大于当前账户中的余额
		if (paramPoint > wcljf_md) {
			throw new GeneralException(EnumGeneralException.MSG_EXCHANGE_POINT_TO_TICKET_POINT_NOT_ENOUGH, EnumGeneralException.CODE_EXCHANGE_POINT_TO_TICKET_POINT_NOT_ENOUGH);
		}

		// TODO
		// 目前，通过接口进行积分兑换，不遵循线下的“5000分兑换100元电子券的规则”，而采用“500分兑换10元电子券的规则”，因此在这里将电子券兑换规则写死。后期根据需求，看是否要添加相应的积分兑换规则定义
		// 根据用户输入计算可兑换次数
		exChangeNumber = paramPoint / exchangeRulePoint;
		// 本次积分兑券使用的积分
		usePoint = exChangeNumber * exchangeRulePoint;
		// 本次积分兑券可以充值的积分
		int rechargeTicket = exChangeNumber * exchangeRuleTicket;

		// 根据会员卡ID取会员卡类型
		short cardType = hyk_HyxxMapper.selectByPrimaryKey(paramCardId).getHyktype();

		// 取积分返利规则中的电子券有效期天数
		Hyk_Jfflgz hyk_Jfflgz = hyk_JfflgzMapper.selectByPrimaryKey(cardType);
		// 根据积分返利规则生成电子券使用有效期
		Date effectDate;
		// 如果积分返利规则中设定了电子券的具体使用有效期，则根据具体使用有效期生成电子券使用有效期
		if (hyk_Jfflgz == null) {
			throw new GeneralException(EnumGeneralException.MSG_NOT_FIND_POINT_EXCHANGE_TICKET_RULE, EnumGeneralException.CODE_NOT_FIND_POINT_EXCHANGE_TICKET_RULE);
		}
		// 如果积分返利规则中设定了电子券的具体使用有效期，则根据具体使用有效期生成电子券使用有效期
		if (hyk_Jfflgz.getSyjsrq() != null) {
			effectDate = hyk_Jfflgz.getSyjsrq();
		} else {
			// 如果积分返利规则中没有设定电子券的具体使用有效期，则取相对有效期
			DateTime dateTime = new DateTime().plusDays(hyk_Jfflgz.getYhqyxts());
			effectDate = DateTime.parse(dateTime.toString("yyyy-MM-dd")).toDate();
		}

		// 取人员信息
		Ryxx ryxx = ryxxMapper.selectByPersonCode(partenrCode);

		// 取调用者对应的加盟机构ID
		ApiPersonDef apiPersonDef = apiPersonDefMapper.selectByPrimaryKey(ryxx.getPersonId());
		if (apiPersonDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF, EnumGeneralException.CODE_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF);
		}

		// 获取加盟机构对应的实体门店ID
		ApiOrgDef apiOrgDef = apiOrgDefMapper.selectByPrimaryKey(apiPersonDef.getOrgId());
		if (apiOrgDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_ORG_AND_MALL_DEF, EnumGeneralException.CODE_SYSTEM_NOT_FOUND_ORG_AND_MALL_DEF);
		}

		// 更新HYK_JFZH表
		// TODO 通过HYK_JFZH.WCLJF字段上设定的规则，如果抛出异常就回滚事务，这是一个蹩脚的确保重入一致性的办法。
		Map<String, Object> jfzhParamMap = new HashMap<String, Object>();
		jfzhParamMap.put("point", usePoint * -1);
		jfzhParamMap.put("cardId", paramCardId);
		hyk_JfzhMapper.modifyPointByCardId(jfzhParamMap);

		// 取编号状态
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("TBLNAME", "HYK_VIPJLCLJL");
		paramMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(paramMap);
		int orderNo = (Integer) paramMap.get("NewRecNo");

		// 更新门店积分分摊
		Map<String, Object> procParam = new HashMap<String, Object>();
		procParam.put("HYID", paramCardId);
		procParam.put("DJJF", usePoint);
		procParam.put("JLBH", orderNo);
		procParam.put("ProcDate", DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		hyk_MdjfMapper.procHyxfMdjfFt(procParam);

		// 写入HYK_VIPJLCLJL表
		Hyk_Vipjlcljl hyk_Vipjlcljl = new Hyk_Vipjlcljl();
		hyk_Vipjlcljl.setJlbh(orderNo);
		hyk_Vipjlcljl.setHyid(paramCardId);
		hyk_Vipjlcljl.setHyktype(cardType);
		hyk_Vipjlcljl.setFlje(new BigDecimal(rechargeTicket));
		hyk_Vipjlcljl.setLjxfje(hyk_Jfzh.getLjxfje());
		hyk_Vipjlcljl.setCljf(new Double(usePoint));
		hyk_Vipjlcljl.setClrq(new Date());
		hyk_Vipjlcljl.setDjr(ryxx.getPersonId());
		hyk_Vipjlcljl.setDjrmc(ryxx.getPersonName());
		hyk_Vipjlcljl.setDjsj(new Date());
		hyk_Vipjlcljl.setShr(ryxx.getPersonId());
		hyk_Vipjlcljl.setShrmc(ryxx.getPersonName());
		hyk_Vipjlcljl.setShrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		hyk_Vipjlcljl.setZxr(ryxx.getPersonId());
		hyk_Vipjlcljl.setZxrmc(ryxx.getPersonName());
		hyk_Vipjlcljl.setZxrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		hyk_Vipjlcljl.setSyjsrq(effectDate);
		hyk_Vipjlcljl.setMdid(apiOrgDef.getMdid());
		hyk_VipjlcljlMapper.insert(hyk_Vipjlcljl);

		// 写入HYK_JFBDJLMX
		Hyk_Jfbdjlmx hyk_Jfbdjlmx = new Hyk_Jfbdjlmx();
		hyk_Jfbdjlmx.setHyid(paramCardId);
		hyk_Jfbdjlmx.setRq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		hyk_Jfbdjlmx.setCllx(bizType);
		hyk_Jfbdjlmx.setJlbh(orderNo);
		hyk_Jfbdjlmx.setWcljfbd(new Double(usePoint * -1));
		hyk_Jfbdjlmx.setBqjfbd(new Double(0));
		hyk_JfbdjlmxMapper.insertSelective(hyk_Jfbdjlmx);

		// 写HYK_VIPJLCLJLMX表
		Hyk_Vipjlcljlmx hyk_Vipjlcljlmx = new Hyk_Vipjlcljlmx();
		hyk_Vipjlcljlmx.setJlbh(orderNo);
		hyk_Vipjlcljlmx.setXh(hyk_jfcljlmx_xh);
		hyk_Vipjlcljlmx.setJfQc(wcljf);
		hyk_Vipjlcljlmx.setJfCl(new Double(exchangeRulePoint));
		hyk_Vipjlcljlmx.setJlje(new BigDecimal(exchangeRuleTicket));
		hyk_Vipjlcljlmx.setContent("");
		hyk_Vipjlcljlmx.setHbfs(hyk_jfcljlmx_hbfs);
		hyk_Vipjlcljlmx.setCs(exChangeNumber);
		hyk_VipjlcljlmxMapper.insertSelective(hyk_Vipjlcljlmx);

		// 写HYK_YHQZH表
		Hyk_Yhqzh hyk_Yhqzh = new Hyk_Yhqzh();
		hyk_Yhqzh.setHyid(paramCardId);
		hyk_Yhqzh.setYhqid(ticketType);
		hyk_Yhqzh.setJsrq(effectDate);
		hyk_Yhqzh.setMdfwdm("");
		Hyk_Yhqzh tmp_Hyk_Yhqzh = hyk_YhqzhMapper.selectByPrimaryKey(hyk_Yhqzh);
		if (tmp_Hyk_Yhqzh == null) {
			hyk_Yhqzh.setJe(new BigDecimal(rechargeTicket));
			hyk_Yhqzh.setJydjje(new BigDecimal(0));
			hyk_YhqzhMapper.insertSelective(hyk_Yhqzh);
		} else {
			hyk_Yhqzh.setJe(tmp_Hyk_Yhqzh.getJe().add(new BigDecimal(rechargeTicket)));
			hyk_Yhqzh.setJydjje(new BigDecimal(0));
			hyk_YhqzhMapper.updateByPrimaryKeySelective(hyk_Yhqzh);
		}

		// 写HYK_YHQCLJL表
		Hyk_Yhqcljl hyk_Yhqcljl = new Hyk_Yhqcljl();
		hyk_Yhqcljl.setHyid(paramCardId);
		hyk_Yhqcljl.setClsj(new Date());
		hyk_Yhqcljl.setCllx(hyk_yhqcljl_cllx);
		hyk_Yhqcljl.setJlbh(orderNo);
		hyk_Yhqcljl.setYhqid(ticketType);
		hyk_Yhqcljl.setJsrq(effectDate);
		hyk_Yhqcljl.setMdfwdm("");
		hyk_Yhqcljl.setMdid(apiOrgDef.getMdid());
		hyk_Yhqcljl.setJfje(new BigDecimal(rechargeTicket));
		hyk_Yhqcljl.setDfje(new BigDecimal(0));
		hyk_Yhqcljl.setYe(hyk_Yhqzh.getJe());
		hyk_Yhqcljl.setCrmjzrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		hyk_YhqcljlMapper.insertSelective(hyk_Yhqcljl);

		returnBean.setOrderNo(orderNo);
		returnBean.setPoint(usePoint);
		returnBean.setTicket(rechargeTicket);

		return returnBean;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yyabl.api.crm.biz.Service.AccountService#getExchangeRule(int)
	 */
	@Override
	public RespGetExchangeRuleBean getExchangeRule(Integer cardId) throws GeneralException, DataAccessException {
		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectByPrimaryKey(cardId);
		if (hyk_Hyxx == null) {
			throw new GeneralException(EnumGeneralException.MSG_CARDINFO_NOT_FOUND, EnumGeneralException.CODE_CARDINFO_NOT_FOUND);
		}

		RespGetExchangeRuleBean respGetExchangeRuleBean = new RespGetExchangeRuleBean();

		// TODO 积分规则写死了，后期根据需求，要从数据库中取积分规则。
		respGetExchangeRuleBean.setPoint(500);
		respGetExchangeRuleBean.setTicket(10);
		respGetExchangeRuleBean.setContext(exchangeRuleContext);
		return respGetExchangeRuleBean;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yyabl.api.crm.biz.Service.AccountService#modifyMemeberTicketAccount(int,
	 *      java.math.BigDecimal, java.lang.String, int, java.util.Date,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public int modifyMemberTicketAccount(Integer cardId, BigDecimal value, String tradeNo, Integer ticketType, Long validDate, String useScope, Integer bizType, String partnerCode)
			throws GeneralException, DataAccessException {
		int orderNo=0;

		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectByPrimaryKey(cardId);
		// 判断会员卡的状态是否为有效状态
		if (!BizUtil.isValidAnalyzingCard(hyk_Hyxx.getStatus())) {
			throw new GeneralException(EnumGeneralException.MSG_CARD_IS_VALID, EnumGeneralException.CODE_CARD_IS_VALID);
		}
		switch(value.compareTo(new BigDecimal(0)))
		{
		case -1:
			orderNo = withdrawTicket(cardId, value, tradeNo, ticketType, validDate, useScope, bizType, partnerCode);
			break;
		case 0:
			throw new GeneralException(EnumGeneralException.MSG_CUTTICKET_CAN_NOT_EQUAL_ZORE, EnumGeneralException.CODE_CUTTICKET_CAN_NOT_EQUAL_ZORE);
		case 1:
			orderNo = depositTicket(cardId, value, tradeNo, ticketType, validDate, useScope, bizType, partnerCode);
			break;
		}
		return orderNo;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yyabl.api.crm.biz.Service.AccountService#depositTicket(int,
	 *      java.math.BigDecimal, java.lang.String, int, java.util.Date,
	 *      java.lang.String, java.lang.String)
	 */
	private int depositTicket(Integer cardId, BigDecimal value, String tradeNo, Integer ticketType, Long validDate, String useScope, Integer bizType, String partnerCode) throws GeneralException,
			DataAccessException {
		// 取人员信息
		Ryxx ryxx = ryxxMapper.selectByPersonCode(partnerCode);
		Date tmpValidDate;

		// 取调用者对应的加盟机构ID
		ApiPersonDef apiPersonDef = apiPersonDefMapper.selectByPrimaryKey(ryxx.getPersonId());
		if (apiPersonDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF, EnumGeneralException.CODE_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF);
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

		// 如果优惠券类型为空，则默认置为0
		if (ticketType == null) {
			ticketType = 0;
		}

		// 如果优惠券有效期参数为空，则默认将优惠券有效期设置为当前日期向后延期1年
		if (validDate == null) {
			tmpValidDate = DateTime.parse(new DateTime().plusYears(1).toString("yyyy-MM-dd")).toDate();
		} else {
			// 对validDate参数进行yyyy-MM-dd格式化
			tmpValidDate = DateTime.parse(new DateTime(new Date(validDate)).toString("yyyy-MM-dd")).toDate();
		}

		// 如果优惠券是否范围为空，则默认是不限使用范围
		if (useScope == null) {
			useScope = "";
		}

		// 设置HYK_YHQZH表的主键
		Hyk_YhqzhKey hyk_YhqzhKey = new Hyk_YhqzhKey();
		hyk_YhqzhKey.setHyid(cardId);
		hyk_YhqzhKey.setJsrq(tmpValidDate);
		hyk_YhqzhKey.setMdfwdm(useScope);
		hyk_YhqzhKey.setYhqid(ticketType.shortValue());

		// 原余额
		double old_value;

		// 更新HYK_YHQZH表
		Hyk_Yhqzh hyk_Yhqzh = hyk_YhqzhMapper.selectByPrimaryKey(hyk_YhqzhKey);
		if (hyk_Yhqzh == null) {
			old_value = 0;
			hyk_Yhqzh = new Hyk_Yhqzh();
			hyk_Yhqzh.setHyid(cardId);
			hyk_Yhqzh.setJsrq(tmpValidDate);
			hyk_Yhqzh.setMdfwdm(useScope);
			hyk_Yhqzh.setYhqid(ticketType.shortValue());
			hyk_Yhqzh.setJe(value);
			hyk_YhqzhMapper.insert(hyk_Yhqzh);
		} else {
			old_value = hyk_Yhqzh.getJe().doubleValue();
			Map<String, Object> yhqzhParamMap = new HashMap<String, Object>();
			yhqzhParamMap.put("value", value);
			yhqzhParamMap.put("cardId", cardId);
			yhqzhParamMap.put("validDate", tmpValidDate);
			yhqzhParamMap.put("useScope", useScope);
			yhqzhParamMap.put("ticketType", ticketType.shortValue());
			hyk_YhqzhMapper.modifyTicketByMap(yhqzhParamMap);
		}

		// 生成单据号
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("TBLNAME", "API_HYK_YHQCLJL");
		paramMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(paramMap);
		int orderNo = (Integer) paramMap.get("NewRecNo");

		// 生成优惠券取款记录(HYK_CZK_YHQ_CKJL)的流水表
		Map<String, Object> ckjl_ParamMap = new HashMap<String, Object>();
		ckjl_ParamMap.put("TBLNAME", "HYK_YHQ_CKJL");
		ckjl_ParamMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(ckjl_ParamMap);
		int ckjlOrderNo = (Integer) ckjl_ParamMap.get("NewRecNo");

		Hyk_Czk_Yhq_Ckjl hyk_Czk_Yhq_Ckjl = new Hyk_Czk_Yhq_Ckjl();
		hyk_Czk_Yhq_Ckjl.setCzjpjJlbh(ckjlOrderNo);
		hyk_Czk_Yhq_Ckjl.setHyid(cardId);
		hyk_Czk_Yhq_Ckjl.setYhqid(ticketType);
		hyk_Czk_Yhq_Ckjl.setJsrq(tmpValidDate);
		hyk_Czk_Yhq_Ckjl.setMdfwdm(useScope);
		hyk_Czk_Yhq_Ckjl.setYje(new BigDecimal(old_value));
		hyk_Czk_Yhq_Ckjl.setCkje(value);
		hyk_Czk_Yhq_Ckjl.setZy("加盟机构调用接口进行优惠券存款操作.");
		hyk_Czk_Yhq_Ckjl.setDjr(ryxx.getPersonId());
		hyk_Czk_Yhq_Ckjl.setDjrmc(ryxx.getPersonName());
		hyk_Czk_Yhq_Ckjl.setDjsj(new Date());
		hyk_Czk_Yhq_Ckjl.setZxr(ryxx.getPersonId());
		hyk_Czk_Yhq_Ckjl.setZxrmc(ryxx.getPersonName());
		hyk_Czk_Yhq_Ckjl.setZxrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
		hyk_Czk_Yhq_Ckjl.setCzdd(hyk_Bgdd.getBgdddm());
		hyk_Czk_Yhq_CkjlMapper.insert(hyk_Czk_Yhq_Ckjl);

		// 写接口调用记录表(API_HYK_YHQCLJL)
		Api_Hyk_Yhqcljl api_Hyk_Yhqcljl = new Api_Hyk_Yhqcljl();
		api_Hyk_Yhqcljl.setJlbh(orderNo);
		api_Hyk_Yhqcljl.setTradeNo(tradeNo);
		api_Hyk_Yhqcljl.setCardId(cardId);
		api_Hyk_Yhqcljl.setTickets(value.doubleValue());
		api_Hyk_Yhqcljl.setBizType(bizType);
		api_Hyk_Yhqcljl.setCallerId(ryxx.getPersonId());
		api_Hyk_Yhqcljl.setCallerName(ryxx.getPersonName());
		api_Hyk_Yhqcljl.setCallDate(new Date());
		api_Hyk_Yhqcljl.setFlagFlushed(false);
		api_Hyk_YhqcljlMapper.insert(api_Hyk_Yhqcljl);

		// 写接口调用记录明细表(API_HYK_YHQCLJL_ITEM)
		Api_Hyk_Yhqcljl_Item api_Hyk_Yhqcljl_Item = new Api_Hyk_Yhqcljl_Item();
		api_Hyk_Yhqcljl_Item.setJlbh(orderNo);
		api_Hyk_Yhqcljl_Item.setCardId(cardId);
		api_Hyk_Yhqcljl_Item.setYhqid(ticketType);
		api_Hyk_Yhqcljl_Item.setJsrq(tmpValidDate);
		api_Hyk_Yhqcljl_Item.setMdfwdm(useScope);
		api_Hyk_Yhqcljl_Item.setJe(value.doubleValue());
		api_Hyk_Yhqcljl_Item.setCzJlbh(ckjlOrderNo);
		api_Hyk_Yhqcljl_ItemMapper.insert(api_Hyk_Yhqcljl_Item);

		// 记录优惠券处理记录表(HYK_YHQCLJL)
		Hyk_Yhqcljl hyk_Yhqcljl = new Hyk_Yhqcljl();
		hyk_Yhqcljl.setHyid(cardId);
		hyk_Yhqcljl.setClsj(new Date());
		hyk_Yhqcljl.setCllx((short) 1);
		hyk_Yhqcljl.setJlbh(ckjlOrderNo);
		hyk_Yhqcljl.setYhqid(ticketType.shortValue());
		hyk_Yhqcljl.setJsrq(tmpValidDate);
		hyk_Yhqcljl.setMdfwdm(useScope);
		hyk_Yhqcljl.setMdid(hyk_Bgdd.getMdid());
		hyk_Yhqcljl.setZy("加盟机构调用接口进行优惠券存款操作.");
		hyk_Yhqcljl.setJfje(value);
		hyk_Yhqcljl.setDfje(new BigDecimal(0));
		hyk_Yhqcljl.setYe(value.add(new BigDecimal(old_value)));
		hyk_YhqcljlMapper.insert(hyk_Yhqcljl);

		return orderNo;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yyabl.api.crm.biz.Service.AccountService#withdrawTicket(int,
	 *      java.math.BigDecimal, java.lang.String, int, java.util.Date,
	 *      java.lang.String, java.lang.String)
	 */
	private int withdrawTicket(Integer cardId, BigDecimal value, String tradeNo, Integer ticketType, Long validDate, String useScope, Integer bizType, String partnerCode) throws GeneralException,
			DataAccessException {
		// 判断会员卡的状态是否为有效状态
		Hyk_Hyxx hyk_Hyxx = hyk_HyxxMapper.selectByPrimaryKey(cardId);
		Date tmpValidDate;
		if (!BizUtil.isValidAnalyzingCard(hyk_Hyxx.getStatus())) {
			throw new GeneralException(EnumGeneralException.MSG_CARD_IS_VALID, EnumGeneralException.CODE_CARD_IS_VALID);
		}
		// 取人员信息
		Ryxx ryxx = ryxxMapper.selectByPersonCode(partnerCode);
		// 取调用者对应的加盟机构ID
		ApiPersonDef apiPersonDef = apiPersonDefMapper.selectByPrimaryKey(ryxx.getPersonId());
		if (apiPersonDef == null) {
			throw new GeneralException(EnumGeneralException.MSG_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF, EnumGeneralException.CODE_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF);
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

		// 查询当前可用优惠券明细列表
		// 根据参数生成查询条件
		// 如果'优惠券类型'参数为空，则给出默认的优惠券类型(在Spring.xml文件的<property
		// name="collectionAvailableTicketType">定义)
		List<Integer> paramTicketType;
		if (ticketType == null) {
			paramTicketType = BizUtil.getCollectionAvailableTicketType();
		} else {
			paramTicketType = new ArrayList<Integer>();
			paramTicketType.add(ticketType);
		}
		// 如果'优惠券有效期'参数为空，则默认优惠券有效期大于等于当前日期
		if (validDate == null) {
			tmpValidDate = DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate();
		} else {
			tmpValidDate = DateTime.parse(new DateTime(new Date(validDate)).toString("yyyy-MM-dd")).toDate();
		}
		// 如果'优惠券使用范围'参数为空，则默认的参数是'全部'
		if (useScope == null) {
			useScope = new String("");
		}
		// 查询优惠券列表
		Map<String, Object> paramMapSelectTicketList = new HashMap<String, Object>();
		paramMapSelectTicketList.put("cardId", cardId);
		paramMapSelectTicketList.put("ticketType", paramTicketType);
		paramMapSelectTicketList.put("validDate", tmpValidDate);
		paramMapSelectTicketList.put("useScope", useScope);
		List<Hyk_Yhqzh> lst_Hyk_Yhqzh = hyk_YhqzhMapper.selectTicketByParamMap(paramMapSelectTicketList);
		// 如果优惠券列表为空，代表优惠券余额为0，则抛出异常
		if (lst_Hyk_Yhqzh == null) {
			throw new GeneralException(EnumGeneralException.MSG_CAN_NOT_FIND_TICKET_LIST, EnumGeneralException.CODE_CAN_NOT_FIND_TICKET_LIST);
		}
		// 计算当前优惠券总额.
		BigDecimal ticketTotal = BigDecimal.valueOf(0);
		for (int i = 0; i < lst_Hyk_Yhqzh.size(); i++) {
			Hyk_Yhqzh tmp_Hyk_Yhqzh = lst_Hyk_Yhqzh.get(i);
			ticketTotal = ticketTotal.add(tmp_Hyk_Yhqzh.getJe());
		}
		
		// 如果要扣减的金额取反后小余当前优惠券总额，则抛出异常
		if (ticketTotal.intValue() < value.negate().intValue()) {
			throw new GeneralException(EnumGeneralException.MSG_TICKET_BALANCE_LESS_EXCHANGE_POINT, EnumGeneralException.CODE_TICKET_BALANCE_LESS_EXCHANGE_POINT);
		}

		// 生成单据号
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("TBLNAME", "API_HYK_YHQCLJL");
		paramMap.put("NewRecNo", 0);
		bhztMapper.procUpdateBHZT(paramMap);
		int orderNo = (Integer) paramMap.get("NewRecNo");

		// 根据优惠券列表的排序，循环扣除每个优惠券批次中的余额
		for (int i = 0; i < lst_Hyk_Yhqzh.size(); i++) {
			Hyk_Yhqzh hyk_Yhqzh = lst_Hyk_Yhqzh.get(i);

			BigDecimal jyje = BigDecimal.valueOf(0);
			// 如果这个批次的优惠券余额小余需要扣减的金额.(把jyje设置为负数，因为调用Hyk_YhqzhMapper.modifyTicketByMap方法时，对余额是做加法处理)
			if (hyk_Yhqzh.getJe().intValue() <= value.negate().intValue()){
				jyje = hyk_Yhqzh.getJe().negate();
			}else{
				jyje = value;
			}

			// 生成优惠券取款记录(HYK_CZK_YHQ_QKJL)的流水表
			Map<String, Object> qkjl_ParamMap = new HashMap<String, Object>();
			qkjl_ParamMap.put("TBLNAME", "HYK_YHQ_QKJL");
			qkjl_ParamMap.put("NewRecNo", 0);
			bhztMapper.procUpdateBHZT(qkjl_ParamMap);
			int qkjlOrderNo = (Integer) qkjl_ParamMap.get("NewRecNo");

			// 写优惠券取款记录表(HYK_CZK_YHQ_QKJL).
			Hyk_Czk_Yhq_Qkjl hyk_Czk_Yhq_Qkjl = new Hyk_Czk_Yhq_Qkjl();
			hyk_Czk_Yhq_Qkjl.setCzjpjJlbh(qkjlOrderNo);
			hyk_Czk_Yhq_Qkjl.setHyid(cardId);
			hyk_Czk_Yhq_Qkjl.setYhqid(hyk_Yhqzh.getYhqid().intValue());
			hyk_Czk_Yhq_Qkjl.setJsrq(hyk_Yhqzh.getJsrq());
			hyk_Czk_Yhq_Qkjl.setMdfwdm(hyk_Yhqzh.getMdfwdm());
			hyk_Czk_Yhq_Qkjl.setYje(hyk_Yhqzh.getJe());
			hyk_Czk_Yhq_Qkjl.setQkje(jyje.negate());
			hyk_Czk_Yhq_Qkjl.setZy("加盟机构调用‘优惠券扣减’API接口。");
			hyk_Czk_Yhq_Qkjl.setDjr(ryxx.getPersonId());
			hyk_Czk_Yhq_Qkjl.setDjrmc(ryxx.getPersonName());
			hyk_Czk_Yhq_Qkjl.setDjsj(new Date());
			hyk_Czk_Yhq_Qkjl.setZxr(ryxx.getPersonId());
			hyk_Czk_Yhq_Qkjl.setZxrmc(ryxx.getPersonName());
			hyk_Czk_Yhq_Qkjl.setZxrq(DateTime.parse(new DateTime().toString("yyyy-MM-dd")).toDate());
			hyk_Czk_Yhq_Qkjl.setCzdd(hyk_Bgdd.getBgdddm());
			hyk_Czk_Yhq_QkjlMapper.insert(hyk_Czk_Yhq_Qkjl);
			// 取当前批次的优惠券余额
			BigDecimal old_value = hyk_Yhqzh.getJe();
			// 修改优惠券账户表(HYK_YHQZH)
			Map<String, Object> yhqzhParamMap = new HashMap<String, Object>();
			yhqzhParamMap.put("value", jyje);
			yhqzhParamMap.put("cardId", cardId);
			yhqzhParamMap.put("validDate", hyk_Yhqzh.getJsrq());
			yhqzhParamMap.put("useScope", hyk_Yhqzh.getMdfwdm());
			yhqzhParamMap.put("ticketType", hyk_Yhqzh.getYhqid());
			hyk_YhqzhMapper.modifyTicketByMap(yhqzhParamMap);

			// 记录优惠券处理记录表(HYK_YHQCLJL)
			Hyk_Yhqcljl hyk_Yhqcljl = new Hyk_Yhqcljl();
			hyk_Yhqcljl.setHyid(cardId);
			hyk_Yhqcljl.setClsj(new Date());
			hyk_Yhqcljl.setCllx((short) 2);
			hyk_Yhqcljl.setJlbh(qkjlOrderNo);
			hyk_Yhqcljl.setYhqid(hyk_Yhqzh.getYhqid());
			hyk_Yhqcljl.setJsrq(hyk_Yhqzh.getJsrq());
			hyk_Yhqcljl.setMdfwdm(hyk_Yhqzh.getMdfwdm());
			hyk_Yhqcljl.setZy("加盟机构调用‘优惠券扣减’API接口。");
			hyk_Yhqcljl.setJfje(new BigDecimal(0));
			hyk_Yhqcljl.setDfje(jyje.negate());
			hyk_Yhqcljl.setYe(old_value);
			hyk_YhqcljlMapper.insert(hyk_Yhqcljl);

			// 写接口调用记录明细表(API_HYK_YHQCLJL_ITEM)
			Api_Hyk_Yhqcljl_Item api_Hyk_Yhqcljl_Item = new Api_Hyk_Yhqcljl_Item();
			api_Hyk_Yhqcljl_Item.setJlbh(orderNo);
			api_Hyk_Yhqcljl_Item.setCardId(cardId);
			api_Hyk_Yhqcljl_Item.setYhqid(hyk_Yhqzh.getYhqid().intValue());
			api_Hyk_Yhqcljl_Item.setJsrq(hyk_Yhqzh.getJsrq());
			api_Hyk_Yhqcljl_Item.setMdfwdm(hyk_Yhqzh.getMdfwdm());
			api_Hyk_Yhqcljl_Item.setJe(jyje.doubleValue());
			api_Hyk_Yhqcljl_Item.setCzJlbh(qkjlOrderNo);
			api_Hyk_Yhqcljl_ItemMapper.insert(api_Hyk_Yhqcljl_Item);

			value = value.subtract(jyje);
			if (value.intValue() == 0) break;
		}
		// 写接口调用记录表(API_HYK_YHQCLJL)
		Api_Hyk_Yhqcljl api_Hyk_Yhqcljl = new Api_Hyk_Yhqcljl();
		api_Hyk_Yhqcljl.setJlbh(orderNo);
		api_Hyk_Yhqcljl.setTradeNo(tradeNo);
		api_Hyk_Yhqcljl.setCardId(cardId);
		api_Hyk_Yhqcljl.setTickets(value.doubleValue());
		api_Hyk_Yhqcljl.setBizType(bizType);
		api_Hyk_Yhqcljl.setCallerId(ryxx.getPersonId());
		api_Hyk_Yhqcljl.setCallerName(ryxx.getPersonName());
		api_Hyk_Yhqcljl.setCallDate(new Date());
		api_Hyk_Yhqcljl.setFlagFlushed(false);
		api_Hyk_YhqcljlMapper.insert(api_Hyk_Yhqcljl);

		return orderNo;
	}
}
