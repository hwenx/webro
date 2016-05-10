package org.jbros.webro.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jbros.webro.models.UserModel;

public interface IMainService {
	public int getUserCount();
	public UserModel getUser(String id);
	public void loginProcess(HttpServletRequest req, String id, String pass);
}
