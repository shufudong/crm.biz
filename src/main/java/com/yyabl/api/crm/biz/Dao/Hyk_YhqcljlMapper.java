package com.yyabl.api.crm.biz.Dao;

import com.yyabl.api.crm.biz.Domain.Hyk_Yhqcljl;

import java.math.BigDecimal;

import org.springframework.dao.DataAccessException;

public interface Hyk_YhqcljlMapper {
    int deleteByPrimaryKey(BigDecimal jybh) throws DataAccessException;

    int insert(Hyk_Yhqcljl record) throws DataAccessException;

    int insertSelective(Hyk_Yhqcljl record) throws DataAccessException;

    Hyk_Yhqcljl selectByPrimaryKey(BigDecimal jybh) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Yhqcljl record) throws DataAccessException;

    int updateByPrimaryKeyWithBLOBs(Hyk_Yhqcljl record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Yhqcljl record) throws DataAccessException;
}