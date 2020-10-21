package com.quang.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quang.javaweb.converter.CategoryConverter;
import com.quang.javaweb.dto.CategoryDTO;
import com.quang.javaweb.entity.CategoryEntity;
import com.quang.javaweb.repository.CategoryRepository;
import com.quang.javaweb.service.IHomeService;

@Service
public class HomeService implements IHomeService{

	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryDTO> loadMenu() {
		List<CategoryDTO> menus = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item: entities) {
			CategoryDTO categoryDTO = categoryConverter.toDto(item);
			menus.add(categoryDTO);
		}
		return menus;
		
	}

}
