package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfbdd;

public interface Hyk_JfbddMapper {
    int deleteByPrimaryKey(Integer jlbh) throws DataAccessException;

    int insert(Hyk_Jfbdd record) throws DataAccessException;

    int insertSelective(Hyk_Jfbdd record) throws DataAccessException;

    Hyk_Jfbdd selectByPrimaryKey(Integer jlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfbdd record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfbdd record) throws DataAccessException;
}