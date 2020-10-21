package com.quang.javaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quang.javaweb.dto.CategoryDTO;
@Service
public interface IHomeService {
	@Autowired
	List<CategoryDTO> loadMenu();

}
