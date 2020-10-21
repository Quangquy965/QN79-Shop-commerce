package com.quang.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quang.javaweb.entity.ProductEntity;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
