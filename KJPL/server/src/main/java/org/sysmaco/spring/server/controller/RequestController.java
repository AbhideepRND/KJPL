package org.sysmaco.spring.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class RequestController {

	
	@RequestMapping(value="/")
	public String home(){
		return "login";
	}
	
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String getDashBoard(){
		return "dashboard";
	}
	
	
	@RequestMapping(value="/DepartmentMaster", method=RequestMethod.GET)
	public String getDepartmentMaster(){
		return "DepartmentMaster";
	}
	
	@RequestMapping(value="/RateEntry", method=RequestMethod.GET)
	public String getRateEntry(){
		return "RateEntry";
	}
	
	@RequestMapping(value="/DailyHands", method=RequestMethod.GET)
	public String getDailyHands(){
		return "DailyHands";
	}
	
	@RequestMapping(value="/ViewHands", method=RequestMethod.GET)
	public String getViewHands(){
		return "ViewHands";
	}
	
}
