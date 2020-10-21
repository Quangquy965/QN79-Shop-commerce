package com.quang.javaweb.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao {

	@Autowired
	public JdbcTemplate _jdbcTemplate;
}
