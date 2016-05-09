package org.jbros.webro.controller;

import org.jbros.webro.common.models.Response;
import org.jbros.webro.models.UserModel;
import org.jbros.webro.service.IUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
	private Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	IUsersService usersService;
	
	
	/**
	 * 사용자 상세 정보
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method =  RequestMethod.GET)
	public Response getUser(@PathVariable String id){
		
		Response result = new Response();
		result.data = usersService.getUser(id);
		
		if(result.data != null){
			result.setStat("ok");
		} else {
			result.setStat("fail");
		}
		
		return result;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public ModelAndView moveUserJoin(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home");
		mav.addObject("bodyContent", "/WEB-INF/views/users/join.jsp");
		
		return mav;
	}
	
	/**
	 * 사용자 가입
	 */
	@RequestMapping(value="/submitUser", method=RequestMethod.POST)
	public ModelAndView submitUser(UserModel user){
		ModelAndView mav = new ModelAndView();
		int result = usersService.joinUser(user);
		System.out.println("insert result : " + result);
		mav.setViewName("redirect:/");
		return mav;
	}
	
	/**
	 * 중복 체크 
	 */
	@ResponseBody
	@RequestMapping(value="/DupleCheck.ajax", method=RequestMethod.GET)
	public String DupleCheck(@RequestParam String id){
		Gson gs = new Gson();
		return gs.toJson(usersService.dupleIdCheck(id));
	}
}
