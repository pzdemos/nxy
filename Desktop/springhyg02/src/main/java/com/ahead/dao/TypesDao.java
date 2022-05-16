package com.ahead.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ahead.bean.Types;

public interface TypesDao {
	@Select("select *from types")
	public List<Types> SelectAll();

}
