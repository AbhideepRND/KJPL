package org.sysmaco.spring.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class RequestController {

	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String getLoginScreen(){
		return "dashboard";
	}
	
	@RequestMapping(value="/")
	public String home(){
		return "login";
	}
	
}
