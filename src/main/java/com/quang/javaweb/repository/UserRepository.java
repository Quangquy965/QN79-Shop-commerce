package com.quang.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quang.javaweb.entity.UserEntity;


	public interface UserRepository extends JpaRepository<UserEntity, Long> {
		UserEntity findOneByUserNameAndStatus(String name, int status);
	}

