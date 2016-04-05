package com.yyabl.api.crm.biz.Dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfzh;

public interface Hyk_JfzhMapper {
    int deleteByPrimaryKey(Integer hyid) throws DataAccessException;

    int insert(Hyk_Jfzh record) throws DataAccessException;

    int insertSelective(Hyk_Jfzh record) throws DataAccessException;

    Hyk_Jfzh selectByPrimaryKey(Integer hyid) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfzh record) throws DataAccessException;

    int updateByPrimaryKeyWithBLOBs(Hyk_Jfzh record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfzh record) throws DataAccessException;
    
    int modifyPointByCardId(Map<String,Object> paramMap) throws DataAccessException;
    
}