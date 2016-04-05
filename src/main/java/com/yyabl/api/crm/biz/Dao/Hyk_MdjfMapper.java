package com.yyabl.api.crm.biz.Dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.yyabl.api.crm.biz.Domain.Hyk_Mdjf;
import com.yyabl.api.crm.biz.Domain.Hyk_MdjfKey;

public interface Hyk_MdjfMapper {
	int deleteByPrimaryKey(Hyk_MdjfKey key) throws DataAccessException;

	int insert(Hyk_Mdjf record) throws DataAccessException;

	int insertSelective(Hyk_Mdjf record) throws DataAccessException;

	Hyk_Mdjf selectByPrimaryKey(Hyk_MdjfKey key) throws DataAccessException;

	int updateByPrimaryKeySelective(Hyk_Mdjf record) throws DataAccessException;

	int updateByPrimaryKeyWithBLOBs(Hyk_Mdjf record) throws DataAccessException;

	int updateByPrimaryKey(Hyk_Mdjf record) throws DataAccessException;

	int selectEffectPointsByCardId(int cardId) throws DataAccessException;

	void procHyxfMdjfFt(Map<?, ?> param) throws DataAccessException;
}