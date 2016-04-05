package com.yyabl.api.crm.biz.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ApiDef;

public interface ApiDefMapper {
	int deleteByPrimaryKey(Integer id) throws DataAccessException;

	int insert(ApiDef record) throws DataAccessException;

	int insertSelective(ApiDef record) throws DataAccessException;

	ApiDef selectByPrimaryKey(Integer id) throws DataAccessException;

	int updateByPrimaryKeySelective(ApiDef record) throws DataAccessException;

	int updateByPrimaryKey(ApiDef record) throws DataAccessException;

	List<ApiDef> selectByUrlEnabled(String url) throws DataAccessException;
}