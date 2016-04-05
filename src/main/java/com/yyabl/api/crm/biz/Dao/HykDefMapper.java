package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.HykDef;

public interface HykDefMapper {
    int deleteByPrimaryKey(Short hyktype) throws DataAccessException;

    int insert(HykDef record) throws DataAccessException;

    int insertSelective(HykDef record) throws DataAccessException;

    HykDef selectByPrimaryKey(Short hyktype) throws DataAccessException;

    int updateByPrimaryKeySelective(HykDef record) throws DataAccessException;

    int updateByPrimaryKeyWithBLOBs(HykDef record) throws DataAccessException;

    int updateByPrimaryKey(HykDef record) throws DataAccessException;
}