package com.yyabl.api.crm.biz.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Api_Hyk_Yhqcljl_Item;

public interface Api_Hyk_Yhqcljl_ItemMapper {
    int insert(Api_Hyk_Yhqcljl_Item record) throws DataAccessException;

    int insertSelective(Api_Hyk_Yhqcljl_Item record) throws DataAccessException;
    
    List<Api_Hyk_Yhqcljl_Item> selectByPramaryKey(int jlbh) throws DataAccessException;
}