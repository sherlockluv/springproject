package com.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.project.domain.AnswerVO;
import com.project.domain.Criteria;
import com.project.persistence.AnswerDAO;
import com.project.persistence.QuestionDAO;

@Service
public class AnswerServiceImpl implements AnswerService {

	  @Inject
	  private AnswerDAO adao;
	  
	  @Inject
	  private QuestionDAO qdao;

	  @Transactional
	  @Override
	  public void addReply(AnswerVO rvo) throws Exception {

		  adao.create(rvo);
		  qdao.updateReplyCnt(rvo.getBno(), 1);
	  }
	  
	  @Transactional
	  @Override
	  public void removeReply(Integer rno) throws Exception {
	  
	    int bno = adao.getBno(rno);
	    adao.delete(rno);
	    qdao.updateReplyCnt(bno, -1);
	  }   

	  @Override
	  public List<AnswerVO> listReply(Integer bno) throws Exception {
	    return adao.list(bno);
	  }

	  @Override
	  public void modifyReply(AnswerVO rvo) throws Exception {
	    adao.update(rvo);
	  }

	  @Override
	  public List<AnswerVO> listReplyPage(Integer bno, Criteria cri) 
	      throws Exception {
	    return adao.listPage(bno, cri);
	  }

	  @Override
	  public int count(Integer bno) throws Exception {
	    return adao.count(bno);
	  }
}
