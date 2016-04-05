package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Bgdd;

public interface Hyk_BgddMapper {
    int deleteByPrimaryKey(String bgdddm) throws DataAccessException;

    int insert(Hyk_Bgdd record) throws DataAccessException;

    int insertSelective(Hyk_Bgdd record) throws DataAccessException;

    Hyk_Bgdd selectByPrimaryKey(String bgdddm) throws DataAccessException;
    
    Hyk_Bgdd selectByMdid(int mdid) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Bgdd record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Bgdd record) throws DataAccessException;
    
}