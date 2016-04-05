package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ApiFlushesPoint;

public interface ApiFlushesPointMapper {
    int deleteByPrimaryKey(Integer jlbh) throws DataAccessException;

    int insert(ApiFlushesPoint record) throws DataAccessException;

    int insertSelective(ApiFlushesPoint record) throws DataAccessException;

    ApiFlushesPoint selectByPrimaryKey(Integer jlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(ApiFlushesPoint record) throws DataAccessException;

    int updateByPrimaryKey(ApiFlushesPoint record) throws DataAccessException;
}