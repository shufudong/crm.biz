package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfdyd_Gzsd;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfdyd_GzsdKey;

public interface Hyk_Jfdyd_GzsdMapper {
    int deleteByPrimaryKey(Hyk_Jfdyd_GzsdKey key) throws DataAccessException;

    int insert(Hyk_Jfdyd_Gzsd record) throws DataAccessException;

    int insertSelective(Hyk_Jfdyd_Gzsd record) throws DataAccessException;

    Hyk_Jfdyd_Gzsd selectByPrimaryKey(Hyk_Jfdyd_GzsdKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfdyd_Gzsd record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfdyd_Gzsd record) throws DataAccessException;
}