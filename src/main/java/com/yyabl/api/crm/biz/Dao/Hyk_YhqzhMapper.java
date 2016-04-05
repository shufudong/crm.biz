package com.yyabl.api.crm.biz.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Yhqzh;
import com.yyabl.api.crm.biz.Domain.Hyk_YhqzhKey;

public interface Hyk_YhqzhMapper {
	int deleteByPrimaryKey(Hyk_YhqzhKey key) throws DataAccessException;

	int insert(Hyk_Yhqzh record) throws DataAccessException;

	int insertSelective(Hyk_Yhqzh record) throws DataAccessException;

	Hyk_Yhqzh selectByPrimaryKey(Hyk_YhqzhKey key) throws DataAccessException;
	
	List<Hyk_Yhqzh> selectTicketByParamMap(Map<String,Object> paramMap) throws DataAccessException;

	int updateByPrimaryKeySelective(Hyk_Yhqzh record) throws DataAccessException;

	int updateByPrimaryKeyWithBLOBs(Hyk_Yhqzh record) throws DataAccessException;

	int updateByPrimaryKey(Hyk_Yhqzh record) throws DataAccessException;

	int selectEffectTicketsByCardId(int cardId) throws DataAccessException;
	
	List<Hyk_Yhqzh> selectEffectTicketListByCardId(int cardId) throws DataAccessException;
	
	int modifyTicketByMap(Map<String,Object> paramMap) throws DataAccessException;
}