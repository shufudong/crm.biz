package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ShSpfl;

public interface ShSpflMapper {
    int deleteByPrimaryKey(Integer shspflid) throws DataAccessException;

    int insert(ShSpfl record) throws DataAccessException;

    int insertSelective(ShSpfl record) throws DataAccessException;

    ShSpfl selectByPrimaryKey(Integer shspflid) throws DataAccessException;

    int updateByPrimaryKeySelective(ShSpfl record) throws DataAccessException;

    int updateByPrimaryKey(ShSpfl record) throws DataAccessException;
}