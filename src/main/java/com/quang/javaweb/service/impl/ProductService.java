   package com.quang.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quang.javaweb.DAO.IProductDAO;
import com.quang.javaweb.converter.ProductConverter;
import com.quang.javaweb.dto.ProductDTO;
import com.quang.javaweb.entity.CategoryEntity;
import com.quang.javaweb.entity.ProductEntity;
import com.quang.javaweb.repository.CategoryRepository;
import com.quang.javaweb.repository.ProductRepository;
import com.quang.javaweb.service.IProductService;


@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private IProductDAO productDAO;

	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> models= new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll(pageable).getContent(); 
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

    

	@Override
	public int getTotalItem() {
		return (int) productRepository.count();
	}



	@Override
	public ProductDTO findById(long id) {
		ProductEntity entity = productRepository.findOne(id);
		return productConverter.toDto(entity);
	}


	@Override
	@Transactional 
	public ProductDTO save(ProductDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		ProductEntity productEntity = new ProductEntity();
		if(dto.getId() != null) {
			ProductEntity oldProduct = productRepository.findOne(dto.getId());
			oldProduct.setCategory(category);
			productEntity = productConverter.toEntity(oldProduct, dto);
		}else {
			productEntity = productConverter.toEntity(dto);
			productEntity.setCategory(category);
		}
		return productConverter.toDto(productRepository.save(productEntity));
	}



	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			productRepository.delete(id);
		}
		
	}



	@Override
	public List<ProductDTO> GetDataProducts(int i) {
		List<ProductDTO> listProductDTOs = productDAO.GetDataProducts(i);
		listProductDTOs.get(0).getCategoryId();
		return listProductDTOs;
	}



	@Override
	public List<ProductDTO> GetDataProductsById(Long id,Pageable pageable) {
		List<ProductDTO> listProductDTOs = productDAO.GetDataProductsById(id);
		return listProductDTOs;
	}



//	@Override
//	public List<ProductDTO> GetDataNewProduct() {
//		List<ProductDTO> listProductDTOs = productDAO.GetDataNewProduct();
//		listProductDTOs.get(0).getCategoryId();
//		return listProductDTOs;
//	}
//
//
//
//	@Override
//	public List<ProductDTO> GetDataHighLight() {
//		List<ProductDTO> listProductDTOs = productDAO.GetDataHighLight();
//		listProductDTOs.get(0).getCategoryId();
//		return listProductDTOs;
//	}






}
