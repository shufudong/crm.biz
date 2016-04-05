package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Vipjlcljl;

public interface Hyk_VipjlcljlMapper {
    int deleteByPrimaryKey(Integer jlbh) throws DataAccessException;

    int insert(Hyk_Vipjlcljl record) throws DataAccessException;

    int insertSelective(Hyk_Vipjlcljl record) throws DataAccessException;

    Hyk_Vipjlcljl selectByPrimaryKey(Integer jlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Vipjlcljl record) throws DataAccessException;

    int updateByPrimaryKeyWithBLOBs(Hyk_Vipjlcljl record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Vipjlcljl record) throws DataAccessException;
}