package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ShSpxx_Dm;
import com.yyabl.api.crm.biz.Domain.ShSpxx_DmKey;

public interface ShSpxx_DmMapper {
    int deleteByPrimaryKey(ShSpxx_DmKey key) throws DataAccessException;

    int insert(ShSpxx_Dm record) throws DataAccessException;

    int insertSelective(ShSpxx_Dm record) throws DataAccessException;

    ShSpxx_Dm selectByPrimaryKey(ShSpxx_DmKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(ShSpxx_Dm record) throws DataAccessException;

    int updateByPrimaryKey(ShSpxx_Dm record) throws DataAccessException;
}