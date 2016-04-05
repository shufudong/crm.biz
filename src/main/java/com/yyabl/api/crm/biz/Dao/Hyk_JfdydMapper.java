package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfdyd;

public interface Hyk_JfdydMapper {
    int deleteByPrimaryKey(Integer jlbh) throws DataAccessException;

    int insert(Hyk_Jfdyd record) throws DataAccessException;

    int insertSelective(Hyk_Jfdyd record) throws DataAccessException;

    Hyk_Jfdyd selectByPrimaryKey(Integer jlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfdyd record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfdyd record) throws DataAccessException;
}