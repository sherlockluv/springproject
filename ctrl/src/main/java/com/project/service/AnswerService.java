package com.project.service;

import java.util.List;

import com.project.domain.AnswerVO;
import com.project.domain.Criteria;



public interface AnswerService {
	public void addReply(AnswerVO rvo) throws Exception;
	public List<AnswerVO> listReply(Integer bno) throws Exception;
	public void modifyReply(AnswerVO rvo) throws Exception;
	public void removeReply(Integer rno) throws Exception;
	public List<AnswerVO> listReplyPage(Integer bno, Criteria cri) throws Exception;
	public int count(Integer bno) throws Exception;
}
