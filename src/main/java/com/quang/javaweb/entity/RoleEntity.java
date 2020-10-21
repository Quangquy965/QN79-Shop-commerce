package com.quang.javaweb.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role") // khai bao bang vai tro
public class RoleEntity extends BaseEntity{

	@Column(name = "")
	private String code; 
	
	@Column(name = "")
	private String name;
	
	@ManyToMany(mappedBy = "roles") // khai bao quan he n-n
	private List<UserEntity> users = new ArrayList<>();

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

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	
}

