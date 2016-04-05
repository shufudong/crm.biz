package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Vipjlcljlmx;
import com.yyabl.api.crm.biz.Domain.Hyk_VipjlcljlmxKey;

public interface Hyk_VipjlcljlmxMapper {
	int deleteByPrimaryKey(Hyk_VipjlcljlmxKey key) throws DataAccessException;

	int insert(Hyk_Vipjlcljlmx record) throws DataAccessException;

	int insertSelective(Hyk_Vipjlcljlmx record) throws DataAccessException;

	Hyk_Vipjlcljlmx selectByPrimaryKey(Hyk_VipjlcljlmxKey key) throws DataAccessException;

	int updateByPrimaryKeySelective(Hyk_Vipjlcljlmx record) throws DataAccessException;

	int updateByPrimaryKey(Hyk_Vipjlcljlmx record) throws DataAccessException;
}