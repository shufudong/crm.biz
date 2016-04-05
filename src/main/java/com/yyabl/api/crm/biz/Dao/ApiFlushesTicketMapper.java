package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ApiFlushesTicket;

public interface ApiFlushesTicketMapper {
    int deleteByPrimaryKey(Integer jlbh) throws DataAccessException;

    int insert(ApiFlushesTicket record) throws DataAccessException;

    int insertSelective(ApiFlushesTicket record) throws DataAccessException;

    ApiFlushesTicket selectByPrimaryKey(Integer jlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(ApiFlushesTicket record) throws DataAccessException;

    int updateByPrimaryKey(ApiFlushesTicket record) throws DataAccessException;
}