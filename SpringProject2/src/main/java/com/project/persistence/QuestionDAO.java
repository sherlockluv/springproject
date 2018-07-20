package com.project.persistence;

import java.util.List;

import com.project.domain.Criteria;
import com.project.domain.QuestionVO;
import com.project.domain.SearchCriteria;


public interface QuestionDAO {
	  public void create(QuestionVO qvo) throws Exception;
	  public void create2(QuestionVO qvo) throws Exception;
	  public QuestionVO read(Integer bno) throws Exception;
	  public QuestionVO read2(QuestionVO qvo) throws Exception;
	  public void update(QuestionVO qvo) throws Exception;
	  public void delete(Integer bno) throws Exception;
	  public List<QuestionVO> listAll() throws Exception;
	  public List<QuestionVO> listPage(int page) throws Exception;
	  public List<QuestionVO> listCriteria(Criteria cri) throws Exception;
	  public int countPaging(Criteria cri) throws Exception;
	  
	  //use for dynamic sql	  
	  public List<QuestionVO> listSearch(SearchCriteria cri)throws Exception;	  
	  public int listSearchCount(SearchCriteria cri)throws Exception;
	  
	  //AOP
	  public void updateReplyCnt(Integer bno, int rcnt)throws Exception;
	  public void updateViewCnt(Integer bno)throws Exception;
	  
	  //FileUpload
	  public void addAttach(String fullname)throws Exception;	  
	  public List<String> getAttach(Integer bno)throws Exception;	   
	  public void deleteAttach(Integer bno)throws Exception;	  
	  public void replaceAttach(String fullname, Integer bno)throws Exception;
}