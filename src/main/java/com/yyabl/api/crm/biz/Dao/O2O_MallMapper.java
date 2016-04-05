package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.O2O_Mall;

public interface O2O_MallMapper {
    int deleteByPrimaryKey(Integer mdid) throws DataAccessException;

    int insert(O2O_Mall record) throws DataAccessException;

    int insertSelective(O2O_Mall record) throws DataAccessException;

    O2O_Mall selectByPrimaryKey(Integer mdid) throws DataAccessException;

    int updateByPrimaryKeySelective(O2O_Mall record) throws DataAccessException;

    int updateByPrimaryKey(O2O_Mall record) throws DataAccessException;
}