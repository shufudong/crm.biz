package com.yyabl.api.crm.biz.Dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Hyxx;

public interface Hyk_HyxxMapper {
	int deleteByPrimaryKey(Integer hyid) throws DataAccessException;

	int insert(Hyk_Hyxx record) throws DataAccessException;

	int insertSelective(Hyk_Hyxx record) throws DataAccessException;

	Hyk_Hyxx selectByPrimaryKey(Integer hyid) throws DataAccessException;
	
	Hyk_Hyxx selectCardInfoByParamMap(Map<String,Object> paramMap) throws DataAccessException;

	int updateByPrimaryKeySelective(Hyk_Hyxx record) throws DataAccessException;

	int updateByPrimaryKeyWithBLOBs(Hyk_Hyxx record) throws DataAccessException;

	int updateByPrimaryKey(Hyk_Hyxx record) throws DataAccessException;
}