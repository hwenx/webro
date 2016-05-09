package org.jbros.webro.service.impl;


import org.jbros.webro.mapper.IUsersMapper;
import org.jbros.webro.models.UserModel;
import org.jbros.webro.service.IUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersServiceImpl implements IUsersService{
	private Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

	@Autowired
	private IUsersMapper mapper;
	
	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserModel getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int joinUser(UserModel user) {
		int result = mapper.joinUser(user);
		
		return result;
	}

	@Override
	public int dupleIdCheck(String id) {
		// TODO Auto-generated method stub
		return mapper.dupleIdCheck(id);
	}
}
