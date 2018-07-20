package com.project.persistence;

import java.util.List;

import com.project.domain.AnswerVO;
import com.project.domain.Criteria;



public interface AnswerDAO {
	  public List<AnswerVO> list(Integer bno) throws Exception;
	  public void create(AnswerVO rvo) throws Exception;
	  public void update(AnswerVO rvo) throws Exception;
	  public void delete(Integer rno) throws Exception;
	  public List<AnswerVO> listPage(Integer bno, Criteria cri) throws Exception;
	  public int count(Integer bno) throws Exception;
	  public int getBno(Integer rno) throws Exception;
}