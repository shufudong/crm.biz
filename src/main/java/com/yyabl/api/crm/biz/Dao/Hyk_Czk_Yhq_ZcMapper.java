package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Czk_Yhq_Zc;

public interface Hyk_Czk_Yhq_ZcMapper {
    int deleteByPrimaryKey(Integer czjpjJlbh) throws DataAccessException;

    int insert(Hyk_Czk_Yhq_Zc record) throws DataAccessException;

    int insertSelective(Hyk_Czk_Yhq_Zc record) throws DataAccessException;

    Hyk_Czk_Yhq_Zc selectByPrimaryKey(Integer czjpjJlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Czk_Yhq_Zc record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Czk_Yhq_Zc record) throws DataAccessException;
}