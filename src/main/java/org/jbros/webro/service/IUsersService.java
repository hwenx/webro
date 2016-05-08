package org.jbros.webro.service;

import org.jbros.webro.models.UserModel;

public interface IUsersService {
	public int getUserCount();
	public UserModel getUser(String id);
}
