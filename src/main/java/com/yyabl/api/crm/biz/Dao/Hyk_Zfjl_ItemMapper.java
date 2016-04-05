package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Zfjl_Item;
import com.yyabl.api.crm.biz.Domain.Hyk_Zfjl_ItemKey;

public interface Hyk_Zfjl_ItemMapper {
    int deleteByPrimaryKey(Hyk_Zfjl_ItemKey key) throws DataAccessException;

    int insert(Hyk_Zfjl_Item record) throws DataAccessException;

    int insertSelective(Hyk_Zfjl_Item record) throws DataAccessException;

    Hyk_Zfjl_Item selectByPrimaryKey(Hyk_Zfjl_ItemKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Zfjl_Item record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Zfjl_Item record) throws DataAccessException;
}