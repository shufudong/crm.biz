package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfdyd_Sp;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfdyd_SpKey;

public interface Hyk_Jfdyd_SpMapper {
    int deleteByPrimaryKey(Hyk_Jfdyd_SpKey key) throws DataAccessException;

    int insert(Hyk_Jfdyd_Sp record) throws DataAccessException;

    int insertSelective(Hyk_Jfdyd_Sp record) throws DataAccessException;

    Hyk_Jfdyd_Sp selectByPrimaryKey(Hyk_Jfdyd_SpKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfdyd_Sp record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfdyd_Sp record) throws DataAccessException;
}