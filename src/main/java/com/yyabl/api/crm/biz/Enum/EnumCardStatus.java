package com.yyabl.api.crm.biz.Enum;

public class EnumCardStatus {
	public static int CODE_CHECK_NOT_EFFECTIVE = -6;
	public static String MSG_CHECK_NOT_EFFECTIVE = "支票未启动卡";

	public static int CODE_TICKET_OVERDUE = -5;
	public static String MSG_TICKET_OVERDUE = "纸券已过期卡";

	public static int CODE_OVERDUE = -4;
	public static String MSG_OVERDUE = "过期卡";

	public static int CODE_MISSING = -3;
	public static String MSG_MISSING = "挂失卡";

	public static int CODE_RETURN = -2;
	public static String MSG_RETURN = "退卡";

	public static int CODE_INVALID = -1;
	public static String MSG_INVALID = "作废卡";

	public static int CODE_EFFECTIVE = 0;
	public static String MSG_EFFECTIVE = "有效卡";

	public static int CODE_CONSUMED = 1;
	public static String MSG_CONSUMED = "已消费卡";

	public static int CODE_NULL = 2;
	public static String MSG_NULL = "空卡";

	public static int CODE_SLEEPING = 3;
	public static String MSG_SLEEPING = "睡眠卡";

	public static int CODE_EXCEPTION = 4;
	public static String MSG_EXCEPTION = "异常卡";

	public static int CODE_HIBERNATE = 5;
	public static String MSG_HIBERNATE = "休眠卡";
}
