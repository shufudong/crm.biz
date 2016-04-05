package com.yyabl.api.crm.biz.Sign;

import java.security.MessageDigest;

import org.springframework.util.DigestUtils;

/**
 * @ClassName: MD5签名处理核心，不要修改
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-7-13 下午5:52:57
 * 
 */
public class MD5 {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	/**
	 * @Title: 签名字符串
	 * @Description: 对字符串采用MD5算法进行签名
	 * @param text
	 *            需要签名的字符串
	 * @param key
	 *            密钥
	 * @param @return
	 * @return String 签名
	 * @throws
	 */
	public static String sign(String text, String key) {
		text = text + key;
		return DigestUtils.md5DigestAsHex(text.getBytes());
	}

	/**
	 * @Title: 验证字符串的签名
	 * @Description: 验证字符串的签名
	 * @param text
	 *            字符串
	 * @param sign
	 *            签名
	 * @param key
	 *            密钥
	 * @param @return
	 * @return boolean 签名结果
	 * @throws
	 */
	public static boolean verify(String text, String sign, String key) {
		String tmp_Test = text + key;
		String mySign = DigestUtils.md5DigestAsHex(tmp_Test.getBytes());
		if (mySign.equals(sign)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Title: encode16
	 * @Description: 将字符串算出16进制MD5串，字符串按系统编码进行编码
	 * @param @param origin 字符串
	 * @param @return
	 * @param @throws Exception
	 * @return String 16进制MD5字符串
	 * @throws
	 */
	public static String encode16(String origin) throws Exception {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest((new String(origin)).getBytes()));
		} catch (Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
		return resultString;
	}

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));// 若使用本函数转换则可得到加密结果的16进制表示，即数字字母混合的形式
		}
		return resultSb.toString();
	}

	/**
	 * 转换字节为10进制字符串
	 * 
	 * @param b字节
	 * @return 10进制字符串
	 */
	/**
	 * @Title: byteToHexString
	 * @Description: 转换字节为10进制字符串
	 * @param @param b 字节
	 * @param @return
	 * @return String 10进制字符串
	 * @throws
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}
