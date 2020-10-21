package com.quang.javaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quang.javaweb.converter.CategoryConverter;
import com.quang.javaweb.dto.CategoryDTO;
import com.quang.javaweb.entity.CategoryEntity;
import com.quang.javaweb.repository.CategoryRepository;
import com.quang.javaweb.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public int getTotalItem() {
		return (int) categoryRepository.count();
	}

	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity item: entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}



	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		List<CategoryDTO> models = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll(pageable).getContent();
		for (CategoryEntity item: entities) {
			CategoryDTO categoryDTO = categoryConverter.toDto(item);
			models.add(categoryDTO);
		}
		return models;
	}

	@Override
	public CategoryDTO findById(long id) {
		CategoryEntity entity = categoryRepository.findOne(id);
		return categoryConverter.toDto(entity);
	}



	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			categoryRepository.delete(id);
		}
		
	}

	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if(categoryDTO.getId() != null) {
			CategoryEntity oldCategory = categoryRepository.findOne(categoryDTO.getId());
			categoryEntity = categoryConverter.toEntity(oldCategory, categoryDTO);
		}else {
			categoryEntity = categoryConverter.toEntity(categoryDTO);
		}
		return categoryConverter.toDto(categoryRepository.save(categoryEntity));
	}





}
