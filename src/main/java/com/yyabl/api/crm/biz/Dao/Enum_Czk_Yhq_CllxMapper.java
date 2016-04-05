package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Enum_Czk_Yhq_Cllx;

public interface Enum_Czk_Yhq_CllxMapper {
    int deleteByPrimaryKey(Integer id) throws DataAccessException;

    int insert(Enum_Czk_Yhq_Cllx record) throws DataAccessException;

    int insertSelective(Enum_Czk_Yhq_Cllx record) throws DataAccessException;

    Enum_Czk_Yhq_Cllx selectByPrimaryKey(Integer id) throws DataAccessException;

    int updateByPrimaryKeySelective(Enum_Czk_Yhq_Cllx record) throws DataAccessException;

    int updateByPrimaryKey(Enum_Czk_Yhq_Cllx record) throws DataAccessException;
}