package org.jbros.webro.mapper;

import java.util.Map;

import org.jbros.webro.models.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface IMainMapper {
	public int selectUserCount();
	public UserModel selectUser(String id);
	public int authUser(Map<String, Object> map);
	public Map<String, Object> getUserInfo(String id);
}
