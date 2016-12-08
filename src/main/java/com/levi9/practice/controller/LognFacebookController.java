package com.levi9.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LognFacebookController {

	@RequestMapping(value="/login/facebook", method = RequestMethod.GET)
	public String facebookLogin(){
		return "static/html//loginFacebook.html";
	}
	
}
