package com.quang.javaweb.converter;

import org.springframework.stereotype.Component;


import com.quang.javaweb.dto.ProductDTO;
import com.quang.javaweb.entity.ProductEntity;

@Component
public class ProductConverter {

	public ProductDTO toDto(ProductEntity entity) {
		ProductDTO result = new ProductDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setTitle(entity.getTitle());
		result.setThumbnail(entity.getThumbnail());
		result.setShortDescription(entity.getShortdescription());
		result.setContent(entity.getContent());
		result.setPrice(entity.getPrice());
		result.setSale(entity.getSale());
		result.setHighLight(entity.isHighLight());
		result.setNew_product(entity.isNew_produc());
//		result.setCategoryCode(entity.getCategory().getCode());
		/* result.setName_colors(entity.getColors()); */
	
		
		return result;
	}

	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity result = new ProductEntity();
		result.setName(dto.getName());
		result.setTitle(dto.getTitle());
		result.setThumbnail(dto.getThumbnail());
		result.setShortdescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setPrice(dto.getPrice());
//		result.setSale(dto.getSale());
		result.setHighLight(dto.isHighLight());
		result.setNew_produc(dto.isNew_product());
		// result.setCategory(dto.getCategoryCode()); 
		return result;
	}
	
	public ProductEntity toEntity(ProductEntity result,ProductDTO dto) {
		result.setName(dto.getName());
		result.setTitle(dto.getTitle());
		result.setThumbnail(dto.getThumbnail());
		result.setShortdescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setPrice(dto.getPrice());
		result.setSale(dto.getSale());
		result.setHighLight(dto.isHighLight());
		result.setNew_produc(dto.isNew_product());
		
		
		return result;
	}
}
