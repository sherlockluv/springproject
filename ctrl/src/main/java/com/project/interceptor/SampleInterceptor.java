package com.project.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(SampleInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info(">>> postHandle()...");

		Object result = modelAndView.getModel().get("result");

		if (result != null) {
			logger.info("result exists");
			request.getSession().setAttribute("result", result);
			response.sendRedirect("/test_A");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info(">>> preHandle()...");

		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();

		logger.info("Bean: " + method.getBean());
		logger.info("Method: " + methodObj);

		return true;

	}

}
