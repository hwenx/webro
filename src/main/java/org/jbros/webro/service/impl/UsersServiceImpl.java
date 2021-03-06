package org.jbros.webro.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.jbros.webro.mapper.IUsersMapper;
import org.jbros.webro.models.UserModel;
import org.jbros.webro.service.IUsersService;
import org.jbros.webro.util.S3Util;
import org.jbros.webro.util.Sha256Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.services.s3.model.ObjectMetadata;

@Service("usersService")
public class UsersServiceImpl implements IUsersService {
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
		String passwd = Sha256Util.SHA256(user.getInputPassword());
		user.setInputPassword(passwd);
		int result = mapper.joinUser(user);
		if (1 == result) {
			S3Util s3 = new S3Util();
			String newFileName = null;
			String realFileName = null;

			realFileName = user.getFileInput().getOriginalFilename();
			int point = realFileName.indexOf(".");
			String extend = realFileName.substring(point+1, realFileName.length());
			newFileName = user.getInputId()+"_profile."+extend;

			try {
				s3.putObject(S3Util.IMAGE_BUCKET_NAME,
						"userprofile/"+newFileName,
						user.getFileInput().getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;

	}

	@Override
	public int dupleIdCheck(String id) {
		// TODO Auto-generated method stub
		return mapper.dupleIdCheck(id);
	}
}
