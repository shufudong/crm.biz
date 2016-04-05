package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.LmkDef;

public interface LmkDefMapper {
    int deleteByPrimaryKey(Integer lmkId) throws DataAccessException;

    int insert(LmkDef record) throws DataAccessException;

    int insertSelective(LmkDef record) throws DataAccessException;

    LmkDef selectByPrimaryKey(Integer lmkId) throws DataAccessException;

    int updateByPrimaryKeySelective(LmkDef record) throws DataAccessException;

    int updateByPrimaryKey(LmkDef record) throws DataAccessException;
}