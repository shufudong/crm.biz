package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfzcjl_Item;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfzcjl_ItemKey;

public interface Hyk_Jfzcjl_ItemMapper {
    int deleteByPrimaryKey(Hyk_Jfzcjl_ItemKey key) throws DataAccessException;

    int insert(Hyk_Jfzcjl_Item record) throws DataAccessException;

    int insertSelective(Hyk_Jfzcjl_Item record) throws DataAccessException;

    Hyk_Jfzcjl_Item selectByPrimaryKey(Hyk_Jfzcjl_ItemKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfzcjl_Item record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfzcjl_Item record) throws DataAccessException;
}