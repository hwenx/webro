package org.jbros.webro.service.impl;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.jbros.webro.mapper.IMainMapper;
import org.jbros.webro.models.UserModel;
import org.jbros.webro.service.IMainService;
import org.jbros.webro.util.Sha256Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mainService")
public class MainServiceImpl implements IMainService{
	private Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);
	
	@Autowired
	private IMainMapper mapper;

	@Override
	public int getUserCount(){
		System.out.println("=======  UserCount =======");
		return mapper.selectUserCount();
	}
	
	@Override
	public UserModel getUser(String id){
		
		UserModel um = mapper.selectUser(id);
		return um;
	}

	/**
	 * 로그인 프로세스 회원 검사 및 세션 생성
	 */
	@Override
	public void loginProcess(HttpServletRequest req, String id, String pass) {
		HttpSession session = req.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> idpwMap = new HashMap<String, Object>();
		idpwMap.put("id", id);
		idpwMap.put("pass", Sha256Util.SHA256(pass));
		int result = mapper.authUser(idpwMap);
		if(result > 0){
			map = mapper.getUserInfo(id);
			map.remove("pass");
			session.setAttribute("userInfo", map);
			session.setAttribute("isSession", "Y");
			session.setAttribute("isState", "Y");
		}else{
			session.setAttribute("isState", "N");
		}
		
	}
}
