package com.quang.javaweb.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category") // khai bao bang the loai 
public class CategoryEntity extends BaseEntity{
	
	@Column(name = "name") // ten the loai
	private String name;
	
	@Column(name = "code") // ma the loai 
	private String code;
	
	@Column(name = "description") // miêu tả 
	private String description;

	
	@OneToMany(mappedBy = "category")
	private List<ProductEntity> produc = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public List<ProductEntity> getProduc() {
		return produc;
	}

	public void setProduc(List<ProductEntity> produc) {
		this.produc = produc;
	}
	
	
}
