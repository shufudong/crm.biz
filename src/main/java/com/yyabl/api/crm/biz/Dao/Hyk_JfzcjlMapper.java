package com.yyabl.api.crm.biz.Dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Jfzcjl;

public interface Hyk_JfzcjlMapper {
    int deleteByPrimaryKey(Integer jlbh) throws DataAccessException;

    int insert(Hyk_Jfzcjl record) throws DataAccessException;

    int insertSelective(Hyk_Jfzcjl record) throws DataAccessException;

    Hyk_Jfzcjl selectByPrimaryKey(Integer jlbh) throws DataAccessException;

    int updateByPrimaryKeySelective(Hyk_Jfzcjl record) throws DataAccessException;

    int updateByPrimaryKey(Hyk_Jfzcjl record) throws DataAccessException;
    
    void proc_HYXF_ZX_MDJFFT_JFZC(Map<?, ?> param) throws DataAccessException;
}