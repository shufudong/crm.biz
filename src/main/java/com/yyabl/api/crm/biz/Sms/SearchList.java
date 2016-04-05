/**
 * @Title: SearchList.java
 * @Package com.yyabl.api.crm.biz.Sms
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月5日 上午10:45:16
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Sms;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @ClassName: SearchList
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2015年1月5日 上午10:45:16
 * 
 */
public class SearchList {
	private Integer currentPage;
	private Integer pageCount;
	private String searchKey;
	private JSONArray sortList = new JSONArray();
	private JSONArray search = new JSONArray();

	private Integer totalRecords;
	private Integer totalPages;
	private JSONArray list;

	/**
	 * @return the list
	 */
	public JSONArray getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(JSONArray list) {
		this.list = list;
	}

	/**
	 * @return the totalRecords
	 */
	public Integer getTotalRecords() {
		return totalRecords;
	}

	/**
	 * @param totalRecords
	 *            the totalRecords to set
	 */
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * @return the totalPages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages
	 *            the totalPages to set
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * 添加排序
	 * 
	 * @param sort
	 */
	public void addSort(String sort) {
		JSONObject object = new JSONObject();
		object.put("sort", sort);
		this.sortList.add(object);
	}

	/**
	 * 添加排序
	 * 
	 * @param sort
	 * @param order
	 */
	public void addSort(String sort, String order) {
		JSONObject object = new JSONObject();
		object.put("sort", sort);
		object.put("order", order);
		this.sortList.add(object);
	}

	/**
	 * 将条件转换成jsonarray形式
	 * 
	 * @param filter
	 * @return
	 */
	private JSONArray searchToArray(FliterObject filter) {
		JSONArray array = new JSONArray();
		array.add(filter.getProperty());
		array.add(filter.getValue());
		array.add(filter.getOperator());
		return array;
	}

	/**
	 * 添加搜索条件
	 * 
	 * @param filter
	 *            条件
	 */
	public void addSearch(FliterObject filter) {
		this.search.add(this.searchToArray(filter));
	}

	/**
	 * 将map对象生成jsonobject
	 * 
	 * @param list
	 *            map对象列表，分别为key 字段,value 值,op 比较方式，可以递归增加or关系
	 * @return
	 */
	private JSONArray toSearchObject(FliterObject... list) {
		JSONArray object = new JSONArray();

		for (FliterObject filter : list) {
			String op = filter.getOperator();
			if (op != null && op.equals("or")) {
				Object value = filter.getValue();
				JSONArray array = new JSONArray();
				array.add("");
				array.add(toSearchObject((FliterObject[]) value));
				array.add(op);
				object.add(array);
			} else {
				object.add(this.searchToArray(filter));
			}
		}
		return object;
	}

	/**
	 * 添加一组or关系的搜索条件
	 * 
	 * @param list
	 *            map对象列表，分别为key 字段,value 值,op 比较方式，可以递归增加or关系
	 */
	public void addSearchOr(FliterObject... list) {
		JSONArray array = new JSONArray();
		array.add("");
		array.add(this.toSearchObject(list));
		array.add("or");
		this.search.add(array);
	}

	/**
	 * @return the search
	 */
	public JSONArray getSearch() {
		return search;
	}

	/**
	 * @param search
	 *            the search to set
	 */
	public void setSearch(JSONArray search) {
		this.search = search;
	}

	/**
	 * @return the searchKey
	 */
	public String getSearchKey() {
		return searchKey;
	}
	
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	/**
	 * @return the sortList
	 */
	public JSONArray getSortList() {
		return sortList;
	}
}
