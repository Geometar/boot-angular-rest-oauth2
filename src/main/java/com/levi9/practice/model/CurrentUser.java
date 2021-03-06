package com.levi9.practice.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User{

	private User user;
	
	public CurrentUser(User user) {
		super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserRole().toString()));
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public Long getId(){
		return user.getId();
	}
	
	public String getRole(){
		return user.getUserRole().toString();
	}

}
