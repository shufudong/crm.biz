package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Shht;

public interface ShhtMapper {
    int deleteByPrimaryKey(Integer shhtid) throws DataAccessException;

    int insert(Shht record) throws DataAccessException;

    int insertSelective(Shht record) throws DataAccessException;

    Shht selectByPrimaryKey(Integer shhtid) throws DataAccessException;

    int updateByPrimaryKeySelective(Shht record) throws DataAccessException;

    int updateByPrimaryKey(Shht record) throws DataAccessException;
}