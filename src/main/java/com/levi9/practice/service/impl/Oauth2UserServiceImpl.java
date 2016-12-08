package com.levi9.practice.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RequestAuthenticator;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.social.InvalidAuthorizationException;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.api.impl.GitHubTemplate;
import org.springframework.stereotype.Service;

import com.levi9.practice.model.FacebookUser;
import com.levi9.practice.model.User;
import com.levi9.practice.model.UserRole;
import com.levi9.practice.service.Oauth2UserService;
import com.levi9.practice.service.UserService;

@Service
@Transactional
public class Oauth2UserServiceImpl implements Oauth2UserService {

	@Autowired
	private UserService userService;

	@SuppressWarnings("unused")
	@Override
	public User createUserFromOauth2(OAuth2AccessToken oauth2AccessToken) {
		
		User user = new User();
		Facebook facebook = null;
		GitHub gitHub = null;
		try {
			facebook = new FacebookTemplate(oauth2AccessToken.getValue());
		} catch (InvalidAuthorizationException e) {
			System.out.println("Uhvacen brat");
			gitHub = new GitHubTemplate(oauth2AccessToken.getValue());
		}
		try {
			gitHub = new GitHubTemplate(oauth2AccessToken.getValue());
		} catch (InvalidAuthorizationException e) {
			System.out.println("Uhvacen brat");
			facebook = new FacebookTemplate(oauth2AccessToken.getValue());
		}

		if (facebook != null) {
			String[] fields = { "birthday", "email", "first_name", "last_name" };
			FacebookUser faceUser = facebook.fetchObject("me", FacebookUser.class, fields);
			user.setFirstname(faceUser.getFirst_name());
			user.setLastname(faceUser.getLast_name());
			user.setEmail(faceUser.getEmail());
			user.setUserRole(UserRole.ANONYMOUS);
		} else {
			System.out.println(gitHub.isAuthorized());
			System.out.println(gitHub.userOperations().getUserProfile().getUsername());
		}

		return user;

	}

}
