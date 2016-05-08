package org.jbros.webro.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home(HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home");
		mav.addObject("bodyContent", "/WEB-INF/include/body.jsp");
		Boolean nullCheck = (Boolean) session.getAttribute("isSession");
		
		if(nullCheck != null){
			mav.addObject("isLogin", 1);
		} else {
			mav.addObject("isLogin", 0);
		}
			
		return mav;
	}
	
/*	@RequestMapping(value="/{viewname}", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView main(@PathVariable("viewname") String view, ModelAndView mav, HttpServletRequest req){
		HttpSession session = req.getSession();
		mav.setViewName("home");	
		
		Boolean check = (Boolean) session.getAttribute("isSession");
		if(check != null && check) mav.addObject("isLoginYn", "Y");

		if("home".equals(view)){
			mav.addObject("bodyContents", "body.jsp");
			
		}else{
			mav.addObject("bodyContents", view+".jsp");
			
		}
		
		return mav;
	}*/
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(ModelAndView mav, HttpServletRequest req, HttpServletResponse res){
		HttpSession session = req.getSession();
		Enumeration params = req.getParameterNames();
		
		while(params.hasMoreElements()){
			String names = (String)params.nextElement();
			session.setAttribute(names, req.getParameter(names));
		}
		session.setAttribute("lv", "1");
		session.setAttribute("isSession", true);
		
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
	
	@RequestMapping(value="/posts/move_list", method=RequestMethod.GET)
	public ModelAndView movePostList(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home");
		mav.addObject("bodyContent", "/WEB-INF/views/posts/post_list.jsp");
		
		return mav;
	}
	

}
