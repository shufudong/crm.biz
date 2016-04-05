package com.yyabl.api.crm.biz.Dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Ryxx;

public interface RyxxMapper {
	int deleteByPrimaryKey(Integer personId) throws DataAccessException;

	int insert(Ryxx record) throws DataAccessException;

	int insertSelective(Ryxx record) throws DataAccessException;

	Ryxx selectByPrimaryKey(Integer personId) throws DataAccessException;

	int updateByPrimaryKeySelective(Ryxx record) throws DataAccessException;

	int updateByPrimaryKey(Ryxx record) throws DataAccessException;

	Ryxx selectByPersonCode(String personCode) throws DataAccessException;

	Ryxx selectByPersonCodeAndUrl(Map<String, Object> paramMap) throws DataAccessException;

	Ryxx selectRyxxAndPrivByPersonCode(String personCode) throws DataAccessException;
}