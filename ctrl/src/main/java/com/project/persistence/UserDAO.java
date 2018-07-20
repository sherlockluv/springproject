package com.project.persistence;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.project.domain.MemberVO;
import com.project.dto.LoginDTO;

public interface UserDAO {
	public MemberVO login(LoginDTO dto)throws Exception;
	
	public void keepLogin(String id, String sessionId, Date next);

	public MemberVO checkUserWithSessionKey(String value);
}

