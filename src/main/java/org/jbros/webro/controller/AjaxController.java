package org.jbros.webro.controller;

import org.jbros.webro.service.IMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
	
	@Autowired
	IMainService mainService;
	
	@RequestMapping("/main/ajax")
	public String menuPage(){
		System.out.println("ajax : ");
		
		return null;
		
	}

}
