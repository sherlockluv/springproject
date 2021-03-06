package com.project.ctrl;

import java.util.List;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.domain.Criteria;
import com.project.domain.PageMaker;
import com.project.domain.TeacherQ_VO;

import com.project.service.TeacherQ_Service;

@Controller
@RequestMapping("/teacher/*")
public class TeacherQ_Ctrl {
	private static final Logger logger = LoggerFactory.getLogger(TeacherQ_Ctrl.class);
	@Inject
	private TeacherQ_Service service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(TeacherQ_VO tvo, Model model) throws Exception {
		logger.info("registerGet(...) >>>");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(TeacherQ_VO tvo, RedirectAttributes rttr) throws Exception {
		logger.info("registPost(...) >>>");
		logger.info(tvo.toString());
		service.regist(tvo);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("listALL(...) >>>");
		model.addAttribute("list", service.listAll());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("qno") int qno, Model model) throws Exception {
		logger.info("read(...) >>> qno : " + qno);
		model.addAttribute(service.read(qno));		
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("qno") int qno, RedirectAttributes rttr) throws Exception {
		logger.info("remove(...) >>> qno : " + qno);
		service.remove(qno);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int qno, Model model) throws Exception {
		logger.info("modifyGET(...) >>> qno : " + qno);
		model.addAttribute(service.read(qno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(TeacherQ_VO tvo, RedirectAttributes rttr) throws Exception {
		logger.info("modifyPOST(...) >>>");
		service.modify(tvo);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}
	
	  @RequestMapping(value = "/listCri", method = RequestMethod.GET)
	  public void listAll(Criteria cri, Model model) throws Exception {

	    logger.info("show list Page with Criteria......................");

	    model.addAttribute("list", service.listCriteria(cri));
	  }
	  @RequestMapping(value = "/listPage", method = RequestMethod.GET)
	  public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {

	    logger.info(cri.toString());

	    model.addAttribute("list", service.listCriteria(cri));
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    //pageMaker.setTotalCount(131);

	    pageMaker.setTotalCount(service.listCountCriteria(cri));

	    model.addAttribute("pageMaker", pageMaker);
	  }
	  @RequestMapping(value = "/readPage", method = RequestMethod.GET)
	  public void read(@RequestParam("qno") int qno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {

	    model.addAttribute(service.read(qno));
	  }
	  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
	  public String remove(@RequestParam("qno") int qno, Criteria cri, RedirectAttributes rttr) throws Exception {

	    service.remove(qno);

	    rttr.addAttribute("page", cri.getPage());
	    rttr.addAttribute("perPageNum", cri.getPerPageNum());
	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/board/listPage";
	  }
	  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	  public void modifyPagingGET(@RequestParam("qno") int qno, @ModelAttribute("cri") Criteria cri, Model model)
	      throws Exception {

	    model.addAttribute(service.read(qno));
	  }
	  @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	  public String modifyPagingPOST(TeacherQ_VO tvo, Criteria cri, RedirectAttributes rttr)
			  throws Exception {
		  service.modify(tvo);
		  
		  rttr.addAttribute("page", cri.getPage());
		  rttr.addAttribute("perPageNum", cri.getPerPageNum());
		  rttr.addFlashAttribute("msg", "SUCCESS");	
		  return "redirect:/board/listPage";
	  }
	  @RequestMapping("/getAttach/{qno}")
	  @ResponseBody
	  public List<String> getAttach(@PathVariable("qno")Integer qno)throws Exception{
	    
	    return service.getAttach(qno);
	  }  
}
