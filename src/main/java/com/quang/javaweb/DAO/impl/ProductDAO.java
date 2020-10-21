package com.quang.javaweb.DAO.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.quang.javaweb.DAO.IProductDAO;
import com.quang.javaweb.Mapper.ProductMapper;
import com.quang.javaweb.dto.ProductDTO;

@Component
public class ProductDAO extends AbstractDAO<ProductDTO> implements IProductDAO{
	
	public static final boolean NO = false;
	public static final boolean YES = true;
	
	@Override
	public List<ProductDTO> GetDataProductsById(Long id) {
		String sql = sqlProductById(id);
		List<ProductDTO> listProduct = query(sql,new ProductMapper());
		return listProduct;
	}

	@Override
	public List<ProductDTO> GetDataProducts(int i) {
		
		if(i == 1) {
			String sql = sqlProduct(YES,NO);
			List<ProductDTO> listProduct = query(sql,new ProductMapper());
			return listProduct;
		} else if (i == 2) {
			String sql2 = sqlProduct(NO,YES);
			List<ProductDTO> listProduct2 = query(sql2,new ProductMapper());
			return listProduct2;
		}
		return null;
	}
	
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id ");
		sql.append(", p.category_id ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highLight ");
		sql.append(", p.new_product ");
		sql.append(", p.content ");
		sql.append(", p.shortdescription ");
		sql.append(", p.thumbnail ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name_colors as name_color ");
		sql.append(", c.code_colors as code_color ");
		sql.append(", c.picture ");
		sql.append(", p.createdDate ");
		sql.append(", p.modifiedDate ");
		sql.append(" FROM  ");
		sql.append(" product AS p ");
		sql.append(" INNER JOIN ");
		sql.append(" colors AS c ");
		sql.append(" ON p.id = c.product_id ");
		return sql;
	}
	
	private String sqlProduct(Boolean new_product, Boolean highLight) {
		StringBuffer sql = new StringBuffer();
		sql = SqlString();
		sql.append(" WHERE 1 = 1 ");
		if(new_product) {
			sql.append(" AND  p.new_product = true ");
		}
		if(highLight) {
			sql.append(" AND p.highLight = true ");
		}
		
		sql.append(" GROUP BY p.id, c.product_id ");
		sql.append(" ORDER BY RAND() ");
		
		if(new_product) {
			sql.append(" LIMIT 12 ");
		}
		if(highLight) {
			sql.append(" LIMIT 8 ");
		}
		return sql.toString();
	}
	private String sqlProductById(Long id) {
		StringBuffer sql = new StringBuffer();
		sql = SqlString();
		sql.append(" WHERE 1 = 1 ");
		sql.append(" AND  category_id = " + id);
		
		return sql.toString();
	}

//	@Override
//	public List<ProductDTO> GetDataNewProduct() {
//		String sql = sqlNewProduct();
//		List<ProductDTO> listProduct = query(sql,new ProductMapper());
//		return listProduct;
//	}
//
//	@Override
//	public List<ProductDTO> GetDataHighLight() {
//		String sql = sqlHighLight();
//		List<ProductDTO> listProduct = query(sql,new ProductMapper());
//		return listProduct;
//	}
	

}
