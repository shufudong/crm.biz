package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfdydj;
import com.yyabl.api.crm.biz.Domain.Hyk_JfdydjKey;

public interface Hyk_JfdydjMapper {
    int deleteByPrimaryKey(Hyk_JfdydjKey key) throws DataAccessException;

    int insert(Hyk_Jfdydj record) throws DataAccessException;

    int insertSelective(Hyk_Jfdydj record) throws DataAccessException;

    Hyk_Jfdydj selectByPrimaryKey(Hyk_JfdydjKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfdydj record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfdydj record) throws DataAccessException;
}