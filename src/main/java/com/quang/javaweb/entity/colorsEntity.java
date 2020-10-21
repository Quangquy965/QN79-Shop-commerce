package com.quang.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // khai bao entity
@Table(name = "colors") // ten bang  màu san pham
public class colorsEntity extends BaseEntity{
	
	@Column(name = "code_colors")
	private String code; 
	
	@Column(name = "name_colors")
	private String name;
	
	@Column(name = "picture")
	private String picture;
	
	@ManyToOne 
	@JoinColumn(name = "product_id") 
	private ProductEntity product;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}


	
	

}
