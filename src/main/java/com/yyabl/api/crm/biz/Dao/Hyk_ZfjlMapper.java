package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Zfjl;

public interface Hyk_ZfjlMapper {
    int deleteByPrimaryKey(Integer jlbh) throws DataAccessException;

    int insert(Hyk_Zfjl record) throws DataAccessException;

    int insertSelective(Hyk_Zfjl record) throws DataAccessException;

    Hyk_Zfjl selectByPrimaryKey(Integer jlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Zfjl record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Zfjl record) throws DataAccessException;
}