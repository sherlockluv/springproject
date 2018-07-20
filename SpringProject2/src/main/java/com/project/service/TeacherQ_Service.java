package com.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.domain.Criteria;
import com.project.domain.TeacherQ_VO;
import com.project.domain.SearchCriteria;

public interface TeacherQ_Service {
	 public void regist(TeacherQ_VO tvo) throws Exception;
	  public TeacherQ_VO read(Integer qno) throws Exception;
	  public void modify(TeacherQ_VO tvo) throws Exception;
	  public void remove(Integer qno) throws Exception;
	  public List<TeacherQ_VO> listAll() throws Exception;
	  public List<TeacherQ_VO> listCriteria(Criteria cri) throws Exception;
	  public int listCountCriteria(Criteria cri) throws Exception;
	  public List<TeacherQ_VO> listSearchCriteria(SearchCriteria cri) throws Exception;
	  public int listSearchCount(SearchCriteria cri) throws Exception;
	  public List<String> getAttach(Integer qno)throws Exception;
}
