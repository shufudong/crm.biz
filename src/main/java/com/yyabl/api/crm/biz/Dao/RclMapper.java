package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Rcl;
import com.yyabl.api.crm.biz.Domain.RclKey;

public interface RclMapper {
    int deleteByPrimaryKey(RclKey key) throws DataAccessException;

    int insert(Rcl record) throws DataAccessException;

    int insertSelective(Rcl record) throws DataAccessException;

    Rcl selectByPrimaryKey(RclKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Rcl record) throws DataAccessException;

    int updateByPrimaryKey(Rcl record) throws DataAccessException;
    
    Rcl checkRclStatus() throws DataAccessException;
}