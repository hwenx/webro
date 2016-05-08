package org.jbros.webro.service.impl;


import org.jbros.webro.mapper.IMainMapper;
import org.jbros.webro.models.UserModel;
import org.jbros.webro.service.IMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersServiceImpl implements IMainService{
	private Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);
	
	@Autowired
	private IMainMapper mapper;

	@Override
	public int getUserCount(){
		return mapper.selectUserCount();
	}
	
	@Override
	public UserModel getUser(String id){
		logger.info("User input Id {}" + id);
		UserModel um = mapper.selectUser(id);
		return um;
	}
}
