package com.project.persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.domain.Criteria;
import com.project.domain.TeacherQ_VO;
import com.project.domain.SearchCriteria;

public interface TeacherQ_DAO {

	  public void create(TeacherQ_VO tvo) throws Exception;
	  public void create2(TeacherQ_VO tvo) throws Exception;
	  public TeacherQ_VO read(Integer qno) throws Exception;
	  public TeacherQ_VO read2(Integer qno) throws Exception;
	  public void update(TeacherQ_VO tvo) throws Exception;
	  public void delete(Integer qno) throws Exception;
	  public List<TeacherQ_VO> listAll() throws Exception;
	  public List<TeacherQ_VO> listPage(int page) throws Exception;
	  public List<TeacherQ_VO> listCriteria(Criteria cri) throws Exception;
	  public int countPaging(Criteria cri) throws Exception;
	  
	  //use for dynamic sql	  
	  public List<TeacherQ_VO> listSearch(SearchCriteria cri)throws Exception;	  
	  public int listSearchCount(SearchCriteria cri)throws Exception;
	  
	  //AOP
	  public void updateReplyCnt(Integer qno, int rcnt)throws Exception;
	  public void updateViewCnt(Integer qno)throws Exception;
	  
	  //FileUpload
	  public void addAttach(String fullname)throws Exception;	  
	  public List<String> getAttach(Integer qno)throws Exception;	   
	  public void deleteAttach(Integer qno)throws Exception;	  
	  public void replaceAttach(String fullname, Integer qno)throws Exception;
}
