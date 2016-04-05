/**
 * @Title: EnumGeneralException.java
 * @Package com.yyabl.api.crm.biz.Enum
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 下午5:03:09
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Enum;

/**
 * @author Maven
 * @version 2014-9-9
 * 
 *          /**
 * @ClassName: EnumGeneralException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 下午5:03:09
 * 
 */
public class EnumGeneralException {

	public static final int CODE_RESPONSE_SUCCESS = 1;

	public static final int CODE_REQUEST_VALID = -10000;

	public static final int CODE_CAN_NOT_FOUND_MOBILENO_BY_CARDNO = -10001;
	public static final String MSG_CAN_NOT_FOUND_MOBILENO_BY_CARDNO = "错误：此会员卡号没有登记手机号，请到友阿集团旗下各百货门店登记手机号码后，再次获取手机号码。详询4008889448。";

	public static final int CODE_MOBILENO_FORMAT_ERROR = -10002;
	public static final String MSG_MOBILENO_FORMAT_ERROR = "错误：您登记的手机号格式不正确，请到友阿集团旗下各百货门店修改手机号后，再次获取此手机号码。详询4008889448。";

	public static final int CODE_CARDINFO_NOT_FOUND = -10003;
	public static final String MSG_CARDINFO_NOT_FOUND = "错误：根据会员卡ID没有找到会员卡资料，请确认会员卡ID是否正确。";

	public static final int CODE_CARDID_NOT_FOUND = -10004;
	public static final String MSG_CARDID_NOT_FOUND = "错误：会员卡号不存在，请确认会员卡号是否正确。";

	public static final int CODE_REQUEST_TIMEOUT = -10005;
	public static final String MSG_REQUEST_TIMEOUT = "错误：请求超时。";

	public static final int CODE_REQUEST_URL_NOT_FOUND_OR_INVALID = -10006;
	public static final String MSG_REQUEST_URL_NOT_FOUND_OR_INVALID = "错误：请求的接口地址不存在或已作废。";

	public static final int CODE_PARTNER_CODE_INVALID = -10007;
	public static final String MSG_PARTNER_CODE_INVALID = "错误：合作商户号无效。";

	public static final int CODE_PARTNER_CODE_ACCESS_PERMISSION = -10008;
	public static final String MSG_PARTNER_CODE_ACCESS_PERMISSION = "错误：合作商户号没有访问此接口地址的权限。";

	public static final int CODE_SIGNATURE_VALID = -10009;
	public static final String MSG_SIGNATURE_VALID = "错误：请求参数中的签名不合法。";

	public static final int CODE_SYSTEM_ERROR = -10010;
	public static final String MSG_SYSTEM_ERROR = "错误：内部错误。";

	public static final int CODE_SMS_SEND_NOT_BIZTYPE = -10011;
	public static final String MSG_SMS_SEND_NOT_BIZTYPE = "错误：短信发送业务类型没有定义,请检查bizType参数是否正确。";

	public static final int CODE_VERIFYCODE_NOT_EXIST = -10012;
	public static final String MSG_VERIFYCODE_NOT_EXIST = "错误：验证码不存在，请先获取验证码。";

	public static final int CODE_VERIFYCODE_NOT_MATCHING = -10013;
	public static final String MSG_VERIFYCODE_NOT_MATCHING = "错误：验证码不匹配，请重新输入。";

	public static final int CODE_VERIFYCODE_IS_LOSE = -10014;
	public static final String MSG_VERIFYCODE_IS_LOSE = "错误：验证码已经过期。";

	public static final int CODE_SMS_SEND_FAIL = -10015;
	public static final String MSG_SMS_SEND_FAIL = "错误：验证码发送失败，请重新发送。";

	public static final int CODE_CONVERT_PAYTYPE_FAIL = -10016;
	public static final String MSG_CONVERT_PAYTYPE_FAIL = "错误：将字符串转换为数组时出错,请检查带入接口的参数";

	public static final int CODE_THE_LENGTH_IS_NOT_EQUAL_TO_THE_PAYTYPE_OF_PAYMENT = -10017;
	public static final String MSG_THE_LENGTH_IS_NOT_EQUAL_TO_THE_PAYTYPE_OF_PAYMENT = "错误：支付方式与支付金额的数组长度不相等，请检查payType和payment参数的元素个数。";

