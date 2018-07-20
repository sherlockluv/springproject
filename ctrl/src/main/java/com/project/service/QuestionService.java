package com.project.service;

import java.util.List;

import com.project.domain.Criteria;
import com.project.domain.QuestionVO;
import com.project.domain.SearchCriteria;



public interface QuestionService {
	  public void regist(QuestionVO qvo) throws Exception;
	  public QuestionVO read(Integer bno) throws Exception;
	  public void modify(QuestionVO qvo) throws Exception;
	  public void remove(Integer bno) throws Exception;
	  public List<QuestionVO> listAll() throws Exception;
	  public List<QuestionVO> listCriteria(Criteria cri) throws Exception;
	  public int listCountCriteria(Criteria cri) throws Exception;
	  public List<QuestionVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	  public int listSearchCount(SearchCriteria cri) throws Exception;
	  public List<String> getAttach(Integer bno)throws Exception;

}