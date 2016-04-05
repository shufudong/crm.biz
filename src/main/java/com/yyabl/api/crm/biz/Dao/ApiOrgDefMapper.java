package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ApiOrgDef;

public interface ApiOrgDefMapper {
    int deleteByPrimaryKey(Integer id) throws DataAccessException;

    int insert(ApiOrgDef record) throws DataAccessException;

    int insertSelective(ApiOrgDef record) throws DataAccessException;

    ApiOrgDef selectByPrimaryKey(Integer id) throws DataAccessException;

    int updateByPrimaryKeySelective(ApiOrgDef record) throws DataAccessException;

    int updateByPrimaryKey(ApiOrgDef record) throws DataAccessException;
}