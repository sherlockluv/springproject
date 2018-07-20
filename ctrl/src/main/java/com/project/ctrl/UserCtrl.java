package com.project.ctrl;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.project.domain.MemberVO;
import com.project.dto.LoginDTO;
import com.project.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCtrl {
	private static Logger logger = LoggerFactory.getLogger(UserCtrl.class);

	@Inject
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {

	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		
		
		MemberVO uvo = service.login(dto);

		if (uvo == null) {
			return;
		}

		model.addAttribute("memberVO", uvo);

		if (dto.isUseCookie()) {

			int amount = 60 * 60 * 24 * 7;

			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));

			service.keepLogin(uvo.getId(), session.getId(), sessionLimit);
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		logger.info(">>> logout...1");
		Object obj = session.getAttribute("login");
		if (obj != null) {
			MemberVO vo = (MemberVO) obj;
			logger.info(">>> logout...2");
			session.removeAttribute("login");
			session.invalidate();

			logger.info(">>> logout...3");
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if (loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				logger.info(">>> logout...4");
				service.keepLogin(vo.getId(), session.getId(), new Date());
			}		}

		return "redirect:/";
	}
	
}
