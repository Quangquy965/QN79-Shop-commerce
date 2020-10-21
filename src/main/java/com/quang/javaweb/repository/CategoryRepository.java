package com.quang.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quang.javaweb.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	 
	CategoryEntity findOneByCode(String code);
}
