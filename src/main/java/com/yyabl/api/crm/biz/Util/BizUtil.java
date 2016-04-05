/**
 * @Title: BizUtil.java
 * @Package com.youahui.api.crm.biz.Util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-7-15 上午5:37:14
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yyabl.api.crm.biz.Enum.EnumGeneralException;
import com.yyabl.api.crm.biz.Exception.GeneralException;

/**
 * @author Maven
 * @version 2014-7-15
 * 
 *          /**
 * @ClassName: BizUtil
 * @Description: 工具类
 * @author Maven
 * @date 2014-7-15 上午5:37:14
 * 
 */
public class BizUtil {

	static Logger logger = LoggerFactory.getLogger(BizUtil.class);
	
	private static Map<String,Object> mapMemberRight = new ConcurrentHashMap<String,Object>();
	
	private static List<Integer> collectionEffectCardStatus = new ArrayList<Integer>();
	
	private static List<Integer> collectionAvailableTicketType = new ArrayList<Integer>();

	/**
	 * @Title: getRandomCode
	 * @Description: 生成随机数字字符串
	 * @param @param length 字符串长度
	 * @param @return
	 * @return String 字符类型的随机数
	 * @throws
	 */
	public static String getRandomCode(int length) {
		Random random = new Random();
		String n = "";
		int num;
		do {
			num = Math.abs(random.nextInt()) % 10 + 48;
			char num1 = (char) num;
			String dn = Character.toString(num1);
			n += dn;
		} while (n.length() < length);
		return n;
	}

	/**
	 * @Title: isMobileNo
	 * @Description: 判断字符串参数是否为手机号码格式
	 * @param @param mobileNo 手机号码
	 * @param @return
	 * @param @throws RequestException
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isMobileNo(String mobileNo) throws GeneralException {
		String mobile = mobileNo;
		if ((mobile.trim().length() == 12) && (mobile.charAt(0) == '0')) {
			mobile = mobile.trim().substring(1, mobile.trim().length() - 1);
		}
		Pattern p = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[6-8])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

	public static int[] convertStringToInt(String args) throws GeneralException {
		String[] strAry = args.split(",");
		int[] resultAry = new int[strAry.length];
		for (int i = 0; i < strAry.length; i++) {
			try {
				resultAry[i] = Integer.parseInt(strAry[i]);
			} catch (NumberFormatException e) {
				logger.error(e.getMessage());
				throw new GeneralException(EnumGeneralException.MSG_NUMBER_FORMAT_EXCEPTION, EnumGeneralException.CODE_NUMBER_FORMAT_EXCEPTION);
			}
		}
		return resultAry;
	}

	public static double[] convertStringToDouble(String args) throws GeneralException {
		String[] strAry = args.split(",");
		double[] resultAry = new double[strAry.length];
		for (int i = 0; i < strAry.length; i++) {
			try {
				resultAry[i] = Double.parseDouble(strAry[i]);
			} catch (NumberFormatException e) {
				logger.error(e.getMessage());
				throw new GeneralException(EnumGeneralException.MSG_NUMBER_FORMAT_EXCEPTION, EnumGeneralException.CODE_NUMBER_FORMAT_EXCEPTION);
			}
		}
		return resultAry;
	}

	/**
	 * @Title: isValidAnalyzingCard
	 * @Description: 判断会员卡是否为有效卡
	 * @param @param status
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	
	public static boolean isValidAnalyzingCard(int status) {
		if (collectionEffectCardStatus.contains(status)) {
			return true;
		} else {
			return false;
		}
	}

	public static String getMemberRight(int cardType){
		return mapMemberRight.get(String.valueOf(cardType)).toString();
	}

	public static Map<String, Object> getMapMemberRight() {
		return mapMemberRight;
	}

	public static void setMapMemberRight(Map<String, Object> mapMemberRight) {
		BizUtil.mapMemberRight = mapMemberRight;
	}

	public static List<Integer> getCollectionEffectCardStatus() {
		return collectionEffectCardStatus;
	}

	public static void setCollectionEffectCardStatus(List<Integer> collectionEffectCardStatus) {
		BizUtil.collectionEffectCardStatus = collectionEffectCardStatus;
	}

	public static List<Integer> getCollectionAvailableTicketType() {
		return collectionAvailableTicketType;
	}

	public static void setCollectionAvailableTicketType(List<Integer> collectionAvailableTicketType) {
		BizUtil.collectionAvailableTicketType = collectionAvailableTicketType;
	}
}
