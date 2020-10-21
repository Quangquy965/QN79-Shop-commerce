package com.quang.javaweb.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // khai bao entity
@Table(name = "product") // ten bang san pham
public class ProductEntity extends BaseEntity{
	
	@Column(name = "name") // cot ten san pham
	private String name;
	
	@Column(name = "title") //  tieu de 
	private String title;
	
	@Column(name = "thumbnail") // hinh mo ta 
	private String thumbnail;
	
	@Column(name = "shortdescription", columnDefinition = "TEXT") // mo ta ngan
	private String shortdescription;
	
	@Column(name = "content", columnDefinition = "TEXT") // noi dung kiểu text
	private String content;
	
	@Column(name = "price") // gias
	private Float price;
	
	@Column(name = "sale") // gias
	private Integer sale;
	
	@Column(name = "highLight") // san pham noi bat hay ko 
	private Boolean highLight;
	
	@Column(name = "new_product") // san pham moi
	private Boolean new_produc;  
	
	@OneToMany(mappedBy = "product")
	private List<colorsEntity> colors = new ArrayList<>();
	
	@ManyToOne // khai bao quan he n-1 
	@JoinColumn(name = "category_id") 
	private CategoryEntity category;
	
	

	public ProductEntity() {
		super();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public Integer getSale() {
		return sale;
	}

	public void setSale(Integer sale) {
		this.sale = sale;
	}

	public Boolean isHighLight() {
		return highLight;
	}

	public void setHighLight(Boolean highLight) {
		this.highLight = highLight;
	}

	public Boolean isNew_produc() {
		return new_produc;
	}

	public void setNew_produc(Boolean new_produc) {
		this.new_produc = new_produc;
	}

	public List<colorsEntity> getColors() {
		return colors;
	}

	public void setColors(List<colorsEntity> colors) {
		this.colors = colors;
	}
	
	
	
	
}

