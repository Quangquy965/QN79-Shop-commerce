package com.quang.javaweb.dto;

public class ProductDTO extends AbstractDTO<ProductDTO> {
	
	private String name;
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private Float price;
	private Long categoryId;
	private String categoryCode;
	
	private Integer sale;
	private Boolean highLight;
	private Boolean new_product;

	private String name_colors;
	private Long color_Id;
	private String code_colors;
	private String picture;
	

	
	public ProductDTO() {
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
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
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
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
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
	public Boolean isNew_product() {
		return new_product;
	}
	public void setNew_product(Boolean new_product) {
		this.new_product = new_product;
	}
	public String getName_colors() {
		return name_colors;
	}
	public void setName_colors(String name_colors) {
		this.name_colors = name_colors;
	}
	public Long getColorsId() {
		return color_Id;
	}
	public void setColorsId(Long colorsId) {
		this.color_Id = colorsId;
	}
	public String getCode_colors() {
		return code_colors;
	}
	public void setCode_colors(String code_colors) {
		this.code_colors = code_colors;
	}
	public String getPicture() {
		return picture;
		}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
}
