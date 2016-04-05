package com.yyabl.api.crm.biz.Dao;

import java.io.IOException;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.O2O_PayType;
import com.yyabl.api.crm.biz.Domain.O2O_PayTypeKey;

public interface O2O_PayTypeMapper {
    int deleteByPrimaryKey(O2O_PayTypeKey key) throws DataAccessException,IOException;

    int insert(O2O_PayType record) throws DataAccessException,IOException;

    int insertSelective(O2O_PayType record) throws DataAccessException,IOException;

    O2O_PayType selectByPrimaryKey(O2O_PayTypeKey key) throws DataAccessException,IOException;

    int updateByPrimaryKeySelective(O2O_PayType record) throws DataAccessException,IOException;

    int updateByPrimaryKeyWithBLOBs(O2O_PayType record) throws DataAccessException,IOException;

    int updateByPrimaryKey(O2O_PayType record) throws DataAccessException,IOException;
}