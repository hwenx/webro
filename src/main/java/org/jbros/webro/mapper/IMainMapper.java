package org.jbros.webro.mapper;

import org.jbros.webro.models.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface IMainMapper {
	public int selectUserCount();
	public UserModel selectUser(String id);
}
