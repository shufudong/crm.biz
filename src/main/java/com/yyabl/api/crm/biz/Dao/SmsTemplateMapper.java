package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.SmsTemplate;

public interface SmsTemplateMapper {
    int deleteByPrimaryKey(Integer id) throws DataAccessException;

    int insert(SmsTemplate record) throws DataAccessException;

    int insertSelective(SmsTemplate record) throws DataAccessException;

    SmsTemplate selectByPrimaryKey(Integer id) throws DataAccessException;

    int updateByPrimaryKeySelective(SmsTemplate record) throws DataAccessException;

    int updateByPrimaryKey(SmsTemplate record) throws DataAccessException;
}