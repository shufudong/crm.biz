package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Czk_Yhq_Ckjl;

public interface Hyk_Czk_Yhq_CkjlMapper {
    int deleteByPrimaryKey(Integer czjpjJlbh) throws DataAccessException;

    int insert(Hyk_Czk_Yhq_Ckjl record) throws DataAccessException;

    int insertSelective(Hyk_Czk_Yhq_Ckjl record) throws DataAccessException;

    Hyk_Czk_Yhq_Ckjl selectByPrimaryKey(Integer czjpjJlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Czk_Yhq_Ckjl record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Czk_Yhq_Ckjl record) throws DataAccessException;
}