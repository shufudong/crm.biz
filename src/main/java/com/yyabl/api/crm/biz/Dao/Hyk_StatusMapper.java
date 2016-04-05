package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Status;

public interface Hyk_StatusMapper {
    int deleteByPrimaryKey(Short id) throws DataAccessException;

    int insert(Hyk_Status record) throws DataAccessException;

    int insertSelective(Hyk_Status record) throws DataAccessException;

    Hyk_Status selectByPrimaryKey(Short id) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Status record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Status record) throws DataAccessException;
}