package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfdyd_Fd;
import com.yyabl.api.crm.biz.Domain.Hyk_Jfdyd_FdKey;

public interface Hyk_Jfdyd_FdMapper {
    int deleteByPrimaryKey(Hyk_Jfdyd_FdKey key) throws DataAccessException;

    int insert(Hyk_Jfdyd_Fd record) throws DataAccessException;

    int insertSelective(Hyk_Jfdyd_Fd record) throws DataAccessException;

    Hyk_Jfdyd_Fd selectByPrimaryKey(Hyk_Jfdyd_FdKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfdyd_Fd record) throws DataAccessException;

    int updateByPrimaryKeyWithBLOBs(Hyk_Jfdyd_Fd record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfdyd_Fd record) throws DataAccessException;
}