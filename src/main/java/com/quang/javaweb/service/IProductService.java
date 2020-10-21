package com.quang.javaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.quang.javaweb.dto.ProductDTO;


public interface IProductService {
	List<ProductDTO> findAll(Pageable pageable);
	List<ProductDTO> GetDataProducts(int i);
//	List<ProductDTO> GetDataNewProduct();
//	List<ProductDTO> GetDataHighLight();
	List<ProductDTO> GetDataProductsById(Long id, Pageable pageable);
	int getTotalItem();
	ProductDTO findById(long id);
	ProductDTO save(ProductDTO dto);
	void delete(long[] ids);
}
