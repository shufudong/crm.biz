package com.yyabl.api.crm.biz.Dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Bhzt;

public interface BhztMapper {
	int deleteByPrimaryKey(String tblname) throws DataAccessException;

	int insert(Bhzt record) throws DataAccessException;

	int insertSelective(Bhzt record) throws DataAccessException;

	Bhzt selectByPrimaryKey(String tblname) throws DataAccessException;

	int updateByPrimaryKeySelective(Bhzt record) throws DataAccessException;

	int updateByPrimaryKey(Bhzt record) throws DataAccessException;
	
	void procUpdateBHZT(Map<?, ?> param) throws DataAccessException;
}