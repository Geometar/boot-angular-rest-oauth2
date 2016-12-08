package com.levi9.practice.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.levi9.practice.model.User;

public interface Oauth2UserService {
	
	User createUserFromOauth2(OAuth2AccessToken oauth2);

}
