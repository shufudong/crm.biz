package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.YhqDef;

public interface YhqDefMapper {
    int deleteByPrimaryKey(Short yhqid) throws DataAccessException;

    int insert(YhqDef record) throws DataAccessException;

    int insertSelective(YhqDef record) throws DataAccessException;

    YhqDef selectByPrimaryKey(Short yhqid) throws DataAccessException;

    int updateByPrimaryKeySelective(YhqDef record) throws DataAccessException;

    int updateByPrimaryKeyWithBLOBs(YhqDef record) throws DataAccessException;

    int updateByPrimaryKey(YhqDef record) throws DataAccessException;
}