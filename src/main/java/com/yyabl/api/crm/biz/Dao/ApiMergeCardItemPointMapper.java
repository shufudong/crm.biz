package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ApiMergeCardItemPoint;

public interface ApiMergeCardItemPointMapper {
    int insert(ApiMergeCardItemPoint record) throws DataAccessException;

    int insertSelective(ApiMergeCardItemPoint record) throws DataAccessException;
}