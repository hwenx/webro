package org.jbros.webro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jbros.webro.service.IMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private IMainService mainService;
	/**
	 * / 세션 체크
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home(HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home");
		mav.addObject("bodyContent", "/WEB-INF/include/body.jsp");
			
		return mav;
	}
	
	/**
	 * 로그인 
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(ModelAndView mav, HttpServletRequest req, @RequestParam String id, @RequestParam String pass){
		mainService.loginProcess(req, id, pass);
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout(ModelAndView mav, HttpServletRequest req, HttpServletResponse res){
		HttpSession session = req.getSession();
		session.invalidate();
		
		mav.setViewName("redirect:/");
		
		return mav;
	}
	
	/**
	 * 게시판 이동
	 */
	@RequestMapping(value="/posts/move_list", method=RequestMethod.GET)
	public ModelAndView movePostList(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home");
		mav.addObject("bodyContent", "/WEB-INF/views/posts/post_list.jsp");
		
		return mav;
	}
	

}
