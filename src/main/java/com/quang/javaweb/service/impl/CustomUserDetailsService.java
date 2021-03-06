package com.quang.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quang.javaweb.constant.SystemConstant;
import com.quang.javaweb.dto.MyUser;
import com.quang.javaweb.entity.RoleEntity;
import com.quang.javaweb.entity.UserEntity;
import com.quang.javaweb.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authority = new ArrayList<>();
		for (RoleEntity role : userEntity.getRoles()) {
			authority.add(new SimpleGrantedAuthority(role.getCode()));
		}
		// put thong tin vao security duy tri khi user login vao he thong 
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), 
				true, true, true, true, authority);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

}
