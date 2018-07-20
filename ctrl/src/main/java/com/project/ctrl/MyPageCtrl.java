package com.project.ctrl;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.domain.MemberVO;
import com.project.dto.LoginDTO;
import com.project.service.MemberService;


@Controller
@RequestMapping("/mypage/*")
public class MyPageCtrl {

	private static Logger logger = LoggerFactory.getLogger(MyPageCtrl.class);
	
	@Inject
	private MemberService mservice;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("mvo") LoginDTO mvo) {

	}
	

	@RequestMapping(value = "/registerPost", method = RequestMethod.POST)
	public String registerPOST(MemberVO mvo, Model model) throws Exception {
		
		
		mservice.insertMember(mvo);
		return "redirect:/";

	}

}


