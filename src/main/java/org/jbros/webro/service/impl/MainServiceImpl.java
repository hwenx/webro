package org.jbros.webro.service.impl;


import org.apache.log4j.Logger;
import org.jbros.webro.mapper.IMainMapper;
import org.jbros.webro.models.UserModel;
import org.jbros.webro.service.IMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mainService")
public class MainServiceImpl implements IMainService{
	
	private final Logger logger = Logger.getLogger(getClass());
	
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
}