	public static final int CODE_DATA_ACCESS_EXCEPTION = -10018;
	public static final String MSG_DATA_ACCESS_EXCEPTION = "错误：数据访问异常。";

	public static final int CODE_NUMBER_FORMAT_EXCEPTION = -10019;
	public static final String MSG_NUMBER_FORMAT_EXCEPTION = "错误：数据格式转换异常。";

	public static final int CODE_EXCHANGE_POINT_TO_TICKET_POINT_NOT_ENOUGH = -10020;
	public static final String MSG_EXCHANGE_POINT_TO_TICKET_POINT_NOT_ENOUGH = "错误：兑换优惠券使用的积分超过了当前积分余额。";

	public static final int CODE_EXCHANGE_POINT_TO_TICKET_POINT_VALUE_EXCEPTION = -10021;
	public static final String MSG_EXCHANGE_POINT_TO_TICKET_POINT_VALUE_EXCEPTION = "错误：积分合计值异常，请联系友阿客服：400-888-9448。";

	public static final int CODE_CARD_POINT_ACCOUNT_NOT_FOUND = -10022;
	public static final String MSG_CARD_POINT_ACCOUNT_NOT_FOUND = "错误：会员卡的积分账户不存在，请联系友阿客服：400-888-9448。";

	public static final int CODE_EXCHANGE_POINT_LESS_RULE = -10023;
	public static final String MSG_EXCHANGE_POINT_LESS_RULE = "错误：用户输入的兑换积分小余兑换积分规则(500分)。";

	public static final int CODE_CARDNO_EXIST = -10024;
	public static final String MSG_CARDNO_EXIST = "错误：导入的会员卡号已经存在。";

	public static final int CODE_IDNUMBER_EXIST = -10025;
	public static final String MSG_IDNUMBER_EXIST = "错误：导入的证件号码已存在。";

	public static final int CODE_CARDTYPE_MAPPING_NOT_FOUND = -10026;
	public static final String MSG_CARDTYPE_MAPPING_NOT_FOUND = "错误：没有找到会员卡类型与实体卡类型的映射关系，请联系系统管理员。";

	public static final int CODE_CUTPOINT_CAN_NOT_EQUAL_ZORE = -10027;
	public static final String MSG_CUTPOINT_CAN_NOT_EQUAL_ZORE = "错误：增加或减少的积分值不能为0。";

	public static final int CODE_POINT_BALANCE_LESS_EXCHANGE_POINT = -10028;
	public static final String MSG_POINT_BALANCE_LESS_EXCHANGE_POINT = "错误：兑换的积分值大于积分账户余额，不能进行积分兑券。";

	public static final int CODE_CURRENT_POINT_NOT_ENOUGH_MODIFY = -10029;
	public static final String MSG_CURRENT_POINT_NOT_ENOUGH_MODIFY = "错误：当前积分账户余额比要扣减的积分值小，不能进行积分扣减操作。";

	public static final int CODE_BIZ_TYPE_NOT_DEFAULT = -10030;
	public static final String MSG_BIZ_TYPE_NOT_DEFAULT = "错误：业务类型没有定义，请联系系统管理员。";

	public static final int CODE_CAN_NOT_FOUND_MALL_MAPPING = -10031;
	public static final String MSG_CAN_NOT_FOUND_MALL_MAPPING = "错误：没有找到加盟机构和实体门店的映射关系。";

	public static final int CODE_TICKET_BALANCE_LESS_EXCHANGE_POINT = -10032;
	public static final String MSG_TICKET_BALANCE_LESS_EXCHANGE_POINT = "错误：扣减的优惠券金额大于当前账户中的余额。";

	public static final int CODE_NOT_FIND_POINT_EXCHANGE_TICKET_RULE = -10033;
	public static final String MSG_NOT_FIND_POINT_EXCHANGE_TICKET_RULE = "错误：没有找到积分兑换规则。";

	public static final int CODE_CARD_IS_VALID = -10034;
	public static final String MSG_CARD_IS_VALID = "错误：会员卡当前状态是‘无效卡’，请联系友阿客服：400-888-9448。";

