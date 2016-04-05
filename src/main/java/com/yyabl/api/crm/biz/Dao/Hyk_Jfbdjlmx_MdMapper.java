package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfbdjlmx_Md;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfbdjlmx_MdKey;

public interface Hyk_Jfbdjlmx_MdMapper {
    int deleteByPrimaryKey(Hyk_Jfbdjlmx_MdKey key) throws DataAccessException;

    int insert(Hyk_Jfbdjlmx_Md record) throws DataAccessException;

    int insertSelective(Hyk_Jfbdjlmx_Md record) throws DataAccessException;

    Hyk_Jfbdjlmx_Md selectByPrimaryKey(Hyk_Jfbdjlmx_MdKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfbdjlmx_Md record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfbdjlmx_Md record) throws DataAccessException;
}