package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_SMS_Verify_Code;
import com.yyabl.api.crm.biz.Domain.Hyk_SMS_Verify_CodeKey;

public interface Hyk_SMS_Verify_CodeMapper {
	int deleteByPrimaryKey(Hyk_SMS_Verify_CodeKey key) throws DataAccessException;

    int insert(Hyk_SMS_Verify_Code record) throws DataAccessException;

    int insertSelective(Hyk_SMS_Verify_Code record) throws DataAccessException;

    Hyk_SMS_Verify_Code selectByPrimaryKey(Hyk_SMS_Verify_CodeKey key) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_SMS_Verify_Code record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_SMS_Verify_Code record) throws DataAccessException;
}