package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ApiMergeCard;

public interface ApiMergeCardMapper {
    int deleteByPrimaryKey(Integer jlbh) throws DataAccessException;

    int insert(ApiMergeCard record) throws DataAccessException;

    int insertSelective(ApiMergeCard record) throws DataAccessException;

    ApiMergeCard selectByPrimaryKey(Integer jlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(ApiMergeCard record) throws DataAccessException;

    int updateByPrimaryKey(ApiMergeCard record) throws DataAccessException;
}