package com.yyabl.api.crm.biz.Dao;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.ApiMergeCardItemTicket;

public interface ApiMergeCardItemTicketMapper {
    int insert(ApiMergeCardItemTicket record) throws DataAccessException;

    int insertSelective(ApiMergeCardItemTicket record) throws DataAccessException;
}