	public static final int CODE_MERGE_CARD_SOURCE_CARD_NOT_FOUND = -10035;
	public static final String MSG_MERGE_CARD_SOURCE_CARD_NOT_FOUND = "错误：会员卡合并失败，没有找到源会员卡信息。";

	public static final int CODE_MERGE_CARD_SOURCE_CARD_IS_VALID = -10036;
	public static final String MSG_MERGE_CARD_SOURCE_CARD_IS_VALID = "错误：会员卡合并失败，源会员卡的状态为‘无效卡’,请联系友阿客服：400-888-9448。";

	public static final int CODE_MERGE_CARD_TARGET_CARD_NOT_FOUND = -10037;
	public static final String MSG_MERGE_CARD_TARGET_CARD_NOT_FOUND = "错误：会员卡合并失败，没有找到目标卡信息。";

	public static final int CODE_MERGE_CARD_TARGET_CARD_IS_VALID = -10038;
	public static final String MSG_MERGE_CARD_TARGET_CARD_IS_VALID = "错误：会员卡合并失败，目标卡的状态为‘无效卡’,请联系友阿客服：400-888-9448。";

	public static final int CODE_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF = -10039;
	public static final String MSG_SYSTEM_NOT_FOUND_PARTNERCODE_AND_ORG_DEF = "错误：没有找到接口调用者帐号与加盟机构的对应关系。";

	public static final int CODE_SYSTEM_NOT_FOUND_ORG_AND_MALL_DEF = -10040;
	public static final String MSG_SYSTEM_NOT_FOUND_ORG_AND_MALL_DEF = "错误：没有找到加盟机构与实体门店的对应关系。";

	public static final int CODE_SYSTEM_NOT_FOUND_PROPERTIES_FILE = -10041;
	public static final String MSG_SYSTEM_NOT_FOUND_PROPERTIES_FILE = "错误：没有找到属性定义文件。";

	public static final int CODE_SYSTEM_IO_EXCEPTION = -10042;
	public static final String MSG_SYSTEM_IO_EXCEPTION = "错误：系统IO错误。";

	public static final int CODE_CONTAINER_ERROR = -10043;
	public static final String MSG_CONTAINER_ERROR = "错误：JAVA容器抛出异常错误代码:";

	public static final int CODE_FLUSHES_ERROR_NOT_FOUND_ORDER_NO = -10044;
	public static final String MSG_FLUSHES_EROR_NOT_FOUND_ORDER_NO = "错误：冲正失败，没有找到原单据号。";

	public static final int CODE_FLUSHES_ERROR_IS_FLUSED = -10045;
	public static final String MSG_FLUSHES_ERROR_IS_FLUSED = "错误：此单据号已经进行过冲正。";

	public static final int CODE_FLUSEHS_ERROR_POINT_NOT_ENOUGH = -10046;
	public static final String MSG_FLUSEHS_ERROR_POINT_NOT_ENOUGH = "错误：当前账户中积分不足，不能进行积分冲正。";

	public static final int CODE_RCL_IS_NOT_FINISH = -10047;
	public static final String MSG_RCL_IS_NOT_FINISH = "错误：CRM正在进行日结，请稍后提交请求。";
	
	public static final int CODE_INVOKE_REPEATING = -10048;
	public static final String MSG_INVOKE_REPEATING = "错误：上一次请求还在处理中，本次请求提交失败。";
	
	public static final int CODE_MEMCACHED_CONNECT_FAIL = -10049;
	public static final String MSG_MEMCACHED_CONNECT_FAIL = "错误：缓存服务器连接失败，不能提交请求.";
	
	public static final int CODE_CAN_NOT_FIND_TICKET_LIST = -10050;
	public static final String MSG_CAN_NOT_FIND_TICKET_LIST = "错误：当前会员卡中没有优惠券.";

	public static final int CODE_CUTTICKET_CAN_NOT_EQUAL_ZORE = -10051;
	public static final String MSG_CUTTICKET_CAN_NOT_EQUAL_ZORE = "错误：增加或减少的电子劵值不能为0。";

}
