package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Api_Hyk_Jfbdjl;

public interface Api_Hyk_JfbdjlMapper {
    int deleteByPrimaryKey(Integer jlbh) throws DataAccessException;

    int insert(Api_Hyk_Jfbdjl record) throws DataAccessException;

    int insertSelective(Api_Hyk_Jfbdjl record) throws DataAccessException;

    Api_Hyk_Jfbdjl selectByPrimaryKey(Integer jlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(Api_Hyk_Jfbdjl record) throws DataAccessException;

    int updateByPrimaryKey(Api_Hyk_Jfbdjl record) throws DataAccessException;
}