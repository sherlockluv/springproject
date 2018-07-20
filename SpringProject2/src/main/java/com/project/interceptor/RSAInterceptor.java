package com.project.interceptor;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RSAInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory.getLogger(RSAInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(1024);
		KeyPair keyPair = generator.genKeyPair();
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
 
		session.setAttribute("_RSA_WEB_Key_", privateKey);   //세션에 RSA 개인키를 세션에 저장한다.
		RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
		String publicKeyModulus = publicSpec.getModulus().toString(16);
		String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
 		
		logger.info(">>> publicKeyModulus : " + publicKeyModulus);
		logger.info(">>> publicKeyExponent : " + publicKeyExponent);
		
		request.setAttribute("RSAModulus", publicKeyModulus);  //로그인 폼에 Input Hidden에 값을 셋팅하기위해서
		request.setAttribute("RSAExponent", publicKeyExponent); 

		return true;
	}
}
