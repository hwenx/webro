package org.jbros.webro.service;

import org.jbros.webro.models.UserModel;

public interface IUsersService {
	public int getUserCount();
	public UserModel getUser(String id);
	public int joinUser(UserModel user);
	public int dupleIdCheck(String id);
}
