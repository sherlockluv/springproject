package com.project.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.domain.MemberVO;
import com.project.dto.LoginDTO;



public interface UserService {
	public MemberVO login(LoginDTO dto) throws Exception;

	public void keepLogin(String id, String sessionId, Date next) throws Exception;

	public MemberVO checkLoginBefore(String value);
}
