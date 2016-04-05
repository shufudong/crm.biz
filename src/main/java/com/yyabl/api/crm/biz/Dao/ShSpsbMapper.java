package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ShSpsb;

public interface ShSpsbMapper {
    int deleteByPrimaryKey(Integer shsbid) throws DataAccessException;

    int insert(ShSpsb record) throws DataAccessException;

    int insertSelective(ShSpsb record) throws DataAccessException;

    ShSpsb selectByPrimaryKey(Integer shsbid) throws DataAccessException;

    int updateByPrimaryKeySelective(ShSpsb record) throws DataAccessException;

    int updateByPrimaryKey(ShSpsb record) throws DataAccessException;
}