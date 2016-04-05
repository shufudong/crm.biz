package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Czk_Yhq_Zc_Item;
import com.yyabl.api.crm.biz.Domain.Hyk_Czk_Yhq_Zc_ItemKey;

public interface Hyk_Czk_Yhq_Zc_ItemMapper {
    int deleteByPrimaryKey(Hyk_Czk_Yhq_Zc_ItemKey key) throws DataAccessException;

    int insert(Hyk_Czk_Yhq_Zc_Item record) throws DataAccessException;

    int insertSelective(Hyk_Czk_Yhq_Zc_Item record) throws DataAccessException;

    Hyk_Czk_Yhq_Zc_Item selectByPrimaryKey(Hyk_Czk_Yhq_Zc_ItemKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Czk_Yhq_Zc_Item record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Czk_Yhq_Zc_Item record) throws DataAccessException;
}