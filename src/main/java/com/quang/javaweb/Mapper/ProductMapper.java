package com.quang.javaweb.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quang.javaweb.dto.ProductDTO;

public class ProductMapper implements com.quang.javaweb.Mapper.RowMapper<ProductDTO> {

	@Override
	public ProductDTO mapRow(ResultSet rs) {
		try {
			ProductDTO product = new ProductDTO();
			product.setId(rs.getLong("id"));
			product.setCategoryId(rs.getLong("category_id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getFloat("price"));
			product.setSale(rs.getInt("sale"));
			product.setTitle(rs.getString("title"));
			product.setHighLight(rs.getBoolean("highLight"));
			product.setNew_product(rs.getBoolean("new_product"));
			product.setContent(rs.getString("content"));
			product.setShortDescription(rs.getString("shortdescription"));
			product.setThumbnail(rs.getString("thumbnail"));
			product.setColorsId(rs.getLong("id_color"));
			product.setName_colors(rs.getString("name_color"));
			product.setCode_colors(rs.getString("code_color"));
			product.setPicture(rs.getString("picture"));
			product.setCreatedDate(rs.getTimestamp("createdDate"));
			product.setModifiedDate(rs.getTimestamp("modifiedDate"));
			return product;
			
		} catch (SQLException e) {
			return null;
		}
	}

}
