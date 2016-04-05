package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ApiPersonDef;

public interface ApiPersonDefMapper {
    int deleteByPrimaryKey(Integer personId) throws DataAccessException;

    int insert(ApiPersonDef record) throws DataAccessException;

    int insertSelective(ApiPersonDef record) throws DataAccessException;

    ApiPersonDef selectByPrimaryKey(Integer personId) throws DataAccessException;

    int updateByPrimaryKeySelective(ApiPersonDef record) throws DataAccessException;

    int updateByPrimaryKey(ApiPersonDef record) throws DataAccessException;
}