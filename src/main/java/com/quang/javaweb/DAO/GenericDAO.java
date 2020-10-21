package com.quang.javaweb.DAO;

import java.util.List;

import com.quang.javaweb.Mapper.RowMapper;



public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters); /// chú ý chưa sửa phần row mapper 
	void update (String sql, Object... parameters);
	Long insert (String sql, Object... parameters);
	int count(String sql, Object... parameters);
}
