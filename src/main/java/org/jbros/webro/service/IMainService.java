package org.jbros.webro.service;

import org.jbros.webro.models.UserModel;

public interface IMainService {
	public int getUserCount();
	public UserModel getUser(String id);
}
