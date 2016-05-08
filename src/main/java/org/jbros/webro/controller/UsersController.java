package org.jbros.webro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jbros.webro.common.models.Response;
import org.jbros.webro.service.IMainService;
import org.jbros.webro.service.IUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	/**
	 * 사용자 가입
	 * @param mav
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public ModelAndView joinProcess(ModelAndView mav, HttpServletRequest req, HttpServletResponse res){
		HttpSession session = req.getSession();
		session.invalidate();
		
		mav.setViewName("redirect:/");
		
		return mav;
	}
	
}
