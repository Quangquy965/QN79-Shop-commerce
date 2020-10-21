package com.quang.javaweb.DAO;

import java.util.List;

import com.quang.javaweb.dto.ProductDTO;

public interface IProductDAO extends GenericDAO<ProductDTO>{
	 List<ProductDTO> GetDataProducts(int i);
//	 List<ProductDTO> GetDataNewProduct();
//	 List<ProductDTO> GetDataHighLight();
	 List<ProductDTO> GetDataProductsById(Long id);

}
