package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Gkda;

public interface Hyk_GkdaMapper {
    int deleteByPrimaryKey(Integer gkid) throws DataAccessException;

    int insert(Hyk_Gkda record) throws DataAccessException;

    int insertSelective(Hyk_Gkda record) throws DataAccessException;

    Hyk_Gkda selectByPrimaryKey(Integer gkid) throws DataAccessException;
    
    Hyk_Gkda selectByIdNumber(String idNumber) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Gkda record) throws DataAccessException;

    int updateByPrimaryKeyWithBLOBs(Hyk_Gkda record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Gkda record) throws DataAccessException;
  
}