package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Xtczy;

public interface XtczyMapper {
    int deleteByPrimaryKey(Integer personId) throws DataAccessException;

    int insert(Xtczy record) throws DataAccessException;

    int insertSelective(Xtczy record) throws DataAccessException;

    Xtczy selectByPrimaryKey(Integer personId) throws DataAccessException;

    int updateByPrimaryKeySelective(Xtczy record) throws DataAccessException;

    int updateByPrimaryKeyWithBLOBs(Xtczy record) throws DataAccessException;

    int updateByPrimaryKey(Xtczy record) throws DataAccessException;
}