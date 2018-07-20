package com.project.service;

import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import com.project.domain.MemberVO;
import com.project.dto.LoginDTO;
import com.project.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Inject
	private UserDAO udao;
	
	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		return udao.login(dto);
	}


	@Override
	public void keepLogin(String id, String sessionId, Date next) throws Exception {

		udao.keepLogin(id, sessionId, next);

	}

	@Override
	public MemberVO checkLoginBefore(String value) {

		return udao.checkUserWithSessionKey(value);
	}
}
