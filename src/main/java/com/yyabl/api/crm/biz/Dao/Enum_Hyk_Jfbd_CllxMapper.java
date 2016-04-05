package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Enum_Hyk_Jfbd_Cllx;

public interface Enum_Hyk_Jfbd_CllxMapper {
    int deleteByPrimaryKey(Integer id) throws DataAccessException;

    int insert(Enum_Hyk_Jfbd_Cllx record) throws DataAccessException;

    int insertSelective(Enum_Hyk_Jfbd_Cllx record) throws DataAccessException;

    Enum_Hyk_Jfbd_Cllx selectByPrimaryKey(Integer id) throws DataAccessException;

    int updateByPrimaryKeySelective(Enum_Hyk_Jfbd_Cllx record) throws DataAccessException;

    int updateByPrimaryKey(Enum_Hyk_Jfbd_Cllx record) throws DataAccessException;
}