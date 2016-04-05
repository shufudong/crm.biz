package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfbdjlmx;
import com.yyabl.api.crm.biz.Domain.Hyk_JfbdjlmxKey;

public interface Hyk_JfbdjlmxMapper {
    int deleteByPrimaryKey(Hyk_JfbdjlmxKey key) throws DataAccessException;

    int insert(Hyk_Jfbdjlmx record) throws DataAccessException;

    int insertSelective(Hyk_Jfbdjlmx record) throws DataAccessException;

    Hyk_Jfbdjlmx selectByPrimaryKey(Hyk_JfbdjlmxKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfbdjlmx record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfbdjlmx record) throws DataAccessException;
}