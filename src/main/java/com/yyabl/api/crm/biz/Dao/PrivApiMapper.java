package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.PrivApiKey;

public interface PrivApiMapper {
    int deleteByPrimaryKey(PrivApiKey key) throws DataAccessException;

    int insert(PrivApiKey record) throws DataAccessException;

    int insertSelective(PrivApiKey record) throws DataAccessException;
}