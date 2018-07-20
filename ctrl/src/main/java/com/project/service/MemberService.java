package com.project.service;

import java.util.List;

import com.project.domain.Criteria;
import com.project.domain.MemberVO;

public interface MemberService {

	
	public void insertMember(MemberVO mvo) throws Exception;
	public MemberVO getMember(String id) throws Exception;
	public List<MemberVO> getMemberList(Criteria cri) throws Exception;
	//아이디 중복확인
	public int checkMember(MemberVO mvo) throws Exception;
	public void deleteMember(String id) throws Exception;
	public int getTotal() throws Exception;
	public void stringToDate(MemberVO member) throws Exception;
	public String checkbirthday(String id) throws Exception;
	public void updateMember(MemberVO mvo) throws Exception;
	
	
}
