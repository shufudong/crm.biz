package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfflgz;

public interface Hyk_JfflgzMapper {
    int deleteByPrimaryKey(Short hyktype) throws DataAccessException;

    int insert(Hyk_Jfflgz record) throws DataAccessException;

    int insertSelective(Hyk_Jfflgz record) throws DataAccessException;

    Hyk_Jfflgz selectByPrimaryKey(Short hyktype) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfflgz record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfflgz record) throws DataAccessException;
}