/**
 * @Title: JsonHttp.java
 * @Package com.yyabl.api.crm.biz.Sms
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月5日 上午10:36:01
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Sms;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;

import com.yyabl.api.crm.biz.Exception.JsonException;
import com.yyabl.api.crm.biz.Sign.MD5;

/**
 * @ClassName: JsonHttp
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2015年1月5日 上午10:36:01
 * 
 */
public class JsonHttp {
	private String url;
	private String request;
	private String dataKey;
	private CookieStore cookie;
	private String sessionId;
	private String authenticationKeyCode;
	private Integer userId;
	private Object data;
	private Integer returnCode;
	private boolean showInfo = true;

	public boolean isShowInfo() {
		return showInfo;
	}

	/**
	 * 设置是否显示信息在控制台
	 * 
	 * @param showInfo
	 */
	public void setShowInfo(boolean showInfo) {
		this.showInfo = showInfo;
	}

	/**
	 * 设置校验编码
	 * 
	 * @param authenticationKeyCode
	 *            the authenticationKeyCode to set
	 */
	public void setAuthenticationKeyCode(String authenticationKeyCode) {
		this.authenticationKeyCode = authenticationKeyCode;
	}

	/**
	 * 设置校验编码
	 * 
	 * @param authenticationKeyCode
	 *            the authenticationKeyCode to set
	 * @param userId
	 */
	public void setAuthenticationKeyCode(String authenticationKeyCode, Integer userId) {
		this.authenticationKeyCode = authenticationKeyCode;
		this.userId = userId;
	}

	/**
	 * 设置sessionId
	 * 
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * 返回接口url
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置接口url
	 * 
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 返回请求数据
	 * 
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * @return the dataKey
	 */
	public String getDataKey() {
		return dataKey;
	}

	/**
	 * @param dataKey
	 *            the dataKey to set
	 */
	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	/**
	 * @return the cookie
	 */
	public CookieStore getCookie() {
		return cookie;
	}

	/**
	 * @param cookie
	 *            the cookie to set
	 */
	public void setCookie(CookieStore cookie) {
		this.cookie = cookie;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @return the returnCode
	 */
	public Integer getReturnCode() {
		return returnCode;
	}

	/**
	 * 返回get请求数据字符串
	 * 
	 * @return
	 */
	public String getURL() {
		StringBuffer get = new StringBuffer(this.url);
		long t = System.currentTimeMillis();
		String hash = null;
		try {
			String data = this.request;
			if (this.authenticationKeyCode != null && this.userId != null) {
				data += this.userId;
			}
			data = new String(Base64.encodeBase64(data.getBytes("UTF-8")));
			if (this.dataKey != null) {
				data += this.dataKey;
			}
			data += t;
			hash = MD5.encode16(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (this.sessionId != null) {
			get.append(";jsessionid=");
			get.append(this.sessionId);
		}
		get.append("?t=");
		get.append(t);
		if (this.authenticationKeyCode != null) {
			get.append("&k=");
			get.append(this.authenticationKeyCode);
		}
		get.append("&hash=");
		get.append(hash);
		return get.toString();
	}

	/**
	 * 返回post数据字符串
	 * 
	 * @return
	 */
	public Map<String, String> getPOST() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("request", this.request);
		if (this.authenticationKeyCode != null && this.userId != null) {
			map.put("userId", String.valueOf(userId));
		}
		return map;
	}

	/**
	 * 普通对象接口调用
	 * 
	 * @param request
	 * @return
	 */
	public String requestObject(JSONObject request) throws Exception {

		this.request = request.toString();
		Map<String, String> post = this.getPOST();
		String url = this.getURL();
		HttpPost req = new HttpPost(url);

		List<NameValuePair> parametersBody = new ArrayList<NameValuePair>(post.size());

		for (String name : post.keySet()) {
			parametersBody.add(new BasicNameValuePair(name, post.get(name)));
		}
		req.setEntity(new UrlEncodedFormEntity(parametersBody));

		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpResponse resp = httpclient.execute(req);

		HttpEntity entity = resp.getEntity();
		InputStream instream = entity.getContent();

		byte b[] = new byte[2048];
		byte buffer[] = new byte[0];
		int length = 0;
		while (true) {
			int len = instream.read(b);
			if (len < 0) {
				break;
			}
			byte[] bf = new byte[length + len];
			System.arraycopy(buffer, 0, bf, 0, buffer.length);
			System.arraycopy(b, 0, bf, length, len);
			buffer = bf;
			length += len;
		}
		String text = new String(buffer);
		return text;
	}

	/**
	 * 列表查询构建请求数据
	 * 
	 * @param search
	 */
	private void buildRequest(SearchList search) {
		JSONObject object = new JSONObject();
		object.put("expire", 3600);
		object.put("limit", 17);
		if (search.getCurrentPage() != null) {
			object.put("currentPage", search.getCurrentPage());
		}
		if (search.getPageCount() != null) {
			object.put("pageCount", search.getPageCount());
		}
		if (search.getSearchKey() != null) {
			object.put("searchKey", search.getSearchKey());
		}
		if (search.getSortList().size() > 0) {
			object.put("sortList", search.getSortList());
		}
		if (search.getSearch().size() > 0) {
			object.put("search", search.getSearch());
		}
		this.request = object.toString();
	}

	/**
	 * 高级列表查询,返回列表对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public JSONArray requestList(SearchList search) throws Exception {

		this.buildRequest(search);
		HttpPost req = new HttpPost(this.getURL());
		Map<String, String> post = this.getPOST();

		List<NameValuePair> parametersBody = new ArrayList<NameValuePair>(post.size());

		for (String name : post.keySet()) {
			parametersBody.add(new BasicNameValuePair(name, post.get(name)));
		}
		req.setEntity(new UrlEncodedFormEntity(parametersBody));

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpParams httpParams = httpclient.getParams();
		httpParams.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 15000);
		httpParams.setParameter(CoreConnectionPNames.SO_TIMEOUT, 15000);
		HttpResponse resp = httpclient.execute(req);

		HttpEntity entity = resp.getEntity();
		InputStream instream = entity.getContent();

		byte b[] = new byte[2048];
		byte buffer[] = new byte[0];
		int length = 0;
		while (true) {
			int len = instream.read(b);
			if (len < 0) {
				break;
			}
			byte[] bf = new byte[length + len];
			System.arraycopy(buffer, 0, bf, 0, buffer.length);
			System.arraycopy(b, 0, bf, length, len);
			buffer = bf;
			length += len;
		}
		String text = new String(buffer);

		JSONObject object = JSONObject.fromObject(text);
		this.returnCode = object.optInt("returnCode");

		this.data = object.opt("data");
		if (this.returnCode == JsonException.SUCCESS) {
			object = object.optJSONObject("data");
			search.setTotalPages(object.optInt("totalPages"));
			search.setTotalRecords(object.optInt("totalRecords"));
			search.setCurrentPage(object.optInt("currentPage"));
			search.setList(object.optJSONArray("list"));
			return search.getList();
		}
		return null;
	}
}
