package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfdyd_GzItem;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfdyd_GzItemKey;

public interface Hyk_Jfdyd_GzItemMapper {
    int deleteByPrimaryKey(Hyk_Jfdyd_GzItemKey key) throws DataAccessException;

    int insert(Hyk_Jfdyd_GzItem record) throws DataAccessException;

    int insertSelective(Hyk_Jfdyd_GzItem record) throws DataAccessException;

    Hyk_Jfdyd_GzItem selectByPrimaryKey(Hyk_Jfdyd_GzItemKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfdyd_GzItem record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfdyd_GzItem record) throws DataAccessException;
}