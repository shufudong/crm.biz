package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ShSpxx;

public interface ShSpxxMapper {
    int deleteByPrimaryKey(Integer shspid) throws DataAccessException;

    int insert(ShSpxx record) throws DataAccessException;

    int insertSelective(ShSpxx record) throws DataAccessException;

    ShSpxx selectByPrimaryKey(Integer shspid) throws DataAccessException;

    int updateByPrimaryKeySelective(ShSpxx record) throws DataAccessException;

    int updateByPrimaryKeyWithBLOBs(ShSpxx record) throws DataAccessException;

    int updateByPrimaryKey(ShSpxx record) throws DataAccessException;
}