package com.levi9.practice.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.levi9.practice.model.CurrentUser;
import com.levi9.practice.model.User;
import com.levi9.practice.repository.UserRepository;
@Service
@Transactional
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	public UserRepository userRepository;

	@Override
	public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		return new CurrentUser(user);
	}
	
	

}
