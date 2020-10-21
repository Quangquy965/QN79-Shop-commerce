package com.quang.javaweb.converter;

import org.springframework.stereotype.Component;

import com.quang.javaweb.dto.CategoryDTO;
import com.quang.javaweb.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO result = new CategoryDTO();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity result = new CategoryEntity();
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		result.setDescription(dto.getDescription());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryEntity result,CategoryDTO dto) {
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		result.setDescription(dto.getDescription());
		return result;
	}
}
