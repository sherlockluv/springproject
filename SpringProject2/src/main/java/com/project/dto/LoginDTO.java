package com.project.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDTO {
	private static final Logger logger = LoggerFactory.getLogger(LoginDTO.class);
	
	private String id;
	private String pwd;
	private boolean useCookie;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", pwd=" + pwd + ", useCookie=" + useCookie + "]";
	}

	
}
